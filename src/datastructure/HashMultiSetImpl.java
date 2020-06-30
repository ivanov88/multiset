package datastructure;

import java.util.*;

public class HashMultiSetImpl<T> implements MultiSet<T> {

    private final Map<T, Integer> countMap;

    public HashMultiSetImpl() {
        this.countMap = new HashMap<>();
    }


    @Override
    public int count(T element) {
        if (!this.countMap.containsKey(element)) {
            return 0;
        }

        return this.countMap.get(element);
    }

    @Override
    public int size() {
        return this.countMap.values()
                .stream()
                .mapToInt(x -> x)
                .sum();
    }

    @Override
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.countMap.containsKey(o);
    }

    @Override
    public Iterator<T> iterator() {
        List<T> items = new ArrayList<>();
        for (T key : this.countMap.keySet()) {
            items.add(key);
            int count = 1;
            while (count < this.countMap.get(key)) {
                items.add(key);
                count++;
            }
        }

        return items.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.countMap.keySet().toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return this.countMap.keySet().toArray(a);
    }

    @Override
    public boolean add(T t) {
        this.countMap.putIfAbsent(t, 0);
        this.countMap.put(t, this.countMap.get(t) + 1);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        this.countMap.remove(o);

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.countMap.entrySet().containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return this.countMap.keySet().addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.countMap.keySet().removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.countMap.keySet().retainAll(c);
    }

    @Override
    public void clear() {
        this.countMap.clear();
    }
}
