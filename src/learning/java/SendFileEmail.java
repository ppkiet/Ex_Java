package learning.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author PhanPhuKiet
 */
public class SendFileEmail {

    public static void main(String[] args) {
        String smtpServer = "smtp.gmail.com"; // Gmail
        String to = "kietppps04803@fpt.edu.vn";
        String cc = "";
        String bcc = "";
        String from = "kietppps04803@fpt.edu.vn";
        String pass = "";
        String subject = "Tiêu Đề Email";
        String body = "<h1>hello. Test mail java</h1>";
        String link_file = "C:\\Users\\PC\\Downloads\\Untitled.png";

        try {
            SendFileEmail.sendEmail(smtpServer, to, cc, bcc, from, pass, subject, body, link_file);
        } catch (Exception e) {
            System.out.println("Main : " + e);
        }
    }

    public static void sendEmail(String smtpServer, String to, String cc, String bcc, String from, String pass,
            String subject, String body, String link_file1) throws Exception {
        try {
            long start = System.currentTimeMillis();  // Lấy thời gian bắt đầu chương trình
            
            Properties props = System.getProperties();
            props.put("mail.smtp.host", smtpServer);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable", "true");
            final String login = from;
            final String pwd = pass;
            Authenticator pa = null;
            if (login != null && pwd != null) {
                props.put("mail.smtp.auth", "true");
                pa = new Authenticator() {

                    @Override
                    public PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(login, pwd);
                    }
                };
            }//else: no authentication
            Session session = Session.getInstance(props, pa);

// — Create a new message –
            Message msg = new MimeMessage(session);

// — Set the FROM and TO fields –
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc, false));
            msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc, false));

// — Set the subject and body text –
            msg.setSubject(subject);

//----------------------Gui file----------------------------------------
// — Tao message 
            BodyPart messageBodyPart = new MimeBodyPart();

// — Phan than message
            messageBodyPart.setContent(body, "text/html; charset=UTF-8");
// — Tao mot multipar message
            Multipart multipart = new MimeMultipart();

// — Thiet lap phan text message
            multipart.addBodyPart(messageBodyPart);

// — Phan hai la attachment
//            messageBodyPart = new MimeBodyPart();
//            String file = link_file1;
//            String arr[] = link_file1.split("\\ ");
//            String name = arr[arr.length - 1];

//             String path = file.getAbsolutePath();
//             String name = file.getName();
//            DataSource source = new FileDataSource(file);
//            messageBodyPart.setDataHandler(new DataHandler(source));
//            messageBodyPart.setFileName(name);
//            multipart.addBodyPart(messageBodyPart);

            SendFileEmail.addAttachment(multipart, link_file1);
            SendFileEmail.addAttachment(multipart, link_file1);
// — Gui cac phan day du cua message
            msg.setContent(multipart);

// — Set some other header information –
//            msg.setHeader("X-Mailer", "LOTONtechEmail");
            msg.setHeader("hello hello", "Alo Alo");
            msg.setSentDate(new Date());
            msg.saveChanges();

// — Send the message –
            Transport.send(msg);
            System.out.println("Mail da duoc gui");
// — Thời gian chạy hệ thống –
            Thread.sleep(2000);
            long end = System.currentTimeMillis();
            long time = (end - start)/1000;
            System.out.println("time: " + time+"s");

            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
            Date date = new Date();
            String day = dateFormat.format(date);
            System.out.println(day);

        } catch (Exception e) {
            System.out.println("Gửi mail thất bại !");
            System.out.println("Lỗi : " + e);
        }
    }

    static void addAttachment(Multipart multipart, String filename) throws MessagingException {
        DataSource source = new FileDataSource(filename);
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setDataHandler(new DataHandler(source));
        String arr[] = filename.split("\\ ");
        String name = arr[arr.length - 1];
        messageBodyPart.setFileName(name);
        multipart.addBodyPart(messageBodyPart);
    }
}
