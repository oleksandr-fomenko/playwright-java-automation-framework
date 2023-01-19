package com.github.utils;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public final class ObjectFormatUtils {

    private ObjectFormatUtils() {
    }

    public static Object[] decorateToJsonObjectTreeIfPossible(Object[] args){
        return Arrays.stream(args)
                .filter(Objects::nonNull)
                .map(ObjectFormatUtils::wrapToJsonTreeIfPossible)
                .toArray(Object[]::new);
    }

    public static <T> String wrapToJsonTreeIfPossible(T object) {
        Gson gson = new Gson();
        try {
            return gson.toJsonTree(object).toString();
        } catch (JsonIOException e) {
            return object.toString();
        }
    }

    public static String joinByComma(Object[] args){
        return Arrays.stream(args).map(Object::toString).collect(Collectors.joining(", "));
    }
}
