package mail_client;

public final class App {
        private App() {
        }

        public static void main(String[] args) {
                System.out.println(
                                "**********************************************************************************************");
                System.out.println(
                                "***Herzlich Willkommen zu dem ASE-Projekt Email-Client von Joel Koch aus dem Kurs TINF19B5!***");
                System.out.println(
                                "**********************************************************************************************\n");
                ClientUi clientUi = new ClientUi();
                clientUi.startUi();
                
        }
}
