package ArrayList.Person;

public interface PersonInterface {
    Person getPerson(int index);
    void addPerson(Person p);
    boolean removePerson(Person p);
    boolean removeAtIndex(int index);
    int size();
    void clear();
}
