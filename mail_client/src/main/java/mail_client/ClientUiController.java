package mail_client;

public class ClientUiController {
    public static void endProgramm() {
        System.exit(0);
    }

    public static void showCommandList() {
        for (ClientUiCommands clientUiCommand : ClientUiCommands.values()) {
            System.out.println(clientUiCommand.getCommand() + ": " + clientUiCommand.getDescription());
        }

    }
}
