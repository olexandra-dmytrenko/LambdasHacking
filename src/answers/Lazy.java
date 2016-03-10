package answers;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * Created by olexandra on 3/10/16.
 */
public class Lazy {

    public <R> R use(Supplier<R> supplier) {

        return supplier.get();
    }

    public String getString(){

        return use(() -> "I'm use implementation in getString");
    }

    @Test
    public void testGetString(){
        System.out.println(getString());
    }
}
