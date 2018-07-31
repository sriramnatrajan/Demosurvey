package com.biits.demosurvey.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Question_options {


    private long questionid;
    private String question;
    private String questiontype;
    private String optionone;
    private String optiontwo;
    private String optionthree;
    private String optionfour;

    public long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(long questionid) {
        this.questionid = questionid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestiontype() {
        return questiontype;
    }

    public void setQuestiontype(String questiontype) {
        this.questiontype = questiontype;
    }

    public String getOptionone() {
        return optionone;
    }

    public void setOptionone(String optionone) {
        this.optionone = optionone;
    }

    public String getOptiontwo() {
        return optiontwo;
    }

    public void setOptiontwo(String optiontwo) {
        this.optiontwo = optiontwo;
    }

    public String getOptionthree() {
        return optionthree;
    }

    public void setOptionthree(String optionthree) {
        this.optionthree = optionthree;
    }

    public String getOptionfour() {
        return optionfour;
    }

    public void setOptionfour(String optionfour) {
        this.optionfour = optionfour;
    }


    public static Parcelable.Creator<Question> getCreator() {
        return CREATOR;
    }

    public Question_options(){

    }



    public Question_options(int questionid, String question, String questiontype, String optionone, String optiontwo, String optionthree, String optionfour) {
        this.questionid = questionid;
        this.question = question;
        this.questiontype = questiontype;
        this.optionone = optionone;
        this.optiontwo = optiontwo;
        this.optionthree = optionthree;
        this.optionfour = optionfour;
    }

    @Override
    public String toString() {
        return question + "\n" + questiontype+ "\n" + optionone+ "\n" + optiontwo+ "\n" + optionthree+ "\n" + optionfour  ;
    }
    public Question_options(Parcel in){

        questionid = in.readLong();
        question = in.readString();
        questiontype = in.readString();
        optionone = in.readString();
        optiontwo = in.readString();
        optionthree = in.readString();
        optionfour = in.readString();
    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLong(questionid);
        dest.writeString(question);
        dest.writeString(questiontype);
        dest.writeString(optionone);
        dest.writeString(optiontwo);
        dest.writeString(optionthree);
        dest.writeString(optionfour);
    }

    public static final Parcelable.Creator<Question> CREATOR =
            new Parcelable.Creator<Question>() {

                @Override
                public Question createFromParcel(Parcel source) {
                    return new Question(source);
                }

                @Override
                public Question[] newArray(int size) {
                    return new Question[size];
                }

            };
}
