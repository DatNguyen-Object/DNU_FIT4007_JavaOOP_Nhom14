package model;

public class Plane {
    private String id;
    private String model;
    private int capacity;

    public Plane(String id, String model, int capacity) {
        this.id = id;
        this.model = model;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String toCsv() {
        return id + "," + model + "," + capacity;
    }
}