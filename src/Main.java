import java.util.Objects;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println("int = " + i);
        System.out.println("string = " + s);
        System.out.println("pair1 =? pair2: " + mustBeTrue);
        System.out.println("hashcode1 =? hashcode2: " + mustAlsoBeTrue);
    }

}

class Pair <E , H> {
    private final E first;
    private final H second;

    private Pair(E first, H second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst(){
        return this.first;
    }

    public H getSecond(){
        return this.second;
    }

    public static <E , H> Pair<E , H> of(E first, H second){
        return new Pair<>(first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (!Objects.equals(first, pair.first)) return false;
        return Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}