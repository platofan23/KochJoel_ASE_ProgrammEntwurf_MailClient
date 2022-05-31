package mail_client;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import jakarta.mail.Address;
import jakarta.mail.Flags;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.SendFailedException;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailUiController 
{
	private EmailUiController() 
	{

	}

	public static void sendTextEmail(Email email) 
	{
		String bodyText = email.getBody();
		String subjectText = email.getSubject();

		ArrayList<Empfaenger> empfaengersText = email.getEmpfaenger();
		ArrayList<Empfaenger> clearCopyText= email.getClearcopy();
		ArrayList<Empfaenger> blindCopyText = email.getBlindcopy();

		String senderText = email.getFrom().getMailAdresse();
		String passwordText = email.getFrom().getPasswort();
		String hostServerText = email.getFrom().getSmtpServer();
		int portSmtpText = email.getFrom().getPortSmtp();

		Properties props = new Properties();
		props.put("mail.from", senderText);
		props.put("mail.user", senderText);
		props.put("mail.smtp.host", hostServerText);
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.protocol.host", hostServerText);
		props.put("mail.protocol.port", portSmtpText);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.auth", true);
		props.put("mail.debug", true);

		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(senderText, passwordText);
			}
		});
		session.setDebug(true);

		try 
		{
			int i = 0;
			int j = 0;
			int k = 0;
			MimeMessage msgText = new MimeMessage(session);
			InternetAddress senderAdressText = new InternetAddress(senderText);
			Address[] toAddrsText= new InternetAddress[empfaengersText.size()];
			Address[] ccAddrsText = new InternetAddress[empfaengersText.size()];
			Address[] bccAddrsText = new InternetAddress[empfaengersText.size()];

			msgText.setSubject(subjectText);
			msgText.setText(bodyText);
			msgText.setFrom(senderAdressText);
			msgText.setSentDate(new Date());
			msgText.setContent(bodyText, "text/plain");

			for (Empfaenger empfaenger : empfaengersText) 
			{
				toAddrsText[i] = new InternetAddress(empfaenger.getMailAdress());
				i = i + 1;
			}
			msgText.setRecipients(Message.RecipientType.TO, toAddrsText);
			if(clearCopyText.size() > 0 )
			{
				for (Empfaenger clearcopyText : clearCopyText) 
				{
					ccAddrsText[j] = new InternetAddress(clearcopyText.getMailAdress());
					j = j + 1;
				}
				msgText.setRecipients(Message.RecipientType.CC,ccAddrsText);
			}
			if(blindCopyText.size() > 0 )
			{
				for (Empfaenger blindcopyText : blindCopyText) 
				{
					bccAddrsText[k] = new InternetAddress(blindcopyText.getMailAdress());
					k = k + 1;
				}
				msgText.setRecipients(Message.RecipientType.BCC,bccAddrsText);
			}

			Transport.send(msgText);
		} 
		catch (MessagingException mex) 
		{
			System.out.println("**********************************************");
			System.out.println("***Exception handling in msgsendsample.java***");
			System.out.println("**********************************************\n");
			mex.printStackTrace();
			Exception ex = mex;
			do {
				if (ex instanceof SendFailedException) 
				{
					SendFailedException sfex = (SendFailedException) ex;
					Address[] invalid = sfex.getInvalidAddresses();
					if (invalid != null) 
					{
						System.out.println("******************************");
						System.out.println("***    ** Invalid Addresses***");
						System.out.println("******************************\n");
						for (int i = 0; i < invalid.length; i++) 
						{
							System.out.println("         " + invalid[i]);
						}
					}
					Address[] validUnsent = sfex.getValidUnsentAddresses();
					if (validUnsent != null) 
					{
						System.out.println("**********************************");
						System.out.println("***    ** ValidUnsent Addresses***");
						System.out.println("**********************************\n");
						for (int i = 0; i < validUnsent.length; i++) 
						{
							System.out.println("         " + validUnsent[i]);
						}
					}
					Address[] validSent = sfex.getValidSentAddresses();
					if (validSent != null) 
					{
						System.out.println("********************************");
						System.out.println("***    ** ValidSent Addresses***");
						System.out.println("********************************\n");
						for (int i = 0; i < validSent.length; i++) 
						{
							System.out.println("         " + validSent[i]);
						}
					}
				}
				System.out.println();
				if (ex instanceof MessagingException) 
				{
					ex = ((MessagingException) ex).getNextException();
				} 
				else 
				{
					ex = null;
				}
			} 
			while (ex != null);
		}
	}

	public static void sendHtmlEmail(Email email) 
	{
		String bodyHtml = email.getBody();
		String subjectHtml = email.getSubject();

		ArrayList<Empfaenger> empfaengersHtml = email.getEmpfaenger();
		ArrayList<Empfaenger> clearCopyHtml = email.getClearcopy();
		ArrayList<Empfaenger> blindCopyHtml = email.getBlindcopy();

		String senderHtml = email.getFrom().getMailAdresse();
		String passwordHtml = email.getFrom().getPasswort();
		String hostServerHtml = email.getFrom().getSmtpServer();
		int portSmtpHtml = email.getFrom().getPortSmtp();

		Properties props = new Properties();
		props.put("mail.from", senderHtml);
		props.put("mail.user", senderHtml);
		props.put("mail.smtp.host", hostServerHtml);
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.protocol.host", hostServerHtml);
		props.put("mail.protocol.port", portSmtpHtml);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.auth", true);
		props.put("mail.debug", true);

		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(senderHtml, passwordHtml);
			}
		});
		session.setDebug(true);

		try 
		{
			int i = 0;
			int j = 0;
			int k = 0;
			MimeMessage msgHtml = new MimeMessage(session);
			InternetAddress senderAdressHtml = new InternetAddress(senderHtml);
			Address[] toAddrsHtml = new InternetAddress[empfaengersHtml.size()];
			Address[] ccAddrsHtml = new InternetAddress[empfaengersHtml.size()];
			Address[] bccAddrsHtml = new InternetAddress[empfaengersHtml.size()];

			msgHtml.setSubject(subjectHtml);
			msgHtml.setText(bodyHtml);
			msgHtml.setFrom(senderAdressHtml);
			msgHtml.setSentDate(new Date());
			msgHtml.setContent(bodyHtml, "text/html");

			for (Empfaenger empfaenger : empfaengersHtml) 
			{
				toAddrsHtml[i] = new InternetAddress(empfaenger.getMailAdress());
				i = i + 1;
			}
			msgHtml.setRecipients(Message.RecipientType.TO, toAddrsHtml);
			if(clearCopyHtml.size() > 0 )
			{
				for (Empfaenger clearcopy : clearCopyHtml) 
				{
					ccAddrsHtml[j] = new InternetAddress(clearcopy.getMailAdress());
					j = j + 1;
				}
				msgHtml.setRecipients(Message.RecipientType.CC,ccAddrsHtml);
			}
			if(blindCopyHtml.size() > 0 )
			{
				for (Empfaenger blindcopy : blindCopyHtml) 
				{
					bccAddrsHtml[k] = new InternetAddress(blindcopy.getMailAdress());
					k = k + 1;
				}
				msgHtml.setRecipients(Message.RecipientType.BCC,bccAddrsHtml);
			}

			Transport.send(msgHtml);
		} 
		catch (MessagingException mex) 
		{
			System.out.println("**********************************************");
			System.out.println("***Exception handling in msgsendsample.java***");
			System.out.println("**********************************************\n");
			mex.printStackTrace();
			Exception ex = mex;
			do {
				if (ex instanceof SendFailedException) 
				{
					SendFailedException sfex = (SendFailedException) ex;
					Address[] invalid = sfex.getInvalidAddresses();
					if (invalid != null) 
					{
						System.out.println("******************************");
						System.out.println("***    ** Invalid Addresses***");
						System.out.println("******************************\n");
						for (int i = 0; i < invalid.length; i++) 
						{
							System.out.println("         " + invalid[i]);
						}
					}
					Address[] validUnsent = sfex.getValidUnsentAddresses();
					if (validUnsent != null) 
					{
						System.out.println("**********************************");
						System.out.println("***    ** ValidUnsent Addresses***");
						System.out.println("**********************************\n");
						for (int i = 0; i < validUnsent.length; i++) 
						{
							System.out.println("         " + validUnsent[i]);
						}
					}
					Address[] validSent = sfex.getValidSentAddresses();
					if (validSent != null) 
					{
						System.out.println("********************************");
						System.out.println("***    ** ValidSent Addresses***");
						System.out.println("********************************\n");
						for (int i = 0; i < validSent.length; i++) 
						{
							System.out.println("         " + validSent[i]);
						}
					}
				}
				System.out.println();
				if (ex instanceof MessagingException) 
				{
					ex = ((MessagingException) ex).getNextException();
				} 
				else 
				{
					ex = null;
				}
			} 
			while (ex != null);
		}
	}

	public static void listEmail(Konto konto) 
	{
		try 
		{
			Properties properties = new Properties();
			int port = konto.getPortImap();
			String imapServer = konto.getImapServer();
			String user = konto.getMailAdresse();
			String password = konto.getPasswort();
			properties.put("mail.imap.host", imapServer);
			properties.put("mail.imap.port", port);
			properties.put("mail.imap.starttls.enable", true);
			Session emailSession = Session.getDefaultInstance(properties);
		
			Store store = emailSession.getStore("imaps");
	  
			store.connect(imapServer, user, password);
	  
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
	  
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);
	  
			for (int i = 0, n = messages.length; i < n; i++) 
			{
			   Message message = messages[i];
			   System.out.println("---------------------------------");
			   System.out.println("Email Number " + (i + 1));
			   System.out.println("Subject: " + message.getSubject());
			   System.out.println("From: " + message.getFrom()[0]);
			}
	  
			emailFolder.close(false);
			store.close();
	  
			} 
			catch (NoSuchProviderException e) 
			{
			   e.printStackTrace();
			} 
			catch (MessagingException e) 
			{
			   e.printStackTrace();
			} 
			catch (Exception e) 
			{
			   e.printStackTrace();
			}
	}

	public static void showEmail(Konto konto) 
	{
		try 
		{
			Properties properties = new Properties();
			int port = konto.getPortImap();
			String imapServer = konto.getImapServer();
			String user = konto.getMailAdresse();
			String password = konto.getPasswort();
			properties.put("mail.imap.host", imapServer);
			properties.put("mail.imap.port", port);
			properties.put("mail.imap.starttls.enable", true);
			Session emailSession = Session.getDefaultInstance(properties);
		
			Store store = emailSession.getStore("imaps");
	  
			store.connect(imapServer, user, password);
	  
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);
	  
			Message[] messages = emailFolder.getMessages();

			for (int i = 0, n = messages.length; i < n; i++) 
			{
			   Message message = messages[i];
			   System.out.println("---------------------------------");
			   System.out.println("Email Number " + (i + 1));
			   System.out.println("Subject: " + message.getSubject());
			   System.out.println("From: " + message.getFrom()[0]);
			}
			
			System.out.println("****************************************************************************");
			System.out.println("***Welche Email möchten Sie einsehn? Geben Sie die Nummer der E-Mail ein!***");
			System.out.println("****************************************************************************\n");
			int emailNumer = Integer.parseInt(BaseActions.readText());
			System.out.println("From: " + messages[emailNumer-1].getFrom()[0]);
			System.out.println("Subject: " + messages[emailNumer-1].getSubject());
			Address[] reciepents = messages[emailNumer-1].getAllRecipients();
			for(int m = 0; m < reciepents.length; m++) 
			{
				System.out.println("Recipient " + m + ":" + reciepents[m]);
			}
			System.out.println("Subject: " + messages[emailNumer-1].getContent());
			System.out.println("Content: " + messages[emailNumer-1].getContent());

			messages[emailNumer-1].setFlag(Flags.Flag.SEEN,true);

			emailFolder.close(false);
			store.close();
	  
			} 
			catch (NoSuchProviderException e) 
			{
			   e.printStackTrace();
			} 
			catch (MessagingException e) 
			{
			   e.printStackTrace();
			} 
			catch (Exception e) 
			{
			   e.printStackTrace();
			}
	}

	public static void deleteEmail(Konto konto) 
	{
		try 
		{
			Properties properties = new Properties();
			int port = konto.getPortImap();
			String imapServer = konto.getImapServer();
			String user = konto.getMailAdresse();
			String password = konto.getPasswort();
			properties.put("mail.imap.host", imapServer);
			properties.put("mail.imap.port", port);
			properties.put("mail.imap.starttls.enable", true);
			Session emailSession = Session.getDefaultInstance(properties);
		
			Store store = emailSession.getStore("imaps");
	  
			store.connect(imapServer, user, password);
	  
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);
	  
			Message[] messages = emailFolder.getMessages();

			for (int i = 0, n = messages.length; i < n; i++) 
			{
			   Message message = messages[i];
			   System.out.println("---------------------------------");
			   System.out.println("Email Number " + (i + 1));
			   System.out.println("Subject: " + message.getSubject());
			   System.out.println("From: " + message.getFrom()[0]);
			}
			
			System.out.println("****************************************************************************");
			System.out.println("***Welche Email möchten Sie löschen? Geben Sie die Nummer der E-Mail ein!***");
			System.out.println("****************************************************************************\n");
			int emailNumer = Integer.parseInt(BaseActions.readText());
			System.out.println("From: " + messages[emailNumer-1].getFrom()[0]);
			System.out.println("Subject: " + messages[emailNumer-1].getSubject());
			Address[] reciepents = messages[emailNumer-1].getAllRecipients();
			for(int m = 0; m < reciepents.length; m++) 
			{
				System.out.println("Recipient " + m + ":" + reciepents[m]);
			}
			System.out.println("Subject: " + messages[emailNumer-1].getContent());
			System.out.println("Content: " + messages[emailNumer-1].getContent());

			messages[emailNumer-1].setFlag(Flags.Flag.DELETED,true);

			emailFolder.close(false);
			store.close();
	  
			} 
			catch (NoSuchProviderException e) 
			{
			   e.printStackTrace();
			} 
			catch (MessagingException e) 
			{
			   e.printStackTrace();
			} 
			catch (Exception e) 
			{
			   e.printStackTrace();
			}
	}

	public static void forwardEmail(Konto konto) 
	{
		try 
		{
			Properties properties = new Properties();
			int port = konto.getPortImap();
			String imapServer = konto.getImapServer();
			String user = konto.getMailAdresse();
			String password = konto.getPasswort();
			properties.put("mail.imap.host", imapServer);
			properties.put("mail.imap.port", port);
			properties.put("mail.imap.starttls.enable", true);
			Session emailSession = Session.getDefaultInstance(properties);
		
			Store store = emailSession.getStore("imaps");
	  
			store.connect(imapServer, user, password);
	  
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);
	  
			Message[] messages = emailFolder.getMessages();

			for (int i = 0, n = messages.length; i < n; i++) 
			{
			   Message message = messages[i];
			   System.out.println("---------------------------------");
			   System.out.println("Email Number " + (i + 1));
			   System.out.println("Subject: " + message.getSubject());
			   System.out.println("From: " + message.getFrom()[0]);
			}
			
			System.out.println("*********************************************************************************");
			System.out.println("***Welche Email möchten Sie weiterleiten? Geben Sie die Nummer der E-Mail ein!***");
			System.out.println("*********************************************************************************\n");
			int emailNumer = Integer.parseInt(BaseActions.readText());
			System.out.println("From: " + messages[emailNumer-1].getFrom()[0]);
			System.out.println("Subject: " + messages[emailNumer-1].getSubject());
			Address[] reciepents = messages[emailNumer-1].getAllRecipients();
			for(int m = 0; m < reciepents.length; m++) 
			{
				System.out.println("Recipient " + m + ":" + reciepents[m]);
			}
			System.out.println("Subject: " + messages[emailNumer-1].getContent());
			System.out.println("Content: " + messages[emailNumer-1].getContent());

			//messages[emailNumer-1].setFlag(Flags.Flag.DELETED,true);

			emailFolder.close(false);
			store.close();
	  
			} 
			catch (NoSuchProviderException e) 
			{
			   e.printStackTrace();
			} 
			catch (MessagingException e) 
			{
			   e.printStackTrace();
			} 
			catch (Exception e) 
			{
			   e.printStackTrace();
			}
	}


}
