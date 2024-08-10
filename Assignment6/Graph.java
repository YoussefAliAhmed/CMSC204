package Assignments.Assignment6;

import java.util.*;

import Assignments.Assignment6.Interface.GraphInterface;

/**
 * A class that implements GraphInterface and represents a graph of towns and roads
 * 
 * @author Youssef Ali Ahmed
 */
public class Graph implements GraphInterface<Town, Road> {
    private ArrayList<Town> map = new ArrayList<>();
    private int[] distance;
    private Town[] shortestPath;
    private boolean[] visited;
    // ~ Methods ----------------------------------------------------------------

    /**
     * Returns an edge connecting source vertex to target vertex if such vertices and such edge exist in this graph.
     * Otherwise returns null. If any of the specified vertices is null returns null In undirected graphs, the returned edge
     * may have its source and target vertices in the opposite order.
     *
     * @param sourceVertex      source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return an edge connecting source vertex to target vertex.
     */
    public Road getEdge(Town sourceVertex, Town destinationVertex) {
        ArrayList<Road> roads = sourceVertex.getTowns();
        for (Road r : roads) {
            if (r.getDestination().equals(destinationVertex)) {
                return r;
            }
        }
        return null;
    }

    public Town getTown(Town target) {
        for (Town t : map) {
            if (target.equals(t)) {
                return t;
            }
        }
        return null;
    }

    /**
     * Creates a new edge in this graph, going from the source vertex to the target vertex, and returns the created edge.
     * The source and target vertices must already be contained in this graph. If they are not found in graph
     * IllegalArgumentException is thrown.
     *
     * @param sourceVertex      source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight            weight of the edge
     * @param description       description for edge
     * @return The newly created edge if added to the graph, otherwise null.
     * @throws IllegalArgumentException if source or target vertices are not found in the graph.
     * @throws NullPointerException     if any of the specified vertices is null.
     */
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
            throws IllegalArgumentException, NullPointerException {
        if (!containsVertex(destinationVertex) || !containsVertex(sourceVertex)) {
            throw new IllegalArgumentException("Sources or target doesn't exist");
        } else if (sourceVertex == null || destinationVertex == null) {
            throw new NullPointerException();
        }
        Road r = new Road(sourceVertex, destinationVertex, weight, description);
        Road r2 = new Road(destinationVertex, sourceVertex, weight, description);
        (sourceVertex).addRoad(r);
        (destinationVertex).addRoad(r2);
        return r;
    }

    /**
     * Adds the specified vertex to this graph if not already present. More formally, adds the specified vertex, v, to this
     * graph if this graph contains no vertex u such that u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination with the restriction on constructors, this ensures that
     * graphs never contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     * @return true if this graph did not already contain the specified vertex.
     * @throws NullPointerException if the specified vertex is null.
     */
    public boolean addVertex(Town v) {
        if (containsVertex(v)) {
            return false;
        }
        map.add(v);
        return true;
    }

    /**
     * Returns true if and only if this graph contains an edge going from the source vertex to the target vertex. In
     * undirected graphs the same result is obtained when source and target are inverted. If any of the specified vertices
     * does not exist in the graph, or if is null, returns false.
     *
     * @param sourceVertex      source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return true if this graph contains the specified edge.
     */
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
        ArrayList<Road> list = sourceVertex.getTowns();
        for (Road r : list) {
            if (r.getDestination().equals(destinationVertex)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this graph contains the specified vertex. More formally, returns true if and only if this graph
     * contains a vertex u such that u.equals(v). If the specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     * @return true if this graph contains the specified vertex.
     */
    public boolean containsVertex(Town v) {
        for (Town t : map) {
            if (v.equals(t)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a set of the edges contained in this graph. The set is backed by the graph, so changes to the graph are
     * reflected in the set. If the graph is modified while an iteration over the set is in progress, the results of the
     * iteration are undefined.
     *
     * @return a set of the edges contained in this graph.
     */
    public Set<Road> edgeSet() {
        Set<Road> edgeSet = new HashSet<>();
        Set<String> nameSet = new HashSet<>();
        for (Town t : map) {
            HashMap<String, Road> roads = t.getRoads();
            for (String r : roads.keySet()) {
                if (!nameSet.contains(r)) {
                    edgeSet.add(roads.get(r));
                    nameSet.add(r);
                }
            }
        }

        return edgeSet;
    }

    /**
     * Returns a set of all edges touching the specified vertex (also referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be returned.
     * @return a set of all edges touching the specified vertex.
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException     if vertex is null.
     */
    public Set<Road> edgesOf(Town vertex) {
        if (!containsVertex(vertex)) {
            throw new IllegalArgumentException();
        } else if (vertex == null) {
            throw new NullPointerException();
        }
        Set<Road> set = new HashSet<>(vertex.getTowns());

        return set;

    }

    /**
     * Removes an edge going from source vertex to target vertex, if such vertices and such edge exist in this graph. If
     * weight >- 1 it must be checked If description != null, it must be checked Returns the edge if removed or null
     * otherwise.
     *
     * @param sourceVertex      source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight            weight of the edge
     * @param description       description of the edge
     * @return The removed edge, or null if no edge removed.
     */
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        HashMap<String, Road> roads = sourceVertex.getRoads();
        return roads.remove(description);
    }

    /**
     * Removes the specified vertex from this graph including all its touching edges if present. More formally, if the graph
     * contains a vertex u such that u.equals(v), the call removes all edges that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged. Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns). If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     * @return true if the graph contained the specified vertex; false otherwise.
     */
    public boolean removeVertex(Town v) {
        HashMap<String, Road> list = v.getRoads();
        for (Road r : list.values()) {
            Town t = r.getDestination();
            t.getRoads().remove(r.getName());
        }
        v.townDeleted();
        return map.remove(v);

    }

    /**
     * Returns a set of the vertices contained in this graph. The set is backed by the graph, so changes to the graph are
     * reflected in the set. If the graph is modified while an iteration over the set is in progress, the results of the
     * iteration are undefined.
     *
     * @return a set view of the vertices contained in this graph.
     */
    public Set<Town> vertexSet() {
        return new HashSet<>(map);
    }

    /**
     * Find the shortest path from the sourceVertex to the destinationVertex call the dijkstraShortestPath with the
     * sourceVertex
     * 
     * @param sourceVertex      starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex to destinationVertex They will be in the
     *         format: startVertex "via" Edge "to" endVertex weight As an example: if finding path from Vertex_1 to
     *         Vertex_10, the ArrayList<String> would be in the following format(this is a hypothetical solution): Vertex_1
     *         via Edge_2 to Vertex_3 4 (first string in ArrayList) Vertex_3 via Edge_5 to Vertex_8 2 (second string in
     *         ArrayList) Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
        ArrayList<String> path = new ArrayList<>();

        dijkstraShortestPath(sourceVertex);
        Town current = destinationVertex;

        while (shortestPath[current.getIndex()] != null) {
            Town prev = shortestPath[current.getIndex()];
            Road edge = getEdge(prev, current);
            String route = prev.getName() + " via " + edge.getName() + " to " + current.getName() + " " + edge.getWeight()
                    + " mi";
            path.add(0, route);
            current = prev;
        }

        return path;
    }

    /**
     * Dijkstra's Shortest Path Method. Internal structures are built which hold the ability to retrieve the path, shortest
     * distance from the sourceVertex to all the other vertices in the graph, etc.
     * 
     * @param sourceVertex the vertex to find shortest path from
     */
    public void dijkstraShortestPath(Town sourceVertex) {
        int[][] weightMatrix = make2DArray();
        distance = new int[weightMatrix.length];
        visited = new boolean[weightMatrix.length];
        shortestPath = new Town[weightMatrix.length];

        // setting default values for distance and visited
        for (int i = 0; i < weightMatrix.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        // setting the source vertex distance to 0 distance
        distance[sourceVertex.getIndex()] = 0;

        for (int i = 0; i < weightMatrix.length; i++) {
            int u = minDistance(distance, visited);
            visited[u] = true;
            for (int j = 0; j < weightMatrix.length; j++) {
                if (!visited[j] && weightMatrix[u][j] != 0 && distance[u] != Integer.MAX_VALUE
                        && distance[u] + weightMatrix[u][j] < distance[j]) {
                    distance[j] = distance[u] + weightMatrix[u][j];
                    shortestPath[j] = map.get(u);
                }
            }
        }

    }

    public int minDistance(int distance[], boolean visited[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < map.size(); i++) {
            if (visited[i] == false && distance[i] <= min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;

    }

    public int[][] make2DArray() {
        int[][] arr = new int[map.size()][map.size()];

        for (int i = 0; i < map.size(); i++) {
            ArrayList<Road> edges = map.get(i).getTowns();
            for (int j = 0; j < edges.size(); j++) {
                Road r = edges.get(j);
                arr[r.getSource().getIndex()][r.getDestination().getIndex()] = r.getWeight();
            }
        }

        return arr;
    }
}
