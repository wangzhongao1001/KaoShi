package com.example.kaoshi.callback;

import com.example.kaoshi.DbBean;

public interface CallBack_impl {
    void onSuccess(DbBean dbBean);
    void onFail(String msg);
}
