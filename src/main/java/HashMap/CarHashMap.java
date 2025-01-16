package HashMap;

import ArrayList.Car.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarHashMap implements CarOwnerList {

    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Entry[] entries =  new Entry[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public void put(CarOwner key, Car value) {
        if(size >= (entries.length * LOAD_FACTOR )) {
            increaseArray();
        }
        boolean put = put(key, value, entries);
        if (put) {
            size++;
        }
    }

    @Override
    public Car get(CarOwner key) {
        int position = getElementPosition(key, entries.length);
        Entry entry = entries[position];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        Set<CarOwner> set = new HashSet<>();
        for(Entry entry : entries){
            Entry existedElement = entry;
            while (existedElement != null) {
                set.add(entry.key);
                existedElement = existedElement.next;
            }
        }
        return set;
    }

    @Override
    public List<Car> values() {
        List<Car> list = new ArrayList<>();
        for(Entry entry : entries){
            Entry existedElement = entry;
            while (existedElement != null) {
                list.add(existedElement.value);
                existedElement = existedElement.next;
            }
        }
        return List.of();
    }

    @Override
    public boolean remove(CarOwner key) {
        int position = getElementPosition(key, entries.length);
        Entry entry = entries[position];
        if(entry != null && entry.key.equals(key)){
            size--;
            entries[position] = entry.next;
            return true;
        }else{
            while (entry != null) {
                Entry nextElem = entry.next;
                if(nextElem == null){
                    return false;
                }
                if(nextElem.key.equals(key)){
                    entry.next = nextElem.next ;
                }
                entry = nextElem.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Entry[] entries = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    private  boolean put(CarOwner key, Car value, Entry[] dst) {
        int position = getElementPosition(key, dst.length);
        Entry existedElement = dst[position];
        if (existedElement == null) {
            Entry entry = new Entry(key, value, null);
            dst[position] = entry;
            return true;
        }else{
            while(true){
                if(existedElement.key.equals(key)){
                    existedElement.value = value;
                    return false;
                }
                if(existedElement.next == null){
                    existedElement.next = new Entry(key, value, null);
                    return true;
                }
                existedElement = existedElement.next;
            }
        }
    }

    private void increaseArray(){
        Entry[] newEntries = new Entry[entries.length * 2];
        for(Entry entry : entries){
            Entry existedElement = entry;
            while (existedElement != null) {
                put(existedElement.key, existedElement.value, newEntries);
                existedElement = existedElement.next;
            }
        }
        entries = newEntries;
    }


    private int getElementPosition(CarOwner key, int arrayLength) {
        return Math.abs(key.hashCode() % arrayLength);
    }

    private static class Entry {

        private CarOwner key;
        private Car value;
        private Entry next;

        public Entry(CarOwner key, Car value,  Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


}
