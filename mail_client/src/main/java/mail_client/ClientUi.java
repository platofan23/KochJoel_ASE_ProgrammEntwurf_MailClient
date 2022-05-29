package mail_client;

import java.util.ArrayList;

public class ClientUi {
    private KontoUi kontoUi;
    private EmailUi emailUi;

    public ClientUi() {
        kontoUi = new KontoUi();
        emailUi = new EmailUi();
    }

    public void startUi() {
        boolean end = false;
        while (end == false) {
            System.out
                    .println("Warte auf Eingabe! Tippe " + ClientUiCommands.CMD.getCommand() + " für die Befehlliste!");
            String command = BaseActions.readText();
            if (command.equals(ClientUiCommands.Qu.getCommand())) {
                System.out.println("**************************");
                System.out.println("***Beende das Programm!***");
                System.out.println("**************************");
                ClientUiController.endProgramm();
            }

            if (command.equals(ClientUiCommands.CMD.getCommand())) {
                System.out.println("*********************");
                System.out.println("***Die Befehlliste***");
                System.out.println("*********************\n");
                ClientUiController.showCommandList();
            }

            if (command.equals(KontoUiCommands.Add.getCommand())) {
                System.out.println("****************************************************************************");
                System.out.println("***Bitte gib den Namen für das Konto ein welches hinzugefügt werden soll!***");
                System.out.println("****************************************************************************\n");
                String mailAdresse = BaseActions.readText();
                System.out.println("Bitte gib das Passwort für das Konto ein welches hinzugefügt werden soll!");
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

            if (command.equals(KontoUiCommands.Remove.getCommand())) {
                System.out.println("********************************************************************************");
                System.out.println("***Bitte gib die Mail-Adresse für das Konto ein welches entfernt werden soll!***");
                System.out
                        .println("*********************************************************************************\n");
                String mailAdresse = BaseActions.readText();
                Konto specificKonto = this.kontoUi.getSpecificKonto(mailAdresse);
                this.kontoUi.getKonten().remove(specificKonto);
            }

            if (command.equals(KontoUiCommands.Get.getCommand())) {
                System.out.println(
                        "***********************************************************************************************");
                System.out.println(
                        "***Bitte gib die Mail-Adresse für das Konto ein welches die Details angezeigt werden sollen!***");
                System.out.println(
                        "***********************************************************************************************\n");
                String mailAdresse = BaseActions.readText();
                Konto specificKonto = this.kontoUi.getSpecificKonto(mailAdresse);
                String specificKontoString = specificKonto.toString();
                if (specificKonto != null) {
                    System.out.println(specificKontoString);
                }
            }

            if (command.equals(KontoUiCommands.GetAll.getCommand())) {
                String alleKonten = this.kontoUi.getAllKonten();
                if (alleKonten.equals("") == false) {
                    System.out.println("Kontoliste:");

                    System.out.println(alleKonten);
                } else {
                    System.out.println("Keine Konten vorhanden!");
                }
            }

            if (command.equals(KontoUiCommands.Change.getCommand())) {
                System.out.println(
                        "Bitte gib die Mail-Adresse für das Konto ein welches die Parameter geändert werden sollen!");
                String mailAdresse = BaseActions.readText();
                Konto specificKonto = this.kontoUi.getSpecificKonto(mailAdresse);
                if (specificKonto != null) {
                    System.out.println(
                            "*****************************************************************************************************************************************");
                    System.out.println(
                            "***Was möchten Sie ändern? Tippe 1 für die Mail-Adresse, 2 für das Passwort, 3 für den HostServer, 4 für den Namen und 5 für den Port!***");
                    System.out.println(
                            "*****************************************************************************************************************************************\n");
                    int choiceNumber = 0;
                    try {
                        choiceNumber = Integer.parseInt(BaseActions.readText());
                    } catch (NumberFormatException ex) {
                        System.out.println("******************************************");
                        System.out.println("***Eingabe war keine Zahl! Überspringe!***");
                        System.out.println("******************************************\n");
                    }
                    switch (choiceNumber) {
                        case (1):
                            System.out.println("******************************************");
                            System.out.println("***Geben Sie die neue Mail-Adresse ein!***");
                            System.out.println("******************************************\n");
                            String mailAdresseNeu = BaseActions.readText();
                            specificKonto.setMailAdresse(mailAdresseNeu);
                            break;
                        case (2):
                            System.out.println("**************************************");
                            System.out.println("***Geben Sie das neue Passwort ein!***");
                            System.out.println("**************************************\n");
                            String passwortNeu = BaseActions.readText();
                            specificKonto.setPasswort(passwortNeu);
                            break;
                        case (3):
                            System.out.println("***********************************");
                            System.out.println("***Geben Sie den HostServer ein!***");
                            System.out.println("***********************************\n");
                            String hostServerNeu = BaseActions.readText();
                            specificKonto.setHostServer(hostServerNeu);
                            break;
                        case (4):
                            System.out.println("Geben Sie den neuen Port ein!");
                            try {
                                int nameNeu = Integer.parseInt(BaseActions.readText());
                                specificKonto.setPort(nameNeu);
                            } catch (NumberFormatException ex) {
                                System.out.println("******************************************");
                                System.out.println("***Eingabe war keine Zahl! Überspringe!***");
                                System.out.println("******************************************\n");
                            }
                            break;
                        case (5):
                            System.out.println("***********************************");
                            System.out.println("***Geben Sie den neuen Port ein!***");
                            System.out.println("***********************************\n");
                            int portNeu = Integer.parseInt(BaseActions.readText());
                            specificKonto.setPort(portNeu);
                            break;
                        default:
                            System.out.println("*************************************");
                            System.out.println("***Ungültige Eingabe! Überspringe!***");
                            System.out.println("*************************************\n");
                    }
                } else {
                    System.out.println("*******************************************************");
                    System.out.println("***Es existiert kein Konto mit dieser Email-Adresse!***");
                    System.out.println("*******************************************************\n");
                }
            }

            if (command.equals(EmailUiCommands.WR.getCommand())) {
                System.out.println("**********************************");
                System.out.println("***Sie haben " + EmailUiCommands.WR.getCommand() + " ausgewählt!***");
                System.out.println("**********************************\n");
                System.out.println("*************************************************************");
                System.out.println("***An wie viele Personenen soll die Email gesendet werden?***");
                System.out.println("************************************************************* \n");
                ArrayList<Empfaenger> empfaengers = new ArrayList<Empfaenger>();
                try {
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
                    System.out.println("****************************************************************************");
                    System.out.println("***Bitte gib den Namen für das Konto ein welches hinzugefügt werden soll!***");
                    System.out
                            .println("****************************************************************************\n");
                    String subject = BaseActions.readText();
                    System.out.println(
                            "*********************************************************************************");
                    System.out.println(
                            "***Bitte gib den HostServer für das Konto ein welches hinzugefügt werden soll!***");
                    System.out
                            .println(
                                    "*********************************************************************************\n");
                    String body = BaseActions.readText();
                    System.out.println("***************************************************************************");
                    System.out.println("***Bitte gib den Port für das Konto ein welches hinzugefügt werden soll!***");
                    System.out.println("***************************************************************************\n");
                    String type = BaseActions.readText();
                } catch (NumberFormatException ex) {
                    System.out.println("******************************************");
                    System.out.println("***Eingabe war keine Zahl! Überspringe!***");
                    System.out.println("******************************************\n");
                }

            }
        }

    }

    public KontoUi getKontoUi() {
        return kontoUi;
    }

    public void setKontoUi(KontoUi kontoUi) {
        this.kontoUi = kontoUi;
    }
}
