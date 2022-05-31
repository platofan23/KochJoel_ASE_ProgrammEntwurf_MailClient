package mail_client;

public enum EmailUiCommands 
{
    WR("/Write", "Dieser Befehl startet das Schreiben einer EMail!"),
    SH("/Show", "Dieser Befehl startet das Anzeigen einer EMail!"),
    LI("/List", "Dieser Befehl listet die EMails im Posteingang!"),
    FW("/Forward", "Dieser Befehl leitet eine Email weiter!"),
    Del("/Delete", "Der Befehl wird zum Löschen einer Email benötigt an!");

    private final String command;
    private final String description;

    EmailUiCommands(String command, String description) 
    {
        this.command = command;
        this.description = description;
    }

    public String getCommand() 
    {
        return command;
    }

    public String getDescription() 
    {
        return description;
    }
}
