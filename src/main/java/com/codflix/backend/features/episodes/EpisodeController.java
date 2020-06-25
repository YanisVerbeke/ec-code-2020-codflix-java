package com.codflix.backend.features.episodes;

import com.codflix.backend.core.Template;
import com.codflix.backend.features.media.MediaDao;
import com.codflix.backend.models.Episode;
import com.codflix.backend.models.Media;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpisodeController {
    private final EpisodesDao episodesDao = new EpisodesDao();

    public String detail(Request request, Response res) {
        List<Episode> episodes;

        int id = Integer.parseInt(request.params(":id"));
        Episode episode = episodesDao.getEpisodeById(id);

        Map<String, Object> model = new HashMap<>();
        model.put("episode", episode);
        return Template.render("episode_detail.html", model);
    }
}
