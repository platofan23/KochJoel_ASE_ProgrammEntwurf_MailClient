package mail_client;

import java.util.ArrayList;

public class Email {
    private Konto from;
    private ArrayList<Empfaenger> empfaenger;
    private String subject;
    private String body;
    private String type;

    public Email(Konto from, ArrayList<Empfaenger> empfaenger, String subject, String body, String type) {
        this.from = from;
        this.empfaenger = empfaenger;
        this.subject = subject;
        this.body = body;
        this.type = type;
    }

    public Konto getFrom() {
        return from;
    }

    public void setFrom(Konto from) {
        this.from = from;
    }

    public ArrayList<Empfaenger> getEmpfaenger() {
        return empfaenger;
    }

    public void setEmpfaenger(ArrayList<Empfaenger> empfaenger) {
        this.empfaenger = empfaenger;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Email [Subject=" + subject + ", body=" + body + ", empfaenger=" + empfaenger + ", from=" + from
                + ", type=" + type + "]";
    }

}
