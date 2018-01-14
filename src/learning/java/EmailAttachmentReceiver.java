/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 * This program demonstrates how to download e-mail messages and save
 * attachments into files on disk.
 *
 * @author www.codejava.net
 *
 */
public class EmailAttachmentReceiver {

    private String saveDirectory;

    /**
     * Sets the directory where attached files will be stored.
     *
     * @param dir absolute path of the directory
     */
    public void setSaveDirectory(String dir) {
        try {
            this.saveDirectory = dir;
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    /**
     * Downloads new messages and saves attachments to disk if any.
     *
     * @param host
     * @param port
     * @param userName
     * @param password
     */
    public void downloadEmailAttachments(String host, String port,
            String userName, String password) {
        try {
        Properties properties = new Properties();

        // server setting
        properties.put("mail.pop3.host", host);
        properties.put("mail.pop3.port", port);

        // SSL setting
        properties.setProperty("mail.pop3.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.pop3.socketFactory.fallback", "false");
        properties.setProperty("mail.pop3.socketFactory.port",
                String.valueOf(port));

        Session session = Session.getDefaultInstance(properties);

        
            // connects to the message store
            Store store = session.getStore("pop3");
            store.connect(userName, password);

            // opens the inbox folder
            Folder folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_ONLY);

            // fetches new messages from server
            Message[] arrayMessages = folderInbox.getMessages();

            for (int i = 0; i < arrayMessages.length; i++) {
                Message message = arrayMessages[i];
                Address[] fromAddress = message.getFrom();
                String from = fromAddress[0].toString();
                String subject = message.getSubject();
                String sentDate = message.getSentDate().toString();

                String contentType = message.getContentType();
                String messageContent = "";

                // store attachment file name, separated by comma
                String attachFiles = "";

                if (contentType.contains("multipart")) {
                    // content may contain attachments
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                            // this part is attachment
                            String fileName = part.getFileName();
                            attachFiles += fileName + ", ";
                            part.saveFile(saveDirectory + File.separator + fileName);
                        } else {
                            // this part may be the message content
                            messageContent = part.getContent().toString();
                        }
                    }

                    if (attachFiles.length() > 1) {
                        attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
                    }
                } else if (contentType.contains("text/plain")
                        || contentType.contains("text/html")) {
//                } else
//                {
                    Object content = message.getContent();
                    if (content != null) {
                        messageContent = content.toString();
                    }
                }

                // print out details of each message
                System.out.println("Message #" + (i + 1) + ":");
                System.out.println("\t From: " + from);
                System.out.println("\t Subject: " + subject);
                System.out.println("\t Sent Date: " + sentDate);
//                System.out.println("\t Message: " + messageContent);
//----------------------------------------------------------------------------
        try {
                OutputStream os = new FileOutputStream("E:\\htlm\\Message " + (i + 1)+".html");
                os.write(239);
                os.write(187);
                os.write(191);
                PrintWriter bwriter = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
                bwriter.write(messageContent);
                bwriter.flush();
                bwriter.close();
            System.out.println("Saved : " + (i + 1));
        } catch (Exception e) {
            System.out.println("Fail");
        }
//----------------------------------------------------------------------------
                System.out.println("\t Attachments: " + attachFiles);
            }

            // disconnect
            folderInbox.close(false);
            store.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Runs this program with Gmail POP3 server
     * @param args
     */
    public static void main(String[] args) {
        try {
            String host = "pop.gmail.com";
            String port = "995";
            String userName = "kietppps04803@fpt.edu.vn";
            String password = "ppk01653066968";
            String saveDirectory = "E:/Attachment";

            EmailAttachmentReceiver receiver = new EmailAttachmentReceiver();
            receiver.setSaveDirectory(saveDirectory);
            receiver.downloadEmailAttachments(host, port, userName, password);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
