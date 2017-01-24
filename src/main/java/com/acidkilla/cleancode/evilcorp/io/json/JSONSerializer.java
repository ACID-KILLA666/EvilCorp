package com.acidkilla.cleancode.evilcorp.io.json;

import com.acidkilla.cleancode.evilcorp.io.Serializer;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Aurelien on 24-Jan-17.
 */
@Slf4j
public class JSONSerializer implements Serializer {

    @Override
    public byte[] serialize(Object object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json.getBytes();
    }

    @Override
    public Object deserialize(byte[] data) {
        if(data == null)
            return null;
        Gson gson = new Gson();
        Object output = gson.fromJson(data.toString(), Object.class);
        return output;
    }
}
