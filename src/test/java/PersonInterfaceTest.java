import ArrayList.Person.Person;
import ArrayList.Person.PersonArrList;
import ArrayList.Person.PersonInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonInterfaceTest {
    private PersonInterface Pers;
    @BeforeEach
    void setUp() {
        Pers = new PersonArrList();
        for(int i = 0; i < 100; i++){
            Pers.addPerson(new Person("Name" + i, i));
        }
    }

    @Test
    void getPerson() {
        Person pers = Pers.getPerson(0);
        assertEquals("Name0", pers.getName());
    }

    @Test
    void removePerson() {
        assertTrue(Pers.removeAtIndex(5));
        assertEquals(99, Pers.size());
    }

    @Test
    void getSize(){
        assertEquals(100, Pers.size());
    }

    @Test
    void clear(){
        Pers.clear();
        assertEquals(0, Pers.size());
    }

    @Test
    void removePersonByName(){
        Person p = new Person("Bobr", 15);
        Pers.addPerson(p);
        assertEquals(101, Pers.size());
        assertTrue(Pers.removePerson(p));
        assertEquals(100, Pers.size());
    }

    @Test
    void removeNonExistingPerson(){
        Person p = new Person("Bob", 15);
        assertFalse(Pers.removePerson(p));
        assertEquals(100, Pers.size());
    }

    @Test
    void whenOutOfRange(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Pers.getPerson(-1);
        });
    }
}