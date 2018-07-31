package com.biits.demosurvey.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Company {

    private String CompanyId;
    private String CompanyName;
    private String CompanyDescription;
    private String isDelete;

    public String getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(String companyId) {
        CompanyId = companyId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getCompanyDescription() {
        return CompanyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        CompanyDescription = companyDescription;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public static Parcelable.Creator<Company> getCreator() {
        return CREATOR;
    }

    public Company(){

    }

    @Override
    public String toString() {
        return CompanyName   ;
    }
    public Company(Parcel in){

        CompanyId = in.readString();
        CompanyName = in.readString();
        CompanyDescription = in.readString();
    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(CompanyId);
        dest.writeString(CompanyName);
        dest.writeString(CompanyDescription);
    }

    public static final Parcelable.Creator<Company> CREATOR =
            new Parcelable.Creator<Company>() {

                @Override
                public Company createFromParcel(Parcel source) {
                    return new Company(source);
                }

                @Override
                public Company[] newArray(int size) {
                    return new Company[size];
                }

            };

}