package account;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Account.
 *
 * @author Wombat
 */
public class Account {
    /**
     * Description of the property username.
     */
    private String username;

    /**
     * Description of the property passwordHash.
     */
    private String passwordHash;

    /**
     * Description of the property email.
     */
    private String email;

    /**
     * Description of the property id.
     */
    private int id;

    // Start of user code (user defined attributes for Account)

    // End of user code

    /**
     * The constructor.
     */
    public Account() {
        // Start of user code constructor for Account)
        super();
        // End of user code
    }

    /**
     * Returns username.
     *
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets a value to attribute username.
     *
     * @param newUsername
     */
    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    /**
     * Returns passwordHash.
     *
     * @return passwordHash
     */
    public String getPasswordHash() {
        return this.passwordHash;
    }

    /**
     * Returns email.
     *
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets a value to attribute email.
     *
     * @param newEmail
     */
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    /**
     * Returns id.
     *
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets a value to attribute id.
     *
     * @param newId
     */
    public void setId(int newId) {
        this.id = newId;
    }


}
