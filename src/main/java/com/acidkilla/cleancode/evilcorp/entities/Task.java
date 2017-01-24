package com.acidkilla.cleancode.evilcorp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Aurelien on 15-Jan-17.
 */
@AllArgsConstructor
public class Task {
	@Getter @Setter protected Worker worker;
	@Getter @Setter protected Activity activity;
}
