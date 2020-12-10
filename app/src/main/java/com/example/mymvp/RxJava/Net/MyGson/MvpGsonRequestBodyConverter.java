package com.example.mymvp.RxJava.Net.MyGson;

import com.example.mymvp.Bean.BaseBean;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author zzh
 * @description:
 * @date :2020/12/9 9:38
 */
public class MvpGsonRequestBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    MvpGsonRequestBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        JsonReader jsonReader = gson.newJsonReader(value.charStream());
        try {
            T result = adapter.read(jsonReader);
            verify(value.string());
            return result;
        } finally {
            value.close();
        }
    }

    private static final int SUCCESS = 1;
    private void verify(String json) {
        BaseBean result = gson.fromJson(json, BaseBean.class);
        if (result.getCode() != SUCCESS) {
            int a = result.getCode();
            switch (result.getCode()) {
                case 299:
                    throw new JsonIOException(result.getMessage());
//                case TOKEN_EXPIRE:
//                    throw new JsonIOException("JSON document was not fully consumed.");
                default:
//                    throw new MyException("不清楚什么原因！");
            }
        }
    }

}