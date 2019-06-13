package com.example.kaoshi.view;

import com.example.kaoshi.DbBean;

public interface View_impl {
    void onSuccess(DbBean dbBean);
    void onFail(String msg);
}
