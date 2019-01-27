package entry;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import account.User;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Entry.
 *
 * @author Wombat
 */
public abstract class Entry implements Serializable {

    private String title;
    /**
     * Description of the property ratingIMDb.
     */
    private double ratingIMDb;

    /**
     * Description of the property description.
     */
    private String description = null;

    /**
     * Description of the property discount.
     */
    private BigDecimal discount = new BigDecimal(0);

    /**
     * Description of the property releaseDate.
     */
    private LocalDate releaseDate = null;

    /**
     * Description of the property length.
     */
    private double length;

    /**
     * Description of the property price.
     */
    private BigDecimal price = null;

    // Start of user code (user defined attributes for Entry)

    // End of user code

    /**
     * The constructor.
     */
    public Entry() {
        // Start of user code constructor for Entry)
        super();
        // End of user code
    }

    /**
     * Description of the method showStatistics.
     */
    public void showStatistics() {
        // Start of user code for method showStatistics
        // End of user code
    }

    /**
     * Description of the method showFitness.
     */
    public void showFitness() {
        // Start of user code for method showFitness
        // End of user code
    }

    /**
     * Description of the method genGraph.
     */
    public void genGraph() {
        // Start of user code for method genGraph
        // End of user code
    }

    // Start of user code (user defined methods for Entry)

    // End of user code

    /**
     * Returns ratingIMDb.
     *
     * @return ratingIMDb
     */
    public double getRatingIMDb() {
        return this.ratingIMDb;
    }

    /**
     * Returns description.
     *
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns releaseDate.
     *
     * @return releaseDate
     */
    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    /**
     * Returns length.
     *
     * @return length
     */
    public double getLength() {
        return this.length;
    }

    /**
     * Returns price.
     *
     * @return price
     */
    public BigDecimal getPrice() { return this.price.multiply(new BigDecimal(1).subtract(discount)); }

    /**
     * Returns discount.
     *
     * @return discount
     */
    public BigDecimal getDiscount() {
        return this.discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public boolean canWatchTier(User user) {
        return false;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRatingIMDb(double ratingIMDb) {
        this.ratingIMDb = ratingIMDb;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String toString()
    {
        return title+"- cena:"+price;
    }

    public String getTitle() {
        return title;
    }
}
