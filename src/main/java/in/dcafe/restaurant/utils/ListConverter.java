package in.dcafe.restaurant.utils;


import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;


public class ListConverter implements AttributeConverter<List<String>, String>{

    private static final String SPLIT_CHAR = ";";

    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        return stringList != null ? String.join(SPLIT_CHAR, stringList) : "";
    }

    @Override
    public List<String> convertToEntityAttribute(String string) {
        return string != null ? Arrays.asList(string.split(SPLIT_CHAR)) : emptyList();
    }
}
