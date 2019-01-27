package entry;

import account.User;
import storage.Actor;

import java.util.ArrayList;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Series.
 *
 * @author Wombat
 */
public class Series extends Entry {
    /**
     * Description of the property genre.
     */
    private String genre;

    /**
     * Description of the property subscriptionTier.
     */
    private int subscriptionTier;

    private int episodeNumber;

    /**
     * Description of the property episodes.
     */
    private ArrayList<Episode> episodes = new ArrayList<Episode>();

    /**
     * Description of the property actors.
     */
    private ArrayList<Actor> actors = new ArrayList<Actor>();

    // Start of user code (user defined attributes for Series)

    // End of user code

    /**
     * The constructor.
     */
    public Series() {
        // Start of user code constructor for Series)
        super();
        // End of user code
    }

    /**
     * Description of the method showFitness.
     */
    public void showFitness() {
        // Start of user code for method showFitness
        // End of user code
    }

    // Start of user code (user defined methods for Series)

    // End of user code

    /**
     * Returns genre.
     *
     * @return genre
     */
    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Returns subscriptionTier.
     *
     * @return subscriptionTier
     */
    public int getSubscriptionTier() {
        return this.subscriptionTier;
    }

    public void setSubscriptionTier(int subscriptionTier) {
        this.subscriptionTier = subscriptionTier;
    }

    /**
     * Returns episodes.
     *
     * @return episodes
     */
    public ArrayList<Episode> getEpisodes() {
        return this.episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodeNumber = episodes;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }

    /**
     * Returns actors.
     *
     * @return actors
     */
    public ArrayList<Actor> getActors() {
        return this.actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public boolean canWatchTier(User user) {
        if (user.getSubscriptionTier() >= subscriptionTier) {
            return true;
        }
        return false;
    }
}
