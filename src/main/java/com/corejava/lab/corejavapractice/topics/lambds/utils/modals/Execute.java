package com.corejava.lab.corejavapractice.topics.lambds.utils.modals;

import lombok.extern.slf4j.Slf4j;


/**
 * @project core-java-practice
 * @autor tejnal on 2020-02-02
 */
@Slf4j
public class Execute implements Runnable {
    @Override
    public void run() {
        log.info("This is thread execution with non lambda expression");

    }
}
