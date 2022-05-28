package mail_client;

public enum KontoCommands {
    Addk("Add new Konto!"),
    removeKonto("Remove a Konto"),
    getSpecificKonto("get a Konto"),
    changeSpecificKonto("Change Konto data");

    private final String command;

    KontoCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
