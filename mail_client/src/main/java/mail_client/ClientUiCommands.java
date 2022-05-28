package mail_client;

public enum ClientUiCommands {
    St("Start"),
    Qu("Quit");

    private final String command;

    ClientUiCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

}
