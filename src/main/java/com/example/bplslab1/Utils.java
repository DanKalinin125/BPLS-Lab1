package com.example.bplslab1;

import java.sql.Date;
import java.time.Instant;

public class Utils {
    public static Date getCurrentDateTime(){
        return new Date(Instant.now().toEpochMilli());
    }
}
