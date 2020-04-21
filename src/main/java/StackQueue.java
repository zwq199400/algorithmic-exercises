import java.util.Stack;

public class StackQueue {

    private Stack<Integer> stack;

    private Stack<Integer> copyStack;

    public StackQueue() {
        stack = new Stack<Integer>();
        copyStack = new Stack<Integer>();
    }

    private void add(int value) {
        stack.push(value);
    }

    private int poll() {
        if (stack.isEmpty() && copyStack.isEmpty()) {
            throw new IllegalStateException("is empty");
        } else if (copyStack.isEmpty()) {
            while (!stack.isEmpty()) {
                copyStack.push(stack.pop());
            }
        }
        return copyStack.pop();
    }

    private int peek() {
        if (stack.isEmpty() && copyStack.isEmpty()) {
            throw new IllegalStateException("is empty");
        } else if (copyStack.isEmpty()) {
            while (!stack.isEmpty()) {
                copyStack.push(stack.pop());
            }
        }
        return copyStack.peek();
    }

    public static void main(String[] args) {
        StackQueue arrayStack = new StackQueue();
        arrayStack.add(5);
        arrayStack.add(2);
        arrayStack.add(3);
        arrayStack.add(1);
        arrayStack.add(4);

        System.out.println(arrayStack.poll());;
        System.out.println(arrayStack.poll());;
        System.out.println(arrayStack.poll());;
        System.out.println(arrayStack.poll());;
        System.out.println(arrayStack.poll());;

        arrayStack.add(6);
        arrayStack.add(3);
        arrayStack.add(4);
        arrayStack.add(5);
        arrayStack.add(1);

        System.out.println(arrayStack.peek());;
    }

}
