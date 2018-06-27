package com.ncrash.code.maildir;

import java.io.FileInputStream;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * @author daekwon.kang
 * @since 2010. 6. 14.
 * @see
 */
public class Deliver {
  private static Logger log = Logger.getLogger(Deliver.class);

  public static void main(String argv[]) throws Exception {
    BasicConfigurator.configure();
    String maildirpath = "///Maildir/";
    if (argv.length == 0) {
      System.err.println("usage: deliver filename [maildirpath]");
      System.exit(1);
    } else if (argv.length >= 2) {
      if (argv[1].startsWith("/")) maildirpath = argv[1];
      else maildirpath = "///" + argv[1];
    }

    log.info("Delivering " + argv[0] + " to " + maildirpath);

    Properties props = new Properties();
    // the following specifies whether to create maildirpath if it is not existant
    // if not specified then autocreatedir is false
    props.put("mail.store.maildir.autocreatedir", "true");
    Session session = Session.getInstance(props, null);
    session.setDebug(true);

    Store store = session.getStore(new URLName("maildir:" + maildirpath));
    Folder inbox = store.getFolder("inbox");
    inbox.open(Folder.READ_WRITE);
    MimeMessage mm = new MimeMessage(session, new FileInputStream(argv[0]));
    inbox.appendMessages(new Message[] {(Message) mm});
  }
}
