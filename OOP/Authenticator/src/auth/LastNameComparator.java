package auth;

import java.util.Comparator;

class LastNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getSortLastNameKey().compareTo(person2.getSortLastNameKey());
    }

}
