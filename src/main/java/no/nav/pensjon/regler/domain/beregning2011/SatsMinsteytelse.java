package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.kode.BorMedTypeCti;
import no.nav.pensjon.regler.domain.kode.MinsteytelseNivaCti;

import java.io.Serializable;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class SatsMinsteytelse implements Serializable {
    private static final long serialVersionUID = -2886963703574975687L;

    @GuiPrompt(prompt = "Sats")
    private double sats;

    @GuiPrompt(prompt = "Satstype")
    private MinsteytelseNivaCti satsType;

    @GuiPrompt(prompt = "Benyttet sivilstand")
    private BorMedTypeCti benyttetSivilstand;

    @GuiPrompt(prompt = "Benyttet ung ufør")
    private boolean benyttetUngUfor;

    @GuiPrompt(prompt = "Oppfylt ung ufør")
    private boolean oppfyltUngUfor;

    /**
     * Angir om ung uføregaranti ikke er benyttet pga eksportforbud.
     */
    @GuiPrompt(prompt = "Eksportforbud ung ufør")
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
