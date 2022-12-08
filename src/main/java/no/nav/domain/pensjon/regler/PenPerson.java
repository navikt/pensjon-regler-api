package no.nav.domain.pensjon.regler;


import java.io.Serializable;

/**
 * @author PREG
 */
public class PenPerson implements Serializable {



    /**
     * Unik id for personen.
     */
    private long penPersonId;

    /**
     * Copy Constructor
     * 
     * @param penPerson a <code>PenPerson</code> object
     */
    public PenPerson(PenPerson penPerson) {
        penPersonId = penPerson.penPersonId;
    }

    public PenPerson() {
        super();
    }

}
