package mail_client;

public enum ClientUiCommands 
{
    Qu("/Quit", "Dieser Befehl beendet das Programm!"),
    CMD("/CMD", "Der Befehl zeigt die Befehlliste an!");

    private final String command;
    private final String description;

    ClientUiCommands(String command, String description) 
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
