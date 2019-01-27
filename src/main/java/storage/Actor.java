package storage;

// Start of user code (user defined imports)

// End of user code

import java.io.Serializable;

/**
 * Actor class represents an actor / actress.
 *
 * @author Wombat
 */
public class Actor implements Serializable {
    /**
     * Name of the actor.
     */
    private String name;

    /**
     * Surname of the actor.
     */
    private String surname;

    /**
     * Description of the property age.
     */
    private int age;

    // Start of user code (user defined attributes for Actor)

    // End of user code

    /**
     * The constructor.
     */
    public Actor(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    // Start of user code (user defined methods for Actor)

    // End of user code

    /**
     * Returns name.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns surname.
     *
     * @return surname
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Returns age.
     *
     * @return age
     */
    public int getAge() {
        return this.age;
    }

}
