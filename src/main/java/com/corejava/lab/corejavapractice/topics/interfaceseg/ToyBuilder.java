package com.corejava.lab.corejavapractice.topics.interfaceseg;

/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-09
 */
public class ToyBuilder {

    public static ToyHouse buildToyHouse() {
        ToyHouse toyHouse = new ToyHouse();
        toyHouse.setColor("pink");
        toyHouse.setPrice(17.00);
        return toyHouse;
    }

    public static ToyCar buildToyCar() {
        ToyCar toyCar = new ToyCar();
        toyCar.setColor("green");
        toyCar.setPrice(25.00);
        toyCar.move();
        return toyCar;

    }

    public static ToyPlane buildToyPlane() {
        ToyPlane toyPlane = new ToyPlane();
        toyPlane.setColor("Orange");
        toyPlane.setPrice(130.00);
        toyPlane.move();
        toyPlane.fly();
        return toyPlane;
    }
}
