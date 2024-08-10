package Assignments.Assignment6;

import java.util.*;

public class Town {
    private String name;
    private HashMap<String, Road> roadMap = new HashMap<>();
    private int index;
    private static int count = 0;

    public Town(String n, boolean t) {
        name = n;
        roadMap = new HashMap<>();
        if (!t) {
            index = count;
            count++;
        }

    }

    public Town(Town t) {
        name = t.getName();
        roadMap = t.getRoads();
        index = t.getIndex();
        roadMap = t.getRoads();
    }

    public void townDeleted() {
        count--;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Road> getTowns() {
        return new ArrayList<>(roadMap.values());
    }

    public ArrayList<String> getRoadNames() {
        return new ArrayList<>(roadMap.keySet());
    }

    public Road getRoad(String name) {
        return roadMap.get(name);
    }

    public boolean equals(Town t) {
        return t.getName().equals(name);
    }

    public HashMap<String, Road> getRoads() {
        return roadMap;
    }

    public boolean addRoad(Road r) {
        if (roadMap.containsKey(r.getName())) {
            return false;
        }
        roadMap.put(r.getName(), r);
        return true;
    }

    public String toString() {
        String town = "";
        for (Road r : roadMap.values()) {
            town += r.getDestination() + ", ";
        }
        return "Town: " + name + " Adjacent Towns:" + town;
    }
}
