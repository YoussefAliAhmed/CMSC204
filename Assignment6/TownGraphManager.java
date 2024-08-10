package Assignments.Assignment6;

import Assignments.Assignment6.Interface.TownGraphManagerInterface;
import java.util.*;
import java.io.*;

public class TownGraphManager implements TownGraphManagerInterface {
    Graph graph = new Graph();

    /**
     * Adds a road with 2 towns and a road name
     * 
     * @param town1    name of town 1 (lastname, firstname)
     * @param town2    name of town 2 (lastname, firstname)
     * @param roadName name of road
     * @return true if the road was added successfully
     */
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        return graph.addEdge(getTown(town1), getTown(town2), weight, roadName) == null ? false : true;
    }

    /**
     * Returns the name of the road that both towns are connected through
     * 
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return name of road if town 1 and town2 are in the same road, returns null if not
     */
    public String getRoad(String town1, String town2) {
        return graph.getEdge(graph.getTown(new Town(town1, true)), graph.getTown(new Town(town2, true))).getName();
    }

    /**
     * Adds a town to the graph
     * 
     * @param v the town's name (lastname, firstname)
     * @return true if the town was successfully added, false if not
     */
    public boolean addTown(String v) {
        return graph.addVertex(new Town(v, false));
    }

    /**
     * Gets a town with a given name
     * 
     * @param name the town's name
     * @return the Town specified by the name, or null if town does not exist
     */
    public Town getTown(String name) {
        return graph.getTown(new Town(name, true));
    }

    /**
     * Determines if a town is already in the graph
     * 
     * @param v the town's name
     * @return true if the town is in the graph, false if not
     */
    public boolean containsTown(String v) {
        return graph.containsVertex(new Town(v, true));
    }

    /**
     * Determines if a road is in the graph
     * 
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return true if the road is in the graph, false if not
     */
    public boolean containsRoadConnection(String town1, String town2) {
        return graph.containsEdge(getTown(town1), getTown(town2));
    }

    /**
     * Creates an arraylist of all road titles in sorted order by road name
     * 
     * @return an arraylist of all road titles in sorted order by road name
     */
    public ArrayList<String> allRoads() {
        Set<Road> roads = graph.edgeSet();
        ArrayList<String> roadArrayList = new ArrayList<String>();
        for (Road road : roads)
            roadArrayList.add(road.getName());
        Collections.sort(roadArrayList);
        return roadArrayList;
    }

    /**
     * Deletes a road from the graph
     * 
     * @param town1    name of town 1 (lastname, firstname)
     * @param town2    name of town 2 (lastname, firstname)
     * @param roadName the road name
     * @return true if the road was successfully deleted, false if not
     */
    public boolean deleteRoadConnection(String town1, String town2, String road) {
        return graph.removeEdge(getTown(town1), getTown(town2), 0, road) == null ? false : true;
    }

    /**
     * Deletes a town from the graph
     * 
     * @param v name of town (lastname, firstname)
     * @return true if the town was successfully deleted, false if not
     */
    public boolean deleteTown(String v) {
        return graph.removeVertex(getTown(v));
    }

    /**
     * Creates an arraylist of all towns in alphabetical order (last name, first name)
     * 
     * @return an arraylist of all towns in alphabetical order (last name, first name)
     */
    public ArrayList<String> allTowns() {
        Set<Town> towns = graph.vertexSet();
        ArrayList<String> townArrayList = new ArrayList<String>();
        for (Town town : towns)
            townArrayList.add(town.getName());
        Collections.sort(townArrayList);
        return townArrayList;
    }

    /**
     * Returns the shortest path from town 1 to town 2
     * 
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return an Arraylist of roads connecting the two towns together, null if the towns have no path to connect them.
     */
    public ArrayList<String> getPath(String town1, String town2) {
        return graph.shortestPath(getTown(town1), getTown(town2));
    }

    public void populateTownGraph(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split("[;,]+");
            if (data.length == 4) {
                addTown(data[2]);
                addTown(data[3]);
                addRoad(data[2], data[3], Integer.parseInt(data[1]), data[0]);
            } else {
                scanner.close();
                throw new IllegalArgumentException("Invalid data format");
            }
        }
        scanner.close();
    }
}
