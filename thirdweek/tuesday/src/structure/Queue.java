package structure;

import exceptions.CustomQueueException;

public class Queue {
    Node front;
    Node rear;

    public Queue() {
        front = null;
        rear = null;
    }

    public void enqueue(String val) {
        Node newNode = new Node(val);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public String dequeue(){
        if (isEmpty()) {
            throw new CustomQueueException();
        }
        String oldVal = front.val;
        front = front.next;
        if (isEmpty()) {
            rear = null;
        }
        return oldVal;
    }

    public String peek(){
        if (isEmpty()) {
            throw new CustomQueueException();
        }
        return front.val;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
