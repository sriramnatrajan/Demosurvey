package com.biits.demosurvey.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class AnswerResponse {

    private Long AnswerResponseId;
    private String AnswerResponse_AnswerOptionsId;
    private String AnswerResponse_QuestionId;
    private String AnswerResponseDescription;
    private String AnswerResponse_UserId;
    private Integer AnswerResponseAttribute;
    private String AnswerResponseisDelete;




    public Long getAnswerResponseId() {
        return AnswerResponseId;
    }

    public void setAnswerResponseId(Long answerResponseId) {
        AnswerResponseId = answerResponseId;
    }

    public String getAnswerResponse_AnswerOptionsId() {
        return AnswerResponse_AnswerOptionsId;
    }

    public void setAnswerResponse_AnswerOptionsId(String answerResponse_AnswerOptionsId) {
        AnswerResponse_AnswerOptionsId = answerResponse_AnswerOptionsId;
    }

    public String getAnswerResponse_QuestionId() {
        return AnswerResponse_QuestionId;
    }

    public void setAnswerResponse_QuestionId(String answerResponse_QuestionId) {
        AnswerResponse_QuestionId = answerResponse_QuestionId;
    }

    public String getAnswerResponseDescription() {
        return AnswerResponseDescription;
    }

    public void setAnswerResponseDescription(String answerResponseDescription) {
        AnswerResponseDescription = answerResponseDescription;
    }

    public String getAnswerResponse_UserId() {
        return AnswerResponse_UserId;
    }

    public void setAnswerResponse_UserId(String answerResponse_UserId) {
        AnswerResponse_UserId = answerResponse_UserId;
    }

    public Integer getAnswerResponseAttribute() {
        return AnswerResponseAttribute;
    }

    public void setAnswerResponseAttribute(Integer answerResponseAttribute) {
        AnswerResponseAttribute = answerResponseAttribute;
    }

    public String getAnswerResponseisDelete() {
        return AnswerResponseisDelete;
    }

    public void setAnswerResponseisDelete(String answerResponseisDelete) {
        AnswerResponseisDelete = answerResponseisDelete;
    }

    public static Parcelable.Creator<AnswerResponse> getCreator() {
        return CREATOR;
    }

    public AnswerResponse(){

    }

    @Override
    public String toString() {
        return (AnswerResponseId + "," +AnswerResponse_AnswerOptionsId + "," + AnswerResponse_QuestionId+ ","  + AnswerResponseDescription+","+ AnswerResponse_UserId+","+ AnswerResponseAttribute+"\n" ) ;
    }
    public AnswerResponse(Parcel in){

        AnswerResponseId = in.readLong();
        AnswerResponse_AnswerOptionsId = in.readString();
        AnswerResponse_QuestionId = in.readString();
        AnswerResponseDescription = in.readString();
        AnswerResponse_UserId = in.readString();
        AnswerResponseAttribute = in.readInt();
        AnswerResponseisDelete = in.readString();
    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLong(AnswerResponseId);
        dest.writeString(AnswerResponse_AnswerOptionsId);
        dest.writeString(AnswerResponse_QuestionId);
        dest.writeString(AnswerResponseDescription);
        dest.writeString(AnswerResponse_UserId);
        dest.writeInt(AnswerResponseAttribute);
        dest.writeString(AnswerResponseisDelete);
    }

    public static final Parcelable.Creator<AnswerResponse> CREATOR =
            new Parcelable.Creator<AnswerResponse>() {

                @Override
                public AnswerResponse createFromParcel(Parcel source) {
                    return new AnswerResponse(source);
                }

                @Override
                public AnswerResponse[] newArray(int size) {
                    return new AnswerResponse[size];
                }

            };

}