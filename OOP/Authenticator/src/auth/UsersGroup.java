package auth;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UsersGroup {
    private String groupName;
    private List<User> users;

    public UsersGroup (String groupName, List<User> users){
        this.setGroupName(groupName);
        this.setUsers(users);
    }

    public boolean addUser(User user){
        return this.users.add(user);
    }

    public void sortUsersFamilyNameFirst () {
        LastNameComparator comaparator = new LastNameComparator();

        Collections.sort(this.users, comaparator);
    }

    public void sortUsersFirstNameFirst () {
        FirstNameComparator comaparator = new FirstNameComparator();

        Collections.sort(this.users, comaparator);
    }

    public void sortUsersUserNameAndPassword () {
        Comparator<User> comaparator = new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    return (o1.getUserName() + o1.getPassword()).compareTo(o2.getUserName() + o2.getPassword());
                }
            };

        Collections.sort(this.users, comaparator);
    }

    @Override
    public String toString() {
        String out = "UserGroup: " + this.getGroupName() + "\n";

        for (User user : this.users) {
            out += user.toString() + "\n";
        }

        return out + "\n" + super.toString();
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
