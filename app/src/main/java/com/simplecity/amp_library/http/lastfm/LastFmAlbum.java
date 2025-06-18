package com.simplecity.amp_library.http.lastfm;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class LastFmAlbum implements LastFmResult {

    @SerializedName("album")
    public Album album;

    public static class Album {
        private String name;
        @SerializedName("image")
        private List<LastFmImage> images = new ArrayList<>();
        private Wiki wiki;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public List<LastFmImage> getImages() { return images; }
        public void setImages(List<LastFmImage> images) { this.images = images; }
        public Wiki getWiki() { return wiki; }
        public void setWiki(Wiki wiki) { this.wiki = wiki; }
    }

    @Override
    public String getImageUrl() {
        if (album != null) {
            return LastFmUtils.getBestImageUrl(album.images);
        } else {
            return null;
        }
    }

    public static class Wiki {
        public String summary;
    }
}