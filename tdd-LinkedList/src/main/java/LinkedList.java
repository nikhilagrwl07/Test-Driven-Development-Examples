import exception.ElementNotFoundException;
import exception.EmptyLinkedListException;

class Node<T>{

    public T value;
    public Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node<T> next() {
        return next;
    }

    public T value() {
        return value;
    }
}

public class LinkedList<T> {

    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public Node head() {
        return head;
    }

    public void add(T element) {
        head = new Node<T>(element, head);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        Node temp = head;
        int size =0;

        while(temp!=null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    public Node remove() {
        if(isEmpty())
            throw new EmptyLinkedListException();

        Node removedNode = head;
        head = head.next();
        return removedNode;
    }

    public boolean contains(T element) {
        Node temp  = head;
        while(temp!=null){
            if(temp.value()==element){
                return true;
            }
            temp= temp.next;
        }
        return false;
    }
}
