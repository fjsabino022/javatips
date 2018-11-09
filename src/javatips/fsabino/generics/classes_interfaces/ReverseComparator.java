package javatips.fsabino.generics.classes_interfaces;

import java.util.Comparator;

import static java.util.Objects.requireNonNull;

public class ReverseComparator<T> implements Comparator<T> {

    private final Comparator<T> delegateComparator;

    public ReverseComparator(final Comparator<T> delegateComparator) {
        this.delegateComparator = requireNonNull(delegateComparator);
    }

    @Override
    public int compare(T left, T right) {
        return -1 * this.delegateComparator.compare(left, right);
    }
}
