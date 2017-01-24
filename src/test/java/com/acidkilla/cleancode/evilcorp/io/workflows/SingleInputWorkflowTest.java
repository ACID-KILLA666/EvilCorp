package com.acidkilla.cleancode.evilcorp.io.workflows;

import com.acidkilla.cleancode.evilcorp.entities.Task;
import com.acidkilla.cleancode.evilcorp.factories.TaskFactory;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Aurelien on 24-Jan-17.
 */
public class SingleInputWorkflowTest {

    private static final String[] DEFAULT_ARGS = {
            "a",
            "b",
            "c",
            "1",
            "2",
            "2016-24-01",
    };
    private static final String[] NOT_ENOUGH_ARGS = {
            "a",
    };
    private static final String[] TOO_MANY_ARGS = {
            "a",
            "b",
            "c",
            "1",
            "2",
            "2016-24-01",
            "a",
            "b",
    };
    private static final String[] WRONG_ARGS_TYPE = {
            "a",
            "b",
            "c",
            "d",
            "2.0",
            "1840-32-13-2048-314153122077-yoloyolo-test",
    };
    private static final Workflow DEFAULT_WORKFLOW = new SingleInputWorkflow();

    @Test
    public void shouldParseArguments() {
        SingleInputWorkflow workflow = spy(new SingleInputWorkflow());
        doNothing().when(workflow).process(any(), any(), any(), any(), any(), any());
        DEFAULT_WORKFLOW.run(DEFAULT_ARGS);
    }

    @Test
    public void shouldThrowExceptionWhenNotEnoughArguments() {
        SingleInputWorkflow workflow = spy(new SingleInputWorkflow());
        doNothing().when(workflow).process(any(), any(), any(), any(), any(), any());
        assertThatThrownBy(() -> {DEFAULT_WORKFLOW.run(NOT_ENOUGH_ARGS);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void shouldThrowExceptionWhenTooManyArguments() {
        SingleInputWorkflow workflow = spy(new SingleInputWorkflow());
        doNothing().when(workflow).process(any(), any(), any(), any(), any(), any());
        assertThatThrownBy(() -> {DEFAULT_WORKFLOW.run(TOO_MANY_ARGS);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void shouldThrowExceptionWhenWrongArgumentsType() {
        SingleInputWorkflow workflow = spy(new SingleInputWorkflow());
        doNothing().when(workflow).process(any(), any(), any(), any(), any(), any());
        assertThatThrownBy(() -> {DEFAULT_WORKFLOW.run(WRONG_ARGS_TYPE);}).isInstanceOf(IllegalArgumentException.class);
    }
}