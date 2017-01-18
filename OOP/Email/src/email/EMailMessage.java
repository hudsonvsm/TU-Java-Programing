package email;

public abstract class EMailMessage {
    protected String eMailMessage;

    public EMailMessage() {
        this("");
    }

    public EMailMessage(String eMailMessage) {
        this.eMailMessage = eMailMessage;
    }

    public abstract void setEMailMessage(String eMailMessage);
    public abstract String getEMailMessage();
}
