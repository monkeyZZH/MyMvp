package com.example.mymvp.RxJava.Net.MyGson;

import com.example.mymvp.Bean.BaseBean;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;

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

        //原始写法看博客：https://mp.csdn.net/console/editor/html/110928151
        JsonReader jsonReader = gson.newJsonReader(value.charStream());
        String json = value.string();
        try {
            verify(json);
//            return adapter.read(jsonReader);
            return adapter.read(gson.newJsonReader(new StringReader(json)));
        } finally {
            value.close();
        }
    }

    //可用于集中处理code报错信息
    private static final int SUCCESS = 200;
    private void verify(String json) {
        BaseBean result = gson.fromJson(json, BaseBean.class);
        if (result.getCode() != SUCCESS) {
            int a = result.getCode();
            switch (result.getCode()) {
                case 29:
                    throw new JsonIOException(result.getMessage());
//                case TOKEN_EXPIRE:
//                    throw new JsonIOException("JSON document was not fully consumed.");
                default:
                    throw new JsonIOException("不清楚什么原因！");
            }
        }
    }
}