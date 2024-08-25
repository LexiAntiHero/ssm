package com.ssm.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {
        super();
        // Remove the default timestamp format
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // Set the time zone to GMT+8
        setTimeZone(TimeZone.getTimeZone("GMT+1"));
        // Set the date format to yyyy-MM-dd HH:mm:ss
        setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // Configure input: prevent mapping of null values in POJOs to JSON strings
        configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        // Do not serialize null values
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // Handle missing properties during deserialization
        getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // Serialize enums using toString(), default is false (uses name() by default)
        configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
    }
}

