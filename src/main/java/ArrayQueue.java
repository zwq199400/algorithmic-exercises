import java.util.HashMap;

public class ArrayQueue {

    private int start;
    private int end;
    private int size;
    private int[] arr;

    public ArrayQueue(int initialCapacity) {
        this.arr = new int[initialCapacity];

        start = 0;
        end = 0;
        size = 0;
    }

    private void add(int x) {
        if (size == arr.length) {
            throw new IllegalStateException("queue full!");
        }
        size++;
        start = start + 1 == arr.length ? 0 : start + 1;
        arr[start] = x;
    }

    private int poll() {
        if (size == 0) {
            throw new IllegalStateException("queue empty!");
        }
        end = end + 1 == arr.length ? 0 : end + 1;

        size--;
        return arr[end];
    }

    private int peek() {
        if (size == 0) {
            throw new IllegalStateException("queue empty!");
        }
        return arr[end];
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.add(5);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(1);
        arrayQueue.add(4);

        System.out.println(arrayQueue.poll());;
        System.out.println(arrayQueue.poll());;
        System.out.println(arrayQueue.poll());;
        System.out.println(arrayQueue.poll());;
        System.out.println(arrayQueue.poll());;

        arrayQueue.add(6);
        arrayQueue.add(6);
        arrayQueue.add(6);
        arrayQueue.add(6);
        arrayQueue.add(6);

        System.out.println(arrayQueue.peek());;
    }

}
