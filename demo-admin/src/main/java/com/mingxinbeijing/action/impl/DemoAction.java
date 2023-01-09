 package com.mingxinbeijing.action.impl;

import com.google.gson.Gson;

public class DemoAction<T> {

	public T jsonToObject(String json,Class<T> classOfT) {
        //成功后的回调
        Gson gson = new Gson();
        T obj = gson.fromJson(json, classOfT);
        System.out.println(" obj "+obj.toString());
        return obj;
	}

}
