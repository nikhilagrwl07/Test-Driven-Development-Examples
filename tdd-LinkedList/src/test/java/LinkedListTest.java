import exception.EmptyLinkedListException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LinkedListTest {

    private LinkedList linkedList;

    private <T> void initializeLinkedList(Class<T> clazz) {
        linkedList =  new LinkedList<T>();
    }

    @Test
    public void createEmptyLinkedList() {
        initializeLinkedList(Integer.class);
        assertNull(linkedList.head());
    }

    @Test
    public void addElementToExistingLinkedList() {
        initializeLinkedList(Integer.class);
        linkedList.add(10);
        assertEquals(linkedList.isEmpty(), Boolean.FALSE);
        assertEquals(linkedList.size(), 1);
    }

    @Test
    public void removeElementFromHeadOfExistingLinkedList() {
        initializeLinkedList(Integer.class);
        linkedList.add(10);
        Node removedNode = linkedList.remove();
        assertEquals(linkedList.isEmpty(), Boolean.TRUE);
        assertEquals(linkedList.size(), 0);
        assertEquals(removedNode.value(), 10);
    }

    @Test
    public void addStringElementToLinkedList() {
        initializeLinkedList(String.class);
        String stringElement = "Nikhil";
        linkedList.add(stringElement);
        assertEquals(linkedList.isEmpty(), Boolean.FALSE);
        assertEquals(linkedList.size(), 1);
    }


    @Test
    public void removeStringElementFromHeadOfExistingLinkedList() {
        initializeLinkedList(String.class);
        linkedList.add("Nikhil");
        Node removedNode = linkedList.remove();
        assertEquals(linkedList.isEmpty(), Boolean.TRUE);
        assertEquals(linkedList.size(), 0);
        assertEquals(removedNode.value(), "Nikhil");
    }

    @Test
    public void containsElement() {
        initializeLinkedList(Integer.class);
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        assertTrue(linkedList.contains(30));
        assertFalse(linkedList.contains(40));
    }

    @Test(expected = EmptyLinkedListException.class)
    public void removeElementFromEmptyLinkedList() {
        initializeLinkedList(Integer.class);
        linkedList.remove();
    }
}
