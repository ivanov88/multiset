package datastructure;

import java.util.Collection;

public interface MultiSet<T> extends Collection<T> {

    /**
     * Returns an integer representing the count of a given element in the MultiSet structure
     *
     * @param element
     * @return
     */
    int count(T element);
}
