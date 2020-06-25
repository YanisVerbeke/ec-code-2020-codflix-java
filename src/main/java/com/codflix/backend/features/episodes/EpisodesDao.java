package com.codflix.backend.features.episodes;

import com.codflix.backend.core.Database;
import com.codflix.backend.models.Episode;
import com.codflix.backend.models.Media;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class EpisodesDao {

    public List<Episode> getAllEpisodes(int media_id) {
        List<Episode> episodes = new ArrayList<>();

        Connection connection = Database.get().getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM episodes WHERE media_id = " + media_id + " ORDER BY episode_nb ASC");
            while (rs.next()) {
                episodes.add(mapToEpisode(rs));
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }

        return episodes;
    }

    public Episode getEpisodeById(int id) {
        Episode episode = null;

        Connection connection = Database.get().getConnection();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM episodes WHERE id=?");

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                episode = mapToEpisode(rs);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }

        return episode;
    }

    private Episode mapToEpisode(ResultSet rs) throws SQLException, ParseException {
        return new Episode(
                rs.getInt(1), // id
                rs.getInt(2), // episode_nb
                rs.getInt(3), // media_id
                rs.getString(4) // trailer_url
        );
    }
}
