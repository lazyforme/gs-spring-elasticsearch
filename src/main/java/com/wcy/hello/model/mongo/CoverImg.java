package com.wcy.hello.model.mongo;

public class CoverImg {

    private Image image;

    private Thumbnail thumbnail;

    public CoverImg() {
    }

    public CoverImg(Image image, Thumbnail thumbnail) {
        this.image = image;
        this.thumbnail = thumbnail;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }
}
