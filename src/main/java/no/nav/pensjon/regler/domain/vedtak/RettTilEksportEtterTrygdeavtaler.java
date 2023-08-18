package no.nav.pensjon.regler.domain.vedtak;

import no.nav.pensjon.regler.domain.grunnlag.Eksportrett;

/**
 * @author Magnus Bakken (Accenture) PK-9695
 */
public class RettTilEksportEtterTrygdeavtaler extends AbstraktVilkar {

    private static final long serialVersionUID = 1224328629329775826L;
    /**
     * Eksportrett etter EØS forordning
     */
    private Eksportrett eksportrettEtterEOSForordning;

    /**
     * Eksportrett etter trygdeavtaler EØS
     */
    private Eksportrett eksportrettEtterTrygdeavtalerEOS;

    /**
     * Eksportrett etter andre trygdeavtaler.
     */
    private Eksportrett eksportrettEtterAndreTrygdeavtaler;

    public RettTilEksportEtterTrygdeavtaler() {
        super();
    }

    /**
     * Kopikonstruktør
     * @param rettTilEksportEtterTrygdeavtaler
     */
    public RettTilEksportEtterTrygdeavtaler(RettTilEksportEtterTrygdeavtaler rettTilEksportEtterTrygdeavtaler) {
        super(rettTilEksportEtterTrygdeavtaler);
        if (rettTilEksportEtterTrygdeavtaler.eksportrettEtterEOSForordning != null) {
            this.eksportrettEtterEOSForordning = new Eksportrett(rettTilEksportEtterTrygdeavtaler.eksportrettEtterEOSForordning);
        }
        if (rettTilEksportEtterTrygdeavtaler.eksportrettEtterTrygdeavtalerEOS != null) {
            this.eksportrettEtterTrygdeavtalerEOS = new Eksportrett(rettTilEksportEtterTrygdeavtaler.eksportrettEtterTrygdeavtalerEOS);
        }
        if (rettTilEksportEtterTrygdeavtaler.eksportrettEtterAndreTrygdeavtaler != null) {
            this.eksportrettEtterAndreTrygdeavtaler = new Eksportrett(rettTilEksportEtterTrygdeavtaler.eksportrettEtterAndreTrygdeavtaler);
        }
    }

    public RettTilEksportEtterTrygdeavtaler(
            Eksportrett eksportrettEtterEOSForordning,
            Eksportrett eksportrettEtterTrygdeavtalerEOS,
            Eksportrett eksportrettEtterAndreTrygdeavtaler) {
        this.eksportrettEtterEOSForordning = eksportrettEtterEOSForordning;
        this.eksportrettEtterTrygdeavtalerEOS = eksportrettEtterTrygdeavtalerEOS;
        this.eksportrettEtterAndreTrygdeavtaler = eksportrettEtterAndreTrygdeavtaler;
    }

    /**
     * @return Eksportrett etter EØS-forordning
     */
    public Eksportrett getEksportrettEtterEOSForordning() {
        return eksportrettEtterEOSForordning;
    }

    /**
     * @param eksportrettEtterEOSForordning Eksportrett etter EØS-forordning som skal settes.
     */
    public void setEksportrettEtterEOSForordning(Eksportrett eksportrettEtterEOSForordning) {
        this.eksportrettEtterEOSForordning = eksportrettEtterEOSForordning;
    }

    /**
     * @return Eksportrett etter trygdeavtaler EØS.
     */
    public Eksportrett getEksportrettEtterTrygdeavtalerEOS() {
        return eksportrettEtterTrygdeavtalerEOS;
    }

    /**
     * @param eksportrettEtterTrygdeavtalerEOS Eksportrett etter trygdeavtaler EØS som skal settes.
     */
    public void setEksportrettEtterTrygdeavtalerEOS(Eksportrett eksportrettEtterTrygdeavtalerEOS) {
        this.eksportrettEtterTrygdeavtalerEOS = eksportrettEtterTrygdeavtalerEOS;
    }

    /**
     * @return Eksportrett etter andre trygdeavtaler.
     */
    public Eksportrett getEksportrettEtterAndreTrygdeavtaler() {
        return eksportrettEtterAndreTrygdeavtaler;
    }

    /**
     * @param eksportrettEtterAndreTrygdeavtaler Eksportrett etter andre trygdeavtaler som skal settes.
     */
    public void setEksportrettEtterAndreTrygdeavtaler(Eksportrett eksportrettEtterAndreTrygdeavtaler) {
        this.eksportrettEtterAndreTrygdeavtaler = eksportrettEtterAndreTrygdeavtaler;
    }

    /**
     *
     * @param abs RettTilEksportEtterTrygdeavtaler som skal kopieres.
     * @return Kopi av input dersom av klassen RettTilEksportEtterTrygdeavtaler, null ellers.
     */
    @Override
    public AbstraktVilkar dypKopi(AbstraktVilkar abs) {
        RettTilEksportEtterTrygdeavtaler rte = null;
        if(abs.getClass() == RettTilEksportEtterTrygdeavtaler.class) {
            rte = new RettTilEksportEtterTrygdeavtaler((RettTilEksportEtterTrygdeavtaler) abs);
        }
        return rte;
    }
}
