package br.com.dh.integra.odonto.util;

import java.sql.Timestamp;
import java.util.Date;

public class UtilDate {

    public static Timestamp dateToTimestamp(Date date) {
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }
}
