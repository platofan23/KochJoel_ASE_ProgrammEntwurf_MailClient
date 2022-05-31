package mail_client;

import java.util.ArrayList;

public class Adressbuch 
{
    private String name;
    private ArrayList<Kontakt> kontakte;

    public Adressbuch(String name) 
    {
        this.name = name;
        kontakte = new ArrayList<Kontakt>();
    }

    public void addKontakt(Kontakt kontakt) 
    {
        kontakte.add(kontakt);
    }

    public void removeKontakt(Kontakt kontakt) 
    {
        kontakte.remove(kontakt);
    }

    public Kontakt getSpecificKontakt(String mailAdress) 
    {
        Kontakt back = null;
        for(Kontakt kontakt: kontakte)
        {
            if(kontakt.getEmailAdress().equals(mailAdress)) 
            {
                back = kontakt;
            }
        }
        return back;
    }

    public String getAllKontakte() 
    {
        String back = "";
        for (Kontakt kontakt : kontakte) 
        {
            back = back + kontakt.getEmailAdress() + "\n";
        }
        return back;
    }

    public String getName() 
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public ArrayList<Kontakt> getKontakte() 
    {
        return kontakte;
    }

    public void setKontakte(ArrayList<Kontakt> kontakte) 
    {
        this.kontakte = kontakte;
    }

    @Override
    public String toString() {
        return "Adressbuch [kontakte=" + kontakte + ", name=" + name + "]";
    }

    
}
