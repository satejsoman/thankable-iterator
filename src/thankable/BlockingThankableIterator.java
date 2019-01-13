package thankable;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingThankableIterator<E> extends ThankableIterator<E> {
    private boolean thanked = false;
    private boolean finished = false;
    private BlockingQueue<E> queue;
    private Iterator<E> iterator;

    BlockingThankableIterator(Collection<E> collection) {
        if (collection instanceof BlockingQueue) {
            this.queue = (BlockingQueue<E>) collection;
        } else {
            this.queue = new LinkedBlockingQueue<>(collection);
        }
        // grab iterator at construction because each call to iterator() yields a new iterator
        this.iterator = this.queue.iterator();
    }

    @Override
    public boolean hasNext() {
        // hard to know if a blocking iterator is finished or not, so use this guess:
        return !finished && iterator.hasNext();
    }

    @Override
    public E next() {
        if (!thanked) {
            throw new UnthankedException();
        }
        E elem;
        try {
            elem = queue.take();
            iterator.next(); // advance iterator to keep state in sync
            thanked = false; // set state after take() because take() can throw
            return elem;
        } catch (InterruptedException e) {
            finished = true;
            throw new UnthankedException();
        }
    }

    @Override
    public ThankableIterator<E> thankU() {
        thanked = true;
        return this;
    }
}
