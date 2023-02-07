package models;

import com.google.gson.annotations.SerializedName;

public class Project {

    @SerializedName(value = "name")
    private String name;
    private String announcement;

    @SerializedName(value = "suite_mode")
    private int type;

    @SerializedName(value = "show_announcement")
    private boolean showAnnouncement;
    private boolean deleted;

//    public Project(String name, String announcement, int type, boolean showAnnouncement, boolean deleted) {
//        this.name = name;
//        this.announcement = announcement;
//        this.type = type;
//        this.showAnnouncement = showAnnouncement;
//        this.deleted = deleted;
//    }

    public String getName() {
        return name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public int getType() {
        return type;
    }

    public boolean isShowAnnouncement() {
        return showAnnouncement;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        this.showAnnouncement = showAnnouncement;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
