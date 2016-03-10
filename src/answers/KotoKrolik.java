package answers;

/**
 * Created by olexandra on 3/10/16.
 */
public class KotoKrolik implements Kot {

    public static void main(String[] args) {
        Kot kot = new Kot() {
        };
        System.out.println(kot.eat());
        System.out.println(Kot.drink());

        Krolik krolik = new Kot() {
        };
        System.out.println(krolik.eat());
        System.out.println(Krolik.drink());

        KotoKrolik kotoKrolik = new KotoKrolik();
        System.out.println(kotoKrolik.eat());
    }

}

interface Kot extends Krolik {
    default String eat() {
        return "Kotik pokushal";
    }

    static String drink() {
        return "Kotik popil";
    }

}

interface Krolik {
    default String eat() {
        return "Krolik pokushal";
    }

    static String drink() {
        return "Krotik popil";
    }
}