package no.nav.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import no.nav.pensjon.regler.domain.beregning2011.BeregningsvilkarPeriode;
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag;
import no.nav.pensjon.regler.domain.grunnlag.Uttaksgrad;
import no.nav.pensjon.regler.domain.kode.KravlinjeTypeCti;
import no.nav.pensjon.regler.domain.kode.RegelverkTypeCti;

/**
 * Dataoverføringsobjekt, inndata, for tjenesten fastsettTrygdetid.
 */
public class TrygdetidRequest extends ServiceRequest {

    private static final long serialVersionUID = -826776149665444842L;
    /**
     * Virkningstidspunktets fom. for ønsket ytelse.
     */
    private Date virkFom;

    /**
     * Tom for trygdetiden som skal beregnes. Kun for AP2011, AP2016 og AP2025.
     */
    private Date virkTom;
    /**
     * Første virkningstidspunkt,denne må være satt dersom personen er SOKER i persongrunnlaget.
     */
    private Date brukerForsteVirk;
    /**
     * Type ytelse (AP,UP osv)
     */
    private KravlinjeTypeCti ytelsesType;
    /**
     * Persongrunnlag for personen.
     * Dersom ytelsesType er UP må uforegrunnlag og uforehistorikk være utfylt.
     */
    private Persongrunnlag persongrunnlag;

    /**
     * Angir om personen har bodd eller arbeidet i utlandet.
     */
    private boolean boddEllerArbeidetIUtlandet;

    /**
     * Regelverktype bestemmer om trygdetid skal regnes etter gamle eller nye regler.
     */
    private RegelverkTypeCti regelverkType;

    private List<Uttaksgrad> uttaksgradListe;

    private Boolean redusertFTTUT;

    /**
     * Liste av beregningsvilkarPerioder, påkrevd ved uføretrygd.
     */
    private List<BeregningsvilkarPeriode> beregningsvilkarPeriodeListe;

    public TrygdetidRequest() {
        super();
        uttaksgradListe = new ArrayList<Uttaksgrad>();
        beregningsvilkarPeriodeListe = new ArrayList<BeregningsvilkarPeriode>();
    }

    public TrygdetidRequest(Date virkFom,
            Date brukerForsteVirk,
            KravlinjeTypeCti ytelsesType,
            Persongrunnlag persongrunnlag,
            boolean boddEllerArbeidetIUtlandet,
            RegelverkTypeCti regelverkType,
            List<Uttaksgrad> uttaksgradListe) {
        super();
        this.virkFom = virkFom;
        this.brukerForsteVirk = brukerForsteVirk;
        this.ytelsesType = ytelsesType;
        this.persongrunnlag = persongrunnlag;
        this.boddEllerArbeidetIUtlandet = boddEllerArbeidetIUtlandet;
        this.regelverkType = regelverkType;
        this.uttaksgradListe = uttaksgradListe;
    }

    public TrygdetidRequest(Date virkFom, Date brukerForsteVirk, KravlinjeTypeCti ytelsesType, Persongrunnlag persongrunnlag, boolean boddEllerArbeidetIUtlandet) {
        super();
        this.virkFom = virkFom;
        this.brukerForsteVirk = brukerForsteVirk;
        this.ytelsesType = ytelsesType;
        this.persongrunnlag = persongrunnlag;
        this.boddEllerArbeidetIUtlandet = boddEllerArbeidetIUtlandet;
    }

    public Persongrunnlag getPersongrunnlag() {
        return persongrunnlag;
    }

    public void setPersongrunnlag(Persongrunnlag persongrunnlag) {
        this.persongrunnlag = persongrunnlag;
    }

    public Date getVirkFom() {
        return virkFom;
    }

    public void setVirkFom(Date virkFom) {
        this.virkFom = virkFom;
    }

    public Date getVirkTom() {
        return virkTom;
    }

    public void setVirkTom(Date virkTom) {
        this.virkTom = virkTom;
    }

    public KravlinjeTypeCti getYtelsesType() {
        return ytelsesType;
    }

    public void setYtelsesType(KravlinjeTypeCti ytelsesType) {
        this.ytelsesType = ytelsesType;
    }

    public Date getBrukerForsteVirk() {
        return brukerForsteVirk;
    }

    public void setBrukerForsteVirk(Date brukerForsteVirk) {
        this.brukerForsteVirk = brukerForsteVirk;
    }

    public boolean isBoddEllerArbeidetIUtlandet() {
        return boddEllerArbeidetIUtlandet;
    }

    public void setBoddEllerArbeidetIUtlandet(boolean boddEllerArbeidetIUtlandet) {
        this.boddEllerArbeidetIUtlandet = boddEllerArbeidetIUtlandet;
    }

    public RegelverkTypeCti getRegelverkType() {
        return regelverkType;
    }

    public void setRegelverkType(RegelverkTypeCti regelverkType) {
        this.regelverkType = regelverkType;
    }

    public List<Uttaksgrad> getUttaksgradListe() {
        return uttaksgradListe;
    }

    public void setUttaksgradListe(List<Uttaksgrad> uttaksgradListe) {
        this.uttaksgradListe = uttaksgradListe;
        sorterUttaksgradListe();
    }

    /**
     * Read only property for uttaksgradListe as array.
     * 
     * @return array of Uttaksgrad
     */
    public Uttaksgrad[] getUttaksgradListeAsArray() {
        return uttaksgradListe != null ? uttaksgradListe.toArray(new Uttaksgrad[uttaksgradListe.size()]) : new Uttaksgrad[0];
    }

    /**
     * Sorterer på nyeste fomDato - denne blir uttaksgradListe.get(0)
     */
    private void sorterUttaksgradListe() {
        Collections.sort(uttaksgradListe, Collections.reverseOrder());
        return;
    }

    public Uttaksgrad[] sortertUttaksgradListe() {
        sorterUttaksgradListe();
        return uttaksgradListe.toArray(new Uttaksgrad[0]);
    }

    /**
     * @return the beregningsvilkarPeriodeListe
     */
    public List<BeregningsvilkarPeriode> getBeregningsvilkarPeriodeListe() {
        return beregningsvilkarPeriodeListe;
    }

    /**
     * @param beregningsvilkarPeriodeListe the beregningsvilkarPeriodeListe to set
     */
    public void setBeregningsvilkarPeriodeListe(List<BeregningsvilkarPeriode> beregningsvilkarPeriodeListe) {
        this.beregningsvilkarPeriodeListe = beregningsvilkarPeriodeListe;
    }

    /**
     * @return the beregningsvilkarPeriodeListe as a array
     */
    public BeregningsvilkarPeriode[] getBeregningsvilkarPeriodeListeAsArray() {
        return !beregningsvilkarPeriodeListe.isEmpty() ? beregningsvilkarPeriodeListe.toArray(new BeregningsvilkarPeriode[beregningsvilkarPeriodeListe.size()])
                : new BeregningsvilkarPeriode[0];
    }

    /**
     * @return beregningsvilkarPeriodeListe som en array sortert kronologisk på fom dato.
     */
    public BeregningsvilkarPeriode[] getSortedBeregningssvilkarPeriodeListeAsArray() {
        if (beregningsvilkarPeriodeListe != null
                && !beregningsvilkarPeriodeListe.isEmpty()) {
            ArrayList<BeregningsvilkarPeriode> sortedBvp = new ArrayList<BeregningsvilkarPeriode>(beregningsvilkarPeriodeListe);
            Collections.sort(sortedBvp);
            return sortedBvp.toArray(new BeregningsvilkarPeriode[sortedBvp.size()]);
        } else {
            return new BeregningsvilkarPeriode[0];
        }
    }

    public Boolean getRedusertFTTUT() {
        return redusertFTTUT;
    }

    public void setRedusertFTTUT(Boolean redusertFTTUT) {
        this.redusertFTTUT = redusertFTTUT;
    }
}
