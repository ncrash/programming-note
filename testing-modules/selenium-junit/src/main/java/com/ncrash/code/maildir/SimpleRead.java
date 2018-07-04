package com.ncrash.code.maildir;

import java.io.FileOutputStream;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * @author daekwon.kang
 * @since 2010. 6. 14.
 * @see
 */
public class SimpleRead {
  private static Logger log = Logger.getLogger(SimpleRead.class);

  public static void main(String args[]) throws Exception {
    // set up the Logger
    BasicConfigurator.configure();

    Session session = Session.getInstance(new Properties());

    String url = "maildir:d:/temp/gmail-archive/";

    Store store = session.getStore(new URLName(url));
    store.connect(); // useless with Maildir but included here for
    // consistency

    Folder inbox = store.getFolder("inbox");
    inbox.open(Folder.READ_WRITE);

    for (Message m : inbox.getMessages()) {
      String subject = new String(m.getSubject().getBytes("iso8859-1"), "euc-kr");
      //			System.out.println("subject of this message: " + subject);
      for (Address address : m.getFrom()) {
        System.out.println("sender name : " + address.toString());
      }
      //			System.out.println("send date : " + m.getSentDate());
      //			System.out.println(m.getContentType());

      if (m.isMimeType("text/plain")) {
        System.out.println((String) m.getContent());
      } else {
        Multipart mp = (Multipart) m.getContent();
        //			log.info(mp.getCount());
        BodyPart bp = mp.getBodyPart(0);
        //			log.info(bp.getContentType());
        if (bp.isMimeType("text/plain")) {
          System.out.println((String) bp.getContent());
        } else {
          Multipart mp2 = (Multipart) bp.getContent();
          //			log.info(mp2.getCount());

          String outFilename = "aaa" + m.getMessageNumber() + ".uni";
          FileOutputStream fos = new FileOutputStream(outFilename);
          mp2.getBodyPart(0).writeTo(fos);
          fos.close();
        }

        m.setFlag(Flags.Flag.DELETED, true);
      }
    }
    inbox.close(true);
    store.close();
  }
}
