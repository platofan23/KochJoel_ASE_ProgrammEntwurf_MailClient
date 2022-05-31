package mail_client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

@DisplayName("KontoTests")

public class KontoverwaltungsTests {
    @Test
    void firstTest()
    {
        KontoVerwaltung kw = new KontoVerwaltung();
        
        Konto konto = new Konto("tischtennismeisterelf@gmail.com","itinimcqsauafchm","smtp.gmail.com","imap.gmail.com","Jona Müller",587,993);

        kw.addKonto(konto);  

        String mailAdresse = "tischtennismeisterelf@gmail.com";

        assertEquals(konto, kw.getSpecificKonto(mailAdresse));
    }

    @Test
    void secondTest()
    {
        KontoVerwaltung kw = new KontoVerwaltung();
        
        Konto konto = new Konto("joel.koch@live.de","itinimcqsauafchm","smtp.gmail.com","imap.gmail.com","Jona Müller",587,993);

        kw.addKonto(konto);  
        
        KontoUiController.changeKontoMailAdress(konto,"tischtennismeisterelf@gmail.com");

        assertEquals("tischtennismeisterelf@gmail.com",konto.getMailAdresse());     
    }

    @Test
    void thirdTest()
    {
        assertEquals("/AddKonto",KontoUiCommands.Add.getCommand());
    }    
    
    @Test
    void fourthTest()
    {
        assertEquals("Dieser Befehl löscht ein Konto aus dem Client!",KontoUiCommands.Remove.getDescription());
    }  

    @Test
    void fifthTest()
    {   
        KontoVerwaltung kw = new KontoVerwaltung();
        
        Konto konto = new Konto("joel.koch@live.de","itinimcqsauafchm","smtp.gmail.com","imap.gmail.com","Jona Müller",587,993);
        
        kw.addKonto(konto);   

        konto = new Konto("joel.koch@live.de","itinimcqsauafchm","smtp.gmail.com","imap.gmail.com","Joel Koch",587,993);
        
        kw.addKonto(konto);

       assertEquals(2,kw.getKonten().size());
    }  
}
