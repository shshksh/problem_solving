package algorithm.algorithm_2020.pa11;

public class Area implements Cloneable{
    String name;
    double longitude;
    double latitude;
    double weigh;
    Area next;
    Area prev;

    public Area(String name, double longitude, double latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "\t{" +
                "place='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
