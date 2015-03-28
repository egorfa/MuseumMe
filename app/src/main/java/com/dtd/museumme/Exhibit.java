package com.dtd.museumme;

/**
 * Created by Egor on 28.03.2015.
 */
public class Exhibit {
    private String TitleExhibit;
    private int ImageExhibit;
    private String Museum;
    private String VideoUrl;
    //private Audio;

    public Exhibit() {
    }

    public Exhibit(String titleExhibit, int imageExhibit, String museum, String videoUrl) {
        TitleExhibit = titleExhibit;
        ImageExhibit = imageExhibit;
        Museum = museum;
        VideoUrl = videoUrl;
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
}
