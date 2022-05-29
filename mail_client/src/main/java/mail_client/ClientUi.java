package mail_client;

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
                System.out.println("Beende das Programm!");
                ClientUiController.endProgramm();
            }

            if (command.equals(ClientUiCommands.CMD.getCommand())) {
                System.out.println("Die Befehlliste");
                ClientUiController.showCommandList();
            }

            if (command.equals(KontoUiCommands.Add.getCommand())) {
                System.out.println("Bitte gib die Mail-Adresse für das Konto ein welches hinzugefügt werden soll!");
                String mailAdresse = BaseActions.readText();
                System.out.println("Bitte gib das Passwort für das Konto ein welches hinzugefügt werden soll!");
                String passwort = BaseActions.readText();
                System.out.println("Bitte gib den Namen für das Konto ein welches hinzugefügt werden soll!");
                String name = BaseActions.readText();
                System.out.println("Bitte gib den HostServer für das Konto ein welches hinzugefügt werden soll!");
                String hostServer = BaseActions.readText();
                System.out.println("Bitte gib den Port für das Konto ein welches hinzugefügt werden soll!");
                int port = Integer.parseInt(BaseActions.readText());
                Konto konto = new Konto(mailAdresse, passwort, hostServer, name, port);
                this.kontoUi.addKonto(konto);
            }

            if (command.equals(KontoUiCommands.Remove.getCommand())) {
                System.out.println("Bitte gib die Mail-Adresse für das Konto ein welches entfernt werden soll!");
                String mailAdresse = BaseActions.readText();
                Konto specificKonto = this.kontoUi.getSpecificKonto(mailAdresse);
                this.kontoUi.getKonten().remove(specificKonto);
            }

            if (command.equals(KontoUiCommands.Get.getCommand())) {
                System.out.println(
                        "Bitte gib die Mail-Adresse für das Konto ein welches die Details angezeigt werden sollen!");
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
                            "Was möchten Sie ändern? Tippe 1 für die Mail-Adresse, 2 für das Passwort, 3 für den HostServer, 4 für den Namen und 5 für den Port!");
                    int choiceNumber = 0;
                    try {
                        choiceNumber = Integer.parseInt(BaseActions.readText());
                    } catch (NumberFormatException ex) {
                        System.out.println("Eingabe war keine Zahl! Überspringe!");
                    }
                    switch (choiceNumber) {
                        case (1):
                            System.out.println("Geben Sie die neue Mail-Adresse ein!");
                            String mailAdresseNeu = BaseActions.readText();
                            specificKonto.setMailAdresse(mailAdresseNeu);
                            break;
                        case (2):
                            System.out.println("Geben Sie das neue Passwort ein!");
                            String passwortNeu = BaseActions.readText();
                            specificKonto.setPasswort(passwortNeu);
                            break;
                        case (3):
                            System.out.println("Geben Sie den HostServer ein!");
                            String hostServerNeu = BaseActions.readText();
                            specificKonto.setHostServer(hostServerNeu);
                            break;
                        case (4):
                            System.out.println("Geben Sie den neuen Port ein!");
                            try {
                                int nameNeu = Integer.parseInt(BaseActions.readText());
                                specificKonto.setPort(nameNeu);
                            } catch (NumberFormatException ex) {
                                System.out.println("Eingabe war keine Zahl! Überspringe!");
                            }
                            break;
                        case (5):
                            System.out.println("Geben Sie den neuen Port ein!");
                            int portNeu = Integer.parseInt(BaseActions.readText());
                            specificKonto.setPort(portNeu);
                            break;
                        default:
                            System.out.println("Ungültige Eingabe! Überspringe!");
                    }
                } else {
                    System.out.println("Es existiert kein Konto mit dieser Email-Adresse!");
                }
            }

            if (command.equals(EmailUiCommands.WR.getCommand())) {
                System.out.println("***************************************************************");
                System.out.println("Sie haben " + EmailUiCommands.WR.getCommand() + " ausgewählt!");
                System.out.println("***************************************************************");
                System.out.println("An wie viele Personenen soll die Email gesendet werden?");

                System.out.println("Bitte gib die Mail-Adresse für das Konto ein welches hinzugefügt werden soll!");
                String mailAdresseEmpfaenger = BaseActions.readText();
                System.out.println("Bitte gib das Passwort für das Konto ein welches hinzugefügt werden soll!");
                String nameEmpfaenger = BaseActions.readText();
                System.out.println("Bitte gib den Namen für das Konto ein welches hinzugefügt werden soll!");
                String subject = BaseActions.readText();
                System.out.println("Bitte gib den HostServer für das Konto ein welches hinzugefügt werden soll!");
                String body = BaseActions.readText();
                System.out.println("Bitte gib den Port für das Konto ein welches hinzugefügt werden soll!");
                String type = BaseActions.readText();

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
