import thankable.ThankableIterator;

import java.util.Arrays;

public class Example {

    public static void main(String[] args) {
        ThankableIterator<Integer> it = ThankableIterator.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        while(it.hasNext()) {
            System.out.println(it

                    .thankU()

                    .next());
        }
    }
}
