package com.corejava.lab.corejavapractice.topics.interfaceseg;

/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-09
 */
public class ToyHouse implements  Toy{

    double price;
    String color;

    @Override
    public void setPrice(double price) {
        this.price = price;

    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
