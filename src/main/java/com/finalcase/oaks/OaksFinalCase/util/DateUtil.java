package com.finalcase.oaks.OaksFinalCase.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

    public DateUtil() {
        throw new UnsupportedOperationException("This cant be initialized");
    }

    public static Date parse(final String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}
