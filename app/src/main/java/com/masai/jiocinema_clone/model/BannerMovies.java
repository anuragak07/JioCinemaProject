package com.masai.jiocinema_clone.model;

public class BannerMovies {
    private Integer id;
    private String movieName;
    private String imageUrl;
    private String fileUrl;

    public BannerMovies(Integer id, String movieName, String imageUrl, String fileUrl) {
        this.id = id;
        this.movieName = movieName;
        this.imageUrl = imageUrl;
        this.fileUrl = fileUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }
}
