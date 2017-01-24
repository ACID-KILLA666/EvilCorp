package com.acidkilla.cleancode.evilcorp.entities;

import com.acidkilla.cleancode.evilcorp.factories.TaskFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Aurelien on 15-Jan-17.
 */

@AllArgsConstructor
public class Worker {

    @Getter @Setter protected String name;

    public Task work(String task, int startHour, int endHour, Date startingDate) {
        return doTask(task, Tasks.WORK.toString(), startHour, endHour, startingDate);
    }

    public Task doOther(String task, int startHour, int endHour, Date startingDate) {
        return doTask(task, Tasks.OTHER.toString(), startHour, endHour, startingDate);
    }

    protected Task doTask(String task, String action, int startHour, int endHour, Date startingDate) {
        TaskFactory factory = new TaskFactory(this, task, action, startHour, endHour, startingDate);
        return factory.build();
    }
}
