package Assignments.Assignment6.Junit;

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

public class Graph_GFA_Test {
    private GraphInterface<Town, Road> graph;
    private Town[] town;

    @Before
    public void setUp() throws Exception {
        graph = new Graph();
        town = new Town[3];

        for (int i = 0; i < 3; i++) {
            town[i] = new Town("Town_" + i, false);
            graph.addVertex(town[i]);
        }

        graph.addEdge(town[0], town[1], 2, "Road_1");
    }

    @After
    public void tearDown() throws Exception {
        graph = null;
    }

    @Test
    public void testGetEdge() {
        assertEquals(new Road(town[1], town[0], 2, "Road_1"), graph.getEdge(town[1], town[0]));
    }

}