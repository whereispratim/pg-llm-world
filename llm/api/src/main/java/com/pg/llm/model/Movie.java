package com.pg.llm.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Movie {
    private UUID _id;
    private String plot;
    private List<String> genres;
    private int runtime;
    private List<String> cast;
    private String poster;
    private String title;
    private String fullplot;
    private List<String> languages;
    private Date released;
    private List<String> directors;
    private String rated;
    private Awards awards;
    private String lastupdated;
    private int year;
    private Imdb imdb;
    private List<String> countries;
    private String type;
    private Tomatoes tomatoes;

    public List<Double> getPlot_embedding_ollama() {
        return plot_embedding_ollama;
    }

    public void setPlot_embedding_ollama(List<Double> plot_embedding_ollama) {
        this.plot_embedding_ollama = plot_embedding_ollama;
    }

    private List<Double> plot_embedding_ollama;

    // Getters and Setters

    public UUID getId() {
        return _id;
    }

    public void setId(UUID _id) {
        this._id = _id;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullplot() {
        return fullplot;
    }

    public void setFullplot(String fullplot) {
        this.fullplot = fullplot;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public Awards getAwards() {
        return awards;
    }

    public void setAwards(Awards awards) {
        this.awards = awards;
    }

    public String getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Imdb getImdb() {
        return imdb;
    }

    public void setImdb(Imdb imdb) {
        this.imdb = imdb;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Tomatoes getTomatoes() {
        return tomatoes;
    }

    public void setTomatoes(Tomatoes tomatoes) {
        this.tomatoes = tomatoes;
    }

    // Inner classes for nested objects

    public static class Awards {
        private int wins;
        private int nominations;
        private String text;

        // Getters and Setters

        public int getWins() {
            return wins;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public int getNominations() {
            return nominations;
        }

        public void setNominations(int nominations) {
            this.nominations = nominations;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class Imdb {
        private double rating;
        private int votes;
        private int id;

        // Getters and Setters

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public int getVotes() {
            return votes;
        }

        public void setVotes(int votes) {
            this.votes = votes;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class Tomatoes {
        private Viewer viewer;
        private Critic critic;
        private Date lastUpdated;

        // Getters and Setters

        public Viewer getViewer() {
            return viewer;
        }

        public void setViewer(Viewer viewer) {
            this.viewer = viewer;
        }

        public Critic getCritic() {
            return critic;
        }

        public void setCritic(Critic critic) {
            this.critic = critic;
        }

        public Date getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(Date lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public static class Viewer {
            private int fresh;

            // Getters and Setters

            public int getFresh() {
                return fresh;
            }

            public void setFresh(int fresh) {
                this.fresh = fresh;
            }
        }

        public static class Critic {
            private int rotten;

            // Getters and Setters

            public int getRotten() {
                return rotten;
            }

            public void setRotten(int rotten) {
                this.rotten = rotten;
            }
        }
    }
}
