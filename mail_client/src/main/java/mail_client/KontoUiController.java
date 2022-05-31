package mail_client;

public class KontoUiController 
{

    private KontoUiController() 
    {

    }

    public static void changeKontoMailAdress(Konto konto,String mailAdresse) 
    {
        konto.setMailAdresse(mailAdresse);
    }

    public static void changeKontoPassword(Konto konto,String passwort) 
    {
        konto.setPasswort(passwort);
    }

    public static void changeKontoName(Konto konto,String name) 
    {
        konto.setName(name);
    }

    public static void changeKontoSmtpServer(Konto konto,String smtpServer) 
    {
        konto.setSmtpServer(smtpServer);
    }

    public static void changeKontoImapServer(Konto konto,String imapServer) 
    {
        konto.setImapServer(imapServer);
    }

    public static void changeKontoPortSmtp(Konto konto,int portSmtp)
    {
        konto.setPortSmtp(portSmtp);
    }

    public static void changeKontoPortImap(Konto konto,int portImap)
    {
        konto.setPortImap(portImap);
    }
}
