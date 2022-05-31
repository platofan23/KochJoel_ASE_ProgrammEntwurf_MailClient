package mail_client;
public class Kontakt 
{
    private String name;
    private String emailAdress;
    private String organisation;
    private String telefonNummer;

    public Kontakt(String name, String emailAdress, String organisation, String telefonNummer) 
    {
        this.name = name;
        this.emailAdress = emailAdress;
        this.organisation = organisation;
        this.telefonNummer = telefonNummer;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getEmailAdress() 
    {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) 
    {
        this.emailAdress = emailAdress;
    }

    public String getOrganisation() 
    {
        return organisation;
    }

    public void setOrganisation(String organisation) 
    {
        this.organisation = organisation;
    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(String telefonNummer) 
    {
        this.telefonNummer = telefonNummer;
    }

    @Override
    public String toString() 
    {
        return "Kontakt [emailAdress=" + emailAdress + ", name=" + name + ", organisation=" + organisation
                + ", telefonNummer=" + telefonNummer + "]\n";
    }    
}
