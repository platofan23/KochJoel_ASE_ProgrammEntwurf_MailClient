package mail_client;

public enum KontoUiCommands 
{
    Add("/Add", "Dieser Befehl fügt ein neues Konto zum Client hinzu!"),
    Remove("/Remove", "Dieser Befehl löscht ein Konto aus dem Client!"),
    Get("/Get", "Dieser Befehl lässt die ganzen Details eines Kontos anzeigen!"),
    GetAll("/GetAll", "Dieser Befehl lässt die ganzen Konten anzeigen!"),
    Change("/Change", "Dieser Befehl lässt die Parameter eines Kontos anpassen!");

    private final String command;
    private final String description;

    KontoUiCommands(String command, String description) 
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
