import java.util.*;

class Program {
    // Time Complexity : O(N^2)
    // Space Complexity : O(N); N is the size of the stack
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        // Base Case : If Stack is empty after we have removed all elements from it, we
        // just return the stack
        if (stack.size() == 0) {
            return stack;
        }

        // Getting the current topmost element of the stack, which we will pass on to
        // insert method once entire substack is sorted
        int top = stack.remove(stack.size() - 1);

        sortStack(stack);

        insertInSortedPosition(stack, top);

        return stack;
    }

    public void insertInSortedPosition(ArrayList<Integer> stack, int value) {
        // If Stack is empty or stack top element is smaller than value, then will add
        // value on top of it
        if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return;
        }

        // Recusive Case: Stack top element is not smaller than value, hence we will
        // have to keep popping element from top until we do have
        int top = stack.remove(stack.size() - 1);

        insertInSortedPosition(stack, value);

        stack.add(top);
    }
}
