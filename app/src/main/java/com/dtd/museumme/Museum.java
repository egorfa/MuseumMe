package com.dtd.museumme;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Egor on 29.03.2015.
 */
public class Museum implements Parcelable{
    private String Title;
    private String Phone;
    private String Address;
    private int Image;
    private int LogoImage;
    private String Time;
    private String Description;
    private ArrayList<Exhibit> Array;

    public Museum() {
    }

    public Museum(String title, String phone, String address, int image, int logoImage, String time, String description, ArrayList<Exhibit> array) {
        Title = title;
        Phone = phone;
        Address = address;
        Image = image;
        LogoImage = logoImage;
        Time = time;
        Description = description;
        Array = array;
    }

    public Museum(Parcel in) {
        this.Title = in.readString();
        this.Phone = in.readString();
        this.Address = in.readString();
        this.Image = in.readInt();
        this.LogoImage= in.readInt();
        this.Time= in.readString();
        this.Description= in.readString();
        //this.Array = in.
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public int getLogoImage() {
        return LogoImage;
    }

    public void setLogoImage(int logoImage) {
        LogoImage = logoImage;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ArrayList<Exhibit> getArray() {
        return Array;
    }

    public void setArray(ArrayList<Exhibit> array) {
        Array = array;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(Title);
        parcel.writeString(Phone);
        parcel.writeString(Address);
        parcel.writeInt(Image);
        parcel.writeInt(LogoImage);
        parcel.writeString(Time);
        parcel.writeString(Description);
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

