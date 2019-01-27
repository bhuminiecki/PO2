package entry;

public class Generator {

    public Movie genMovie() {
        Movie movie = new Movie();

        return movie;
    }

    public Movie genRandomMovie() {
        return genMovie();
    }

    public Event genEvent() {
        Event event = new Event();

        return event;
    }

    public Event genRandomEvent() {
        return genEvent();
    }

    public Series genSeries() {
        Series series = new Series();

        return series;
    }

    public Series genRandomSeries() {
        return genSeries();
    }

    private Episode genEpisode() {
        Episode episode = new Episode();

        return episode;
    }
}
