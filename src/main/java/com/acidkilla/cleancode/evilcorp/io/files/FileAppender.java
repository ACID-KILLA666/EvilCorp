package com.acidkilla.cleancode.evilcorp.io.files;

import com.acidkilla.cleancode.evilcorp.io.Appender;
import com.acidkilla.cleancode.evilcorp.io.Writer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;

/**
 * Created by Aurelien on 22-Jan-17.
 */
@AllArgsConstructor
@Slf4j
public class FileAppender implements Appender {

    private Path path;
    private static final String FILE_APPEND_ERROR_TEXT = "Could not append to given file";

    public void append(byte[] data){

        try {
            Files.write(this.path, data, APPEND);
        } catch (IOException e) {
            log.error(FILE_APPEND_ERROR_TEXT);
        }
    }
}
