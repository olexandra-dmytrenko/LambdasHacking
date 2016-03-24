package answers;

/**
 * Created by olexandra on 3/10/16.
 */
public class KotoKrolik implements Kot, Krolik {
    public static void main(String[] args) {
        Kot kot = new Kot() {
        };
        System.out.println(kot.eat());

        Krolik krolik = new Krolik() {
        };
        System.out.println(krolik.eat());
    }

    @Override
    public String eat() {
        return "Kotokrolik pokushal";
    }
}

interface Kot {
    default String eat() {
        return "Kotik pokushal";
    }
}

interface Krolik {
    default String eat() {
        return "Krolik pokushal";
    }
}