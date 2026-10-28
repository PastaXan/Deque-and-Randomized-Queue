import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended queue that supports adding and removing items at either end.
 * @param <Item> the type of items stored in this deque
 */
public class Deque<Item> implements Iterable<Item> {

    /** A node in the doubly linked list. */
    private class Node {
        Item item;
        Node next;
        Node prev;
        public Node(Item i){
            item=i;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    /** Construct an empty deque. */
    public Deque() {
        // TODO: Initialize an empty linked list.
        head = new Node(null);
        tail = new Node(null);
        head.prev = null;
        tail.next = null;
        head.next = tail;
        tail.prev = head;
        size=0;
    }

    /** Return whether the deque is empty. */
    public boolean isEmpty() {
        // TODO: Report whether this linked list contains no items.
        return size==0;
    }

    /** Return the number of items in the deque. */
    public int size() {
        // TODO: Return this linked list's item count.
        return size;
    }

    /** Add an item to the front; reject null items with IllegalArgumentException. */
    public void addFirst(Item item) {
        // TODO: Create a node and link it at the front; update head/tail pointers.
        if(item==null){
            throw new IllegalArgumentException("YOU MESSED Up: addfirst");
        }
        Node n = new Node(item);
        head.next.prev = n;
        n.next = head.next;
        head.next=n;
        n.prev=head;
        size++;
    }

    /** Add an item to the back; reject null items with IllegalArgumentException. */
    public void addLast(Item item) {
        // TODO: Create a node and link it at the back; update head/tail pointers.
        if(item==null){
            throw new IllegalArgumentException("YOU MESSED Up: addlast");
        }
        Node n = new Node(item);
        tail.prev.next = n;
        n.prev = tail.prev;
        tail.prev=n;
        n.next=tail;
        size++;
    }

    /** Remove and return the front item; throw NoSuchElementException if empty. */
    public Item removeFirst() {
        // TODO: Remove the front node and update head/tail pointers.
        if(head.next.item==null){throw new NoSuchElementException("Nada bozo: removeFirst");}
        Node n = head.next;
        head.next =n.next;
        n.next.prev = head;
        n.prev = null;
        n.next=null;
        size--;
        return n.item;
    }

    /** Remove and return the back item; throw NoSuchElementException if empty. */
    public Item removeLast() {
        // TODO: Remove the back node and update head/tail pointers.
            if(tail.prev.item==null){throw new NoSuchElementException("Nada bozo: removeLast");}
            Node n = tail.prev;
             tail.prev =n.prev;
            n.prev.next = tail;
            n.prev = null;
            n.next=null;
            size--;
            return n.item;
    }

    /** Return an iterator from front to back; next() and remove() follow the specified exceptions. */
    @Override
    public Iterator<Item> iterator() {
        // TODO: Return an iterator that follows next links from head to tail.
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{
        private Node current = head.next;
        @Override
        public boolean hasNext() {
            return current!=tail;
        }

        @Override
        public Item next() {
            if(hasNext()){
                Item item = current.item;
                current = current.next;
                return item;
            }
            else{
                throw new NoSuchElementException("STOP IT, THERES NONE LEFT, ZERO, NADA, NIHILO, ZIP:  DequeIterator:next()");
            }
        }
    }

    /** Run unit tests for the deque. */
    public static void main(String[] args) {
        // TODO: Add unit tests.
    }
}
