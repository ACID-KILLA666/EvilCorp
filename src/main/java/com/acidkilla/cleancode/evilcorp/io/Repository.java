package com.acidkilla.cleancode.evilcorp.io;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Aurelien on 22-Jan-17.
 */
@AllArgsConstructor
public class Repository {
    @Getter protected Reader reader;
    @Getter protected Writer writer;
    @Getter protected Appender appender;
}
