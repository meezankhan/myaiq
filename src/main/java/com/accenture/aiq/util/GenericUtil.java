package com.accenture.aiq.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.accenture.aiq.constants.Constants;

public class GenericUtil {
	
	static SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);

	public static String convertDateToDTOFormat(Timestamp date) {
		return sdf.format(date);

	}
}
