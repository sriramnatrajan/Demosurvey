/*
package com.biits.demosurvey.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHandler extends SQLiteOpenHelper {

    private static final String TAG=DataHandler.class.getSimpleName();
    private static final int DATABASEVERSION=1;
    private static final String DATABASENAME1="saver.db";
    private static final String TABLE_NAME="contents";

    private static final String QUES_ID="id";
    private static final String QUES_QID="question_id";
    private static final String QUES_NO="question_no";
    private static final String QUES_DISPLAY="QuestionDisplay";
    private static final String KEY_QUESTIONTYPE="question_type";

    private static final String KEY_QUESSEC="QuestionNoSection";
    private static final String ANS_OPTIONID="AnswerOptionsId";
    private static final String ANS_OPTIONS="AnswerOptions";
    private static final String ANS_ID="answerId"


    public DataHandler(Context mContext){
        super(  mContext,DATABASENAME1,null,DATABASEVERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTENT_TABLE= "CREATE TABLE "+TABLE_NAME+"("
                +QUES_ID+"INTEGER PRIMARY_KEY,"
                +QUES_QID+"TEXT,"
                +QUES_NO+"TEXT,"
                +QUES_DISPLAY+"TEXT,"
                +KEY_QUESTIONTYPE+"TEXT,"
                +KEY_QUESSEC+"TEXT,"
                +ANS_OPTIONID+"TEXT,"
                +ANS_OPTIONS+"TEXT"+")";
        sqLiteDatabase.execSQL(CREATE_CONTENT_TABLE);
        Log.d(TAG,"Database table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


    public boolean addContents(String QID,String QUS_NO,String QUS_TITLE, String QUS_TYPE,
                               String QUS_SEC,String OPTIONID,String OPTIONS){

        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues mContentValues=new ContentValues();
        mContentValues.put(QUES_ID,QID);
        mContentValues.put(QUES_NO,QUS_NO);
        mContentValues.put(QUES_DISPLAY,QUS_TITLE);
        mContentValues.put(KEY_QUESTIONTYPE,QUS_TYPE);
        mContentValues.put(KEY_QUESSEC,QUS_SEC);
        mContentValues.put(ANS_ID,ANS_ID);
        mContentValues.put(ANS_OPTIONID,OPTIONID);
        mContentValues.put(ANS_OPTIONS,OPTIONS);

    }
}
*/
