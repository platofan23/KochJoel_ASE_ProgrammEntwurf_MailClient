package mail_client;

public class Konto 
{
    private String mailAdresse;
    private String passwort;
    private String smtpServer;
    private String imapServer;
    private String name;
    private int portSmtp;
    private int portImap;

    public Konto(String mailAdresse, String passwort, String smtpServer, String imapServer, String name, int portSmtp,
            int portImap) 
    {
        this.mailAdresse = mailAdresse;
        this.passwort = passwort;
        this.smtpServer = smtpServer;
        this.imapServer = imapServer;
        this.name = name;
        this.portSmtp = portSmtp;
        this.portImap = portImap;
    }

    public String getMailAdresse() 
    {
        return mailAdresse;
    }

    public void setMailAdresse(String mailAdresse) 
    {
        this.mailAdresse = mailAdresse;
    }

    public String getSmtpServer() {
        return smtpServer;
    }

    public void setSmtpServer(String smtpServer) 
    {
        this.smtpServer = smtpServer;
    }

    public String getImapServer() 
    {
        return imapServer;
    }

    public void setImapServer(String imapServer) 
    {
        this.imapServer = imapServer;
    }

    public int getPortSmtp() 
    {
        return portSmtp;
    }

    public void setPortSmtp(int portSmtp) 
    {
        this.portSmtp = portSmtp;
    }

    public int getPortImap() 
    {
        return portImap;
    }

    public void setPortImap(int portImap) 
    {
        this.portImap = portImap;
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
        return "Konto [imapServer=" + imapServer + ", mailAdresse=" + mailAdresse + ", name=" + name + ", passwort="
                + passwort + ", portImap=" + portImap + ", portSmtp=" + portSmtp + ", smtpServer=" + smtpServer + "]\n";
    }

}
