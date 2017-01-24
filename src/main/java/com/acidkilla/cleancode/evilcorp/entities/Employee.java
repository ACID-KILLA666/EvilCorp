package com.acidkilla.cleancode.evilcorp.entities;

import java.util.Date;

/**
 * Created by Aurelien on 15-Jan-17.
 */
public class Employee extends Worker {

    public Employee(String name) {
        super(name);
    }

    public Task sleep(String task, int startHour, int endHour, Date startingDate) {
        return doTask(task, Tasks.SLEEP.toString(), startHour, endHour, startingDate);
    }

    public Task eat(String task, int startHour, int endHour, Date startingDate) {
        return doTask(task, Tasks.EAT.toString(), startHour, endHour, startingDate);
    }
}
