package com.biits.demosurvey.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


import com.biits.demosurvey.Model.AnswerResponse;

import java.util.ArrayList;
import java.util.List;

public class MarketResearchDatabaseOpenHelper extends SQLiteOpenHelper {

    public static final String LOGCAT = "MarketResearch";

    public static final String DATABASE_NAME = "marketresearch.db";
    // public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "answerresponse";
    public static final String TAB_ANSWERS="answerstab";
    public static final String COLUMN_AnswerResponseId = "AnswerResponseId";
    public static final String COLUMN_AnswerResponse_AnswerOptionsId = "AnswerResponse_AnswerOptionsId";

    public static final String COLUMN_AnswerResponse_AnswerOptions = "AnswerResponse_AnswerOptions";
    public static final String COLUMN_AnswerResponse_QuestionId = "AnswerResponse_QuestionId";
    public static final String COLUMN_AnswerResponseDescription = "AnswerResponseDescription";
    public static final String COLUMN_AnswerResponse_UserId = "AnswerResponse_UserId";
    public static final String COLUMN_AnswerResponseAttribute = "AnswerResponseAttribute";
  //  public static final String COLUMN_AnswerResponseisDelete = "AnswerResponseisDelete";




    public MarketResearchDatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (AnswerResponseId INTEGER PRIMARY KEY AUTOINCREMENT,AnswerResponse_AnswerOptionsId TEXT,AnswerResponse_QuestionId TEXT,AnswerResponseDescription TEXT,AnswerResponse_UserId TEXT,AnswerResponseAttribute INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String AnswerResponse_AnswerOptionsId, String AnswerResponse_QuestionId, String AnswerResponseDescription, String AnswerResponse_UserId, Integer AnswerResponseAttribute ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_AnswerResponse_AnswerOptionsId,AnswerResponse_AnswerOptionsId);
        contentValues.put(COLUMN_AnswerResponse_QuestionId,AnswerResponse_QuestionId);
        contentValues.put(COLUMN_AnswerResponseDescription,AnswerResponseDescription);
        contentValues.put(COLUMN_AnswerResponse_UserId,AnswerResponse_UserId);
        contentValues.put(COLUMN_AnswerResponseAttribute,AnswerResponseAttribute);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean answersdata(String AnswerResponse_AnswerOptionsId, String AnswerResponse_AnswerOptions,
                               String AnswerResponse_QuestionId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_AnswerResponse_QuestionId,AnswerResponse_QuestionId);
        contentValues.put(COLUMN_AnswerResponse_AnswerOptionsId,AnswerResponse_AnswerOptionsId);
        contentValues.put(COLUMN_AnswerResponse_AnswerOptions, AnswerResponse_AnswerOptions);

        /*
        contentValues.put(COLUMN_AnswerResponseDescription,AnswerResponseDescription);
        contentValues.put(COLUMN_AnswerResponse_UserId,AnswerResponse_UserId);
        contentValues.put(COLUMN_AnswerResponseAttribute,AnswerResponseAttribute);*/
        long result = db.insert(TAB_ANSWERS,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }

    /*
     * this method is for getting all the unsynced name
     * so that we can sync it with database
     * */
//    public Cursor getUnsyncedData() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "SELECT * FROM " + TABLE_NAME ;
//        Cursor c = db.rawQuery(sql, null);
//        return c;
//    }
        public Cursor getUnsyncedData() {
                SQLiteDatabase db = this.getReadableDatabase();
                String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_AnswerResponseAttribute
                        + " = 1;";;
                Cursor c = db.rawQuery(sql, null);
                return c;
            }



    /*
     * This method taking two arguments
     * first one is the id of the name for which
     * we have to update the sync status
     * and the second one is the status that will be changed
     * */
    public boolean updateAnswerResponseAttribute(Long AnswerResponseId, int AnswerResponseAttribute) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_AnswerResponseAttribute, AnswerResponseAttribute);
        db.update(TABLE_NAME, contentValues, COLUMN_AnswerResponseId + "=" + AnswerResponseId, null);
        db.close();
        return true;
    }


    public List<AnswerResponse> getAllAnswerResponse() {
        List<AnswerResponse> answerResponses = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                AnswerResponse answerResponse = new AnswerResponse();
                answerResponse.setAnswerResponseId(cursor.getLong(cursor.getColumnIndex(COLUMN_AnswerResponseId)));
                answerResponse.setAnswerResponse_AnswerOptionsId(cursor.getString(cursor.getColumnIndex(COLUMN_AnswerResponse_AnswerOptionsId)));
                answerResponse.setAnswerResponse_QuestionId(cursor.getString(cursor.getColumnIndex(COLUMN_AnswerResponse_QuestionId)));
                answerResponse.setAnswerResponseDescription(cursor.getString(cursor.getColumnIndex(COLUMN_AnswerResponseDescription)));
                answerResponse.setAnswerResponse_UserId(cursor.getString(cursor.getColumnIndex(COLUMN_AnswerResponse_UserId)));
                answerResponse.setAnswerResponseAttribute(cursor.getInt(cursor.getColumnIndex(COLUMN_AnswerResponseAttribute)));

                answerResponses.add(answerResponse);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return answerResponses list
        return answerResponses;
    }



    public boolean updateData(String AnswerResponseId, String AnswerResponse_AnswerOptionsId, String AnswerResponse_QuestionId, String AnswerResponseDescription) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_AnswerResponseId,AnswerResponseId);
        contentValues.put(COLUMN_AnswerResponse_AnswerOptionsId,AnswerResponse_AnswerOptionsId);
        contentValues.put(COLUMN_AnswerResponse_QuestionId,AnswerResponse_QuestionId);
        contentValues.put(COLUMN_AnswerResponseDescription,AnswerResponseDescription);

        db.update(TABLE_NAME, contentValues, "AnswerResponseId = ?",new String[] { AnswerResponseId });
        return true;
    }




    /**
     * Get the AnswerResponse object based on AnswerResponse_QuestionId.
     * @param AnswerResponse_QuestionId
     * @return
     */

    public List<AnswerResponse> getAnswerResponse(String AnswerResponse_QuestionId){
        SQLiteDatabase db = this.getWritableDatabase();
        List<AnswerResponse> answerResponseList = new ArrayList<AnswerResponse>();

        String query = "SELECT * FROM "+TABLE_NAME + " WHERE AnswerResponse_QuestionId == '"+AnswerResponse_QuestionId+ "'";
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                AnswerResponse answerResponse = new AnswerResponse();

                answerResponse.setAnswerResponseId(cursor.getLong(cursor.getColumnIndex(COLUMN_AnswerResponseId)));
                answerResponse.setAnswerResponse_AnswerOptionsId(cursor.getString(cursor.getColumnIndex(COLUMN_AnswerResponse_AnswerOptionsId)));
                answerResponse.setAnswerResponse_QuestionId(cursor.getString(cursor.getColumnIndex(COLUMN_AnswerResponse_QuestionId)));
                answerResponse.setAnswerResponseDescription(cursor.getString(cursor.getColumnIndex(COLUMN_AnswerResponseDescription)));
                answerResponseList.add(answerResponse);

            }
        }

        return answerResponseList;
    }


    /**
     * Delete database table
     *
     * @param
     */
    public  void cleartable() {
       // DBHelper dbHelper = new DBHelper(context);
      //  SQLiteDatabase db = dbHelper.getReadableDatabase();
        SQLiteDatabase db = this.getReadableDatabase();

        try {

            db.execSQL("DELETE  FROM " + TABLE_NAME);

        } catch (SQLiteException e) {
            e.printStackTrace();
        }

    }

//    public Integer deleteData (String id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
//    }
}