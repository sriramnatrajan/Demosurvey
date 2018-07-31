package com.biits.demosurvey.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class CompanyProject {
    private String CompanyProjectId;
    private String CompanyProject_CompanyId;
    private String CompanyProjectName;
    private String CompanyProjectType;
    private String CompanyProjectDescription;
    private String CompanyProjectCenter;
    private String CompanyProjectisDelete;


    public String getCompanyProjectId() {
        return CompanyProjectId;
    }

    public void setCompanyProjectId(String companyProjectId) {
        CompanyProjectId = companyProjectId;
    }

    public String getCompanyProject_CompanyId() {
        return CompanyProject_CompanyId;
    }

    public void setCompanyProject_CompanyId(String companyProject_CompanyId) {
        CompanyProject_CompanyId = companyProject_CompanyId;
    }

    public String getCompanyProjectName() {
        return CompanyProjectName;
    }

    public void setCompanyProjectName(String companyProjectName) {
        CompanyProjectName = companyProjectName;
    }

    public String getCompanyProjectType() {
        return CompanyProjectType;
    }

    public void setCompanyProjectType(String companyProjectType) {
        CompanyProjectType = companyProjectType;
    }

    public String getCompanyProjectDescription() {
        return CompanyProjectDescription;
    }

    public void setCompanyProjectDescription(String companyProjectDescription) {
        CompanyProjectDescription = companyProjectDescription;
    }

    public String getCompanyProjectCenter() {
        return CompanyProjectCenter;
    }

    public void setCompanyProjectCenter(String companyProjectCenter) {
        CompanyProjectCenter = companyProjectCenter;
    }

    public String getCompanyProjectisDelete() {
        return CompanyProjectisDelete;
    }

    public void setCompanyProjectisDelete(String companyProjectisDelete) {
        CompanyProjectisDelete = companyProjectisDelete;
    }




    public static Parcelable.Creator<CompanyProject> getCreator() {
        return CREATOR;
    }

    public CompanyProject(){

    }

    @Override
    public String toString() {
        return CompanyProjectName   ;
    }
    public CompanyProject(Parcel in){

        CompanyProjectId = in.readString();
        CompanyProject_CompanyId = in.readString();
        CompanyProjectName = in.readString();
        CompanyProjectType = in.readString();
        CompanyProjectDescription = in.readString();
        CompanyProjectCenter= in.readString();
        CompanyProjectisDelete= in.readString();
    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(CompanyProjectId);
        dest.writeString(CompanyProject_CompanyId);
        dest.writeString(CompanyProjectName);
        dest.writeString(CompanyProjectType);
        dest.writeString(CompanyProjectDescription);
        dest.writeString(CompanyProjectCenter);
        dest.writeString(CompanyProjectisDelete);
    }

    public static final Parcelable.Creator<CompanyProject> CREATOR =
            new Parcelable.Creator<CompanyProject>() {

                @Override
                public CompanyProject createFromParcel(Parcel source) {
                    return new CompanyProject(source);
                }

                @Override
                public CompanyProject[] newArray(int size) {
                    return new CompanyProject[size];
                }

            };

}