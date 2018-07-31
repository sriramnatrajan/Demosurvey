package com.biits.demosurvey.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Role {

    private String RoleId;
    private String RoleName;
    private String RoleisDelete;

    public String getRoleId() {
        return RoleId;
    }

    public void setRoleId(String roleId) {
        RoleId = roleId;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getRoleisDelete() {
        return RoleisDelete;
    }

    public void setRoleisDelete(String roleisDelete) {
        RoleisDelete = roleisDelete;
    }





    public static Parcelable.Creator<Role> getCreator() {
        return CREATOR;
    }

    public Role(){

    }

    @Override
    public String toString() {
        return RoleName   ;
    }
    public Role(Parcel in){

        RoleId = in.readString();
        RoleName = in.readString();
        RoleisDelete = in.readString();
    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(RoleId);
        dest.writeString(RoleName);
        dest.writeString(RoleisDelete);
    }

    public static final Parcelable.Creator<Role> CREATOR =
            new Parcelable.Creator<Role>() {

                @Override
                public Role createFromParcel(Parcel source) {
                    return new Role(source);
                }

                @Override
                public Role[] newArray(int size) {
                    return new Role[size];
                }

            };

}