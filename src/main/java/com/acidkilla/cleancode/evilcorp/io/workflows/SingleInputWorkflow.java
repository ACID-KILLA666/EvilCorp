package com.acidkilla.cleancode.evilcorp.io.workflows;

import com.acidkilla.cleancode.evilcorp.entities.Task;
import com.acidkilla.cleancode.evilcorp.entities.Worker;
import com.acidkilla.cleancode.evilcorp.factories.TaskFactory;
import com.acidkilla.cleancode.evilcorp.io.Serializer;
import com.acidkilla.cleancode.evilcorp.io.csv.CSVSerializer;
import com.acidkilla.cleancode.evilcorp.io.files.FileAppender;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Created by Aurelien on 24-Jan-17.
 */
@Slf4j
public class SingleInputWorkflow implements Workflow{

    private static final Path LOG_PATH = Paths.get("log.log");
    private static final int LOW_EXPECTED_ARGS_NUMBER = 5;
    private static final int HIGH_EXPECTED_ARGS_NUMBER = 6;
    private static final String ARGS_ERROR = "Could not parse argument due to type mismatch";
    private static final String ARGS_NUMBER_ERROR = "Given arguments number is not the same as expected."
                                + "Expected between " + LOW_EXPECTED_ARGS_NUMBER + " and "
                                + HIGH_EXPECTED_ARGS_NUMBER;
    @Override
    public void run(String[] args) {
        if(args == null || args.length < LOW_EXPECTED_ARGS_NUMBER || args.length > HIGH_EXPECTED_ARGS_NUMBER) {
            log.error(ARGS_NUMBER_ERROR);
            throw new IllegalArgumentException(ARGS_NUMBER_ERROR);
        }

        String name;
        String task;
        String action;
        int startHour;
        int endHour;
        Date startDate;
        try {
            name = args[0];
            task = args[1];
            action = args[2];
            startHour = Integer.parseInt(args[3]);
            endHour = Integer.parseInt(args[4]);
            startDate = new Date(args[3]);
        } catch(Exception e) {
            log.error(ARGS_ERROR);
            throw new IllegalArgumentException(ARGS_ERROR);
        }

        process(name, task, action, startHour, endHour, startDate);
    }

    protected void process(String name, String task, String action, int startHour, int endHour, Date startDate) {
        Worker worker = new Worker(name);
        TaskFactory factory = new TaskFactory(worker, task, action, startHour, endHour, startDate);
        Task builtTask = factory.build();
        serializeToLogFile(builtTask);
    }

    private void serializeToLogFile(Task task){
        Serializer csvSerializer = new CSVSerializer();
        byte[] csv = csvSerializer.serialize(task);
        FileAppender appender = new FileAppender(LOG_PATH);
        appender.append(csv);
    }
}
