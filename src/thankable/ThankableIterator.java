package thankable;

import java.util.Collection;
import java.util.Iterator;

public abstract class ThankableIterator<E> implements Iterator<E> {
    public abstract ThankableIterator<E> thankU();

    public static <E> ThankableIterator<E> of(Collection<E> underlying) {
        return new NonBlockingThankableIterator<>(underlying);
    }

    public static <E> ThankableIterator<E> of(Collection<E> underlying, Teacher teacher) {
        switch (teacher) {
            case PAIN:
                return new PainfulThankableIterator<>();
            case PATIENCE:
                return new BlockingThankableIterator<>(underlying);
            case LOVE:
            default:
                return new NonBlockingThankableIterator<>(underlying);
        }
    }
}
