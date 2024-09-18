package structure;

import exceptions.CustomStackException;

public class Stack {
    Node top;

    public Stack() {
        top = null;
    }

    public void push(String val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
    }

    public String pop(){
        if (isEmpty()) {
            throw new CustomStackException("Stack is empty");
        }
        String poppedVal = top.val;
        top = top.next;
        return poppedVal;
    }

    public String peek(){
        if (isEmpty()) {
            throw new CustomStackException("Stack is empty");
        }
        return top.val;
    }

    public int size() {
        int size = 0;
        Node toSize = top;
        while (toSize != null) {
            toSize = toSize.next;
            size++;
        }
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
