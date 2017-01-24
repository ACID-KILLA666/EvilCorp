package com.acidkilla.cleancode.evilcorp.factories;

import com.acidkilla.cleancode.evilcorp.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

/**
 * Created by Aurelien on 15-Jan-17.
 */
@AllArgsConstructor
public class TaskFactory {
    @Getter private Worker worker;
    @Getter private String task;
    @Getter protected String action;
    @Getter protected int startHour;
    @Getter protected int endHour;
    @Getter protected Date startingDate;

    public Task build() {
        Activity activity = new Activity(task, action, startHour, endHour, startingDate);
        Task task = new Task(worker, activity);
        return task;
    }
}
