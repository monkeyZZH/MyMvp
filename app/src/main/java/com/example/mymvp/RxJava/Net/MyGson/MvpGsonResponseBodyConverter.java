package com.example.mymvp.RxJava.Net.MyGson;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author zzh
 * @description:
 * @date :2020/12/9 9:40
 */
public class MvpGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;
    //增加了type类型
    private Type type;

    MvpGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter,Type type) {
        this.gson = gson;
        this.adapter = adapter;
        this.type = type;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        if (type == String.class) {
            try {
                MediaType mediaType = value.contentType();
                Charset charset = null;
                if (mediaType == null) {
                    charset = mediaType.charset();
                }
                String s = new String(value.bytes(), charset == null ? StandardCharsets.UTF_8 : charset);
                return (T) s;
            } finally {
                value.close();
            }
        } else {
            JsonReader jsonReader = gson.newJsonReader(value.charStream());
            try {
                T result = adapter.read(jsonReader);
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
                return result;
            } finally {
                value.close();
            }
        }
    }
}