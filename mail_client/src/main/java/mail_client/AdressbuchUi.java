package mail_client;
public class AdressbuchUi 
{
    private Adressbuch adressbuch;

    public AdressbuchUi() {
        adressbuch = new Adressbuch("Persönlich");
    }

    public boolean startUi(String command) 
    {
        boolean isDone = false;

        if (command.equals(AdressbuchUiCommands.Add.getCommand())) 
        {
            System.out.println("*********************************");
            System.out.println("***Sie haben " + AdressbuchUiCommands.Add.getCommand() + " ausgewählt!***");
            System.out.println("*********************************\n");
            System.out.println("****************************************************************************");
            System.out.println("********************************************************************************");
            System.out.println("***Bitte gib die Adresse für den Kontakt ein welcher hinzugefügt werden soll!***");
            System.out.println("********************************************************************************\n");
            String mailAdresse = BaseActions.readText();
            System.out.println("****************************************************************************");
            System.out.println("***Bitte gib den Namen für den Kontakt ein welcher hinzugefügt werden soll!***");
            System.out.println("****************************************************************************\n");
            String name = BaseActions.readText();
            System.out.println("*************************************************************************************");
            System.out.println("***Bitte gib die Organisation für den Kontakt ein welcher hinzugefügt werden soll!***");
            System.out.println("************************************************************************************\n");
            String organisation = BaseActions.readText();
            System.out.println("**************************************************************************************");
            System.out.println("***Bitte gib die Telefonnummer für den Kontakt ein welcher hinzugefügt werden soll!***");
            System.out.println("**************************************************************************************\n");
            String telefonNummer = BaseActions.readText();
            Kontakt kontakt = new Kontakt(mailAdresse,name,organisation,telefonNummer);
            Kontakt specificKontakt = adressbuch.getSpecificKontakt(mailAdresse);
            if (specificKontakt != null) 
            {
                    System.out.println("******************************");
                    System.out.println("***Kontakt schon vorhanden!***");  
                    System.out.println("******************************\n");
            } 
            else 
            {
                    adressbuch.addKontakt(kontakt);
                    System.out.println("**************************************");
                    System.out.println("***Kontakt erfolgreich hinzugefügt!***");  
                    System.out.println("**************************************\n");
            }
            isDone = true;
        }

        if (command.equals(AdressbuchUiCommands.Remove.getCommand())) 
            {
                System.out.println("***********************************");
                System.out.println("***Sie haben " + AdressbuchUiCommands.Remove.getCommand() + " ausgewählt!***");
                System.out.println("***********************************\n");
                System.out.println("**********************************************************************************");
                System.out.println("***Bitte gib die Mail-Adresse für den Kontakt ein welcher entfernt werden soll!***");
                System.out.println("**********************************************************************************\n");
                String mailAdresse = BaseActions.readText();
                Kontakt specificKontakt = adressbuch.getSpecificKontakt(mailAdresse);
                if (specificKontakt != null) 
                {
                    adressbuch.removeKontakt(specificKontakt);
                    System.out.println("***********************************");
                    System.out.println("***Kontakt erfolgreich entfernt!***");  
                    System.out.println("***********************************\n");
                }
                else {
                    System.out.println("******************************");
                    System.out.println("***Kontakt nicht vorhanden!***");  
                    System.out.println("******************************\n");
                }
                isDone = true;
            }

            if (command.equals(AdressbuchUiCommands.Get.getCommand())) 
            {
                System.out.println("********************************");
                System.out.println("***Sie haben " + AdressbuchUiCommands.Get.getCommand() + " ausgewählt!***");
                System.out.println("********************************\n");
                System.out.println(
                        "*************************************************************************************************");
                System.out.println(
                        "***Bitte gib die Mail-Adresse für den Kontakt ein welches die Details angezeigt werden sollen!***");
                System.out.println(
                        "*************************************************************************************************\n");
                String mailAdresse = BaseActions.readText();
                Kontakt specificKontakt = adressbuch.getSpecificKontakt(mailAdresse);
                if (specificKontakt != null) 
                {
                    String specificKontaktString = specificKontakt.toString();
                    System.out.println(specificKontaktString);
                } 
                else 
                {
                    System.out.println("******************************");
                    System.out.println("***Kontakt nicht vorhanden!***");  
                    System.out.println("******************************\n");
                }
                isDone = true;
            }

            if (command.equals(AdressbuchUiCommands.GetAll.getCommand()))
            {
                System.out.println("***********************************");
                System.out.println("***Sie haben " + AdressbuchUiCommands.GetAll.getCommand() + " ausgewählt!***");
                System.out.println("***********************************\n");
                String alleKontakte = adressbuch.getAllKontakte();
                if (alleKontakte.equals("") == false) 
                {
                    System.out.println("*****************");
                    System.out.println("***Kontoliste:***");
                    System.out.println("*****************");
                    System.out.println(alleKontakte);
                } 
                else 
                {
                    System.out.println("*******************************");
                    System.out.println("***Keine Kontakte vorhanden!***");
                    System.out.println("*******************************\n");
                }
                isDone = true;
            }

            if (command.equals(AdressbuchUiCommands.Change.getCommand())) 
            {
                System.out.println("***********************************");
                System.out.println("***Sie haben " + AdressbuchUiCommands.Change.getCommand() + " ausgewählt!***");
                System.out.println("***********************************\n");
                System.out.println(
                        "******************************************************************************************");
                System.out.println(
                        "Bitte gib die Mail-Adresse für das Konto ein welches die Parameter geändert werden sollen!");
                System.out.println(
                        "******************************************************************************************\n");
                String mailAdresse = BaseActions.readText();
                Kontakt specificKontakt = adressbuch.getSpecificKontakt(mailAdresse);
                if (specificKontakt != null) 
                {
                    System.out.println("********************************************************************************************************************************");
                    System.out.println("***Was möchten Sie ändern? Tippe 1 für die Mail-Adresse, 2 für den Namen, 3 für die Organisation oder 4 für die Telefonnummer***");
                    System.out.println("********************************************************************************************************************************\n");
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
                            AdressbuchUiController.changeKontaktMailAdress(specificKontakt, mailAdresseNeu);
                            System.out.println("*************************************************");
                            System.out.println("***Kontakt-MailAdresse erfolgreich bearbeitet!***");
                            System.out.println("*************************************************\n");
                            break;
                        case (2):
                            System.out.println("************************************");
                            System.out.println("***Geben Sie den neuen Namen ein!***");
                            System.out.println("************************************\n");
                            String nameNeu = BaseActions.readText();
                            AdressbuchUiController.changeKontaktName(specificKontakt, nameNeu);
                            System.out.println("******************************************");
                            System.out.println("***Kontakt-Name erfolgreich bearbeitet!***");
                            System.out.println("******************************************\n");
                            break;
                        case (3):
                            System.out.println("******************************************");
                            System.out.println("***Geben Sie die neue Organisation ein!***");
                            System.out.println("*****************************************\n");
                            String organisation = BaseActions.readText();
                            AdressbuchUiController.changeKontaktOrganisation(specificKontakt, organisation);
                            System.out.println("**************************************************");
                            System.out.println("***Kontakt-Organisation erfolgreich bearbeitet!***");
                            System.out.println("**************************************************\n");
                            break;
                        case (4):
                            System.out.println("*******************************************");
                            System.out.println("***Geben Sie die neue Telefonnummer ein!***");
                            System.out.println("*******************************************\n");
                            String telefonNummer = BaseActions.readText();
                            AdressbuchUiController.changeKontaktTelefonNummer(specificKontakt, telefonNummer);
                            System.out.println("***************************************************");
                            System.out.println("***Kontakt-Telefonnummer erfolgreich bearbeitet!***");
                            System.out.println("***************************************************\n");
                            break;
                        default:
                            System.out.println("*************************************");
                            System.out.println("***Ungültige Eingabe! Überspringe!***");
                            System.out.println("*************************************\n");
                    }
                } 
                else 
                {
                    System.out.println("*********************************************************");
                    System.out.println("***Es existiert kein Kontakt mit dieser Email-Adresse!***");
                    System.out.println("*********************************************************\n");
                }
                isDone = true;
            }

        return isDone;
    }

    public Adressbuch getAdressbuch() 
    {
        return adressbuch;
    }

    public void setAdressbuch(Adressbuch adressbuch) 
    {
        this.adressbuch = adressbuch;
    } 
}
