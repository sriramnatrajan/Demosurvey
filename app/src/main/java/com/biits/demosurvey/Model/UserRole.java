package com.biits.demosurvey.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserRole {
    private String UserRoleId;
    private String UserRoleDescription;
    private String UserRole_UserId;
    private String UserRole_RoleId;
    private String UserRoleisDelete;

    public String getUserRoleId() {
        return UserRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        UserRoleId = userRoleId;
    }

    public String getUserRoleDescription() {
        return UserRoleDescription;
    }

    public void setUserRoleDescription(String userRoleDescription) {
        UserRoleDescription = userRoleDescription;
    }

    public String getUserRole_UserId() {
        return UserRole_UserId;
    }

    public void setUserRole_UserId(String userRole_UserId) {
        UserRole_UserId = userRole_UserId;
    }

    public String getUserRole_RoleId() {
        return UserRole_RoleId;
    }

    public void setUserRole_RoleId(String userRole_RoleId) {
        UserRole_RoleId = userRole_RoleId;
    }

    public String getUserRoleisDelete() {
        return UserRoleisDelete;
    }

    public void setUserRoleisDelete(String userRoleisDelete) {
        UserRoleisDelete = userRoleisDelete;
    }




    public static Parcelable.Creator<UserRole> getCreator() {
        return CREATOR;
    }

    public UserRole(){

    }

    @Override
    public String toString() {
        return UserRoleDescription   ;
    }
    public UserRole(Parcel in){

        UserRoleId = in.readString();
        UserRoleDescription = in.readString();
        UserRole_RoleId = in.readString();
        UserRole_UserId = in.readString();
        UserRoleisDelete = in.readString();
    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(UserRoleId);
        dest.writeString(UserRoleDescription);
        dest.writeString(UserRole_RoleId);
        dest.writeString(UserRole_UserId);
        dest.writeString(UserRoleisDelete);
    }

    public static final Parcelable.Creator<UserRole> CREATOR =
            new Parcelable.Creator<UserRole>() {

                @Override
                public UserRole createFromParcel(Parcel source) {
                    return new UserRole(source);
                }

                @Override
                public UserRole[] newArray(int size) {
                    return new UserRole[size];
                }

            };

}