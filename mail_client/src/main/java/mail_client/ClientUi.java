package mail_client;

public class ClientUi {
    private KontoUi kontoUi;

    public ClientUi(KontoUi kontoUi) {
        this.kontoUi = kontoUi;
    }

    public KontoUi getKontoUi() {
        return kontoUi;
    }

    public void setKontoUi(KontoUi kontoUi) {
        this.kontoUi = kontoUi;
    }

    public void startUI() {
        boolean end = false;
        while (end == false) {
            String command = BaseActions.readText();
            if (command.equals(ClientUiCommands.St.getCommand())) {

            }

            if (command.equals(ClientUiCommands.Qu.getCommand())) {
                ClientUiController.endProgramm();
            }

        }
    }

}
