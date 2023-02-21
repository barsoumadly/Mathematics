public class Pair<dataType1, dataType2> {
    public dataType1 first;
    public dataType2 second;

    public Pair(dataType1 first, dataType2 second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "[" + first + ", " + second + "]";
    }
}
