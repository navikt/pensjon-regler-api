package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.kode.OmsorgTypeCti;

import java.io.Serializable;

public class Omsorgsgrunnlag implements Serializable {
    

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
