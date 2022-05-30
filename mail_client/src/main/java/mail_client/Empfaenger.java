package mail_client;

public class Empfaenger 
{
    private String mailAdress;
    private String name;

    public Empfaenger(String mailAdress, String name) 
    {
        this.mailAdress = mailAdress;
        this.name = name;
    }

    public String getMailAdress() 
    {
        return mailAdress;
    }

    public void setMailAdress(String mailAdress) 
    {
        this.mailAdress = mailAdress;
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
        return "Empfaenger [mailAdress=" + mailAdress + ", name=" + name + "]";
    }
}
