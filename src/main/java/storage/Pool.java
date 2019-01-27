package storage;

import entry.Entry;

import java.io.Serializable;
import java.util.ArrayList;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Pool.
 *
 * @author Wombat
 */
public class Pool implements Serializable {
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
    public Pool() {
        // Start of user code constructor for Pool)
        super();
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

}
