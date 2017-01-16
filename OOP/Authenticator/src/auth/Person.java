package auth;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Locale;

class Person implements Comparable<Object> {
    private String firstName;
    private String familyName;
    private int age;
    private static final Collator COLLATOR = Collator.getInstance(Locale.getDefault());
    private final CollationKey sortLastNameKey;
    private final CollationKey sortFirstNameKey;

    @Override
    public int compareTo(Object obj) {
        return ((Integer) this.getAge()).compareTo(((Person) obj).getAge());
    }

    Person (String firstName, String familyName, int age) {
        this.setAge(age);
        this.setFamilyName(familyName);
        this.setFirstName(firstName);

        this.sortLastNameKey = Person.COLLATOR.getCollationKey(
                this.getFamilyName().toUpperCase() + this.getFirstName().toUpperCase()
        );

        this.sortFirstNameKey = Person.COLLATOR.getCollationKey(
                this.getFirstName().toUpperCase() + this.getFamilyName().toUpperCase()
        );
    }

    @Override
    public String toString() {
        return this.getFirstName() +" " + this.getFamilyName() + ", age: " + this.getAge() + super.toString();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return 31 * this.getFirstName().hashCode() + this.getFamilyName().hashCode();
    }

    public CollationKey getSortLastNameKey() {
        return this.sortLastNameKey;
    }

    public CollationKey getSortFirstNameKey() {
        return this.sortFirstNameKey;
    }

}
