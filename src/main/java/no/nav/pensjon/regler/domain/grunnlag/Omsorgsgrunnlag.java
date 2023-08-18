package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.PenPerson;
import no.nav.pensjon.regler.domain.kode.OmsorgTypeCti;

import java.io.Serializable;

public class Omsorgsgrunnlag implements Serializable {
    private static final long serialVersionUID = 463721142507622210L;

    private int ar;
    private OmsorgTypeCti omsorgType;
    private PenPerson personOmsorgFor;
    private boolean bruk;

    public Omsorgsgrunnlag() {
        super();
    }

    public Omsorgsgrunnlag(Omsorgsgrunnlag og) {
        this();
        ar = og.ar;
        if (og.omsorgType != null) {
            omsorgType = new OmsorgTypeCti(og.omsorgType);
        }
        if (og.personOmsorgFor != null) {
            personOmsorgFor = new PenPerson(og.personOmsorgFor);
        }
        bruk = og.bruk;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public OmsorgTypeCti getOmsorgType() {
        return omsorgType;
    }

    public void setOmsorgType(OmsorgTypeCti omsorgType) {
        this.omsorgType = omsorgType;
    }

    public PenPerson getPersonOmsorgFor() {
        return personOmsorgFor;
    }

    public void setPersonOmsorgFor(PenPerson personOmsorgFor) {
        this.personOmsorgFor = personOmsorgFor;
    }

    public boolean isBruk() {
        return bruk;
    }

    public void setBruk(boolean bruk) {
        this.bruk = bruk;
    }

}
