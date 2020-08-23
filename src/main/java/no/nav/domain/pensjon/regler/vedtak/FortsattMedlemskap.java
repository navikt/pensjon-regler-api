package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.grunnlag.Eksportforbud;
import no.nav.domain.pensjon.regler.grunnlag.Unntak;

/**
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063
 * @author Steinar Hjellvik Decisive,  PK-6559
 */
public class FortsattMedlemskap extends AbstraktVilkar {

    private static final long serialVersionUID = -8952373630724401467L;
    /**
     * Fortsatt medlem i folketrygden
     */
    private Boolean fortsattMedlemFT;

    /**
     * Brukeren har minst 20 års botid i Norge
     */
    private Boolean minstTyveArBotidNorge;

    /**
     * Opptjent rett til tilleggspensjon etter folketrygdloven
     */
    private Boolean opptjentRettTilTPEtterFT;

    /**
     * Eksportforbud
     */
    private Eksportforbud eksportforbud;

    /**
     * Fri eksport fordi uførhet skyldes yrkesskade
     */
    private Boolean friEksportPgaYrkesskade;

    /**
     * Innvilget garantert tilleggspensjon til ung ufør/død skal eksporteres
     */
    private Boolean innvilgetGarantertTP;

    /**
     * Eksportrett garantert TP
     */
    private Unntak eksportrettGarantertTP;

    public FortsattMedlemskap() {
        super();
    }

    public FortsattMedlemskap(FortsattMedlemskap aFortsattMedlemskap) {
        super(aFortsattMedlemskap);
        if (aFortsattMedlemskap.fortsattMedlemFT != null){
            fortsattMedlemFT = new Boolean(aFortsattMedlemskap.fortsattMedlemFT);
        }
        if (aFortsattMedlemskap.minstTyveArBotidNorge != null){
            minstTyveArBotidNorge = new Boolean(aFortsattMedlemskap.minstTyveArBotidNorge);
        }
        if (aFortsattMedlemskap.opptjentRettTilTPEtterFT != null){
            opptjentRettTilTPEtterFT = new Boolean(aFortsattMedlemskap.opptjentRettTilTPEtterFT);
        }
        if (aFortsattMedlemskap.eksportforbud != null){
            eksportforbud = new Eksportforbud(aFortsattMedlemskap.eksportforbud);
        }
        if (aFortsattMedlemskap.friEksportPgaYrkesskade != null){
            friEksportPgaYrkesskade = new Boolean(aFortsattMedlemskap.friEksportPgaYrkesskade);
        }
        if (aFortsattMedlemskap.innvilgetGarantertTP != null){
            innvilgetGarantertTP = new Boolean(aFortsattMedlemskap.innvilgetGarantertTP);
        }
        if (aFortsattMedlemskap.eksportrettGarantertTP != null){
            eksportrettGarantertTP = new Unntak(aFortsattMedlemskap.eksportrettGarantertTP);
        }
    }

    public Boolean getFortsattMedlemFT() {
        return fortsattMedlemFT;
    }

    public void setFortsattMedlemFT(Boolean fortsattMedlemFT) {
        this.fortsattMedlemFT = fortsattMedlemFT;
    }

    public Boolean getMinstTyveArBotidNorge() {
        return minstTyveArBotidNorge;
    }

    public void setMinstTyveArBotidNorge(Boolean minstTyveArBotidNorge) {
        this.minstTyveArBotidNorge = minstTyveArBotidNorge;
    }

    public Boolean getOpptjentRettTilTPEtterFT() {
        return opptjentRettTilTPEtterFT;
    }

    public void setOpptjentRettTilTPEtterFT(Boolean opptjentRettTilTPEtterFT) {
        this.opptjentRettTilTPEtterFT = opptjentRettTilTPEtterFT;
    }

    public Eksportforbud getEksportforbud() {
        return eksportforbud;
    }

    public void setEksportforbud(Eksportforbud eksportforbud) {
        this.eksportforbud = eksportforbud;
    }

    public Boolean getFriEksportPgaYrkesskade() {
        return friEksportPgaYrkesskade;
    }

    public void setFriEksportPgaYrkesskade(Boolean friEksportPgaYrkesskade) {
        this.friEksportPgaYrkesskade = friEksportPgaYrkesskade;
    }

    public Boolean getInnvilgetGarantertTP() {
        return innvilgetGarantertTP;
    }

    public void setInnvilgetGarantertTP(Boolean innvilgetGarantertTP) {
        this.innvilgetGarantertTP = innvilgetGarantertTP;
    }

    public Unntak getEksportrettGarantertTP() {
        return eksportrettGarantertTP;
    }

    public void setEksportrettGarantertTP(Unntak eksportrettGarantertTP) {
        this.eksportrettGarantertTP = eksportrettGarantertTP;
    }

    public AbstraktVilkar dypKopi(AbstraktVilkar abs) {
        FortsattMedlemskap fm = null;
        if(abs.getClass() == FortsattMedlemskap.class) {
            fm = new FortsattMedlemskap((FortsattMedlemskap) abs);
        }
        return fm;
    }
}
