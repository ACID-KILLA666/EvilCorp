package com.acidkilla.cleancode.evilcorp.io.workflows;

import com.acidkilla.cleancode.evilcorp.entities.Activity;
import com.acidkilla.cleancode.evilcorp.entities.Task;
import com.acidkilla.cleancode.evilcorp.entities.Worker;
import com.acidkilla.cleancode.evilcorp.io.Serializer;
import com.acidkilla.cleancode.evilcorp.io.files.FileReader;
import com.acidkilla.cleancode.evilcorp.io.json.JSONSerializer;
import lombok.NoArgsConstructor;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Aurelien on 24-Jan-17.
 */
@NoArgsConstructor
public class JSONInputWorkflow implements Workflow{

    private static final int EXPECTED_ARGS_NUMBER = 1;
    private static final String ARGS_NUMBER_ERROR = "Given arguments number is not the same as expected. Expected " + EXPECTED_ARGS_NUMBER;

    @Override
    public void run(String[] args){
        if(args == null || args.length != EXPECTED_ARGS_NUMBER)
            throw new IllegalArgumentException(ARGS_NUMBER_ERROR);
        Path path = Paths.get(args[0]);
        FileReader reader = new FileReader(path);
        byte[] json = reader.read();
        Serializer serializer = new JSONSerializer();
        Task[] tasks = (Task[]) serializer.deserialize(json);

        Workflow singleInput = new SingleInputWorkflow();
        for(Task t : tasks) {
            Worker worker = t.getWorker();
            Activity activity = t.getActivity();
            String[] arguments = new String[] {
                            worker.getName(),
                            activity.getTask(),
                            activity.getAction(),
                            "" + activity.getStartHour(),
                            "" + activity.getEndHour(),
                            activity.getStartingDate() != null ? activity.getStartingDate().toString() : ""
            };
            singleInput.run(arguments);
        }
    }

}
