package Labs.Recursion;

public class ArraySum {

    public ArraySum() {

    }

    public Integer sumOfArray(Integer[] a, int index) {
        if (index == 0) {
            return a[0];
        } else {
            return a[index] + sumOfArray(a, index - 1);
        }
    }

}