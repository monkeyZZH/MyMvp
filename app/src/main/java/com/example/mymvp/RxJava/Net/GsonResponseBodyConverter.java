package com.example.mymvp.RxJava.Net;

/**
 * @author zzh
 * @description:
 * @date :2020/12/4 17:09
 */
//public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
//    private final Gson gson;
//    private final Type type;
//
//    GsonResponseBodyConverter(Gson gson, Type type) {
//        this.gson = gson;
//        this.type = type;
//    }
//
//    @Override
//    public T convert(ResponseBody value) throws IOException{
//        String response = value.string();
//        try {
//            Log.d("Network", "response>>" + response);
//            //ResultResponse 只解析result字段
//            BaseBean resultResponse = gson.fromJson(response, BaseBean.class);
//            if (resultResponse.getCode() == 0){
//                //result==0表示成功返回，继续用本来的Model类解析
//                return gson.fromJson(response, type);
//            } else {
//                //ErrResponse 将msg解析为异常消息文本
//                ErrResponse errResponse = gson.fromJson(response, ErrResponse.class);
//                throw new ResultException(resultResponse.getResult(), errResponse.getMsg());
//            }
//        } finally {
//        }
//    }
//
//}
