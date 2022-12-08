package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.BorMedTypeCti;
import no.nav.domain.pensjon.regler.kode.MinsteytelseNivaCti;

import java.io.Serializable;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class SatsMinsteytelse implements Serializable {


    private double sats;

    private MinsteytelseNivaCti satsType;

    private BorMedTypeCti benyttetSivilstand;

    private boolean benyttetUngUfor;

    private boolean oppfyltUngUfor;

    /**
     * Angir om ung uføregaranti ikke er benyttet pga eksportforbud.
     */
    private boolean eksportForbudUngUfor;

    public SatsMinsteytelse() {
        super();
    }

    public SatsMinsteytelse(SatsMinsteytelse satsMinsteytelse) {
        super();
        sats = satsMinsteytelse.sats;
        if (satsMinsteytelse.satsType != null) {
            satsType = new MinsteytelseNivaCti(satsMinsteytelse.satsType);
        }
        if (satsMinsteytelse.benyttetSivilstand != null) {
            benyttetSivilstand = new BorMedTypeCti(satsMinsteytelse.benyttetSivilstand);
        }
        benyttetUngUfor = satsMinsteytelse.benyttetUngUfor;
        oppfyltUngUfor = satsMinsteytelse.oppfyltUngUfor;
        eksportForbudUngUfor = satsMinsteytelse.eksportForbudUngUfor;
    }

    public double getSats() {
        return sats;
    }

    public void setSats(double sats) {
        this.sats = sats;
    }

    public MinsteytelseNivaCti getSatsType() {
        return satsType;
    }

    public void setSatsType(MinsteytelseNivaCti satsType) {
        this.satsType = satsType;
    }

    public BorMedTypeCti getBenyttetSivilstand() {
        return benyttetSivilstand;
    }

    public void setBenyttetSivilstand(BorMedTypeCti benyttetSivilstand) {
        this.benyttetSivilstand = benyttetSivilstand;
    }

    public boolean isBenyttetUngUfor() {
        return benyttetUngUfor;
    }

    public void setBenyttetUngUfor(boolean benyttetUngUfor) {
        this.benyttetUngUfor = benyttetUngUfor;
    }

    public boolean isOppfyltUngUfor() {
        return oppfyltUngUfor;
    }

    public void setOppfyltUngUfor(boolean oppfyltUngUfor) {
        this.oppfyltUngUfor = oppfyltUngUfor;
    }

    public boolean isEksportForbudUngUfor() {
        return eksportForbudUngUfor;
    }

    public void setEksportForbudUngUfor(boolean eksportForbudUngUfor) {
        this.eksportForbudUngUfor = eksportForbudUngUfor;
    }
}
