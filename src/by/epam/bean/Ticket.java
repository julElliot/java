package by.epam.bean;

import java.util.Objects;

public class Ticket implements java.io.Serializable{

    private double price;
    private boolean baggage;
    private ServiceClass serviceClass;
    private Client client;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBaggage() {
        return baggage;
    }

    public void setBaggage(boolean baggage) {
        this.baggage = baggage;
    }

    public ServiceClass getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(ServiceClass serviceClass) {
        this.serviceClass = serviceClass;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.price, price) == 0 &&
                baggage == ticket.baggage &&
                serviceClass == ticket.serviceClass &&
                Objects.equals(client, ticket.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, baggage, serviceClass, client);
    }

    @Override
    public String toString() {
        return "Ticket: " + '\'' + "price= " + String.valueOf(price) + '\'' + "service class= " + serviceClass
                + '\'' + "baggage= " + (baggage?"yes":"no");
    }

}
