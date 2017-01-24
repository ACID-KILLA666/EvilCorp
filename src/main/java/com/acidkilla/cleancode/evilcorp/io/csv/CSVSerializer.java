package com.acidkilla.cleancode.evilcorp.io.csv;

import com.acidkilla.cleancode.evilcorp.io.Serializer;
import lombok.extern.slf4j.Slf4j;
import net.sf.sojo.interchange.csv.CsvSerializer;

/**
 * Created by Aurelien on 22-Jan-17.
 */
@Slf4j
public class CSVSerializer implements Serializer {

    @Override
    public byte[] serialize(Object object) {
        CsvSerializer csvSerializer = new CsvSerializer();
        String csv = (String) csvSerializer.serialize(object);
        return csv.getBytes();
    }

    @Override
    public Object deserialize(byte[] data) {
        CsvSerializer csvSerializer = new CsvSerializer();
        Object output = csvSerializer.deserialize(data.toString());
        return output;
    }
}
