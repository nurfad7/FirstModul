package structure;

public class DataStructure {
    public static void run() {
        Stack stack = new Stack();
        stack.push("three");
        stack.push("two");
        System.out.println(stack.peek());
        stack.push("one");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());

        Queue queue = new Queue();
        queue.enqueue("one");
        queue.enqueue("two");
        System.out.println(queue.peek());
        queue.enqueue("three");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());

        BinaryTree bt = new BinaryTree();
        bt.insert(8);
        bt.insert(5);
        bt.insert(9);
        System.out.println(bt.search(17));
        bt.insert(5);
        bt.insert(10);
        bt.insert(17);
        bt.insert(19);
        bt.insert(5);
        bt.insert(29);
        System.out.println(bt.search(17));
    }
}
