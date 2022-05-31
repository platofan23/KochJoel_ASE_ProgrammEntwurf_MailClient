package mail_client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

@DisplayName("AdressbuchTests")

public class AdressbuchTests {
   
    @Test
    void firtTest()
    {
        Adressbuch adressbuch = new Adressbuch("Test");

        Kontakt k = new Kontakt("Ein Kontakt", "kontakt@kontakt.com", "Kontakt AG", "101514132");

        adressbuch.addKontakt(k);

        assertEquals(1, adressbuch.getKontakte().size());
    }

    @Test
    void secondTest()
    {
        Adressbuch adressbuch = new Adressbuch("Test");

        Kontakt k = new Kontakt("Ein Kontakt", "kontakt@kontakt.com", "Kontakt AG", "101514132");

        adressbuch.addKontakt(k);

        adressbuch.removeKontakt(k);

        assertEquals(0, adressbuch.getKontakte().size());
    }

    @Test
    void thirdTest()
    {
        AdressbuchUi adressUi= new AdressbuchUi();

        assertEquals(false, adressUi.startUi("/DeleteAll"));     
    }  
    
    @Test
    void fourthTest()
    {
        Adressbuch adressbuch = new Adressbuch("Test");

        Kontakt k = new Kontakt("Ein Kontakt", "kontakt@kontakt.com", "Kontakt AG", "101514132");

        adressbuch.addKontakt(k);

        adressbuch.addKontakt(k);

        adressbuch.addKontakt(k);

        adressbuch.removeKontakt(k);

        assertEquals(2, adressbuch.getKontakte().size());
    }

    @Test
    void fifthTest()
    {
        Adressbuch adressbuch = new Adressbuch("Test");

        Kontakt k = new Kontakt("Ein Kontakt", "kontakt@kontakt.com", "Kontakt AG", "101514132");

        adressbuch.removeKontakt(k);

        assertEquals(0, adressbuch.getKontakte().size());
    }

}
