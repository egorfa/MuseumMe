package com.dtd.museumme;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Egor on 28.03.2015.
 */
public class Exhibit implements Parcelable{
    private String TitleExhibit;
    private int ImageExhibit;
    private String Museum;
    private String VideoUrl;
    private String TextExhibit;
    //private Audio;

    public Exhibit() {
    }

    public Exhibit(String titleExhibit, int imageExhibit, String museum, String videoUrl, String textExhibit) {
        TitleExhibit = titleExhibit;
        ImageExhibit = imageExhibit;
        Museum = museum;
        VideoUrl = videoUrl;
        TextExhibit = textExhibit;

    }

    public Exhibit(Parcel in) {
        this.TitleExhibit = in.readString();
        this.ImageExhibit = in.readInt();
        this.Museum = in.readString();
        this.VideoUrl = in.readString();
        this.TextExhibit = in.readString();
    }

    public String getTitleExhibit() {
        return TitleExhibit;
    }

    public void setTitleExhibit(String titleExhibit) {
        TitleExhibit = titleExhibit;
    }

    public int getImageExhibit() {
        return ImageExhibit;
    }

    public void setImageExhibit(int imageExhibit) {
        ImageExhibit = imageExhibit;
    }

    public String getMuseum() {
        return Museum;
    }

    public void setMuseum(String museum) {
        Museum = museum;
    }

    public String getVideoUrl() {
        return VideoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        VideoUrl = videoUrl;
    }

    public String getTextExhibit() {
        return TextExhibit;
    }

    public void setTextExhibit(String textExhibit) {
        TextExhibit = textExhibit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(TitleExhibit);
        parcel.writeInt(ImageExhibit);
        parcel.writeString(Museum);
        parcel.writeString(VideoUrl);
        parcel.writeString(TextExhibit);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Exhibit createFromParcel(Parcel in) {
            return new Exhibit(in);
        }

        @Override
        public Exhibit[] newArray(int size) {
            return new Exhibit[size];
        }
    };
}
