package mail_client;

import java.util.ArrayList;

public class EmailUi 
{

    public EmailUi() 
    {

    }

    public void sendEmail(Email email) 
    {
        if (email.getType().equals("Html")) {
            EmailUiController.sendHtmlEmail(email);
        } 
        else 
        {
            EmailUiController.sendTextEmail(email);
        }
    }

    public boolean startUi(String command, KontoUi kontoUi) 
    {
        boolean isDone = false;
        if (command.equals(EmailUiCommands.WR.getCommand())) 
        {
            System.out.println("**********************************");
            System.out.println("***Sie haben " + EmailUiCommands.WR.getCommand() + " ausgewählt!***");
            System.out.println("**********************************\n");
            System.out.println("******************************************");
            System.out.println("***Bitte gebe die Absender-Adresse ein!***");
            System.out.println("******************************************\n");
            String absender = BaseActions.readText();
            Konto sender = kontoUi.getKontoVerwaltung().getSpecificKonto(absender);
            ArrayList<Empfaenger> empfaengers = new ArrayList<Empfaenger>();
            ArrayList<Empfaenger> clearCopy = new ArrayList<Empfaenger>();
            ArrayList<Empfaenger> blindCopy = new ArrayList<Empfaenger>();
            if (sender != null) 
            {
                try 
                {
                    System.out.println("*************************************************************");
                    System.out.println("***An wie viele Personenen soll die Email gesendet werden?***");
                    System.out.println("************************************************************* \n");
                    int anzahlEmpfaenger = Integer.parseInt(BaseActions.readText());
                    for (int i = 0; i < anzahlEmpfaenger; i++) 
                    {
                        System.out.println("******************************************************");
                        System.out.println("***Gib die Adresse des " + i + "ten Empfängers ein!***");
                        System.out.println("******************************************************\n");
                        String mailAdresseEmfaenger = BaseActions.readText();
                        System.out.println("****************************************************");
                        System.out.println("***Gib den Namen des " + i + "ten Empfängers ein!***");
                        System.out.println("****************************************************\n");
                        String nameEmfaenger = BaseActions.readText();
                        Empfaenger empfaenger = new Empfaenger(mailAdresseEmfaenger, nameEmfaenger);
                        empfaengers.add(empfaenger);
                    }

                    System.out.println("*******************************************************************");
                    System.out.println("***An wie viele Personenen soll die Email im CC gesendet werden?***");
                    System.out.println("********************************************************************\n");
                    int anzahlClearCopy = Integer.parseInt(BaseActions.readText());
                    for (int i = 0; i < anzahlClearCopy; i++) 
                    {
                        System.out.println("******************************************************");
                        System.out.println("***Gib die Adresse des " + i + "ten Empfängers ein!***");
                        System.out.println("******************************************************\n");
                        String mailAdresseClearCopy = BaseActions.readText();
                        System.out.println("****************************************************");
                        System.out.println("***Gib den Namen des " + i + "ten Empfängers ein!***");
                        System.out.println("****************************************************\n");
                        String nameClearCopy = BaseActions.readText();
                        Empfaenger empfaenger = new Empfaenger(mailAdresseClearCopy, nameClearCopy);
                        clearCopy.add(empfaenger);
                    }

                    System.out.println("********************************************************************");
                    System.out.println("***An wie viele Personenen soll die Email im BCC gesendet werden?***");
                    System.out.println("*********************************************************************\n");
                    int anzahlBlindCopy = Integer.parseInt(BaseActions.readText());
                    for (int i = 0; i < anzahlBlindCopy; i++)
                    {
                        System.out.println("******************************************************");
                        System.out.println("***Gib die Adresse des " + i + "ten Empfängers ein!***");
                        System.out.println("******************************************************\n");
                        String mailAdresseBlindCopy = BaseActions.readText();
                        System.out.println("****************************************************");
                        System.out.println("***Gib den Namen des " + i + "ten Empfängers ein!***");
                        System.out.println("****************************************************\n");
                        String nameBlindCopy = BaseActions.readText();
                        Empfaenger empfaenger = new Empfaenger(mailAdresseBlindCopy, nameBlindCopy);
                        blindCopy.add(empfaenger);
                    }

                    System.out.println(
                            "***************************************************************************************");
                    System.out.println(
                            "***Bitte geben den Email Typen an! Entweder Text für Textmail oder Html für Htmlmail***");
                    System.out.println(
                            "*************************************************************************************\n");
                    String type = BaseActions.readText();
                    System.out.println("********************************************");
                    System.out.println("***Bitte geben der Betreff der Email ein!***");
                    System.out.println("********************************************\n");
                    String subject = BaseActions.readText();
                    System.out.println("**************************************");
                    System.out.println("**Bitte gib den Body der Email ein!***");
                    System.out.println("**************************************\n");
                    String body = BaseActions.readText();
                    Email email = new Email(sender, empfaengers, clearCopy, blindCopy, subject, body, type);
                    this.sendEmail(email);
                } 
                catch (NumberFormatException ex) 
                {
                    System.out.println("******************************************");
                    System.out.println("***Eingabe war keine Zahl! Überspringe!***");
                    System.out.println("******************************************\n");
                }
            } 
            else 
            {
                System.out.println("***************************************************************");
                System.out.println("***Konto mit der eingegebenen Email-Adresse existiert nicht!***");
                System.out.println("***************************************************************\n");
            }
            isDone = true;
        }
        if (command.equals(EmailUiCommands.LI.getCommand())) 
        {
            System.out.println("**********************************");
            System.out.println("***Sie haben " + EmailUiCommands.LI.getCommand() + " ausgewählt!***");
            System.out.println("**********************************\n");
            System.out.println("********************************************");
            System.out.println("***Bitte gebe die gewünschte Adresse ein!***");
            System.out.println("*******************************************\n");
            String abrufer = BaseActions.readText();
            Konto abruf = kontoUi.getKontoVerwaltung().getSpecificKonto(abrufer);  
            if (abruf != null) 
            {
                EmailUiController.listEmail(abruf);
            }
            else 
            {
                System.out.println("***************************************************************");
                System.out.println("***Konto mit der eingegebenen Email-Adresse existiert nicht!***");
                System.out.println("***************************************************************\n");   
            }
        }
        if (command.equals(EmailUiCommands.SH.getCommand())) 
        {
            System.out.println("**********************************");
            System.out.println("***Sie haben " + EmailUiCommands.SH.getCommand() + " ausgewählt!***");
            System.out.println("**********************************\n");
            System.out.println("********************************************");
            System.out.println("***Bitte gebe die gewünschte Adresse ein!***");
            System.out.println("*******************************************\n");
            String abrufer = BaseActions.readText();
            Konto abruf = kontoUi.getKontoVerwaltung().getSpecificKonto(abrufer);  
            if (abruf != null) 
            {
                EmailUiController.showEmail(abruf);
            }
            else 
            {
                System.out.println("***************************************************************");
                System.out.println("***Konto mit der eingegebenen Email-Adresse existiert nicht!***");
                System.out.println("***************************************************************\n");   
            }
        }

        if (command.equals(EmailUiCommands.Del.getCommand())) 
        {
            System.out.println("**********************************");
            System.out.println("***Sie haben " + EmailUiCommands.Del.getCommand() + " ausgewählt!***");
            System.out.println("**********************************\n");
            System.out.println("********************************************");
            System.out.println("***Bitte gebe die gewünschte Adresse ein!***");
            System.out.println("*******************************************\n");
            String abrufer = BaseActions.readText();
            Konto abruf = kontoUi.getKontoVerwaltung().getSpecificKonto(abrufer);  
            if (abruf != null) 
            {
                EmailUiController.deleteEmail(abruf);
            }
            else 
            {
                System.out.println("***************************************************************");
                System.out.println("***Konto mit der eingegebenen Email-Adresse existiert nicht!***");
                System.out.println("***************************************************************\n");   
            }
        }

        if (command.equals(EmailUiCommands.FW.getCommand())) 
        {
            System.out.println("**********************************");
            System.out.println("***Sie haben " + EmailUiCommands.FW.getCommand() + " ausgewählt!***");
            System.out.println("**********************************\n");
            System.out.println("********************************************");
            System.out.println("***Bitte gebe die gewünschte Adresse ein!***");
            System.out.println("*******************************************\n");
            String abrufer = BaseActions.readText();
            Konto abruf = kontoUi.getKontoVerwaltung().getSpecificKonto(abrufer);  
            if (abruf != null) 
            {
                EmailUiController.forwardEmail(abruf);
            }
            else 
            {
                System.out.println("***************************************************************");
                System.out.println("***Konto mit der eingegebenen Email-Adresse existiert nicht!***");
                System.out.println("***************************************************************\n");   
            }
        }

        return isDone;
    }
}
