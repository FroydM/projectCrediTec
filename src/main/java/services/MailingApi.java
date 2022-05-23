/*
 *Esta clase se encarga de gestionar el APi para el envio de correos electronicos
 */
package services;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 *
 * @author Melanie & Froyd
 */
public class MailingApi {
    static private Properties properties = new Properties();
    static private String systemEmail = "pruebas.itcr@gmail.com";
    static private String emailPassword = "PruebasTek1425";
    
    public static void sendMailWithText(String reciver,String text) throws Exception{
        //Enable authentication
        properties.put("mail.smtp.auth","true");
        //SMTP encryption
        properties.put("mail.smtp.starttls.enable", "true");
        
        //SMTP Host
        properties.put("mail.smtp.host","smtp.gmail.com");
        //SMTP Protocols
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "*");
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        
        Session session = Session.getInstance(properties,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(systemEmail,emailPassword);
            }
        });
        String subject = "Reporte de credito | CredicTec ";
        Message message = prepareTextMessage(session,reciver, subject, text);
        Transport.send(message);
    }
    
    public static void sendMailWithTextAndDocument(String reciver,String text) throws Exception{
        //Enable authentication
        properties.put("mail.smtp.auth","true");
        //SMTP encryption
        properties.put("mail.smtp.starttls.enable", "true");
        
        //SMTP Host
        properties.put("mail.smtp.host","smtp.gmail.com");
        //SMTP Protocols
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "*");
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        
        Session session = Session.getInstance(properties,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(systemEmail,emailPassword);
            }
        });
        
        String subject = "Reporte de credito | CredicTec ";
        
        Message message = prepareTextMessage(session,reciver, subject, text);
        Transport.send(message);
    }
    /**
     * Esta funcion se encarga de redactar un correo
     * @param session Se envia la sesion activa del correo que utiliza el sistema para enviar correos.
     * @param receiver Correo electronico del destinatario
     * @param subject Asusto del correo electronico
     * @param text Texto que se encuentra en el texto del correo
     * @return Un objeto de tipo Message con toda la informacion cargada
     * @throws Exception En caso de que exista un error al generar el correo
     */
    private static Message prepareTextMessage(Session session, String receiver,String subject,String text) throws Exception {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(systemEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
        message.setSubject(subject);
        //message.setText(text);
        Multipart multiPart = new MimeMultipart();
        BodyPart content = new MimeBodyPart();
        content.setText(text);
        multiPart.addBodyPart(content);
        BodyPart attachmend = new MimeBodyPart();
        DataSource source = new FileDataSource("data.pdf");
        attachmend.setDataHandler(new DataHandler(source));
        attachmend.setFileName("amortizacion.pdf");
        multiPart.addBodyPart(attachmend);
        message.setContent(multiPart);
        return message;
    }
    
    /**
     * Esta funcion se encarga de redactar un correo con contenido para darle un poco mas de formato la texto tipo HMTL
     * @param session Se envia la sesion activa del correo que utiliza el sistema para enviar correos.
     * @param receiver Correo electronico del destinatario
     * @param subject Asusto del correo electronico
     * @param htmlContent  Texto con formato html para enviar datos
     * @return Un objeto de tipo Message con toda la informacion cargada
     * @throws Exception En caso de que exista un error al generar el correo
     */
    private static Message prepareContentMessage(Session session, String receiver,String subject,String htmlContent) throws Exception {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(systemEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
        message.setSubject(subject);
        message.setContent(htmlContent, "txt/html");
        return message;
    }
}
