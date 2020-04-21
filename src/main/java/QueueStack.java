import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {

    private Queue<Integer> queue = new LinkedList<Integer>();

    private Queue<Integer> copyQueue = new LinkedList<Integer>();

    public QueueStack() {
    }

    private void push(int i) {
        queue.add(i);
    }

    private Integer pop() {
        if (queue.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("empty");
        }
        while (queue.size() > 1) {
            copyQueue.add(queue.poll());
        }
        Integer result = queue.poll();
        swap();
        return result;
    }

    private Integer peek() {
        if (queue.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("empty");
        }
        while (queue.size() > 1) {
            copyQueue.add(queue.poll());
        }
        Integer result = queue.peek();
        swap();
        return result;
    }

    private void swap() {
        Queue<Integer> temp = queue;
        queue = copyQueue;
        copyQueue = temp;
    }

    public static void main(String[] args) {
        QueueStack arrayQueue = new QueueStack();
        arrayQueue.push(5);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.push(1);
        arrayQueue.push(4);

        System.out.println(arrayQueue.pop());;
        System.out.println(arrayQueue.pop());;
        System.out.println(arrayQueue.pop());;
        System.out.println(arrayQueue.pop());;
        System.out.println(arrayQueue.pop());;

        arrayQueue.push(6);
        arrayQueue.push(6);
        arrayQueue.push(6);
        arrayQueue.push(6);
        arrayQueue.push(6);

        System.out.println(arrayQueue.peek());;
    }

}