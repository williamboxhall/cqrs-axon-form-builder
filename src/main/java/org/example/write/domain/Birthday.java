package org.example.write.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Birthday {
    // TODO joda
    private final Date date;

    public Birthday(Date date) {
        this.date = date;
    }

    public static Birthday valueOf(String date) {
        return new Birthday(dateFor(date));
    }

    private static Date dateFor(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
