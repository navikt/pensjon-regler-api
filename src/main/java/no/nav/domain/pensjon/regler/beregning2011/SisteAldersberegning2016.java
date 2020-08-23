package no.nav.domain.pensjon.regler.beregning2011;

/**
 * Siste aldersberegning 2016 som arver SisteAldersberegning2011. Har en pub2025 i tilleg til pub2011.
 */

/**
 * @author Geir Anders Nilsen
 * @author Magnus Bakken (Accenture), PK-20716
 */
public class SisteAldersberegning2016 extends SisteAldersberegning2011 {

    /**
     * Autogenerert serial UID
     */
    private static final long serialVersionUID = 4016601451107889809L;

    /**
     * Pensjon under utbetaling fra beregningsresultatet for AP2011
     */
    private PensjonUnderUtbetaling pensjonUnderUtbetaling2011;

    /**
     * Pensjon under utbetaling fra beregningsresultatet for AP2011, regnet uten gjenlevenderett
     * Feltet brukes ved revurdering av AP2016 når bruker har gjenlevendetillegg.
     */
    private PensjonUnderUtbetaling pensjonUnderUtbetaling2011UtenGJR;

    /**
     * Pensjon under utbetaling fra beregningsresultatet for AP2025
     */
    private PensjonUnderUtbetaling pensjonUnderUtbetaling2025;

    /**
     * Restpensjon regnet uten gjenlevenderettighet.
     * Feltet brukes ved revurdering av AP2016 når bruker har gjenlevendetillegg.
     */
    private Basispensjon restpensjonUtenGJR;

    /**
     * Basispensjon regnet uten gjenlevenderettighet.
     * Feltet brukes ved revurdering av AP2016 når bruker har gjenlevendetillegg.
     */
    private Basispensjon basispensjonUtenGJR;

    /**
     * konstruktører
     */
    public SisteAldersberegning2016() {
        super();
    }

    public SisteAldersberegning2016(SisteAldersberegning2016 sb) {
        super(sb);

        if (sb.pensjonUnderUtbetaling2025 != null) {
            pensjonUnderUtbetaling2025 = new PensjonUnderUtbetaling(sb.pensjonUnderUtbetaling2025);
        }
        if (sb.pensjonUnderUtbetaling2011 != null) {
            pensjonUnderUtbetaling2011 = new PensjonUnderUtbetaling(sb.pensjonUnderUtbetaling2011);
        }
        if (sb.pensjonUnderUtbetaling2011UtenGJR != null) {
            pensjonUnderUtbetaling2011UtenGJR = new PensjonUnderUtbetaling(sb.pensjonUnderUtbetaling2011UtenGJR);
        }
        if (sb.basispensjonUtenGJR != null) {
            basispensjonUtenGJR = new Basispensjon(sb.basispensjonUtenGJR);
        }
        if (sb.restpensjonUtenGJR != null) {
            restpensjonUtenGJR = new Basispensjon(sb.restpensjonUtenGJR);
        }
    }

    public PensjonUnderUtbetaling getPensjonUnderUtbetaling2011UtenGJR() {
        return pensjonUnderUtbetaling2011UtenGJR;
    }

    public void setPensjonUnderUtbetaling2011UtenGJR(PensjonUnderUtbetaling pensjonUnderUtbetaling2011UtenGJR) {
        this.pensjonUnderUtbetaling2011UtenGJR = pensjonUnderUtbetaling2011UtenGJR;
    }

    public Basispensjon getRestpensjonUtenGJR() {
        return restpensjonUtenGJR;
    }

    public void setRestpensjonUtenGJR(Basispensjon restpensjonUtenGJR) {
        this.restpensjonUtenGJR = restpensjonUtenGJR;
    }

    public Basispensjon getBasispensjonUtenGJR() {
        return basispensjonUtenGJR;
    }

    public void setBasispensjonUtenGJR(Basispensjon basispensjonUtenGJR) {
        this.basispensjonUtenGJR = basispensjonUtenGJR;
    }

    /**
     * @return the pensjonUnderUtbetaling2011
     */
    public PensjonUnderUtbetaling getPensjonUnderUtbetaling2011() {
        return pensjonUnderUtbetaling2011;
    }

    /**
     * @param pensjonUnderUtbetaling2011
     *            the pensjonUnderUtbetaling2011 to set
     */
    public void setPensjonUnderUtbetaling2011(PensjonUnderUtbetaling pensjonUnderUtbetaling2011) {
        this.pensjonUnderUtbetaling2011 = pensjonUnderUtbetaling2011;
    }

    /**
     * @return the pensjonUnderUtbetaling2025
     */
    public PensjonUnderUtbetaling getPensjonUnderUtbetaling2025() {
        return pensjonUnderUtbetaling2025;
    }

    /**
     * @param pensjonUnderUtbetaling2025
     *            the pensjonUnderUtbetaling2025 to set
     */
    public void setPensjonUnderUtbetaling2025(PensjonUnderUtbetaling pensjonUnderUtbetaling2025) {
        this.pensjonUnderUtbetaling2025 = pensjonUnderUtbetaling2025;
    }

}
