package no.nav.pensjon.regler.domain;

import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;

/**
 * @author PREG
 */
public class PenPerson implements Serializable {

    private static final long serialVersionUID = -4707791087086725544L;

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

    /**
     * @param penPersonId
     */
    public PenPerson(long penPersonId) {
        super();
        this.penPersonId = penPersonId;
    }

    public long getPenPersonId() {
        return penPersonId;
    }

    public void setPenPersonId(long penPersonId) {
        this.penPersonId = penPersonId;
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
