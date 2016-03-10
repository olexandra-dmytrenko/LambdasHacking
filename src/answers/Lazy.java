package answers;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * Created by olexandra on 3/10/16.
 */
public class Lazy {

    public <R> R use(Supplier<R> supplier) {
        System.out.println("Start use");
        R r = supplier.get();
        System.out.println("End use r=" + r);
        return r;
    }

    public String getString() {
        System.out.println("Start getString");
        use(() -> "I'm use implementation in getString");
        System.out.println("End getString");
        return "I'm get String return";
    }

    public String getStringUse() {

        return use(() -> "I'm use implementation in getString");
    }

    public void getStringVoid() {
        System.out.println("Start getStringVoid");
        System.out.println(use(() -> "I'm use implementation in getString"));
        System.out.println("End getStringVoid");
    }

    @Test
    public void testGetString() {
        System.out.println(getString());
        // System.out.println(getStringUse());
        // getStringVoid();

    }
}
