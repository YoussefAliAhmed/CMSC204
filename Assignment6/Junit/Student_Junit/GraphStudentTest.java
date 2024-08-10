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

public class GraphStudentTest {
    private GraphInterface<Town, Road> graph;
    private Town ex1, ex2, ex3;

    @Before
    public void setUp() throws Exception {
        graph = new Graph();
        ex1 = new Town("Town1", false);
        ex2 = new Town("Town2", false);
        ex3 = new Town("Town3", false);

    }

    @After
    public void tearDown() throws Exception {
        graph = null;
        ex1 = ex2 = ex3 = null;
    }

    @Test
    public void testContainsVertex() {
        assertTrue(graph.addVertex(ex1));
        Town comp = new Town("Town1", false);
        assertTrue(graph.containsVertex(new Town("Town1", true)));
        assertFalse(graph.containsVertex(new Town("Town2", true)));

    }

    @Test
    public void testAddEdge() {
        graph.addVertex(ex1);
        try {
            graph.addEdge(ex1, ex2, 2, "youssef");
        } catch (IllegalArgumentException e) {
            assertEquals("Sources or target doesn't exist", e.getMessage());
        }
        graph.addVertex(ex2);
        graph.addEdge(ex1, ex2, 30, "Youssefs' road");
        assertTrue(graph.containsEdge(ex2, ex1));
        assertTrue(graph.containsEdge(ex1, ex2));

    }

    @Test
    public void testEdgeSet() {
        graph.addVertex(ex1);
        graph.addVertex(ex2);
        graph.addVertex(ex3);
        graph.addEdge(ex1, ex2, 30, "Youssefs' road");
        graph.addEdge(ex2, ex3, 29, "Prospect hill");
        graph.addEdge(ex1, ex3, 0, "Washington Rd.");
        Set<Road> roads = graph.edgeSet();
        assertEquals(3, roads.size());
    }

    @Test
    public void test2DArray() {
        graph.addVertex(ex1);
        graph.addVertex(ex2);
        graph.addVertex(ex3);
        graph.addEdge(ex1, ex2, 30, "Youssefs' road");
        graph.addEdge(ex2, ex3, 29, "Prospect hill");
        graph.addEdge(ex1, ex3, 8, "Washington Rd.");
        graph.make2DArray();
    }
}