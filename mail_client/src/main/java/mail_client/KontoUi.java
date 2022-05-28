package mail_client;

import java.util.ArrayList;

public class KontoUi {
    private ArrayList<Konto> konten;

    public KontoUi() {
        konten = new ArrayList<Konto>();
    }

    public void addKonto(Konto konto) {
        konten = KontoUiController.addKonto(konten, konto);
    }

    public void removeKonto(Konto konto) {
        konten = KontoUiController.removeKonto(konten, konto);
    }

    public Konto getSpecificKonto(String mailAdresse) {
        return KontoUiController.getSpecificKonto(konten, mailAdresse);
    }

    public void changeSpecificKonto() {

    }

    public String getAllKonten() {
        return KontoUiController.getAllKonten(konten);
    }

    public ArrayList<Konto> getKonten() {
        return konten;
    }

    public void setKonten(ArrayList<Konto> konten) {
        this.konten = konten;
    }

}
