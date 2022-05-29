package mail_client;

public enum EmailUiCommands {
    WR("/Write", "Dieser Befehl startet das Schreiben einer EMail!"),
    Del("/Delete", "Der Befehl zeigt die Befehlliste an!");

    private final String command;
    private final String description;

    EmailUiCommands(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
