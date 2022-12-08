package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.PenPerson;

import java.io.Serializable;
import java.util.Date;

public class BarnDetalj implements Serializable {

    
    /**
     * Angir barnets andre forelder enn søker.
     */
    private PenPerson annenForelder;
    /**
     * Angir om barnet bor med en begge foreldre.
     * "true" betyr fellesbarn, "false" betyr særkullsbarn.
     */
    private boolean borMedBeggeForeldre;
    /**
     * Fra-og-med dato for når barnet bor sammen med begge foreldrene.
     */
    private Date borFomDato;
    /**
     * Til-og-med dato for når barnet bor sammen med begge foreldrene.
     */
    private Date borTomDato;

    /**
     * Angir om barnet har hatt inntekt over 1G.
     */
    private boolean inntektOver1G;
    /**
     * Angir hvorvidt barnet er under utdanning.
     */
    private boolean underUtdanning;

    /**
     * Copy Constructor
     * 
     * @param barnDetalj a <code>BarnDetalj</code> object
     */
    public BarnDetalj(BarnDetalj barnDetalj) {
        if (barnDetalj.annenForelder != null) {
            annenForelder = new PenPerson(barnDetalj.annenForelder);
        }
        borMedBeggeForeldre = barnDetalj.borMedBeggeForeldre;
        if (barnDetalj.borFomDato != null) {
            borFomDato = (Date) barnDetalj.borFomDato.clone();
        }
        if (barnDetalj.borTomDato != null) {
            borTomDato = (Date) barnDetalj.borTomDato.clone();
        }
        inntektOver1G = barnDetalj.inntektOver1G;
        underUtdanning = barnDetalj.underUtdanning;
    }

    public BarnDetalj(PenPerson annenForelder, boolean borMedBeggeForeldre, Date borFomDato, Date borTomDato, boolean inntektOver1G, boolean underUtdanning) {
        super();
        this.annenForelder = annenForelder;
        this.borMedBeggeForeldre = borMedBeggeForeldre;
        this.borFomDato = borFomDato;
        this.borTomDato = borTomDato;
        this.inntektOver1G = inntektOver1G;
        this.underUtdanning = underUtdanning;
    }

    public BarnDetalj() {
        super();
    }

    public boolean isBorMedBeggeForeldre() {
        return borMedBeggeForeldre;
    }

    public void setBorMedBeggeForeldre(boolean borMedBeggeForeldre) {
        this.borMedBeggeForeldre = borMedBeggeForeldre;
    }

    public PenPerson getAnnenForelder() {
        return annenForelder;
    }

    public void setAnnenForelder(PenPerson annenForelder) {
        this.annenForelder = annenForelder;
    }

    public Date getBorFomDato() {
        return borFomDato;
    }

    public void setBorFomDato(Date borFomDato) {
        this.borFomDato = borFomDato;
    }

    public Date getBorTomDato() {
        return borTomDato;
    }

    public void setBorTomDato(Date borTomDato) {
        this.borTomDato = borTomDato;
    }

    public boolean isInntektOver1G() {
        return inntektOver1G;
    }

    public void setInntektOver1G(boolean inntektOver1G) {
        this.inntektOver1G = inntektOver1G;
    }

    public boolean isUnderUtdanning() {
        return underUtdanning;
    }

    public void setUnderUtdanning(boolean underUtdanning) {
        this.underUtdanning = underUtdanning;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     * 
     * @return a <code>String</code> representation
     *         of this object.
     */
    @Override
    public String toString() {
        final String TAB = "    ";

        StringBuilder retValue = new StringBuilder();

        retValue.append("BarnDetalj ( ").append(super.toString()).append(TAB).append("annenForelder = ").append(annenForelder).append(TAB).append("borMedBeggeForeldre = ")
                .append(borMedBeggeForeldre).append(TAB).append("borFomDato = ").append(borFomDato).append(TAB).append("borTomDato = ").append(borTomDato).append(TAB)
                .append("inntektOver1G = ").append(inntektOver1G).append(TAB).append("underUtdanning = ").append(underUtdanning).append(TAB).append(" )");

        return retValue.toString();
    }

}
