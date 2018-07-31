package com.biits.demosurvey.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class User {
    private String UserId;
    private String User_CompanyId;
    private String UserName;
    private String UserFirstName;
    private String UserMiddleName;
    private String UserLastName;
    private String UserAddress;
    private String UserEmail;
    private String UserMobile;
    private String UserisDelete;



    public User(String UserName) {
        this.UserName = UserName;
    }
    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUser_CompanyId() {
        return User_CompanyId;
    }

    public void setUser_CompanyId(String user_CompanyId) {
        User_CompanyId = user_CompanyId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserFirstName() {
        return UserFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        UserFirstName = userFirstName;
    }

    public String getUserMiddleName() {
        return UserMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        UserMiddleName = userMiddleName;
    }

    public String getUserLastName() {
        return UserLastName;
    }

    public void setUserLastName(String userLastName) {
        UserLastName = userLastName;
    }

    public String getUserAddress() {
        return UserAddress;
    }

    public void setUserAddress(String userAddress) {
        UserAddress = userAddress;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserMobile() {
        return UserMobile;
    }

    public void setUserMobile(String userMobile) {
        UserMobile = userMobile;
    }

    public String getUserisDelete() {
        return UserisDelete;
    }

    public void setUserisDelete(String userisDelete) {
        UserisDelete = userisDelete;
    }



    public static Parcelable.Creator<User> getCreator() {
        return CREATOR;
    }

    public User(){

    }


    @Override
    public String toString() {
        return UserName   ;
    }
    public User(Parcel in){

        UserId = in.readString();
        User_CompanyId = in.readString();
        UserName = in.readString();
        UserFirstName = in.readString();
        UserMiddleName = in.readString();
        UserLastName = in.readString();
        UserAddress = in.readString();
        UserEmail = in.readString();
        UserMobile = in.readString();
    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(UserId);
        dest.writeString(User_CompanyId);
        dest.writeString(UserName);
        dest.writeString(UserFirstName);
        dest.writeString(UserMiddleName);
        dest.writeString(UserLastName);
        dest.writeString(UserAddress);
        dest.writeString(UserEmail);
        dest.writeString(UserMobile);
    }

    public static final Parcelable.Creator<User> CREATOR =
            new Parcelable.Creator<User>() {

                @Override
                public User createFromParcel(Parcel source) {
                    return new User(source);
                }

                @Override
                public User[] newArray(int size) {
                    return new User[size];
                }

            };

}
