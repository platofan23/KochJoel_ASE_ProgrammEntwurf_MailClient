package mail_client;

public class ClientUiController 
{

    private ClientUiController() 
    {
        
    }

    public static void endProgramm() 
    {
        System.exit(0);
    }

    public static void showCommandList() 
    {
        for (ClientUiCommands clientUiCommand : ClientUiCommands.values()) 
        {
            String ausgabe = "---" + clientUiCommand.getCommand() + ": " + clientUiCommand.getDescription() + "---";
            for (int i = 0; i < ausgabe.length(); i++) 
            {
                if (i < ausgabe.length() - 1) 
                {
                    System.out.print("-");
                } 
                else 
                {
                    System.out.println("-");
                }
            }
            System.out.println(ausgabe);
            for (int i = 0; i < ausgabe.length(); i++) 
            {
                if (i < ausgabe.length() - 1) 
                {
                    System.out.print("-");
                } 
                else 
                {
                    System.out.println("-");
                }
            }
        }
        for (KontoUiCommands kontoUiCommand : KontoUiCommands.values()) 
        {
            String ausgabe = "---" + kontoUiCommand.getCommand() + ": " + kontoUiCommand.getDescription() + "---";
            for (int i = 0; i < ausgabe.length(); i++) 
            {
                if (i < ausgabe.length() - 1) 
                {
                    System.out.print("-");
                } 
                else 
                {
                    System.out.println("-");
                }
            }
            System.out.println(ausgabe);
            for (int i = 0; i < ausgabe.length(); i++) 
            {
                if (i < ausgabe.length() - 1) {
                    System.out.print("-");
                } 
                else 
                {
                    System.out.println("-");
                }
            }
        }
        for (EmailUiCommands emailUiCommands : EmailUiCommands.values()) 
        {
            String ausgabe = "---" + emailUiCommands.getCommand() + ": " + emailUiCommands.getDescription() + "---";
            for (int i = 0; i < ausgabe.length(); i++) 
            {
                if (i < ausgabe.length() - 1) 
                {
                    System.out.print("-");
                } 
                else 
                {
                    System.out.println("-");
                }
            }
            System.out.println(ausgabe);
            for (int i = 0; i < ausgabe.length(); i++) 
            {
                if (i < ausgabe.length() - 1) 
                {
                    System.out.print("-");
                } 
                else 
                {
                    System.out.println("-");
                }
            }
        }
        for (AdressbuchUiCommands adressbuchUiCommands : AdressbuchUiCommands.values()) 
        {
            String ausgabe = "---" + adressbuchUiCommands.getCommand() + ": " + adressbuchUiCommands.getDescription() + "---";
            for (int i = 0; i < ausgabe.length(); i++) 
            {
                if (i < ausgabe.length() - 1) 
                {
                    System.out.print("-");
                } 
                else 
                {
                    System.out.println("-");
                }
            }
            System.out.println(ausgabe);
            for (int i = 0; i < ausgabe.length(); i++) 
            {
                if (i < ausgabe.length() - 1) 
                {
                    System.out.print("-");
                } 
                else 
                {
                    System.out.println("-");
                }
            }
        }
    }
}
