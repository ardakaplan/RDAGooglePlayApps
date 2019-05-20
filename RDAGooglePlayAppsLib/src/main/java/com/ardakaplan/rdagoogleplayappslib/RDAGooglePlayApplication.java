package com.ardakaplan.rdagoogleplayappslib;

import com.ardakaplan.rdalibrary.base.objects.RDAObject;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Arda Kaplan on 30-Jan-19 - 11:45
 */
public class RDAGooglePlayApplication extends RDAObject implements Serializable {

    @SerializedName("index")
    private int index;
    @SerializedName("name_turkish")
    private String nameTurkish;
    @SerializedName("name_english")
    private String nameEnglish;
    @SerializedName("package_name")
    private String packageName;
    @SerializedName("version")
    private int version;
    @SerializedName("description_turkish")
    private String descriptionTurkish;
    @SerializedName("description_english")
    private String descriptionEnglish;
    @SerializedName("icon_url")
    private String iconUrl;

    public RDAGooglePlayApplication() {

    }

    public RDAGooglePlayApplication(int index, String nameTurkish, String nameEnglish, String packageName, int version, String descriptionTurkish, String descriptionEnglish, String iconUrl) {
        this.index = index;
        this.nameTurkish = nameTurkish;
        this.nameEnglish = nameEnglish;
        this.packageName = packageName;
        this.version = version;
        this.descriptionTurkish = descriptionTurkish;
        this.descriptionEnglish = descriptionEnglish;
        this.iconUrl = iconUrl;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getNameTurkish() {
        return nameTurkish;
    }

    public void setNameTurkish(String nameTurkish) {
        this.nameTurkish = nameTurkish;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDescriptionTurkish() {
        return descriptionTurkish;
    }

    public void setDescriptionTurkish(String descriptionTurkish) {
        this.descriptionTurkish = descriptionTurkish;
    }

    public String getDescriptionEnglish() {
        return descriptionEnglish;
    }

    public void setDescriptionEnglish(String descriptionEnglish) {
        this.descriptionEnglish = descriptionEnglish;
    }
}
