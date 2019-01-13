package thankable;

import java.util.Iterator;

public class NonBlockingThankableIterator<E> extends ThankableIterator<E> {

    private boolean thanked;
    private Iterator<E> underlying;

    NonBlockingThankableIterator(Iterable<E> collection) {
        this.underlying = collection.iterator();
    }

    @Override
    public ThankableIterator<E> thankU() {
        thanked = true;
        return this;
    }

    @Override
    public boolean hasNext() {
        return underlying.hasNext();
    }

    @Override
    public E next() {
        if (!thanked) {
            throw new UnthankedException();
        }
        thanked = false;
        return underlying.next();
    }
}