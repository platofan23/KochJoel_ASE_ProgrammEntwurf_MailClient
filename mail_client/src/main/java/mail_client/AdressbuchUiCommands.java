package mail_client;

public enum AdressbuchUiCommands 
{
    Add("/AddKonktakt", "Dieser Befehl fügt ein neuer Kontakt zum Adressbuch hinzu!"),
    Remove("/RemoveKontakt", "Dieser Befehl löscht ein Kontakt aus dem Adressbuch!"),
    Get("/GetKontakt", "Dieser Befehl lässt die ganzen Details eines Kontaktes anzeigen!"),
    GetAll("/GetAllKontakte", "Dieser Befehl lässt die ganzen Kontakte anzeigen!"),
    Change("/ChangeKontakt", "Dieser Befehl lässt die Parameter eines Kontaktes anpassen!");

    private final String command;
    private final String description;

    AdressbuchUiCommands(String command, String description) 
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
