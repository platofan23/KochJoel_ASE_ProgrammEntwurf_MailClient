package mail_client;

import java.util.ArrayList;

public class KontoUiController {

    public KontoUiController() {

    }

    public static ArrayList<Konto> addKonto(ArrayList<Konto> konten, Konto konto) {
        konten.add(konto);
        return konten;
    }

    public static ArrayList<Konto> removeKonto(ArrayList<Konto> konten, Konto konto) {
        konten.remove(konto);
        return konten;
    }

    public static Konto getSpecificKonto(ArrayList<Konto> konten, String mailAdresse) {
        Konto back = null;
        for (Konto konto : konten) {
            if (konto.getMailAdresse().equals(mailAdresse)) {
                back = konto;
                break;
            }
        }
        return back;
    }

    public static String getAllKonten(ArrayList<Konto> konten) {
        String back = "";
        for (Konto konto : konten) {
            back = back + konto.toString() + "\n";
        }
        return back;
    }

    public static void changeMailAdress(ArrayList<Konto> konten, String mailAdresse) {

    }

}
