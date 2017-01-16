package auth;

class User extends Person implements Comparable<Object> {

    private String userName;
    private String password;

    User(String userName, String password, String firstName, String familyName, int age) {
        super(firstName, familyName, age);

        this.setUserName(userName);
        this.setPassword(password);
    }

    @Override
    public String toString() {
        return "User: " + this.getPassword() + ", " + super.toString();
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.compareTo(obj) == 0) ? true : false;
    }

    @Override
    public int compareTo(Object obj) {
        User casted = (User) obj;

        String objToCompare = casted.getUserName() + casted.getPassword() + casted.getAge();
        String thisToCompare = this.getUserName() + this.getPassword() + super.getAge();

        return thisToCompare.compareTo(objToCompare);
    }
}
