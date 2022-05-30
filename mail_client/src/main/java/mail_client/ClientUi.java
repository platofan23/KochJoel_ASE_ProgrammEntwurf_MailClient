package mail_client;

import java.util.ArrayList;

public class ClientUi 
{
    private KontoUi kontoUi;
    private EmailUi emailUi;

    public ClientUi() 
    {
        kontoUi = new KontoUi();
        emailUi = new EmailUi();
    }

    public void startUi() 
    {
        boolean end = false;
        while (end == false) 
        {
            System.out
                    .println("********************************************************");
            System.out
                    .println("***Warte auf Eingabe! Tippe " + ClientUiCommands.CMD.getCommand()
                            + " für die Befehlliste!***");
            System.out
                    .println(
                            "********************************************************\n");
            String command = BaseActions.readText();
            if (command.equals(ClientUiCommands.Qu.getCommand())) 
            {
                System.out.println("*********************************");
                System.out.println("***Sie haben " + ClientUiCommands.Qu.getCommand() + " ausgewählt!***");
                System.out.println("*********************************\n");
                System.out.println("**************************");
                System.out.println("***Beende das Programm!***");
                System.out.println("**************************");
                ClientUiController.endProgramm();
            }

            if (command.equals(ClientUiCommands.CMD.getCommand())) 
            {
                System.out.println("*********************************");
                System.out.println("***Sie haben " + ClientUiCommands.CMD.getCommand() + " ausgewählt!***");
                System.out.println("*********************************\n");
                System.out.println("*********************");
                System.out.println("***Die Befehlliste***");
                System.out.println("*********************\n");
                ClientUiController.showCommandList();
            }

            if (command.equals(KontoUiCommands.Add.getCommand())) 
            {
                System.out.println("*********************************");
                System.out.println("***Sie haben " + KontoUiCommands.Add.getCommand() + " ausgewählt!***");
                System.out.println("*********************************\n");
                System.out.println("****************************************************************************");
                System.out.println("***Bitte gib den Namen für das Konto ein welches hinzugefügt werden soll!***");
                System.out.println("****************************************************************************\n");
                String mailAdresse = BaseActions.readText();
                System.out.println("*******************************************************************************");
                System.out.println("***Bitte gib das Passwort für das Konto ein welches hinzugefügt werden soll!***");
                System.out.println("*******************************************************************************\n");
                String passwort = BaseActions.readText();
                System.out.println("****************************************************************************");
                System.out.println("***Bitte gib den Namen für das Konto ein welches hinzugefügt werden soll!***");
                System.out.println("****************************************************************************\n");
                String name = BaseActions.readText();
                System.out.println("*********************************************************************************");
                System.out.println("***Bitte gib den HostServer für das Konto ein welches hinzugefügt werden soll!***");
                System.out
                        .println("*********************************************************************************\n");
                String hostServer = BaseActions.readText();
                System.out.println("***************************************************************************");
                System.out.println("***Bitte gib den Port für das Konto ein welches hinzugefügt werden soll!***");
                System.out.println("***************************************************************************\n");
                int port = Integer.parseInt(BaseActions.readText());
                Konto konto = new Konto(mailAdresse, passwort, hostServer, name, port);
                this.kontoUi.addKonto(konto);
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
                Konto specificKonto = this.kontoUi.getSpecificKonto(mailAdresse);
                this.kontoUi.removeKonto(specificKonto);
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
                Konto specificKonto = this.kontoUi.getSpecificKonto(mailAdresse);
                String specificKontoString = specificKonto.toString();
                if (specificKonto != null) 
                {
                    System.out.println(specificKontoString);
                }
            }

            if (command.equals(KontoUiCommands.GetAll.getCommand()))
            {
                System.out.println("***********************************");
                System.out.println("***Sie haben " + KontoUiCommands.GetAll.getCommand() + " ausgewählt!***");
                System.out.println("***********************************\n");
                String alleKonten = this.kontoUi.getAllKonten();
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
                Konto specificKonto = this.kontoUi.getSpecificKonto(mailAdresse);
                if (specificKonto != null) 
                {
                    System.out.println(
                            "*****************************************************************************************************************************************");
                    System.out.println(
                            "***Was möchten Sie ändern? Tippe 1 für die Mail-Adresse, 2 für das Passwort, 3 für den HostServer, 4 für den Namen und 5 für den Port!***");
                    System.out.println(
                            "*****************************************************************************************************************************************\n");
                    int choiceNumber = 0;
                    try 
                    {
                        choiceNumber = Integer.parseInt(BaseActions.readText());
                    } 
                    catch (NumberFormatException ex) {
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
                            this.kontoUi.changeKontoMailAdress(specificKonto, mailAdresseNeu);
                            break;
                        case (2):
                            System.out.println("**************************************");
                            System.out.println("***Geben Sie das neue Passwort ein!***");
                            System.out.println("**************************************\n");
                            String passwortNeu = BaseActions.readText();
                            this.kontoUi.changeKontoMailAdress(specificKonto, passwortNeu);
                            break;
                        case (3):
                            System.out.println("***********************************");
                            System.out.println("***Geben Sie den HostServer ein!***");
                            System.out.println("***********************************\n");
                            String hostServerNeu = BaseActions.readText();
                            this.kontoUi.changeKontoMailAdress(specificKonto, hostServerNeu);
                            break;
                        case (4):
                            System.out.println("************************************");
                            System.out.println("***Geben Sie den neuen Namen ein!***");
                            System.out.println("************************************\n");
                            String nameNeu = BaseActions.readText();
                            this.kontoUi.changeKontoMailAdress(specificKonto, nameNeu);
                            break;
                        case (5):
                            System.out.println("***********************************");
                            System.out.println("***Geben Sie den neuen Port ein!***");
                            System.out.println("***********************************\n");
                            int portNeu = Integer.parseInt(BaseActions.readText());
                            this.kontoUi.changeKontoPort(specificKonto, portNeu);
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
            }

            if (command.equals(EmailUiCommands.WR.getCommand())) 
            {
                System.out.println("**********************************");
                System.out.println("***Sie haben " + EmailUiCommands.WR.getCommand() + " ausgewählt!***");
                System.out.println("**********************************\n");
                System.out.println("******************************************");
                System.out.println("***Bitte gebe die Absender-Adresse ein!***");
                System.out.println("******************************************\n");
                String absender = BaseActions.readText();
                Konto sender = this.kontoUi.getSpecificKonto(absender);
                ArrayList<Empfaenger> empfaengers = new ArrayList<Empfaenger>();
                ArrayList<Empfaenger> clearCopy = new ArrayList<Empfaenger>();
                ArrayList<Empfaenger> blindCopy = new ArrayList<Empfaenger>();
                try 
                {
                    System.out.println("*************************************************************");
                    System.out.println("***An wie viele Personenen soll die Email gesendet werden?***");
                    System.out.println("************************************************************* \n");
                    int anzahlEmpfaenger = Integer.parseInt(BaseActions.readText());
                    for (int i = 0; i < anzahlEmpfaenger; i++) {
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
                    for (int i = 0; i < anzahlClearCopy; i++) {
                        System.out.println("******************************************************");
                        System.out.println("***Gib die Adresse des " + i + "ten Empfängers ein!***");
                        System.out.println("******************************************************\n");
                        String mailAdresseClearCopy = BaseActions.readText();
                        System.out.println("****************************************************");
                        System.out.println("***Gib den Namen des " + i + "ten Empfängers ein!***");
                        System.out.println("****************************************************\n");
                        String nameClearCopy= BaseActions.readText();
                        Empfaenger empfaenger = new Empfaenger(mailAdresseClearCopy, nameClearCopy);
                        clearCopy.add(empfaenger);
                    }

                    System.out.println("********************************************************************");
                    System.out.println("***An wie viele Personenen soll die Email im BCC gesendet werden?***");
                    System.out.println("*********************************************************************\n");
                    int anzahlBlindCopy = Integer.parseInt(BaseActions.readText());
                    for (int i = 0; i < anzahlBlindCopy; i++) {
                        System.out.println("******************************************************");
                        System.out.println("***Gib die Adresse des " + i + "ten Empfängers ein!***");
                        System.out.println("******************************************************\n");
                        String mailAdresseBlindCopy = BaseActions.readText();
                        System.out.println("****************************************************");
                        System.out.println("***Gib den Namen des " + i + "ten Empfängers ein!***");
                        System.out.println("****************************************************\n");
                        String nameBlindCopy= BaseActions.readText();
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
                    Email email = new Email(sender, empfaengers,clearCopy,blindCopy,subject, body, type);
                    emailUi.sendEmail(email);
                } 
                catch (NumberFormatException ex) 
                {
                    System.out.println("******************************************");
                    System.out.println("***Eingabe war keine Zahl! Überspringe!***");
                    System.out.println("******************************************\n");
                }
            }
        }
    }

    public KontoUi getKontoUi() 
    {
        return kontoUi;
    }

    public void setKontoUi(KontoUi kontoUi) 
    {
        this.kontoUi = kontoUi;
    }
}
