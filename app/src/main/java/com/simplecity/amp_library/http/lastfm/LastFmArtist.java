package com.simplecity.amp_library.http.lastfm;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class LastFmArtist implements LastFmResult {

    @SerializedName("artist")
    public Artist artist;

    public static class Artist {
        private String name;
        @SerializedName("image")
        private List<LastFmImage> images = new ArrayList<>();
        private Bio bio;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public List<LastFmImage> getImages() { return images; }
        public void setImages(List<LastFmImage> images) { this.images = images; }
        public Bio getBio() { return bio; }
        public void setBio(Bio bio) { this.bio = bio; }
    }

    @Override
    public String getImageUrl() {
        if (artist == null || artist.images == null || artist.images.isEmpty()) {
            return null;
        }
        return LastFmUtils.getBestImageUrl(artist.images);
    }

    public static class Bio {
        public String summary;
    }
}