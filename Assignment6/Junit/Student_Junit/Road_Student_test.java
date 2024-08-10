package Assignments.Assignment6.Junit.Student_Junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Assignments.Assignment6.*;

import Assignments.Assignment6.Interface.GraphInterface;

public class Road_Student_test {
    Town t1, t2;
    Road r;

    @Before
    public void setUp() {
        t1 = new Town("Town1", false);
        t2 = new Town("Town2", false);
        r = new Road(t1, t2, 2, "Road1");
    }

    @After
    public void tearDown() {
        t1 = t2 = null;
        r = null;
    }

    @Test
    public void testCompareTo() {

        assertEquals(0, r.compareTo(new Road(t2, t1, 2, "Road1")));
    }

    @Test
    public void testContains() {
        assertTrue(r.contains(t1));
        assertTrue(r.contains(t2));
    }
}
