package com.biits.demosurvey.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class AnswerOptions {
    private String AnswerOptionsId;
    private String AnswerOptions_QuestionId;
    private String AnswerOptionsisDelete;



    public static Parcelable.Creator<AnswerOptions> getCreator() {
        return CREATOR;
    }

    public AnswerOptions(){

    }

    @Override
    public String toString() {
        return AnswerOptionsId   ;
    }
    public AnswerOptions(Parcel in){

        AnswerOptionsId = in.readString();
        AnswerOptions_QuestionId = in.readString();
        AnswerOptionsisDelete = in.readString();
    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(AnswerOptionsId);
        dest.writeString(AnswerOptions_QuestionId);
        dest.writeString(AnswerOptionsisDelete);
    }

    public static final Parcelable.Creator<AnswerOptions> CREATOR =
            new Parcelable.Creator<AnswerOptions>() {

                @Override
                public AnswerOptions createFromParcel(Parcel source) {
                    return new AnswerOptions(source);
                }

                @Override
                public AnswerOptions[] newArray(int size) {
                    return new AnswerOptions[size];
                }

            };

}