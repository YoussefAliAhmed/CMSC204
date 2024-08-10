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

public class TownGraphManager_STUDENT_test {
    TownGraphManager graph;

    @Before
    public void setUp() throws Exception {
        graph = new TownGraphManager();
    }

    @After
    public void tearDown() throws Exception {
        graph = null;
    }

    @Test
    public void testAddTown() {
        assertTrue(graph.addTown("Town1"));
        assertTrue(graph.addTown("Town2"));
        assertTrue(graph.addTown("Town3"));
        assertFalse(graph.addTown("Town1"));
    }

    @Test
    public void testAddRoad() {
        graph.addTown("Town1");
        graph.addTown("Town2");
        assertTrue(graph.addRoad("Town1", "Town2", 2, "Road1"));
    }

    @Test
    public void testGetRoad() {
        graph.addTown("Town1");
        graph.addTown("Town2");
        graph.addRoad("Town1", "Town2", 2, "Road1");
        assertEquals("Road1", graph.getRoad("Town1", "Town2"));
    }

    @Test
    public void testGetTown() {
        graph.addTown("Town1");
        graph.addTown("Town2");
        assertEquals("Town1", graph.getTown("Town1").getName());
        assertEquals("Town2", graph.getTown("Town2").getName());
    }

    @Test
    public void testContainsTown() {
        graph.addTown("Town1");
        graph.addTown("Town2");
        assertTrue(graph.containsTown("Town1"));
        assertTrue(graph.containsTown("Town2"));
        assertFalse(graph.containsTown("Town3"));
    }

    @Test
    public void testAllRoads() {
        graph.addTown("Town1");
        graph.addTown("Town2");
        graph.addRoad("Town1", "Town2", 2, "Road1");
        ArrayList<String> roads = graph.allRoads();
        assertEquals("Road1", roads.get(0));
    }

    @Test
    public void testDeleteTown() {
        graph.addTown("Town1");
        graph.addTown("Town2");
        graph.addRoad("Town1", "Town2", 2, "Road1");
        assertTrue(graph.containsTown("Town1"));
        graph.deleteTown("Town1");
        assertFalse(graph.containsTown("Town1"));
    }

}
