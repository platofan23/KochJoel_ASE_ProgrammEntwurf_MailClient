package mail_client;

public class KontoController {
    private Konto konto;

    public KontoController(Konto konto) {
        this.konto = konto;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

}
