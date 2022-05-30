package mail_client;

import java.util.ArrayList;

public class KontoUi 
{
    private ArrayList<Konto> konten;

    public KontoUi() 
    {
        konten = new ArrayList<Konto>();
    }

    public void addKonto(Konto konto) 
    {
        konten = KontoUiController.addKonto(konten, konto);
    }

    public void removeKonto(Konto konto) 
    {
        konten = KontoUiController.removeKonto(konten, konto);
    }

    public Konto getSpecificKonto(String mailAdresse) 
    {
        return KontoUiController.getSpecificKonto(konten, mailAdresse);
    }

    public String getAllKonten() 
    {
        return KontoUiController.getAllKonten(konten);
    }

    public boolean startUi(String command) 
    {
        boolean isDone = false;

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
            System.out.println("*********************************************************************************\n");
            String hostServer = BaseActions.readText();
            System.out.println("***************************************************************************");
            System.out.println("***Bitte gib den Port für das Konto ein welches hinzugefügt werden soll!***");
            System.out.println("***************************************************************************\n");
            int port = Integer.parseInt(BaseActions.readText());
            Konto konto = new Konto(mailAdresse, passwort, hostServer, name, port);
            this.addKonto(konto);
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
                Konto specificKonto = this.getSpecificKonto(mailAdresse);
                this.removeKonto(specificKonto);
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
                Konto specificKonto = this.getSpecificKonto(mailAdresse);
                String specificKontoString = specificKonto.toString();
                if (specificKonto != null) 
                {
                    System.out.println(specificKontoString);
                }
                isDone = true;
            }

            if (command.equals(KontoUiCommands.GetAll.getCommand()))
            {
                System.out.println("***********************************");
                System.out.println("***Sie haben " + KontoUiCommands.GetAll.getCommand() + " ausgewählt!***");
                System.out.println("***********************************\n");
                String alleKonten = this.getAllKonten();
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
                Konto specificKonto = this.getSpecificKonto(mailAdresse);
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
                            this.changeKontoMailAdress(specificKonto, mailAdresseNeu);
                            break;
                        case (2):
                            System.out.println("**************************************");
                            System.out.println("***Geben Sie das neue Passwort ein!***");
                            System.out.println("**************************************\n");
                            String passwortNeu = BaseActions.readText();
                            this.changeKontoMailAdress(specificKonto, passwortNeu);
                            break;
                        case (3):
                            System.out.println("***********************************");
                            System.out.println("***Geben Sie den HostServer ein!***");
                            System.out.println("***********************************\n");
                            String hostServerNeu = BaseActions.readText();
                            this.changeKontoMailAdress(specificKonto, hostServerNeu);
                            break;
                        case (4):
                            System.out.println("************************************");
                            System.out.println("***Geben Sie den neuen Namen ein!***");
                            System.out.println("************************************\n");
                            String nameNeu = BaseActions.readText();
                            this.changeKontoMailAdress(specificKonto, nameNeu);
                            break;
                        case (5):
                            System.out.println("***********************************");
                            System.out.println("***Geben Sie den neuen Port ein!***");
                            System.out.println("***********************************\n");
                            int portNeu = Integer.parseInt(BaseActions.readText());
                            this.changeKontoPort(specificKonto, portNeu);
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

    public ArrayList<Konto> getKonten() 
    {
        return konten;
    }

    public void setKonten(ArrayList<Konto> konten) 
    {
        this.konten = konten;
    }

    public void changeKontoMailAdress(Konto konto,String mailAdresse) 
    {
        KontoUiController.changeKontoMailAdress(konto, mailAdresse);
    }

    public void changeKontoPassword(Konto konto,String passwort) 
    {
        KontoUiController.changeKontoPassword(konto, passwort);
    }

    public void changeKontoName(Konto konto,String name) 
    {
        KontoUiController.changeKontoName(konto, name);
    }

    public void changeKontoHostServer(Konto konto,String hostServer) 
    {
        KontoUiController.changeKontoHostServer(konto, hostServer);
    }

    public void changeKontoPort(Konto konto,int port)
    {
        KontoUiController.changeKontoPort(konto, port);
    }
}