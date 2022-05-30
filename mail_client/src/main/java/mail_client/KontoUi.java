package mail_client;

import java.util.ArrayList;

public class KontoUi 
{
    private ArrayList<Konto> konten;

    public KontoUi() 
    {
        konten = new ArrayList<Konto>();
    }

    public void addKonto(Konto konto) 
    {
        konten = KontoUiController.addKonto(konten, konto);
    }

    public void removeKonto(Konto konto) 
    {
        konten = KontoUiController.removeKonto(konten, konto);
    }

    public Konto getSpecificKonto(String mailAdresse) 
    {
        return KontoUiController.getSpecificKonto(konten, mailAdresse);
    }

    public String getAllKonten() 
    {
        return KontoUiController.getAllKonten(konten);
    }

    public ArrayList<Konto> getKonten() 
    {
        return konten;
    }

    public void setKonten(ArrayList<Konto> konten) 
    {
        this.konten = konten;
    }

    public void changeKontoMailAdress(Konto konto,String mailAdresse) 
    {
        KontoUiController.changeKontoMailAdress(konto, mailAdresse);
    }

    public void changeKontoPassword(Konto konto,String passwort) 
    {
        KontoUiController.changeKontoPassword(konto, passwort);
    }

    public void changeKontoName(Konto konto,String name) 
    {
        KontoUiController.changeKontoName(konto, name);
    }

    public void changeKontoHostServer(Konto konto,String hostServer) 
    {
        KontoUiController.changeKontoHostServer(konto, hostServer);
    }

    public void changeKontoPort(Konto konto,int port)
    {
        KontoUiController.changeKontoPort(konto, port);
    }
}