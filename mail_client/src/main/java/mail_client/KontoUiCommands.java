package mail_client;

public enum KontoUiCommands 
{
    Add("/AddKonto", "Dieser Befehl fügt ein neues Konto zum Client hinzu!"),
    Remove("/RemoveKonto", "Dieser Befehl löscht ein Konto aus dem Client!"),
    Get("/GetKonto", "Dieser Befehl lässt die ganzen Details eines Kontos anzeigen!"),
    GetAll("/GetAllKonten", "Dieser Befehl lässt die ganzen Konten anzeigen!"),
    Change("/ChangeKonto", "Dieser Befehl lässt die Parameter eines Kontos anpassen!");

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
