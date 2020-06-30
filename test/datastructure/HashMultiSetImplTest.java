package datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashMultiSetImplTest<T> {

    @Test
    public void testSizeWhenEmptySet() {
        MultiSet<?> hashMultiSet = new HashMultiSetImpl<>();

        assertEquals(0, hashMultiSet.size());
    }

    @Test
    public void testSizeWhenNotEmptySet() {
        MultiSet<Integer> hashMultiSet = new HashMultiSetImpl<>();
        hashMultiSet.add(1);
        hashMultiSet.add(2);
        hashMultiSet.add(3);

        assertEquals(3, hashMultiSet.size());
    }

    @Test
    public void testIsEmpty() {
        MultiSet<?> hashMultiSet = new HashMultiSetImpl<>();

        assertEquals(0, hashMultiSet.size());
    }

    @Test
    public void testAddDifferentElementsIncreasesSize() {
        MultiSet<Integer> hashMultiSet = new HashMultiSetImpl<>();
        hashMultiSet.add(1);
        hashMultiSet.add(2);

        assertEquals(2, hashMultiSet.size());
    }

    @Test
    public void testAddSametElementIncreasesSize() {
        MultiSet<Integer> hashMultiSet = new HashMultiSetImpl<>();
        hashMultiSet.add(1);
        hashMultiSet.add(1);

        assertEquals(2, hashMultiSet.size());
    }

    @Test
    public void testIteratorWithDifferentElements() {
        MultiSet<Integer> multiSet = new HashMultiSetImpl<>();
        multiSet.add(1);
        multiSet.add(2);
        multiSet.add(3);

        Iterator<Integer> iterator = multiSet.iterator();
        List<Integer> resultList = new ArrayList<>();
        while (iterator.hasNext()) {
            int number = iterator.next();
            resultList.add(number);
        }

        assertTrue(resultList.contains(1));
        assertTrue(resultList.contains(2));
        assertTrue(resultList.contains(3));
    }

    @Test
    public void testIteratorWithSameElement() {
        MultiSet<Integer> multiSet = new HashMultiSetImpl<>();
        multiSet.add(1);
        multiSet.add(1);
        multiSet.add(1);

        Iterator<Integer> iterator = multiSet.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        assertEquals(3, count);
    }
}
