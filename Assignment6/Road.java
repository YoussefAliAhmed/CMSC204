package Assignments.Assignment6;

public class Road {
    private String name;
    private int weight;
    private Town source, destination;

    public Road() {

    }

    public Road(Town s, Town d, int w, String n) {
        name = n;
        weight = w;
        source = s;
        destination = d;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public Town getSource() {
        return source;
    }

    public Town getDestination() {
        return destination;
    }

    public int compareTo(Road r) {
        return name.compareTo(r.getName());
    }

    public boolean contains(Town t) {

        return destination.equals(t) || source.equals(t);
    }

    @Override
    public boolean equals(Object r) {
        Road comp = (Road)r;
        return comp.contains(destination) && comp.contains(source);
    }

    public String toString() {
        return "Name: " + name + " " + source + " to " + destination + " Miles: " + weight;
    }

}
