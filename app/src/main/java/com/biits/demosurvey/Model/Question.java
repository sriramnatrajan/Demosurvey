package com.biits.demosurvey.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Question {

    private boolean isSelected;

    private String QuestionId;
    private String questionno;
    private String question;
    private String questiontype;
    private String AnswerOptionsId1;
    private String AnswerOptionsId2;
    private String AnswerOptionsId3;
    private String AnswerOptionsId4;
    private String optionone;
    private String optiontwo;
    private String optionthree;
    private String optionfour;

private String Et_Answer;
    public String getEt_Answer() {
        return QuestionId;
    }

    public void setEt_Answer(String etAnswer) {
        QuestionId = etAnswer;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }




    public String getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(String questionId) {
        QuestionId = questionId;
    }

    public String getQuestionno() {
        return questionno;
    }

    public void setQuestionno(String questionno) {
        this.questionno = questionno;
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


    public String getAnswerOptionsId1() {
        return AnswerOptionsId1;
    }

    public void setAnswerOptionsId1(String answerOptionsId1) {
        AnswerOptionsId1 = answerOptionsId1;
    }

    public String getAnswerOptionsId2() {
        return AnswerOptionsId2;
    }

    public void setAnswerOptionsId2(String answerOptionsId2) {
        AnswerOptionsId2 = answerOptionsId2;
    }

    public String getAnswerOptionsId3() {
        return AnswerOptionsId3;
    }

    public void setAnswerOptionsId3(String answerOptionsId3) {
        AnswerOptionsId3 = answerOptionsId3;
    }

    public String getAnswerOptionsId4() {
        return AnswerOptionsId4;
    }

    public void setAnswerOptionsId4(String answerOptionsId4) {
        AnswerOptionsId4 = answerOptionsId4;
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

        public Question(){

        }



    public Question(String QuestionId, String questionno, String question, String questiontype, String AnswerOptionsId1, String AnswerOptionsId2, String AnswerOptionsId3, String AnswerOptionsId4, String optionone, String optiontwo, String optionthree, String optionfour) {
        this.QuestionId = QuestionId;
        this.questionno = questionno;
        this.question = question;
        this.questiontype = questiontype;
        this.AnswerOptionsId1 = AnswerOptionsId1;
        this.AnswerOptionsId2 = AnswerOptionsId2;
        this.AnswerOptionsId3 = AnswerOptionsId3;
        this.AnswerOptionsId4 = AnswerOptionsId4;
        this.optionone = optionone;
        this.optiontwo = optiontwo;
        this.optionthree = optionthree;
        this.optionfour = optionfour;
    }

        @Override
        public String toString() {
            return QuestionId + "\n" +question + "\n" + questiontype+ "\n" + AnswerOptionsId1+ "\n"+ optionone+ "\n" + optiontwo+ "\n" + optionthree+ "\n" + optionfour  ;
        }
        public Question(Parcel in){

            QuestionId = in.readString();
            questionno = in.readString();
            question = in.readString();
            questiontype = in.readString();
            AnswerOptionsId1 = in.readString();
            AnswerOptionsId2 = in.readString();
            AnswerOptionsId3 = in.readString();
            AnswerOptionsId4 = in.readString();
            optionone = in.readString();
            optiontwo = in.readString();
            optionthree = in.readString();
            optionfour = in.readString();
        }
        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {

            dest.writeString(QuestionId);
            dest.writeString(questionno);
            dest.writeString(question);
            dest.writeString(questiontype);
            dest.writeString(AnswerOptionsId1);
            dest.writeString(AnswerOptionsId2);
            dest.writeString(AnswerOptionsId3);
            dest.writeString(AnswerOptionsId4);
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
