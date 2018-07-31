package com.biits.demosurvey.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Preassesment {

    private String PreAssessmentQuestionNo;
    private String PreAssessmentQuestionDesc;

    private String PreAssessmentQuestionOption1;
    private String PreAssessmentQuestionOption2;
    private String PreAssessmentQuestionOption3;
    private String PreAssessmentQuestionOption4;

    private String PreAssessmentQuestionOptionChoice1;
    private String PreAssessmentQuestionOptionChoice2;
    private String PreAssessmentQuestionOptionChoice3;
    private String PreAssessmentQuestionOptionChoice4;

    public String getPreAssessmentQuestionNo() {
        return PreAssessmentQuestionNo;
    }

    public void setPreAssessmentQuestionNo(String preAssessmentQuestionNo) {
        PreAssessmentQuestionNo = preAssessmentQuestionNo;
    }

    public String getPreAssessmentQuestionDesc() {
        return PreAssessmentQuestionDesc;
    }

    public void setPreAssessmentQuestionDesc(String preAssessmentQuestionDesc) {
        PreAssessmentQuestionDesc = preAssessmentQuestionDesc;
    }

    public String getPreAssessmentQuestionOption1() {
        return PreAssessmentQuestionOption1;
    }

    public void setPreAssessmentQuestionOption1(String preAssessmentQuestionOption1) {
        PreAssessmentQuestionOption1 = preAssessmentQuestionOption1;
    }

    public String getPreAssessmentQuestionOption2() {
        return PreAssessmentQuestionOption2;
    }

    public void setPreAssessmentQuestionOption2(String preAssessmentQuestionOption2) {
        PreAssessmentQuestionOption2 = preAssessmentQuestionOption2;
    }

    public String getPreAssessmentQuestionOption3() {
        return PreAssessmentQuestionOption3;
    }

    public void setPreAssessmentQuestionOption3(String preAssessmentQuestionOption3) {
        PreAssessmentQuestionOption3 = preAssessmentQuestionOption3;
    }

    public String getPreAssessmentQuestionOption4() {
        return PreAssessmentQuestionOption4;
    }

    public void setPreAssessmentQuestionOption4(String preAssessmentQuestionOption4) {
        PreAssessmentQuestionOption4 = preAssessmentQuestionOption4;
    }

    public String getPreAssessmentQuestionOptionChoice1() {
        return PreAssessmentQuestionOptionChoice1;
    }

    public void setPreAssessmentQuestionOptionChoice1(String preAssessmentQuestionOptionChoice1) {
        PreAssessmentQuestionOptionChoice1 = preAssessmentQuestionOptionChoice1;
    }

    public String getPreAssessmentQuestionOptionChoice2() {
        return PreAssessmentQuestionOptionChoice2;
    }

    public void setPreAssessmentQuestionOptionChoice2(String preAssessmentQuestionOptionChoice2) {
        PreAssessmentQuestionOptionChoice2 = preAssessmentQuestionOptionChoice2;
    }

    public String getPreAssessmentQuestionOptionChoice3() {
        return PreAssessmentQuestionOptionChoice3;
    }

    public void setPreAssessmentQuestionOptionChoice3(String preAssessmentQuestionOptionChoice3) {
        PreAssessmentQuestionOptionChoice3 = preAssessmentQuestionOptionChoice3;
    }

    public String getPreAssessmentQuestionOptionChoice4() {
        return PreAssessmentQuestionOptionChoice4;
    }

    public void setPreAssessmentQuestionOptionChoice4(String preAssessmentQuestionOptionChoice4) {
        PreAssessmentQuestionOptionChoice4 = preAssessmentQuestionOptionChoice4;
    }


    public static Parcelable.Creator<Preassesment> getCreator() {
        return CREATOR;
    }

    public Preassesment(){

    }



    public Preassesment(String PreAssessmentQuestionNo, String PreAssessmentQuestionDesc, String PreAssessmentQuestionOption1, String PreAssessmentQuestionOption2,
                        String PreAssessmentQuestionOption3, String PreAssessmentQuestionOptionChoice1, String PreAssessmentQuestionOptionChoice2, String PreAssessmentQuestionOptionChoice3, String PreAssessmentQuestionOptionChoice4) {

        this.PreAssessmentQuestionNo = PreAssessmentQuestionNo;
        this.PreAssessmentQuestionDesc = PreAssessmentQuestionDesc;

        this.PreAssessmentQuestionOption1 = PreAssessmentQuestionOption1;
        this.PreAssessmentQuestionOption2 = PreAssessmentQuestionOption2;
        this.PreAssessmentQuestionOption3 = PreAssessmentQuestionOption3;
        this.PreAssessmentQuestionOption4 = PreAssessmentQuestionOption4;

        this.PreAssessmentQuestionOptionChoice1 = PreAssessmentQuestionOptionChoice1;
        this.PreAssessmentQuestionOptionChoice2 = PreAssessmentQuestionOptionChoice2;
        this.PreAssessmentQuestionOptionChoice3 = PreAssessmentQuestionOptionChoice3;
        this.PreAssessmentQuestionOptionChoice4 = PreAssessmentQuestionOptionChoice4;
    }

    @Override
    public String toString() {
        return PreAssessmentQuestionNo + "\n" +PreAssessmentQuestionDesc + "\n" + PreAssessmentQuestionOption1+ "\n" + PreAssessmentQuestionOption2+ "\n"+ PreAssessmentQuestionOption3+ "\n" + PreAssessmentQuestionOption4+ "\n"
                + PreAssessmentQuestionOptionChoice1+ "\n" + PreAssessmentQuestionOptionChoice2+ "\n" + PreAssessmentQuestionOptionChoice3+ "\n" + PreAssessmentQuestionOptionChoice4  ;
    }
    public Preassesment(Parcel in){

        PreAssessmentQuestionNo = in.readString();
        PreAssessmentQuestionDesc = in.readString();

        PreAssessmentQuestionOption1 = in.readString();
        PreAssessmentQuestionOption2 = in.readString();
        PreAssessmentQuestionOption3 = in.readString();
        PreAssessmentQuestionOption4 = in.readString();

        PreAssessmentQuestionOptionChoice1 = in.readString();
        PreAssessmentQuestionOptionChoice2 = in.readString();
        PreAssessmentQuestionOptionChoice3 = in.readString();
        PreAssessmentQuestionOptionChoice4 = in.readString();

    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(PreAssessmentQuestionNo);
        dest.writeString(PreAssessmentQuestionDesc);

        dest.writeString(PreAssessmentQuestionOption1);
        dest.writeString(PreAssessmentQuestionOption2);
        dest.writeString(PreAssessmentQuestionOption3);
        dest.writeString(PreAssessmentQuestionOption4);

        dest.writeString(PreAssessmentQuestionOptionChoice1);
        dest.writeString(PreAssessmentQuestionOptionChoice2);
        dest.writeString(PreAssessmentQuestionOptionChoice3);
        dest.writeString(PreAssessmentQuestionOptionChoice4);

    }

    public static final Parcelable.Creator<Preassesment> CREATOR =
            new Parcelable.Creator<Preassesment>() {

                @Override
                public Preassesment createFromParcel(Parcel source) {
                    return new Preassesment(source);
                }

                @Override
                public Preassesment[] newArray(int size) {
                    return new Preassesment[size];
                }

            };

}
