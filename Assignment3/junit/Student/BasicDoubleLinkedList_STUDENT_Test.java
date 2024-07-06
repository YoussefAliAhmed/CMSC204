package Assignments.Assignment3.junit.Student;

import java.util.*;

import Assignments.Assignment3.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_STUDENT_Test {
    BasicDoubleLinkedList<Integer> list;
    Comparator<Integer> comp;

    @Before
    public void setUp() throws Exception {
        list = new BasicDoubleLinkedList<>();
        comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer arg0, Integer arg1) {
                return arg0.compareTo(arg1);
            }
        };
    }

    @After
    public void tearDown() throws Exception {
        list = null;
        comp = null;
    }

    public void populate(int size) {
        for (int i = 0; i < size; i++) {
            list.addToEnd(i);
        }
    }

    @Test
    public void testGetSize() {
        assertTrue(list.getSize() == 0);
        populate(10);
        assertTrue(list.getSize() == 10);
    }

    @Test
    public void testAddToEnd() {
        populate(5);
        list.addToEnd(20);
        assertTrue(list.getLast() == 20);
    }

    @Test
    public void testAddToFront() {
        populate(5);
        list.addToEnd(30);
        assertTrue(list.getLast() == 30);
    }

    @Test
    public void testRemove() {
        populate(10);
        list.remove(5, comp);
        assertTrue(list.getSize() == 9);
        list.remove(9, comp);
        assertTrue(list.getLast() == 8);
        assertNull(list.remove(20, comp));
    }

    @Test
    public void testRetrieveFirstElement() {
        assertNull(list.retrieveFirstElement());
        populate(20);
        assertTrue(list.retrieveFirstElement() == 0);
    }

    @Test
    public void testRetrieveLastElement() {
        assertNull(list.retrieveLastElement());
        populate(20);
        assertTrue(list.retrieveLastElement() == 19);
    }

    @Test
    public void testArrayList() {
        populate(10);
        Iterator<Integer> iter = list.iterator();
        for (Integer i = 0; i < list.getSize(); i++) {
            assertEquals(i, iter.next());
        }
    }
}
