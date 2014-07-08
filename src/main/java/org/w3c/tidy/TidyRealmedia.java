/*
 *  Java HTML Tidy - JTidy
 *  HTML parser and pretty printer
 *
 *  Copyright (c) 1998-2000 World Wide Web Consortium (Massachusetts
 *  Institute of Technology, Institut National de Recherche en
 *  Informatique et en Automatique, Keio University). All Rights
 *  Reserved.
 *
 *  Contributing Author(s):
 *
 *     Dave Raggett <dsr@w3.org>
 *     Andy Quick <ac.quick@sympatico.ca> (translation to Java)
 *     Gary L Peskin <garyp@firstech.com> (Java development)
 *     Sami Lempinen <sami@lempinen.net> (release management)
 *     Fabrizio Giustina <fgiust at users.sourceforge.net>
 *
 *  The contributing author(s) would like to thank all those who
 *  helped with testing, bug fixes, and patience.  This wouldn't
 *  have been possible without all of you.
 *
 *  COPYRIGHT NOTICE:
 * 
 *  This software and documentation is provided "as is," and
 *  the copyright holders and contributing author(s) make no
 *  representations or warranties, express or implied, including
 *  but not limited to, warranties of merchantability or fitness
 *  for any particular purpose or that the use of the software or
 *  documentation will not infringe any third party patents,
 *  copyrights, trademarks or other rights. 
 *
 *  The copyright holders and contributing author(s) will not be
 *  liable for any direct, indirect, special or consequential damages
 *  arising out of any use of the software or documentation, even if
 *  advised of the possibility of such damage.
 *
 *  Permission is hereby granted to use, copy, modify, and distribute
 *  this source code, or portions hereof, documentation and executables,
 *  for any purpose, without fee, subject to the following restrictions:
 *
 *  1. The origin of this source code must not be misrepresented.
 *  2. Altered versions must be plainly marked as such and must
 *     not be misrepresented as being the original source.
 *  3. This Copyright notice may not be removed or altered from any
 *     source or altered source distribution.
 * 
 *  The copyright holders and contributing author(s) specifically
 *  permit, without fee, and encourage the use of this source code
 *  as a component for supporting the Hypertext Markup Language in
 *  commercial products. If you use this source code in a product,
 *  acknowledgment is not required but would be appreciated.
 *
 */
package org.w3c.tidy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @author fgiust
 * @version $Revision: 808 $ ($Author: fgiust $)
 */
public class TidyRealmedia 
{
    /**
     * Tidy executable name, if you want to produce output files for comparison.
     */
    private static final String TIDY_EXECUTABLE = "tidy.exe";

    /**
     * Logger used to enable/disable output file generation using tidy c executable. Setting this logger to
     * <code>debug</code> in your log4j configuration file will cause the TIDY_EXECUTABLE to be run against the actual
     * test file. If set to false the command line used to manually run tidy will appear in the log.
     */
    private static final Log RUN_TIDY_EXECUTABLE = LogFactory.getLog("runtidy");

    /**
     * Tidy test instance.
     */
    protected Tidy tidy;

    /**
     * message listener.
     */
    protected TidyRealmediaMessageListener messageListener;

    /**
     * Error out.
     */
    protected StringWriter errorLog;

    /**
     * Tidy output.
     */
    protected String tidyOut;

    /**
     * logger.
     */
    protected Log log = LogFactory.getLog(getClass());

    /**
     * write directly to out. Useful for debugging (but it will make the test fail!).
     */
    private boolean writeToOut;

    /**
     * Instantiate a new Test case.
     * @param name test name
     */
    public TidyRealmedia()
    {
    	this.tidy = new Tidy();
    }

    /**
     * Executes a tidy test. This method simply requires the input file name. If a file with the same name but with a
     * ".cfg" extension is found is used as configuration file for the test, otherwise the default config will be used.
     * If a file with the same name, but with the ".out" extension is found, tidy will the result with the content of
     * such file.
     * @param fileName input file name
     * @throws Exception any exception generated during the test
     */
    protected TidyRealmediaMessageListener executeTidyValidation(String fileName) throws Exception
    {
    	// set up Tidy using supplied configuration
    	setUpTidy(fileName);
    	
    	// input file
    	URL inputURL = getClass().getClassLoader().getResource(fileName);
//    	assertNotNull("Can't find input file [" + fileName + "]", inputURL);
    	
    	OutputStream out;
    	// out
    	if (!writeToOut)
    	{
    		out = new ByteArrayOutputStream();
    	}
    	else
    	{
    		out = System.out;
    	}
    	
    	// go!
    	this.tidy.parse(inputURL.openStream(), out);
    	
    	if (log.isDebugEnabled())
    	{
    		log.debug("out:\n---- out ----\n" + out + "\n---- out ----");
    		log.debug("log:\n---- log ----\n" + this.errorLog + "\n---- log ----");
    	}
    	
    	StringBuffer messagesAsString = new StringBuffer();
    	List<TidyMessage> tidyMsgs = this.messageListener.getReceived();
    	
        for (Iterator<TidyMessage> iter = tidyMsgs.iterator(); iter.hasNext();)
        {
            TidyMessage message = (TidyMessage) iter.next();
            messagesAsString.append("\n");
            messagesAsString.append(message.getMessage());
        }
        
    	this.messageListener.setParseErrors(this.tidy.getParseWarnings());
    	this.messageListener.setParseWarnings(this.tidy.getParseWarnings());
    	this.messageListener.setParseMessages(messagesAsString.toString());
    	
    	return this.messageListener;
    }
    
    /**
     * set up the tidy instance.
     * @param fileName input file name (needed to determine configuration file name)
     * @throws IOException in reading configuration file
     */
    private void setUpTidy(String fileName) throws IOException
    {
        // config file names
        String configFileName = fileName.substring(0, fileName.lastIndexOf(".")) + ".cfg";
        String messagesFileName = fileName.substring(0, fileName.lastIndexOf("."));
    	
        // input file
        URL inputURL = getClass().getClassLoader().getResource(fileName);
//        assertNotNull("Can't find input file [" + fileName + "]", inputURL);

        // configuration file
        URL configurationFile = getClass().getClassLoader().getResource(configFileName);

        // debug runing test info
        if (log.isDebugEnabled())
        {
            StringBuffer message = new StringBuffer();
            message.append("Testing [" + fileName + "]");
            if (configurationFile != null)
            {
                message.append(" using configuration file [" + configFileName + "]");
            }
            log.debug(message.toString());
        }
        
        if (configurationFile == null)
        {
            configurationFile = getClass().getClassLoader().getResource("default.cfg");
        }

        generateOutputUsingTidyC(inputURL.getFile(), configurationFile.getFile(), RUN_TIDY_EXECUTABLE.isDebugEnabled());

        // set up error log
        this.errorLog = new StringWriter();
        this.tidy.setErrout(new PrintWriter(this.errorLog));

        this.messageListener = new TidyRealmediaMessageListener(messagesFileName);
        this.tidy.setMessageListener(messageListener);
    }


    /**
     * Run TIDY_EXECUTABLE to produce an output file. Used to generates output files using tidy c for comparison with
     * jtidy. A file ".out" will be written in the same folder of the input file.
     * @param inputFileName input file for tidy.
     * @param configurationFileName configuration file name (default if there is no not test-specific file).
     * @param runIt if true the output is generated using tidy, if false simply output the command line.
     */
    private void generateOutputUsingTidyC(String inputFileName, String configurationFileName, boolean runIt)
    {

        String outputFileName = inputFileName.substring(0, inputFileName.lastIndexOf(".")) + ".out";

        String strCmd = TIDY_EXECUTABLE
            + " -config \""
            + cleanUpFilePath(configurationFileName)
            + "\" -o \""
            + cleanUpFilePath(outputFileName)
            + "\" \""
            + cleanUpFilePath(inputFileName)
            + "\"";

        log.debug("cmd line:\n***\n"
            + strCmd
            + "\nw/o output:\n"
            + TIDY_EXECUTABLE
            + " -config \""
            + cleanUpFilePath(configurationFileName)
            + "\" \""
            + cleanUpFilePath(inputFileName)
            + "\""
            + "\n***");

        if (runIt)
        {
            log.debug("running " + TIDY_EXECUTABLE);
            try
            {
                Runtime.getRuntime().exec(strCmd);
            }
            catch (IOException e)
            {
                log.warn("Error running [" + strCmd + "] cmd: " + e.getMessage());
            }
        }

    }

    /**
     * Utility method to clean up file path returned by URLs.
     * @param fileName file name as given by URL.getFile()
     * @return String fileName
     */
    protected String cleanUpFilePath(String fileName)
    {
        if (fileName.length() > 3 && fileName.charAt(2) == ':')
        {
            // assuming something like ""/C:/program files/..."
            return fileName.substring(1);
        }
        else if (fileName.startsWith("file://"))
        {
            return fileName.substring(7);
        }

        return fileName;

    }
}