package mail_client;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailUiController {
	public EmailUiController() {

	}

	public static void sendTextEmail(Email email) {
		String body = email.getBody();
		String subject = email.getSubject();

		ArrayList<Empfaenger> empfaengers = email.getEmpfaenger();
		ArrayList<Empfaenger> clearCopy = email.getClearcopy();
		ArrayList<Empfaenger> blindCopy = email.getBlindcopy();

		String sender = email.getFrom().getMailAdresse();
		String hostServer = email.getFrom().getHostServer();
		int port = email.getFrom().getPort();

		Properties props = new Properties();
		props.put("mail.from", sender);
		props.put("mail.user", sender);
		props.put("mail.smtp.host", hostServer);
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.protocol.host", hostServer);
		props.put("mail.protocol.port", port);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.debug", true);

		Session session = Session.getInstance(props, null);
		session.setDebug(true);

		try {
			int i = 0;
			int j = 0;
			int k = 0;
			MimeMessage msg = new MimeMessage(session);
			InternetAddress senderAdress = new InternetAddress(sender);
			Address[] toAddrs = new InternetAddress[empfaengers.size()];
			Address[] ccAddrs = new InternetAddress[empfaengers.size()];
			Address[] bccAddrs = new InternetAddress[empfaengers.size()];

			msg.setSubject(subject);
			msg.setText(body);
			msg.setFrom(senderAdress);
			msg.setSentDate(new Date());

			for (Empfaenger empfaenger : empfaengers) {
				toAddrs[i] = new InternetAddress(empfaenger.getMailAdress());
				i = i + 1;
			}

			for (Empfaenger clearcopy : clearCopy) {
				ccAddrs[j] = new InternetAddress(clearcopy.getMailAdress());
				j = j + 1;
			}

			for (Empfaenger blindcopy : blindCopy) {
				bccAddrs[k] = new InternetAddress(blindcopy.getMailAdress());
				k = k + 1;
			}

			msg.setRecipients(Message.RecipientType.TO, toAddrs);
			// msg.setRecipients(Message.RecipientType.CC,ccAddrs);
			// msg.setRecipients(Message.RecipientType.BCC,bccAddrs);

			Transport.send(msg);
		} catch (MessagingException mex) {
			System.out.println("**********************************************");
			System.out.println("***Exception handling in msgsendsample.java***");
			System.out.println("**********************************************\n");
			mex.printStackTrace();
			Exception ex = mex;
			do {
				if (ex instanceof SendFailedException) {
					SendFailedException sfex = (SendFailedException) ex;
					Address[] invalid = sfex.getInvalidAddresses();
					if (invalid != null) {
						System.out.println("******************************");
						System.out.println("***    ** Invalid Addresses***");
						System.out.println("******************************\n");
						for (int i = 0; i < invalid.length; i++) {
							System.out.println("         " + invalid[i]);
						}
					}
					Address[] validUnsent = sfex.getValidUnsentAddresses();
					if (validUnsent != null) {
						System.out.println("**********************************");
						System.out.println("***    ** ValidUnsent Addresses***");
						System.out.println("**********************************\n");
						for (int i = 0; i < validUnsent.length; i++)
							System.out.println("         " + validUnsent[i]);
					}
					Address[] validSent = sfex.getValidSentAddresses();
					if (validSent != null) {
						System.out.println("********************************");
						System.out.println("***    ** ValidSent Addresses***");
						System.out.println("********************************\n");
						for (int i = 0; i < validSent.length; i++) {
							System.out.println("         " + validSent[i]);
						}
					}
				}
				System.out.println();
				if (ex instanceof MessagingException) {
					ex = ((MessagingException) ex).getNextException();
				} else {
					ex = null;
				}
			} while (ex != null);
		}
	}

	public static void sendHtmlEmail(Email email) {

	}
}
