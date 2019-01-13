package thankable;

public class PainfulThankableIterator<E> extends ThankableIterator<E> {
    @Override
    public ThankableIterator<E> thankU() {
        throw new UnthankedException();
    }

    @Override
    public boolean hasNext() {
        throw new UnthankedException();
    }

    @Override
    public E next() {
        throw new UnthankedException();
    }
}
