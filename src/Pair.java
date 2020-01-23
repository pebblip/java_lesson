public class Pair<T, O> {
    private T value;
    private O word;

    public Pair(T value, O word) {
        this.value = value;
        this.word = word;
    }

    public T getValue() {
        return this.value;
    }

    public O getWord() {
        return this.word;
    }
}
