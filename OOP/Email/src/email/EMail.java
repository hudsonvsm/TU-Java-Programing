package email;

public class EMail extends EMailMessage implements IEMail, Comparable<EMail> {
    private int number;
    private String ident;
    private String provider;

    public EMail(String message, int number, String ident, String provider) {
        super(message);
        this.setNumber(number);
        this.setIdent(ident);
        this.setProvider(provider);
    }

    public EMail(String line) {
        String[] emailParts = line.split("-|@|(:=)");

        this.setNumber(Integer.parseInt(emailParts[0]));
        this.setIdent(emailParts[1]);
        this.setProvider(emailParts[2]);
        this.setEMailMessage(emailParts[3]);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        if(obj == this) return true;

        return (this.compareTo((EMail) obj) == 0) ? true : false;
    }

    @Override
    public int compareTo(EMail email) {
        return this.toString().compareTo(email.toString());
    }

    @Override
    public int compareToId(String id) {
        return this.getIdent().compareTo(id);
    }

    @Override
    public int compareToMessage(String message) {
        return this.getEMailMessage().compareTo(message);
    }

    @Override
    public void setEMailMessage(String message) {
        super.eMailMessage = message;
    }

    @Override
    public String getEMailMessage() {
        return super.eMailMessage;
    }

    @Override
    public String toString() {
        return "EMail(Number: " + this.getNumber() + ", ID: " + this.getIdent() + ", Provider: " + this.getProvider() + ", Message='" + this.getEMailMessage() + ')';
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIdent() {
        return this.ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
