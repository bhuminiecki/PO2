package storage;

import entry.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import simulation.Simulation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Pool.
 *
 * @author Wombat
 */
public class Pool implements Serializable {

    private Simulation parent;
    /**
     * Description of the property programs.
     */
    private ArrayList<Entry> entries = new ArrayList<Entry>();

    /**
     * Description of the property favouriteTags.
     */
    private ArrayList<String> favouriteTags = new ArrayList<String>();

    // Start of user code (user defined attributes for Pool)

    // End of user code

    /**
     * The constructor.
     */
    public Pool(Simulation parent) {
        super();
        // Start of user code constructor for Pool)
        this.parent = parent;
        // End of user code
    }


    public void addEntry(Entry entry) {
        entries.add(entry);
    }


    public void removeSeries(int id) {
        // Start of user code for method removeSeries
        // End of user code
    }

    /**
     * Description of the method findMostFitting.
     */
    public void findMostFitting() {
        // Start of user code for method findMostFitting
        // End of user code
    }

    /**
     * Description of the method showStatistics.
     *
     * @param name
     */
    public void showStatistics(String name) {
        // Start of user code for method showStatistics
        // End of user code
    }

    @NotNull
    @Contract(" -> new")
    private static String getRandomString() {
        byte[] array = new byte[8];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

    // Start of user code (user defined methods for Pool)

    // End of user code

    /**
     * Returns programs.
     *
     * @return programs
     */
    public ArrayList<Entry> getEntries() {
        return this.entries;
    }

    /**
     * Returns favouriteTags.
     *
     * @return favouriteTags
     */
    public ArrayList<String> getFavouriteTags() {
        return this.favouriteTags;
    }

    public void genMovie(String title, String genre, BigDecimal price, double rating, int tier, LocalDate date, String desc) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setPrice(price);
        movie.setRatingIMDb(rating);
        movie.setSubscriptionTier(tier);
        movie.setReleaseDate(date);
        movie.setDescription(desc);
        entries.add(movie);
    }

    public void genRandomMovie() {
        String temp = getRandomString();
        while(existsEntry(temp))
        {
            temp = getRandomString();
        }
        genMovie(temp,getRandomString(),new BigDecimal(new Random().nextInt(100)),new Random().nextDouble()*10,new Random().nextInt(4),parent.getCurrentDate(),getRandomString());
    }

    public void genEvent(String title, double lenght, BigDecimal price, LocalDate date ) {
        Event event = new Event();
        event.setTitle(title);
        event.setLength(lenght);
        event.setPrice(price);
        event.setReleaseDate(date);
        entries.add(event);
    }

    public void genRandomEvent() {
        String temp = getRandomString();
        while(existsEntry(temp))
        {
            temp = getRandomString();
        }
        genEvent(temp,new Random().nextDouble()*100,new BigDecimal(new Random().nextInt(100)),parent.getCurrentDate().plusDays(new Random().nextInt(100)));
    }

    public void genSeries(String title, String genre, BigDecimal price, double rating, int tier, LocalDate date, String desc, int episodes) {
        Series series = new Series();
        series.setTitle(title);
        series.setGenre(genre);
        series.setPrice(price);
        series.setRatingIMDb(rating);
        series.setSubscriptionTier(tier);
        series.setReleaseDate(date);
        series.setDescription(desc);
        series.setEpisodes(episodes);
        entries.add(series);
    }

    public void genRandomSeries() {
        String temp = getRandomString();
        while(existsEntry(temp))
        {
            temp = getRandomString();
        }
        genSeries(temp,getRandomString(),new BigDecimal(new Random().nextInt(100)),new Random().nextDouble()*10,new Random().nextInt(4),parent.getCurrentDate(),getRandomString(),new Random().nextInt(30));
    }

    private Episode genEpisode() {
        Episode episode = new Episode();

        return episode;
    }

    public boolean existsEntry(String title) {
        return entries.stream().anyMatch(x -> x.getTitle().equals(title));
    }

    public Entry getRandomEntry() {
        return entries.get(new Random().nextInt(entries.size()));
    }

    public boolean isEmpty() {
        return entries.size()==0;
    }

    public int sizeOf()
    {
        return entries.size();
    }
}
