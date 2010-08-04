package org.w3c.tidy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author fgiust, daekwon-kang
 * @version $Revision: 779 $ ($Author: fgiust $)
 */
public class TidyRealmediaMessageListener implements TidyMessageListener
{

    private int parseErrors;

    private int parseWarnings;
    
    private String parseMessages;
    
    /**
     * filename.
     */
    private String filename;
    

    /**
     * Contains all the received TidyMessages.
     */
    private List<TidyMessage> received = new ArrayList<TidyMessage>();

    /**
     * Instantiate a new messag listener for the given test file.
     * @param filename actual test case name
     */
    public TidyRealmediaMessageListener(String filename)
    {
        this.filename = filename;
    }

    /**
     * @see org.w3c.tidy.TidyMessageListener#messageReceived(org.w3c.tidy.TidyMessage)
     */
    public void messageReceived(TidyMessage message)
    {
        received.add(message);
    }

    /**
     * Write received messages as xml.
     * @return xml containing message details.
     */
    public String messagesToXml()
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n");
        buffer.append("<!-- expected messages for test ");
        buffer.append(this.filename);
        buffer.append("-->\n");

        buffer.append("<messages>\n");
        Iterator<TidyMessage> iterator = received.iterator();
        while (iterator.hasNext())
        {
            TidyMessage msg = (TidyMessage) iterator.next();
            buffer.append("  <message>\n");

            buffer.append("    <code>");
            buffer.append(msg.getErrorCode());
            buffer.append("</code>\n");

            buffer.append("    <level>");
            buffer.append(msg.getLevel().getCode());
            buffer.append("</level>\n");

            buffer.append("    <line>");
            buffer.append(msg.getLine());
            buffer.append("</line>\n");

            buffer.append("    <column>");
            buffer.append(msg.getColumn());
            buffer.append("</column>\n");

            buffer.append("    <text><![CDATA[");
            buffer.append(msg.getMessage());
            buffer.append("]]></text>\n");

            buffer.append("  </message>\n");
        }

        buffer.append("</messages>\n");

        return buffer.toString();
    }

    /**
     * Getter for <code>filename</code>.
     * @return Returns the filename.
     */
    protected String getFilename()
    {
        return this.filename;
    }

    /**
     * Returns the list of received messages.
     * @return Returns the received messages.
     */
    public List<TidyMessage> getReceived()
    {
        return this.received;
    }

	public void setParseErrors(int parseErrors) {
		this.parseErrors = parseErrors;
	}

	public int getParseErrors() {
		return parseErrors;
	}

	public void setParseWarnings(int parseWarnings) {
		this.parseWarnings = parseWarnings;
	}

	public int getParseWarnings() {
		return parseWarnings;
	}

	public void setParseMessages(String parseMessages) {
		this.parseMessages = parseMessages;
	}

	public String getParseMessages() {
		return parseMessages;
	}

}