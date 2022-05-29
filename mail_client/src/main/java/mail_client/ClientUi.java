package mail_client;

public class ClientUi {
    private KontoUi kontoUi;

    public ClientUi() {
        kontoUi = new KontoUi();
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
                System.out.println("Bitte gib den HostServer für das Konto ein welches hinzugefügt werden soll!");
                String hostServer = BaseActions.readText();
                System.out.println("Bitte gib den Port für das Konto ein welches hinzugefügt werden soll!");
                int port = Integer.parseInt(BaseActions.readText());
                Konto konto = new Konto(mailAdresse, passwort, hostServer, port);
                this.kontoUi.addKonto(konto);
            }

            if (command.equals(KontoUiCommands.Remove.getCommand())) {
                System.out.println("Bitte gib die Mail-Adresse für das Konto ein welches entfernt werden soll!");
                String mailAdresse = BaseActions.readText();
                this.kontoUi.getKonten().remove(this.kontoUi.getSpecificKonto(mailAdresse));
            }

            if (command.equals(KontoUiCommands.Get.getCommand())) {
                System.out.println(
                        "Bitte gib die Mail-Adresse für das Konto ein welches die Details angezeigt werden sollen!");
                String mailAdresse = BaseActions.readText();
                if (this.kontoUi.getSpecificKonto(mailAdresse) != null) {
                    System.out.println(this.kontoUi.getSpecificKonto(mailAdresse).toString());
                } else {
                    System.out.println("Es existiert kein Konto mit dieser Email-Adresse!");
                }
            }

            if (command.equals(KontoUiCommands.GetAll.getCommand())) {
                if (this.kontoUi.getAllKonten().equals("") == false) {
                    System.out.println("Kontoliste:");
                    System.out.println(this.kontoUi.getAllKonten());
                } else {
                    System.out.println("Keine Konten vorhanden!");
                }
            }

            if (command.equals(KontoUiCommands.Change.getCommand())) {
                System.out.println(
                        "Bitte gib die Mail-Adresse für das Konto ein welches die Parameter geändert werden sollen!");
                String mailAdresse = BaseActions.readText();
                if (this.kontoUi.getSpecificKonto(mailAdresse) != null) {
                    System.out.println(
                            "Was möchten Sie ändern? Tippe 1 für die Mail-Adresse, 2 für das Passwort, 3 für den HostServer und 4 für den Port!");
                    String choiceNumber = BaseActions.readText();
                    switch (choiceNumber) {
                        case ("1"):
                            System.out.println("Geben Sie die neue Mail-Adresse ein!");
                            String mailAdresseNeu = BaseActions.readText();
                            this.kontoUi.getSpecificKonto(mailAdresse).setMailAdresse(mailAdresseNeu);
                            break;
                        case ("2"):
                            System.out.println("Geben Sie das neue Passwort ein!");
                            String passwortNeu = BaseActions.readText();
                            this.kontoUi.getSpecificKonto(mailAdresse).setPasswort(passwortNeu);
                            break;
                        case ("3"):
                            System.out.println("Geben Sie den HostServer ein!");
                            String hostServerNeu = BaseActions.readText();
                            this.kontoUi.getSpecificKonto(mailAdresse).setHostServer(hostServerNeu);
                            break;
                        case ("4"):
                            System.out.println("Geben Sie den neuen Port ein!");
                            int portNeu = Integer.parseInt(BaseActions.readText());
                            this.kontoUi.getSpecificKonto(mailAdresse).setPort(portNeu);
                            break;
                        default:
                            System.out.println("Ungültige Eingabe! Überspringe!");
                    }
                } else {
                    System.out.println("Es existiert kein Konto mit dieser Email-Adresse!");
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
