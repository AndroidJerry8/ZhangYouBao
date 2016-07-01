package com.game.lol.zhangyoubao.db;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.game.lol.zhangyoubao.constant.DB;
import com.game.lol.zhangyoubao.model.DBHeroListBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/29 15:46
 * 创建描述：HeroList表的数据库操作类
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class DBHelperDao {
    private static final String TAG = "DBHelperDao";
    private SQLiteDatabase db;
    private Context context;

    private volatile static DBHelperDao instance;

    /**
     * 构造函数，初始化一些数据
     */
    private DBHelperDao(Context context) {
        this.context = context;
    }

    /**
     * 返回 DBHelperDao 单例对象
     *
     * @return DBHelperDao 单例对象
     */
    public static DBHelperDao getInstance(Context context) {
        if (instance == null) {
            synchronized (DBHelperDao.class) {
                if (instance == null) {
                    instance = new DBHelperDao(context);
                }
            }
        }
        return instance;
    }

    public DBHelperDao openDB() {
        db = opDB();
        return this;
    }

    /**
     * 从Assets文件里打开数据库文件
     *
     * @return
     */
    private SQLiteDatabase opDB() {
        AssetManager assets = context.getAssets();
        try {
            File file = new File(context.getFilesDir(), "db_zhangyoubao.db");
            if (file.exists()) {
                return SQLiteDatabase.openOrCreateDatabase(file, null);
            } else {
                FileOutputStream fos = new FileOutputStream(file);
                InputStream open = assets.open("db_zhangyoubao.db");
                int available = open.available();
                byte[] buffer = new byte[available];
                open.read(buffer);
                fos.write(buffer);
                fos.flush();
                fos.close();
                open.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return opDB();
    }

    /**
     * 根据Id查询HeroList的Bean
     *
     * @param id id
     * @return
     */
    public DBHeroListBean queryHeroListById(String id) {
        if (db.isOpen()) {
            String[] columns = {"area", "duoname", "filter", "free", "keyword", "money", "name", "nickname", "nickpinyin", "pic_url", "point", "publish"};
            String[] selectionArgs = {id};
            Cursor cursor = db.query(DB.TABLE_NAME_herolist, columns, "id=?", selectionArgs, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                return new DBHeroListBean(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        id,
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10),
                        cursor.getString(11));
            }
//            db.close();
        }
        return null;
    }

    /**
     * 查询所有HeroList的Bean
     *
     * @return
     */
    public List<DBHeroListBean> queryHeroListAll(String selection, String[] selectionArgs, String orderBy) {
        if (db.isOpen()) {
            String[] columns = {"area", "duoname", "filter", "free", "id", "keyword", "money", "name", "nickname", "nickpinyin", "pic_url", "point", "publish"};
            Cursor cursor = db.query(DB.TABLE_NAME_herolist, columns, selection, selectionArgs, null, null, null);    //"publish DESC"
            if (cursor != null && cursor.getCount() > 0) {
                List<DBHeroListBean> list = new ArrayList<>();
                while (cursor.moveToNext()) {
                    list.add(new DBHeroListBean(cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            cursor.getString(5),
                            cursor.getString(6),
                            cursor.getString(7),
                            cursor.getString(8),
                            cursor.getString(9),
                            cursor.getString(10),
                            cursor.getString(11),
                            cursor.getString(12)));
                }
                cursor.close();
                db.close();
                return list;
            }

        }
        return null;
    }
}
