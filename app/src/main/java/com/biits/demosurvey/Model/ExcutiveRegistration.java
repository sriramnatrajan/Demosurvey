package com.biits.demosurvey.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ExcutiveRegistration {

    private long excutiveid;
    private String excutivename;
    private String excutiveemail;
    private String excutivepassword;
    private String excutivemobile;
    private String excutiveimei;

    public long getExcutiveid() {
        return excutiveid;
    }

    public void setExcutiveid(long excutiveid) {
        this.excutiveid = excutiveid;
    }

    public String getExcutivename() {
        return excutivename;
    }

    public void setExcutivename(String excutivename) {
        this.excutivename = excutivename;
    }

    public String getExcutiveemail() {
        return excutiveemail;
    }

    public void setExcutiveemail(String excutiveemail) {
        this.excutiveemail = excutiveemail;
    }

    public String getExcutivepassword() {
        return excutivepassword;
    }

    public void setExcutivepassword(String excutivepassword) {
        this.excutivepassword = excutivepassword;
    }

    public String getExcutivemobile() {
        return excutivemobile;
    }

    public void setExcutivemobile(String excutivemobile) {
        this.excutivemobile = excutivemobile;
    }

    public String getExcutiveimei() {
        return excutiveimei;
    }

    public void setExcutiveimei(String excutiveimei) {
        this.excutiveimei = excutiveimei;
    }



    public static Parcelable.Creator<ExcutiveRegistration> getCreator() {
        return CREATOR;
    }

    public ExcutiveRegistration(){

    }

    @Override
    public String toString() {
        return excutivename + "\n" + excutiveemail+ "\n" + excutivemobile+ "\n" + excutiveimei  ;
    }
    public ExcutiveRegistration(Parcel in){

        excutiveid = in.readLong();
        excutivename = in.readString();
        excutiveemail = in.readString();
        excutivepassword = in.readString();
        excutivemobile = in.readString();
        excutiveimei = in.readString();
    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLong(excutiveid);
        dest.writeString(excutivename);
        dest.writeString(excutiveemail);
        dest.writeString(excutivepassword);
        dest.writeString(excutivemobile);
        dest.writeString(excutiveimei);
    }

    public static final Parcelable.Creator<ExcutiveRegistration> CREATOR =
            new Parcelable.Creator<ExcutiveRegistration>() {

                @Override
                public ExcutiveRegistration createFromParcel(Parcel source) {
                    return new ExcutiveRegistration(source);
                }

                @Override
                public ExcutiveRegistration[] newArray(int size) {
                    return new ExcutiveRegistration[size];
                }

            };

}
