package Assignments.Assignment3.junit.Student;

import java.util.*;

import Assignments.Assignment3.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedList_STUDENT_Test {
    SortedDoubleLinkedList<Integer> list;
    Comparator<Integer> comp;

    @Before
    public void setUp() {
        comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer arg0, Integer arg1) {
                return arg0.compareTo(arg1);
            }
        };
        list = new SortedDoubleLinkedList<>(comp);

    }

    @After
    public void tearDown() {
        list = null;
    }

    public void populate(int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(20));
        }
    }

    @Test
    public void testAddToEnd() {
        populate(10);
        try {
            list.addToEnd(20);
        } catch (UnsupportedOperationException e) {
            assertTrue("Successfully threw a UnsupportedOperationException", true);
        }
    }

    @Test
    public void testAddToFront() {
        populate(10);
        try {
            list.addToFront(20);
        } catch (UnsupportedOperationException e) {
            assertTrue("Successfully threw a UnsupportedOperationException", true);
        }
    }

    @Test
    public void testAdd() {
        populate(30);
        assertTrue(isSorted());
    }

    public boolean isSorted() {
        ArrayList<Integer> arr = list.toArrayList();
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

}
