package com.biits.demosurvey.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class PreAssesmentmodel {

    private Long PreAssessmentId;
    private String PreAssessmentQuestionOption;
    private String PreAssessmentQuestionOptionChoice;


    public Long getPreAssessmentId() {
        return PreAssessmentId;
    }

    public void setPreAssessmentId(Long preAssessmentId) {
        PreAssessmentId = preAssessmentId;
    }

    public String getPreAssessmentQuestionOption() {
        return PreAssessmentQuestionOption;
    }

    public void setPreAssessmentQuestionOption(String preAssessmentQuestionOption) {
        PreAssessmentQuestionOption = preAssessmentQuestionOption;
    }

    public String getPreAssessmentQuestionOptionChoice() {
        return PreAssessmentQuestionOptionChoice;
    }

    public void setPreAssessmentQuestionOptionChoice(String preAssessmentQuestionOptionChoice) {
        PreAssessmentQuestionOptionChoice = preAssessmentQuestionOptionChoice;
    }








    public static Parcelable.Creator<PreAssesmentmodel> getCreator() {
        return CREATOR;
    }

    public PreAssesmentmodel(){

    }

    @Override
    public String toString() {
        return (PreAssessmentId + "," +PreAssessmentQuestionOption + "," + PreAssessmentQuestionOptionChoice+"\n" ) ;
    }
    public PreAssesmentmodel(Parcel in){

        PreAssessmentId = in.readLong();
        PreAssessmentQuestionOption = in.readString();
        PreAssessmentQuestionOptionChoice = in.readString();
    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLong(PreAssessmentId);
        dest.writeString(PreAssessmentQuestionOption);
        dest.writeString(PreAssessmentQuestionOptionChoice);
    }

    public static final Parcelable.Creator<PreAssesmentmodel> CREATOR =
            new Parcelable.Creator<PreAssesmentmodel>() {

                @Override
                public PreAssesmentmodel createFromParcel(Parcel source) {
                    return new PreAssesmentmodel(source);
                }

                @Override
                public PreAssesmentmodel[] newArray(int size) {
                    return new PreAssesmentmodel[size];
                }

            };

}