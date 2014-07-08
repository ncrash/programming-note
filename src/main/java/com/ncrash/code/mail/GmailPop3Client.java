package com.ncrash.code.mail;
/**
 * GmailPop3Client.java
 * 
 * @author daekwon.kang
 * @since 2010. 3. 15.
 * @see
 */
public class GmailPop3Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        try {
            GmailUtilities gmail = new GmailUtilities();
            gmail.setUserPass(" myemail@gmail.comThis e-mail address is being protected from spam bots, you need JavaScript enabled to view it ", "mypassword");
            gmail.connect();
            gmail.openFolder("INBOX");
            
            int totalMessages = gmail.getMessageCount();
            int newMessages = gmail.getNewMessageCount();
            
            System.out.println("Total messages = " + totalMessages);
            System.out.println("New messages = " + newMessages);
            System.out.println("-------------------------------");
            
            //gmail.printAllMessageEnvelopes();
            gmail.printAllMessages();
            
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
	}

}
