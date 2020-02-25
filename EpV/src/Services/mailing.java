
package Services;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

  
public class mailing {
    public static void sendMail(String reception,String msg1) throws Exception{
        System.out.println("preparing to send mail");
        Properties properties =new Properties ();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        String myEmail="nawelkkhammari@gmail.com";
        String password="Esprit123456789";
        
        Session session=Session.getInstance(properties,new Authenticator() {
        @Override 
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(myEmail,password);
        }
        });
        
        Message message =prepareMessage(session,myEmail,reception,msg1);
                System.out.println("preparing to send mail");

        Transport.send(message);
        System.out.println("message sent ");      
        
    }
    public static Message prepareMessage(Session session,String myEmail,String reception,String msg) throws MessagingException {
       
        
        try {
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(reception) );
            message.setSubject("Reclamation ajouté");
            message.setText(msg);
            return message;
        } catch (AddressException ex) {
            Logger.getLogger(mailing.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return null;
        
    }
}
