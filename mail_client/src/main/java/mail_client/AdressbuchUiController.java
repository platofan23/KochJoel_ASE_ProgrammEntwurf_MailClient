package mail_client;

public class AdressbuchUiController 
{

    private AdressbuchUiController()
    {
        
    }

    public static void changeKontaktMailAdress(Kontakt kontakt,String emailAdress) 
    {
        kontakt.setEmailAdress(emailAdress);
    }

    public static void changeKontaktName(Kontakt kontakt,String name) 
    {
        kontakt.setName(name);
    }

    public static void changeKontaktOrganisation(Kontakt kontakt,String organisation) 
    {
        kontakt.setOrganisation(organisation);
    }

    public static void changeKontaktTelefonNummer(Kontakt kontakt,String telefonNummer) 
    {
        kontakt.setTelefonNummer(telefonNummer);
    }    
}
