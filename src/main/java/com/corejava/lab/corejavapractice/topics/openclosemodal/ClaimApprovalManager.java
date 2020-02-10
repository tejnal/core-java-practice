package com.corejava.lab.corejavapractice.topics.openclosemodal;

/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-09
 */
public class ClaimApprovalManager {

    public void process(InsuranceSurveyor surveyor) {
        if(surveyor.isValidClaim()){
            System.out.println("Claim approval manager ...... ");
        }


    }
}
