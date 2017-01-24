package com.acidkilla.cleancode.evilcorp.entities;

import java.util.Date;

/**
 * Created by Aurelien on 15-Jan-17.
 */
public class Robot extends Worker {

    public Robot(String name) {
        super(name);
    }

    public Task standby(String task, int startHour, int endHour, Date startingDate) {
        return doTask(task, Tasks.STANDBY.toString(), startHour, endHour, startingDate);
    }
}
