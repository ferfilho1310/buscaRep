package com.example.buscarep.Util;

import androidx.annotation.Nullable;

import java.util.HashMap;

public class GetViewData extends HashMap<String, Object> {

    private static GetViewData getViewData;

    public static synchronized GetViewData getInstance(){
        getViewData = new GetViewData();
        return  getViewData;
    }

    @Nullable
    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }

    @Nullable
    @Override
    public Object get(@Nullable Object key) {
        return super.get(key);
    }

    @Nullable
    @Override
    public Object remove(@Nullable Object key) {
        return super.remove(key);
    }
}
