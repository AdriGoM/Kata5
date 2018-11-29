package kata5;

public class Mail {

    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    public String getDomain() {
        int atSignPos = this.mail.indexOf('@');
        return this.mail.substring(atSignPos+1);
    }

    public String getMail() {
        return this.mail;
    }

}