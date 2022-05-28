package mail_client;

import java.util.ArrayList;

public class KontoUi {
    private ArrayList<Konto> konten;
    private KontoCommands[] commands;

    public KontoUi() {
        konten = new ArrayList<Konto>();
        commands = KontoCommands.values();
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

    public ArrayList<Konto> getKonten() {
        return konten;
    }

    public void setKonten(ArrayList<Konto> konten) {
        this.konten = konten;
    }

    public KontoCommands[] getCommands() {
        return commands;
    }

    public void setCommands(KontoCommands commands[]) {
        this.commands = commands;
    }

    public void changeSpecificKonto() {

    }

}
