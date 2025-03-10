package ArrayList.Person;

import java.util.Arrays;

public class PersonArrList implements PersonInterface {

    Person[] personArr = new Person[10];
    int size = 0;

    @Override
    public Person getPerson(int index) {
        checkOutOfRange(index);
        return personArr[index];
    }

    @Override
    public boolean removeAtIndex(int index) {
        checkOutOfRange(index);
        for(int i = index; i < size; i++) {
            personArr[i] = personArr[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        personArr = new Person[10];
        size = 0;
    }

    @Override
    public boolean removePerson(Person p) {
        for(int i = 0; i < size; i++) {
            if(personArr[i].equals(p)) {
                return removeAtIndex(i);
            }
        };
        return false;
    }

    @Override
    public void addPerson(Person p) {
        increaseArraySize();
        personArr[size] = p;
        size++;
    }

    public  void addPersonIndex(Person p, int index) {
        increaseArraySize();
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(personArr, index, personArr, index + 1, size - index);
        personArr[index] = p;
        size++;
    }


    public void increaseArraySize() {
        if(size >= personArr.length) {
            personArr = Arrays.copyOf(personArr, personArr.length * 2);
        }
    }



    private void checkOutOfRange(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
}
