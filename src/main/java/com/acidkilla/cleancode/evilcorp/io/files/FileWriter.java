package com.acidkilla.cleancode.evilcorp.io.files;

import com.acidkilla.cleancode.evilcorp.io.Writer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.WRITE;

/**
 * Created by Aurelien on 22-Jan-17.
 */
@AllArgsConstructor
@Slf4j
public class FileWriter implements Writer {

    private Path path;
    private static final String FILE_WRITE_ERROR_TEXT = "Could not write to given file";

    public void write(byte[] data){

        try {
            Files.write(this.path, data, WRITE);
        } catch (IOException e) {
            log.error(FILE_WRITE_ERROR_TEXT);
        }
    }
}
