package edu.txstate.library.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter implements JsonSerializer<LocalDate> {
    public LocalDateAdapter() {
    }

    /**
     * Original format: "checkoutDate":{"year":2021,"month":7,"day":27}
     * Format after registering this class: yyyy-mm-dd
     * @param date
     * @param typeOfSrc
     * @param context
     * @return
     */
    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
    }
}
