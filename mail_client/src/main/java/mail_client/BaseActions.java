package mail_client;

import java.util.Scanner;

public class BaseActions 
{
    private static Scanner scanner = new Scanner(System.in);;

    public BaseActions() 
    {

    }

    public static String readText() 
    {
        String back = scanner.nextLine();
        return back;
    }

}
