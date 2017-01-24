package com.acidkilla.cleancode.evilcorp.entities;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Aurelien on 15-Jan-17.
 */
@AllArgsConstructor
public class Activity {

	@Getter @Setter protected String task;
	@Getter @Setter protected String action;
	@Getter @Setter protected int startHour;
	@Getter @Setter protected int endHour;
	@Getter @Setter protected Date startingDate;
	
}
