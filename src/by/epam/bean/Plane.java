package by.epam.bean;

import java.util.Objects;

public class Plane implements java.io.Serializable{
    private String model;
    private int places;
    private int age;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return getPlaces() == plane.getPlaces() &&
                getAge() == plane.getAge() &&
                Objects.equals(getModel(), plane.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getPlaces(), getAge());
    }

    @Override
    public String toString() {
        return "Plane: " + '\'' + "model= " + model + '\'' + "places= " + String.valueOf(places)
                + '\'' + "age= " +  String.valueOf(age);
    }
}
