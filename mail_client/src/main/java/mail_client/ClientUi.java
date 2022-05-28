package mail_client;

public class ClientUi {
    private KontoUi kontoUi;

    public ClientUi() {
        kontoUi = new KontoUi();
    }

    public KontoUi getKontoUi() {
        return kontoUi;
    }

    public void setKontoUi(KontoUi kontoUi) {
        this.kontoUi = kontoUi;
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
        }
    }

}
