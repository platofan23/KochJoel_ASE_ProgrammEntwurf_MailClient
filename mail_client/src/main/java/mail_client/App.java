package mail_client;

public final class App {
        private App() {

        }

        public static void main(String[] args) 
        {
                System.out.println(
                                "**********************************************************************************************");
                System.out.println(
                                "***Herzlich Willkommen zu dem ASE-Projekt Email-Client von Joel Koch aus dem Kurs TINF19B5!***");
                System.out.println(
                                "**********************************************************************************************\n");

                ClientUi clientUi = new ClientUi();
                KontoUi kontoUi = new KontoUi();
                AdressbuchUi adressbuchUi = new AdressbuchUi();

                kontoUi.getKontoVerwaltung().addKonto(new Konto("/W","itinimcqsauafchm","smtp.gmail.com","imap.google.com","Jona Müller",587,993));
                adressbuchUi.getAdressbuch().addKontakt(new Kontakt("Jona Müller", "müller@web.de", "NTT", "01251651"));
                EmailUi emailUi = new EmailUi();
                boolean end = false;
                while (end == false) 
                {
                        System.out
                                .println("********************************************************");
                        System.out
                                .println("***Warte auf Eingabe! Tippe " + ClientUiCommands.CMD.getCommand()
                                        + " für die Befehlliste!***");
                        System.out
                                .println(
                                        "********************************************************\n");
                        String command = BaseActions.readText();
                        boolean isDone = clientUi.startUi(command);

                        if(isDone == false) 
                        {
                                isDone = kontoUi.startUi(command);
                        }

                        if(isDone == false) 
                        {
                                emailUi.startUi(command,kontoUi);
                        }

                        if(isDone == false) 
                        {
                                adressbuchUi.startUi(command);
                        }
                }

        }
}
