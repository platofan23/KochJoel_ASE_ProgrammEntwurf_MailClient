package mail_client;

public class Konto 
{
    private String mailAdresse;
    private String passwort;
    private String hostServer;
    private String name;
    private int port;

    public Konto(String mailAdresse, String passwort, String hostServer, String name, int port) 
    {
        this.mailAdresse = mailAdresse;
        this.passwort = passwort;
        this.hostServer = hostServer;
        this.name = name;
        this.port = port;
    }

    public String getMailAdresse() 
    {
        return mailAdresse;
    }

    public void setMailAdresse(String mailAdresse) 
    {
        this.mailAdresse = mailAdresse;
    }

    public String getHostServer() 
    {
        return hostServer;
    }

    public void setHostServer(String hostServer) 
    {
        this.hostServer = hostServer;
    }

    public int getPort() 
    {
        return port;
    }

    public void setPort(int port) 
    {
        this.port = port;
    }

    public String getPasswort() 
    {
        return passwort;
    }

    public void setPasswort(String passwort) 
    {
        this.passwort = passwort;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    @Override
    public String toString() 
    {
        return "Konto [hostServer=" + hostServer + ", mailAdresse=" + mailAdresse + ", name=" + name + ", passwort="
                + passwort + ", port=" + port + "]";
    }

}
