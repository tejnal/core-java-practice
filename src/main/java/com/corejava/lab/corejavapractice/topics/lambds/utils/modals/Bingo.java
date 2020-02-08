package com.corejava.lab.corejavapractice.topics.lambds.utils.modals;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-08
 */

public class Bingo {


    public Bingo() {
    }

    //create a method with Arrays as List
    public List<String> createList() {

        //we have bingo number as arraylist
        List<String> bingoNumbers = Arrays.asList(
                "A12", "A23", "A45",
                "B54", "B25", "B89",
                "C89", "C67","C43",
                "D02", "D92","D26"
        );

        return bingoNumbers;
    }
}
