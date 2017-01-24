package com.acidkilla.cleancode.evilcorp.io.files;

import com.acidkilla.cleancode.evilcorp.io.Reader;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Aurelien on 22-Jan-17.
 */
@AllArgsConstructor
@Slf4j
public class FileReader implements Reader {
    private Path path;
    private static final String FILE_ERROR_TEXT = "Could not read given file";

    @Override
    public byte[] read() {
        try {
            byte[] data = Files.readAllBytes(path);
            return data;
        } catch (IOException e) {
            log.error(FILE_ERROR_TEXT);
            return null;
        }

    }
}
