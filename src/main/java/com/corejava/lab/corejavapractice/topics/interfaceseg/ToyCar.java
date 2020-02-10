package com.corejava.lab.corejavapractice.topics.interfaceseg;

/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-09
 */
public class ToyCar implements Toy, Movable{

    double price;
    String color;

    @Override
    public void move() {
        System.out.println("Toy Car: Start moving  ....");

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
        return "ToyCar{" +
                "price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
