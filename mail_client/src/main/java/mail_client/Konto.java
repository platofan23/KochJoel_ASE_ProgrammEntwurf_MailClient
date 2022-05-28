package mail_client;

public class Konto {
    private String mailAdresse;
    private String passwort;
    private String hostServer;
    private int port;
    private KontoController kontoSchnittstelle;

    public Konto(String mailAdresse, String passwort, String hostServer, int port) {
        this.mailAdresse = mailAdresse;
        this.passwort = passwort;
        this.hostServer = hostServer;
        this.port = port;
        kontoSchnittstelle = new KontoController(this);
    }

    public String getMailAdresse() {
        return mailAdresse;
    }

    public void setMailAdresse(String mailAdresse) {
        this.mailAdresse = mailAdresse;
    }

    public String getHostServer() {
        return hostServer;
    }

    public void setHostServer(String hostServer) {
        this.hostServer = hostServer;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public KontoController getKontoSchnittstelle() {
        return kontoSchnittstelle;
    }

    public void setKontoSchnittstelle(KontoController kontoSchnittstelle) {
        this.kontoSchnittstelle = kontoSchnittstelle;
    }

}
