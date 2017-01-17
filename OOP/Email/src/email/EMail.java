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
        this.setIdent(emailParts[2]);
        this.setProvider(emailParts[3]);
        this.setEMailMessage(emailParts[4]);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }

        if(obj == null) {
            return false;
        }

        if(obj.getClass() != this.getClass()) {
            return false;
        }

        return this.provider.equals(((EMail) obj).getProvider());
    }

    @Override
    public int compareTo(EMail obj) {
        return this.getProvider().compareTo(obj.getProvider());
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
        return "EMail(Number: " + this.getNumber() + ", ID: " + this.getIdent() + ", Provider: " + this.getProvider() + ", Message='" + this.getEMailMessage() + ')' + super.toString();
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
