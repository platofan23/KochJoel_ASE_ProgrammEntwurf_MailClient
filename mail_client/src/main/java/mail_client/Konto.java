package mail_client;

public class Konto {
    private String mailAdresse;
    private String passwort;
    
    public Konto(String mailAdresse, String passwort) {
        this.mailAdresse = mailAdresse;
        this.passwort = passwort;
    }

    

    public String getMailAdresse() {
        return mailAdresse;
    }

    public void setMailAdresse(String mailAdresse) {
        this.mailAdresse = mailAdresse;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    
}
