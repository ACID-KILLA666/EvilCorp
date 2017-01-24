package com.acidkilla.cleancode.evilcorp.io.json;

import lombok.AllArgsConstructor;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by Aurelien on 22-Jan-17.
 */
public class JSONSerializerTest {

    @AllArgsConstructor
    private static class TestSerial {
        private String string;
        private int number;
    }

    private static final String DEFAULT_NAME = "DEFAULT_NAME";
    private static final int DEFAULT_NUMBER = 42;
    private static final String DEFAULT_RESULT = DEFAULT_NAME + "," + DEFAULT_NUMBER;
    private static final TestSerial NULL_SERIAL = null;
    private static final String EMPTY_RESULT = "";
    private static final byte[] NULL_RESULT = null;
    private static final TestSerial DEFAULT_SERIAL = new TestSerial(DEFAULT_NAME, DEFAULT_NUMBER);

    @Test
    public void shouldSerializeObject() {
        JSONSerializer serializer = new JSONSerializer();
        String serial = new String(serializer.serialize(DEFAULT_SERIAL));

        assertThat(serial).isEqualTo(DEFAULT_RESULT);
    }

    @Test
    public void shouldReturnEmptyStringWhenSerialIsNull() {
        JSONSerializer serializer = new JSONSerializer();
        String serial = new String(serializer.serialize(NULL_SERIAL));

        assertThat(serial).isEqualTo(EMPTY_RESULT);
    }

    @Test
    public void shouldDeserializeObject() {
        JSONSerializer serializer = new JSONSerializer();
        TestSerial object = (TestSerial) serializer.deserialize(DEFAULT_RESULT.getBytes());

        assertThat(object).isEqualTo(DEFAULT_SERIAL);
    }

    @Test
    public void shouldReturnNullWhenDataIsNull() {
        JSONSerializer serializer = new JSONSerializer();
        TestSerial object = (TestSerial) serializer.deserialize(NULL_RESULT);

        assertThat(object).isEqualTo(NULL_SERIAL);
    }
}
