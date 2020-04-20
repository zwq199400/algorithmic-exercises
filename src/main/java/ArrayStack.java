import java.util.Stack;

public class ArrayStack {

    private int size;
    private int[] arr;

    private Stack<Integer> stack;

    public ArrayStack(int initialCapacity) {
        this.arr = new int[initialCapacity];
        size = 0;
        stack = new Stack<Integer>();
    }

    private void push(int x) {
        if (size == arr.length) {
            throw new IllegalStateException("queue full!");
        }
        arr[size++] = x;
        if (stack.isEmpty()) {
            stack.push(x);
        } else if (stack.peek() > x) {
            stack.push(x);
        }
    }

    private int poll() {
        if (size == 0) {
            throw new IllegalStateException("queue empty!");
        }
        int result = arr[--size];
        if (result == getMin()) {
            stack.pop();
        }
        return result;
    }

    private int peek() {
        if (size == 0) {
            throw new IllegalStateException("queue empty!");
        }
        return arr[size - 1];
    }

    private int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(5);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(1);
        arrayStack.push(4);
        System.out.println(arrayStack.getMin());

        System.out.println(arrayStack.poll());;
        System.out.println(arrayStack.poll());;
        System.out.println(arrayStack.poll());;
        System.out.println(arrayStack.poll());;
        System.out.println(arrayStack.poll());;

        arrayStack.push(6);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(1);

        System.out.println(arrayStack.peek());;
    }

}
