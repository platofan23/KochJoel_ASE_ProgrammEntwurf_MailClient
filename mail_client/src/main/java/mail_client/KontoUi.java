package mail_client;

import java.util.ArrayList;

public class KontoUi {
    private ArrayList<Konto> konten;
    private KontoCommands commands;

    public KontoUi() {
        konten = new ArrayList<Konto>();
    }

    public void addKonto(Konto konto) {
        konten.add(konto);
    }

    public void removeKonto(Konto konto) {
        konten.remove(konto);
    }

    public Konto getSpecificKonto() {
        return null;
    }

    public void changeSpecificKonto() {

    }

}
