/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

import java.io.IOException;

import java.io.InputStream;

import java.util.Properties;

import javax.mail.Address;

import javax.mail.BodyPart;

import javax.mail.Flags;

import javax.mail.Folder;

import javax.mail.Message;

import javax.mail.Multipart;

import javax.mail.PasswordAuthentication;

import javax.mail.Session;

import javax.mail.Store;

import javax.mail.Flags.Flag;

import javax.mail.search.FlagTerm;

public class CheckingMails_imap {

    Properties properties = null;

    private Session session = null;

    private Store store = null;

    private Folder inbox = null;

    private static boolean run;

//    private String userName = "kietppps04803@fpt.edu.vn";// provide user name
    private final String userName = "zacktons968@gmail.com";// provide user name

    private final String password = "01653066968";// provide password

    public CheckingMails_imap() {

    }

    public void readMails() throws IOException {

        properties = new Properties();

        properties.setProperty("mail.host", "imap.gmail.com");

        properties.setProperty("mail.port", "995");

        properties.setProperty("mail.transport.protocol", "imaps");

        session = Session.getInstance(properties,
                new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(userName, password);

            }

        });

        try {

            store = session.getStore("imaps");

            store.connect();

            inbox = store.getFolder("INBOX");

            inbox.open(Folder.READ_ONLY);

            Message messages[] = inbox.search(new FlagTerm(
                    new Flags(Flag.SEEN), false));
            ;

            System.out.println("Number of mails = " + messages.length);

            for (int i = 0; i < messages.length; i++) {

                Message message = messages[i];

                Address[] from = message.getFrom();

                System.out.println("-------------------------------");

                System.out.println("Email Number " + (i + 1));

                System.out.println("Date : " + message.getSentDate());

                System.out.println("From : " + from[0]);

                System.out.println("Subject: " + message.getSubject());

                Object content = message.getContentType();

                String a = (String) content.toString();

                if ("TEXT/HTML; charset=UTF-8".equalsIgnoreCase(a)) {

                    System.out.print("Content : ");

                    System.out.println(a);

                } else {
                    System.out.println("Content : ");

                    processMessageBody(message);

                }

                System.out.println("--------------------------------");

            }
            inbox.close(true);

            store.close();

            run = true;

        } catch (Exception e) {

//            e.printStackTrace();
            System.out.println("1 " + e);
            run = false;

        }

    }

    public void processMessageBody(Message message) {

        try {

//            Object content = message.getContentType();
            Object content = message.getContent();

            // check for string
            // then check for multipart
            if (content instanceof String) {

                System.out.println(((String) content));

            } else if (content instanceof Multipart) {

                Multipart multiPart = (Multipart) content;

                procesMultiPart(multiPart);

            } else if (content instanceof InputStream) {

                InputStream inStream = (InputStream) content;

                int ch;

                while ((ch = inStream.read()) != -1) {

                    System.out.write(ch);

                }
            }

        } catch (Exception e) {

//            e.printStackTrace();
            System.out.println("2 " + e);

        }

    }

    public void procesMultiPart(Multipart content) {

        try {

            int multiPartCount = content.getCount();

            for (int i = 0; i < multiPartCount; i++) {

                BodyPart bodyPart = content.getBodyPart(i);

                Object o;

                o = bodyPart.getContent();

                if (o instanceof String) {

                    System.out.println(o);

                } else if (o instanceof Multipart) {

                    procesMultiPart((Multipart) o);

                }

            }

        } catch (Exception e) {

//            e.printStackTrace();
            System.out.println("3 " + e);

        }

    }

    public static void main(String[] args) {
        try {
            CheckingMails_imap sample = new CheckingMails_imap();

            sample.readMails();
        } catch (Exception e) {
            System.out.println("4 " + e);
        }

    }
}
