package com.acidkilla.cleancode.evilcorp.io;

/**
 * Created by Aurelien on 22-Jan-17.
 */
public interface Serializer {
    byte[] serialize(Object object);
    Object deserialize(byte[] data);
}
