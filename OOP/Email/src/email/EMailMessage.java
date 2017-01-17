package email;


public abstract class EMailMessage
{
    protected String eMailMessage;

    public EMailMessage() {
        this("");
    }

    public EMailMessage(String strEMailMessage) {
        this.eMailMessage = strEMailMessage;
    }


    public abstract void setEMailMessage(String mess); // изпращане на съобщение
    public abstract String getEMailMessage(); // получаване на съобщение

}
