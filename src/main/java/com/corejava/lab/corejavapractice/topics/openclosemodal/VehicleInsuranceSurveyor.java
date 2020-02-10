package com.corejava.lab.corejavapractice.topics.openclosemodal;

/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-09
 */
public class VehicleInsuranceSurveyor extends InsuranceSurveyor {

    @Override
    public boolean isValidClaim() {
        System.out.println("Vehicle  insurance surveyor : ");
        return true;
    }
}
