package mail_client;

public class EmailUi {

    public EmailUi() {

    }

    public void sendEmail(Email email) {
        if (email.getType().equals("Text")) {
            EmailUiController.sendTextEmail(email);
        } else {
            EmailUiController.sendHtmlEmail(email);
        }
    }
}
