package com.corejava.lab.corejavapractice.topics.lambds.utils.modals;

import lombok.extern.slf4j.Slf4j;

/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-02
 */
@Slf4j
public class Print {

    public void printValue() {
        int number = 100;

        Runnable  runnable = () -> {
            try{
                Thread.sleep(5000);

            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            log.info("The Value is : " + number);

        };
        new Thread(runnable).start();

    }
}
