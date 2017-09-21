package com.viacheslavtitov.commoncode.data.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created by Viacheslav Titov on 21.09.2017.
 */

public class JsonUtils {

    public static <T> T parseJsonObject(String json, Class<T> clsz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clsz);
    }

    public static <T> T parseJsonList(String json, Class<T> clsz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clsz));
    }

}
