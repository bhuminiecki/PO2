package entry;

import account.User;
import storage.Actor;

import java.util.ArrayList;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Movie.
 *
 * @author Wombat
 */
public class Movie extends Entry {
    /**
     * Description of the property genre.
     */
    private String genre;

    /**
     * Description of the property subscriptionTier.
     */
    private int subscriptionTier;

    /**
     * Description of the property actors.
     */
    private ArrayList<Actor> actors = new ArrayList<Actor>();

    // Start of user code (user defined attributes for Movie)

    // End of user code

    /**
     * The constructor.
     */
    public Movie() {
        // Start of user code constructor for Movie)
        super();
        // End of user code
    }

    // Start of user code (user defined methods for Movie)

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
