import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedian {

    public static void main(String[] args) {

    }

    private class MedianHolder {
        private PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        private PriorityQueue<Integer> maxQueue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (o2 > o1) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }
        );
        
    }
}
