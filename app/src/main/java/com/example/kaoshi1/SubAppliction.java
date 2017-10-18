package com.example.kaoshi1;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.alex.greendao.gen.DaoMaster;
import com.alex.greendao.gen.DaoSession;

/**
 * Created by 你瞅啥 on 2017/9/27.
 */
public class SubAppliction extends Application {
    private static SubAppliction subAppliction;
    private DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
       subAppliction=this;
        create();
    }

    private void create() {
       DaoMaster.DevOpenHelper helper= new DaoMaster.DevOpenHelper(this,"kaoshi");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster=new DaoMaster(db);
        daoSession=daoMaster.newSession();

    }

    public static SubAppliction getSubAppliction() {
        return subAppliction;}

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
