package auth;

import java.util.Comparator;

class FirstNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getSortFirstNameKey().compareTo(person2.getSortFirstNameKey());
    }

}
