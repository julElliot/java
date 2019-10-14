package by.epam.bean;

import java.util.Objects;

public class Client implements java.io.Serializable{
    private int discount;
    private String name;
    private String surname;
    private String login;
    private String pass;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getDiscount() == client.getDiscount() &&
                Objects.equals(getName(), client.getName()) &&
                Objects.equals(getSurname(), client.getSurname()) &&
                Objects.equals(getLogin(), client.getLogin()) &&
                Objects.equals(getPass(), client.getPass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiscount(), getName(), getSurname(), getLogin(), getPass());
    }

    @Override
    public String toString() {
        return "Client: "  + " name= " + name  + " surname= " + surname + " discount= " + String.valueOf(discount);
    }
}
