/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Thusitha
 */
public class sendEmail {
    public static void sendEmail(String mail,String password,String to,String subject,String body){
        final String emailAddress = mail;
        final String pass = password;
        final String receiver = to;
        final String sub = subject;
        final String content = body;
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "465");
        
        Session sess = Session.getDefaultInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(emailAddress, pass);
                    }
                }
                );
        
        try {
            Message message = new MimeMessage(sess);
            message.setFrom(new InternetAddress(emailAddress));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receiver));
            message.setSubject(sub);
            message.setText(content);
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
