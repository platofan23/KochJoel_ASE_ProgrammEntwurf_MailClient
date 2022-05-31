package mail_client;

import java.util.ArrayList;

public class KontoVerwaltung {
    private ArrayList<Konto> konten;

    public KontoVerwaltung() 
    {
        konten = new ArrayList<Konto>();
    }

    public void addKonto(Konto konto) 
    {
        konten.add(konto);
    }

    public void removeKonto(Konto konto) 
    {
        konten.remove(konto);
    }

    public Konto getSpecificKonto(String mailAdress) 
    {
        Konto back = null;
        for(Konto konto: konten)
        {
            if(konto.getMailAdresse().equals(mailAdress)) 
            {
                back = konto;
            }
        }
        return back;
    }

    public String getAllKonten() 
    {
        String back = "";
        for (Konto konto : konten) 
        {
            back = back + konto.getMailAdresse() + "\n";
        }
        return back;
    }

    public ArrayList<Konto> getKonten() 
    {
        return konten;
    }

    public void setKonten(ArrayList<Konto> konten) 
    {
        this.konten = konten;
    }

    @Override
    public String toString() 
    {
        return "KontoVerwaltung [konten=" + konten + "]";
    }  
}
