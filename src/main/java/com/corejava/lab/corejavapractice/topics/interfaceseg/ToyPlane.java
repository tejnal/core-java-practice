package com.corejava.lab.corejavapractice.topics.interfaceseg;

/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-09
 */
public class ToyPlane implements Toy, Movable, Flyable {

    double price;
    String color;


    @Override
    public void fly() {
        System.out.println("ToyPlane: Start flying plane. ");
    }

    @Override
    public void move() {
        System.out.println("ToyPlane: Start moving plane. ");
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setColor(String color) {
        this.color = color;

    }

    @Override
    public String toString() {
        return "ToyPlane{" +
                "price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
