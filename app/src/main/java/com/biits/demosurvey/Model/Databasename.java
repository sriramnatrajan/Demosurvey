package com.biits.demosurvey.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Databasename {
    private String DatabaseId;
    private String DatabseName;
    private String DatabseDescription;
    private String Database_CompanyId;
    private String DatabaseisDelete;

    public String getDatabaseId() {
        return DatabaseId;
    }

    public void setDatabaseId(String databaseId) {
        DatabaseId = databaseId;
    }

    public String getDatabseName() {
        return DatabseName;
    }

    public void setDatabseName(String databseName) {
        DatabseName = databseName;
    }

    public String getDatabseDescription() {
        return DatabseDescription;
    }

    public void setDatabseDescription(String databseDescription) {
        DatabseDescription = databseDescription;
    }

    public String getDatabase_CompanyId() {
        return Database_CompanyId;
    }

    public void setDatabase_CompanyId(String database_CompanyId) {
        Database_CompanyId = database_CompanyId;
    }

    public String getDatabaseisDelete() {
        return DatabaseisDelete;
    }

    public void setDatabaseisDelete(String databaseisDelete) {
        DatabaseisDelete = databaseisDelete;
    }



    public static Parcelable.Creator<Databasename> getCreator() {
        return CREATOR;
    }

    public Databasename(){

    }

    @Override
    public String toString() {
        return DatabseName   ;
    }
    public Databasename(Parcel in){

        DatabaseId = in.readString();
        Database_CompanyId = in.readString();
        DatabseName = in.readString();
        DatabseDescription = in.readString();
    }
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(DatabaseId);
        dest.writeString(Database_CompanyId);
        dest.writeString(DatabseName);
        dest.writeString(DatabseDescription);
    }

    public static final Parcelable.Creator<Databasename> CREATOR =
            new Parcelable.Creator<Databasename>() {

                @Override
                public Databasename createFromParcel(Parcel source) {
                    return new Databasename(source);
                }

                @Override
                public Databasename[] newArray(int size) {
                    return new Databasename[size];
                }

            };

}

