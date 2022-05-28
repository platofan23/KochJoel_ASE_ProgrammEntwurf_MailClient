package mail_client;

import java.util.Scanner;

public class BaseActions {
    public BaseActions() {

    }

    public static String readText() {
        Scanner scanner = new Scanner(System.in);
        String back = scanner.nextLine();
        scanner.close();
        return back;
    }

}
