package com.codflix.backend.models;

public class Episode {
    private int id;
    private int episode_nb;
    private int media_id;
    private String trailer_url;

    public Episode(int id, int episode_nb, int media_id, String trailer_url) {
        this.id = id;
        this.episode_nb = episode_nb;
        this.media_id = media_id;
        this.trailer_url = trailer_url;
    }

    public int getId() {
        return id;
    }

    public int getEpisode_nb() {
        return episode_nb;
    }

    public int getMedia_id() {
        return media_id;
    }

    public String getTrailer_url() {
        return trailer_url;
    }
}
