package mail_client;

public class KontoUi 
{
    private KontoVerwaltung kontoVerwaltung;

    public KontoUi() 
    {
        kontoVerwaltung = new KontoVerwaltung();
    }

    public boolean startUi(String command) 
    {
        boolean isDone = false;

        if (command.equals(KontoUiCommands.Add.getCommand())) 
        {
            System.out.println("*********************************");
            System.out.println("***Sie haben " + KontoUiCommands.Add.getCommand() + " ausgewählt!***");
            System.out.println("*********************************\n");
            System.out.println("******************************************************************************");
            System.out.println("***Bitte gib die Adresse für das Konto ein welches hinzugefügt werden soll!***");
            System.out.println("******************************************************************************\n");
            String mailAdresse = BaseActions.readText();
            System.out.println("*******************************************************************************");
            System.out.println("***Bitte gib das Passwort für das Konto ein welches hinzugefügt werden soll!***");
            System.out.println("*******************************************************************************\n");
            String passwort = BaseActions.readText();
            System.out.println("****************************************************************************");
            System.out.println("***Bitte gib den Namen für das Konto ein welches hinzugefügt werden soll!***");
            System.out.println("****************************************************************************\n");
            String name = BaseActions.readText();
            System.out.println("**********************************************************************************");
            System.out.println("***Bitte gib den SMTP-Server für das Konto ein welches hinzugefügt werden soll!***");
            System.out.println("**********************************************************************************\n");
            String smtpServer = BaseActions.readText();
            System.out.println("**********************************************************************************");
            System.out.println("***Bitte gib den Imap-Server für das Konto ein welches hinzugefügt werden soll!***");
            System.out.println("**********************************************************************************\n");
            String imapServer = BaseActions.readText();
            System.out.println("*******************************************************************************");
            System.out.println("***Bitte gib den SmtpPort für das Konto ein welches hinzugefügt werden soll!***");
            System.out.println("******************************************************************************\n");
            int portSmtp = Integer.parseInt(BaseActions.readText());
            System.out.println("*******************************************************************************");
            System.out.println("***Bitte gib den ImapPort für das Konto ein welches hinzugefügt werden soll!***");
            System.out.println("******************************************************************************\n");
            int portImap = Integer.parseInt(BaseActions.readText());
            Konto konto = new Konto(mailAdresse, passwort, smtpServer,imapServer, name, portSmtp,portImap);
            Konto specificKonto = kontoVerwaltung.getSpecificKonto(mailAdresse);
            if (specificKonto != null) 
            {
                System.out.println("****************************");
                System.out.println("***Konto schon vorhanden!***");  
                System.out.println("****************************\n");
            } 
            else 
            {   
                kontoVerwaltung.addKonto(konto);
                System.out.println("************************************");
                System.out.println("***Konto erfolgreich hinzugefügt!***");  
                System.out.println("************************************\n");
            }
            isDone = true;
        } 

        if (command.equals(KontoUiCommands.Remove.getCommand())) 
        {
            System.out.println("***********************************");
            System.out.println("***Sie haben " + KontoUiCommands.Remove.getCommand() + " ausgewählt!***");
            System.out.println("***********************************\n");
            System.out.println("********************************************************************************");
            System.out.println("***Bitte gib die Mail-Adresse für das Konto ein welches entfernt werden soll!***");
            System.out
                        .println("********************************************************************************\n");
            String mailAdresse = BaseActions.readText();
            Konto specificKonto = kontoVerwaltung.getSpecificKonto(mailAdresse);
            if (specificKonto != null) 
            {
                kontoVerwaltung.removeKonto(specificKonto);
                System.out.println("*********************************");
                System.out.println("***Konto erfolgreich entfernt!***");  
                System.out.println("*********************************\n");
            }
            else
            {
                System.out.println("****************************");
                System.out.println("***Konto nicht vorhanden!***");  
                System.out.println("****************************\n");
            }
            isDone = true;
        }

        if (command.equals(KontoUiCommands.Get.getCommand())) 
        {
            System.out.println("********************************");
            System.out.println("***Sie haben " + KontoUiCommands.Get.getCommand() + " ausgewählt!***");
            System.out.println("********************************\n");
            System.out.println(
                        "***********************************************************************************************");
            System.out.println(
                        "***Bitte gib die Mail-Adresse für das Konto ein welches die Details angezeigt werden sollen!***");
            System.out.println(
                        "***********************************************************************************************\n");
            String mailAdresse = BaseActions.readText();
            Konto specificKonto = kontoVerwaltung.getSpecificKonto(mailAdresse);
            if (specificKonto != null) 
            {
                String specificKontoString = specificKonto.toString();
                System.out.println(specificKontoString);
            }
            else 
            {
                System.out.println("****************************");
                System.out.println("***Konto nicht vorhanden!***");  
                System.out.println("****************************\n");
            }
            isDone = true;
        }

        if (command.equals(KontoUiCommands.GetAll.getCommand()))
        {
            System.out.println("***********************************");
            System.out.println("***Sie haben " + KontoUiCommands.GetAll.getCommand() + " ausgewählt!***");
            System.out.println("***********************************\n");
            String alleKonten = kontoVerwaltung.getAllKonten();
            if (alleKonten.equals("") == false) 
            {
                System.out.println("*****************");
                System.out.println("***Kontoliste:***");
                System.out.println("*****************");
                System.out.println(alleKonten);
            } 
            else 
            {
                System.out.println("*****************************");
                System.out.println("***Keine Konten vorhanden!***");
                System.out.println("*****************************\n");
            }
            isDone = true;
        }

        if (command.equals(KontoUiCommands.Change.getCommand())) 
        {
            System.out.println("***********************************");
            System.out.println("***Sie haben " + KontoUiCommands.Change.getCommand() + " ausgewählt!***");
            System.out.println("***********************************\n");
            System.out.println(
                        "******************************************************************************************");
            System.out.println(
                        "Bitte gib die Mail-Adresse für das Konto ein welches die Parameter geändert werden sollen!");
            System.out.println(
                        "******************************************************************************************\n");
            String mailAdresse = BaseActions.readText();
            Konto specificKonto = kontoVerwaltung.getSpecificKonto(mailAdresse);
            if (specificKonto != null) 
            {
                System.out.println("**************************************************************************************************************************************************************************************");
                System.out.println("***Was möchten Sie ändern? Tippe 1 für die Mail-Adresse, 2 für das Passwort, 3 für den SmtpServer, 4 für den SmtpServer,5 für den Namen, 6 für den SmtpPort und 7 für den ImapPort!***");
                System.out.println("*************************************************************************************************************************************************************************************\n");
                int choiceNumber = 0;
                try 
                {
                    choiceNumber = Integer.parseInt(BaseActions.readText());
                } 
                catch (NumberFormatException ex) 
                {
                    System.out.println("******************************************");
                    System.out.println("***Eingabe war keine Zahl! Überspringe!***");
                    System.out.println("******************************************\n");
                }
                switch (choiceNumber) 
                {
                    case (1):
                        System.out.println("******************************************");
                        System.out.println("***Geben Sie die neue Mail-Adresse ein!***");
                        System.out.println("******************************************\n");
                        String mailAdresseNeu = BaseActions.readText();
                        KontoUiController.changeKontoMailAdress(specificKonto, mailAdresseNeu);
                        System.out.println("*******************************************");
                        System.out.println("***Konto-Adresse erfolgreich bearbeitet!***");
                        System.out.println("*******************************************\n");
                        break;
                    case (2):
                        System.out.println("**************************************");
                        System.out.println("***Geben Sie das neue Passwort ein!***");
                        System.out.println("**************************************\n");
                        String passwortNeu = BaseActions.readText();
                        KontoUiController.changeKontoPassword(specificKonto, passwortNeu);
                        System.out.println("********************************************");
                        System.out.println("***Konto-Passwort erfolgreich bearbeitet!***");
                        System.out.println("********************************************\n");
                        break;
                    case (3):
                        System.out.println("******************************************");
                        System.out.println("***Geben Sie den neuen SMTP-Server ein!***");
                        System.out.println("*****************************************\n");
                        String smtpServerNeu = BaseActions.readText();
                        KontoUiController.changeKontoSmtpServer(specificKonto, smtpServerNeu);
                        System.out.println("****************************************");
                        System.out.println("***Konto-SMTP erfolgreich bearbeitet!***");
                        System.out.println("****************************************\n");
                        break;
                    case (4):
                        System.out.println("******************************************");
                        System.out.println("***Geben Sie den neuen Imap-Server ein!***");
                        System.out.println("*****************************************\n");
                        String imapServerNeu = BaseActions.readText();
                        KontoUiController.changeKontoImapServer(specificKonto, imapServerNeu);
                        System.out.println("****************************************");
                        System.out.println("***Konto-IMAP erfolgreich bearbeitet!***");
                        System.out.println("****************************************\n");
                        break;
                    case (5):
                        System.out.println("************************************");
                        System.out.println("***Geben Sie den neuen Namen ein!***");
                        System.out.println("************************************\n");
                        String nameNeu = BaseActions.readText();
                        KontoUiController.changeKontoName(specificKonto, nameNeu);
                        System.out.println("****************************************");
                        System.out.println("***Konto-Name erfolgreich bearbeitet!***");
                        System.out.println("****************************************\n");
                        break;
                    case (6):
                        System.out.println("***************************************");
                        System.out.println("***Geben Sie den neuen SmtpPort ein!***");
                        System.out.println("**************************************\n");
                        int portSmtpNeu = Integer.parseInt(BaseActions.readText());
                        KontoUiController.changeKontoPortSmtp(specificKonto, portSmtpNeu);
                        System.out.println("*********************************************");
                        System.out.println("***Konto-SMTP-Port erfolgreich bearbeitet!***");
                        System.out.println("*********************************************\n");
                        break;
                    case (7):
                        System.out.println("***************************************");
                        System.out.println("***Geben Sie den neuen ImapPort ein!***");
                        System.out.println("**************************************\n");
                        int portImapNeu = Integer.parseInt(BaseActions.readText());
                        KontoUiController.changeKontoPortImap(specificKonto, portImapNeu);
                        System.out.println("*********************************************");
                        System.out.println("***Konto-IMAP-Port erfolgreich bearbeitet!***");
                        System.out.println("*********************************************\n");
                        break;
                    default:
                        System.out.println("*************************************");
                        System.out.println("***Ungültige Eingabe! Überspringe!***");
                        System.out.println("*************************************\n");
                }
            } 
            else 
            {
                System.out.println("*******************************************************");
                System.out.println("***Es existiert kein Konto mit dieser Email-Adresse!***");
                System.out.println("*******************************************************\n");
            }
            isDone = true;
        }
        return isDone;
    }

    public KontoVerwaltung getKontoVerwaltung() {
        return kontoVerwaltung;
    }

    public void setKontoVerwaltung(KontoVerwaltung kontoVerwaltung) {
        this.kontoVerwaltung = kontoVerwaltung;
    }
}