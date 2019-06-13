package com.example.kaoshi.utils;

import com.example.kaoshi.DbBean;
import com.example.kaoshi.MyApp;
import com.example.kaoshi.dao.DaoMaster;
import com.example.kaoshi.dao.DaoSession;
import com.example.kaoshi.dao.DbBeanDao;

import java.util.ArrayList;
import java.util.List;

public class MyHelper {
    public static MyHelper myHelper;
    private final DbBeanDao dbBeanDao;

    public MyHelper() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getMyApp(), "a.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        dbBeanDao = daoSession.getDbBeanDao();

        initData();
    }

    private void initData() {
        ArrayList<DbBean> dbBeans = new ArrayList<>();
        for (int i = 0; i <40 ; i++) {
            dbBeans.add(new DbBean("标题"+i,"内容"+i,"网址"+i,"图片"+i));
        }
        dbBeanDao.insertOrReplaceInTx(dbBeans);
    }

    public void insert(DbBean beanDao){
             if (has(beanDao)){
                 return;
             }
         dbBeanDao.insertOrReplace(beanDao);
         }
         public List<DbBean> query(){
            return dbBeanDao.queryBuilder().list();
         }
         public void delete(DbBean beanDao){
             if (has(beanDao)){
                 dbBeanDao.delete(beanDao);
             }
         }
         public boolean has(DbBean beanDao){
             List<DbBean> list = dbBeanDao.queryBuilder().where(DbBeanDao.Properties.Title.eq(beanDao.getTitle())).list();
             if (list!=null&&list.size()>0){
                 return true;
             }
             return false;
         }
}
