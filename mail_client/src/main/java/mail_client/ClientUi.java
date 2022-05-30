package mail_client;

import java.util.ArrayList;

public class ClientUi 
{
    private KontoUi kontoUi;
    private EmailUi emailUi;

    public ClientUi() 
    {
        kontoUi = new KontoUi();
        emailUi = new EmailUi();
    }

    public boolean startUi(String command) 
    {  
        boolean isDone = false; 
        if (command.equals(ClientUiCommands.Qu.getCommand())) 
        {
            System.out.println("*********************************");
            System.out.println("***Sie haben " + ClientUiCommands.Qu.getCommand() + " ausgewählt!***");
            System.out.println("*********************************\n");
            System.out.println("**************************");
            System.out.println("***Beende das Programm!***");
            System.out.println("**************************");
            ClientUiController.endProgramm();
            isDone = true;
        }

        if (command.equals(ClientUiCommands.CMD.getCommand())) 
        {
            System.out.println("*********************************");
            System.out.println("***Sie haben " + ClientUiCommands.CMD.getCommand() + " ausgewählt!***");
            System.out.println("*********************************\n");
            System.out.println("*********************");
            System.out.println("***Die Befehlliste***");
            System.out.println("*********************\n");
            ClientUiController.showCommandList();
            isDone = true;
        }      
        return isDone;
    }

    public KontoUi getKontoUi() 
    {
        return kontoUi;
    }

    public void setKontoUi(KontoUi kontoUi) 
    {
        this.kontoUi = kontoUi;
    }
}
