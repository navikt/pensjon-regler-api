package no.nav.pensjon.regler.domain.vedtak;

import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.PenPerson;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsvilkarPeriode;
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag;
import no.nav.pensjon.regler.domain.kode.BegrunnelseTypeCti;
import no.nav.pensjon.regler.domain.kode.KravlinjeTypeCti;
import no.nav.pensjon.regler.domain.kode.VilkarVurderingCti;
import no.nav.pensjon.regler.domain.kode.VilkarsvedtakResultatCti;
import no.nav.pensjon.regler.domain.krav.Kravlinje;
import no.nav.pensjon.regler.domain.util.DateCompareUtil;
import no.nav.pensjon.regler.domain.util.DateUtil;
import no.nav.pensjon.regler.domain.util.ListUtil;
import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.util.*;

/**
 * @author Magnus Bakken (Accenture) PK-10597, PK-9695, PKPYTON-923
 * @author Swiddy de Louw (Capgemini), PK-8704,PKPYTON-563
 */

public class VilkarsVedtak implements java.io.Serializable, Comparable<VilkarsVedtak> {

    private static final long serialVersionUID = -1337190529917317453L;

    /**
     * Kode som angir hvilket resultat PREG setter på vilkårsvedtaket. Se
     * K_VILKAR_RESUL_T for gyldige typer. Kun satt hvis PREG utfører
     * vilkårsprøving.
     */
    private VilkarsvedtakResultatCti anbefaltResultat;

    /**
     * Kode som angir det resultatet til vilkårsvedtaket. Settes av konsumenten
     * av tjenesten, eventuelt basert på anbefaltResultat. Se K_VILKAR_RESUL_T
     * for gyldige typer.
     */
    private VilkarsvedtakResultatCti vilkarsvedtakResultat;

    /**
     * Kode som angir hvilken type kravlinje vilkårsvedtaket relaterer seg til.
     * K_KRAVLINJE_T for gyldige typer.
     */
    private KravlinjeTypeCti kravlinjeType;

    /**
     * Beskriver hvilken vurdering saksbehandler har lagt til grunn for
     * resultatvurderingen. Se K_VILKAR_VURD_T.
     */
    private VilkarVurderingCti anvendtVurdering;

    /**
     * Dato vilkårsvedtaket har virkning fra.
     */
    private Date virkFom;

    /**
     * Dato vilkårsvedtaket har virkning til. Denne skal ikke være satt, og det
     * betyr at vedtaket har uendelig gyldighet. Skulle den likevel være satt
     * vil PREG sjekke at virken på ytelsen det beregnes for er nnnnenfor
     * virkFom-virkTom. Er den utenfor blir vedtaket behandlet som ikke gyldig.
     */
    private Date virkTom;

    /**
     * Dato første innvilgede vilkårsvedtak personen har fått fra trygden.
     * Eks: har personen tidligere hatt UP og får nå AP vil det være datoen for første UP-vedtaket.
     */
    private Date forsteVirk;

    /**
     * Dato dette vilkårsvedtakets kravlinje først ble innvilget.
     * Eks: personen fikk innvilget gjenlevenderett fom dette virkningstidspunkt.
     */
    private Date kravlinjeForsteVirk;

    /**
     * Kravlinje som er vilkårsprøvd.
     */
    private Kravlinje kravlinje;

    /**
     * Id for personen
     */
    private PenPerson penPerson;

    private AbstraktVilkarsprovResultat vilkarsprovresultat;

    private BegrunnelseTypeCti begrunnelse;
    private boolean avslattKapittel19;
    private boolean avslattGarantipensjon;
    private Persongrunnlag PREG_persongrunnlag;
    private boolean vurderSkattefritakET;
    // CR170026
    private boolean unntakHalvMinstepensjon;
    private boolean epsAvkallEgenPensjon;
    private boolean epsRettEgenPensjon;

    /**
     * List av Beregningsvilkarperioder
     */
    private List<BeregningsvilkarPeriode> beregningsvilkarPeriodeListe;

    /**
     * Liste av merknader - forklaringer,unntak og avvisningsgrunner fra
     * regelmotoren.
     */
    private List<Merknad> merknadListe;

    /**
     * Copy Constructor
     * 
     * @param v a <code>VilkarsVedtak</code> object
     */
    public VilkarsVedtak(VilkarsVedtak v) {
        if (v.anbefaltResultat != null) {
            anbefaltResultat = new VilkarsvedtakResultatCti(v.anbefaltResultat);
        }
        if (v.vilkarsvedtakResultat != null) {
            vilkarsvedtakResultat = new VilkarsvedtakResultatCti(v.vilkarsvedtakResultat);
        }
        if (v.kravlinjeType != null) {
            kravlinjeType = new KravlinjeTypeCti(v.kravlinjeType);
        }
        if (v.anvendtVurdering != null) {
            anvendtVurdering = new VilkarVurderingCti(v.anvendtVurdering);
        }
        if (v.virkFom != null) {
            virkFom = (Date) v.virkFom.clone();
        }
        if (v.virkTom != null) {
            virkTom = (Date) v.virkTom.clone();
        }
        if (v.forsteVirk != null) {
            forsteVirk = (Date) v.forsteVirk.clone();
        }
        if (v.kravlinjeForsteVirk != null) {
            kravlinjeForsteVirk = (Date) v.kravlinjeForsteVirk.clone();
        }
        if (v.kravlinje != null) {
            kravlinje = new Kravlinje(v.kravlinje);
        }
        if (v.penPerson != null) {
            penPerson = new PenPerson(v.penPerson);
        }
        if (v.begrunnelse != null) {
            begrunnelse = v.begrunnelse;
        }
        if (v.vilkarsprovresultat != null) {
            if (v.vilkarsprovresultat instanceof VilkarsprovAlderspensjonResultat) {
                vilkarsprovresultat = new VilkarsprovAlderspensjonResultat((VilkarsprovAlderspensjonResultat) v.vilkarsprovresultat);
            } else if (v.vilkarsprovresultat instanceof VilkarsprovAlderspensjon67Resultat) {
                vilkarsprovresultat = new VilkarsprovAlderspensjon67Resultat((VilkarsprovAlderspensjon67Resultat) v.vilkarsprovresultat);
            }
        }
        avslattKapittel19 = v.avslattKapittel19;
        avslattGarantipensjon = v.avslattGarantipensjon;
        vurderSkattefritakET = v.vurderSkattefritakET;
        unntakHalvMinstepensjon = v.unntakHalvMinstepensjon;
        epsAvkallEgenPensjon = v.epsAvkallEgenPensjon;

        // Kopierer ikke denne for å unngå Stackoverflow exception!
        //		if (vilkarsVedtak.PREG_persongrunnlag != null) {
        //			this.PREG_persongrunnlag = new Persongrunnlag(vilkarsVedtak.PREG_persongrunnlag);
        //		}	
        merknadListe = new ArrayList<Merknad>();
        if (v.merknadListe != null) {
            for (Merknad merknad : v.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }

        beregningsvilkarPeriodeListe = new ArrayList<BeregningsvilkarPeriode>();
        if (v.beregningsvilkarPeriodeListe != null) {
            for (BeregningsvilkarPeriode bvp : v.beregningsvilkarPeriodeListe) {
                beregningsvilkarPeriodeListe.add(new BeregningsvilkarPeriode(bvp));
            }
        }
    }

    public VilkarsVedtak(VilkarsvedtakResultatCti anbefaltResultat, VilkarsvedtakResultatCti vilkarsvedtakResultat, KravlinjeTypeCti kravlinjeType,
                         VilkarVurderingCti anvendtVurdering, Date virkFom, Date virkTom, Date forsteVirk, Kravlinje kravlinje, PenPerson penPerson,
                         VilkarsprovAlderspensjonResultat vilkarsprovresultat, BegrunnelseTypeCti begrunnelse, boolean avslattKapittel19, boolean epsAvkallEgenPensjon,
                         List<Merknad> merknadListe, boolean epsRettEgenPensjon) {
        this();
        this.anbefaltResultat = anbefaltResultat;
        this.vilkarsvedtakResultat = vilkarsvedtakResultat;
        this.kravlinjeType = kravlinjeType;
        this.anvendtVurdering = anvendtVurdering;
        this.virkFom = virkFom;
        this.virkTom = virkTom;
        this.forsteVirk = forsteVirk;
        this.kravlinje = kravlinje;
        this.penPerson = penPerson;
        this.vilkarsprovresultat = vilkarsprovresultat;
        this.begrunnelse = begrunnelse;
        this.avslattKapittel19 = avslattKapittel19;
        this.epsAvkallEgenPensjon = epsAvkallEgenPensjon;
        this.epsRettEgenPensjon = epsRettEgenPensjon;
        this.merknadListe = merknadListe;
    }

    public VilkarsVedtak() {
        super();
        merknadListe = new ArrayList<Merknad>();
        beregningsvilkarPeriodeListe = new ArrayList<BeregningsvilkarPeriode>();
    }

    /**
     * @deprecated
     * @return Returns the merknad as array.
     */
    @Deprecated
    public Merknad[] retrieveMerknadListeAsArray() {
        return merknadListe.toArray(new Merknad[merknadListe.size()]);
    }

    /**
     * Read only property for merknadListe as array.
     * 
     * @return array of Merknad
     */
    public Merknad[] getMerknadListeAsArray() {
        return merknadListe != null ? merknadListe.toArray(new Merknad[merknadListe.size()]) : new Merknad[0];
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

    public VilkarsvedtakResultatCti getAnbefaltResultat() {
        return anbefaltResultat;
    }

    public void setAnbefaltResultat(VilkarsvedtakResultatCti anbefaltResultat) {
        this.anbefaltResultat = anbefaltResultat;
    }

    public Date getForsteVirk() {
        return forsteVirk;
    }

    public void setForsteVirk(Date forsteVirk) {
        this.forsteVirk = forsteVirk;
    }

    public Date getKravlinjeForsteVirk() {
        return kravlinjeForsteVirk;
    }

    public void setKravlinjeForsteVirk(Date kravlinjeForsteVirk) {
        this.kravlinjeForsteVirk = kravlinjeForsteVirk;
    }

    public Kravlinje getKravlinje() {
        return kravlinje;
    }

    public void setKravlinje(Kravlinje kravlinje) {
        this.kravlinje = kravlinje;
    }

    public KravlinjeTypeCti getKravlinjeType() {
        return kravlinjeType;
    }

    public void setKravlinjeType(KravlinjeTypeCti kravlinjeType) {
        this.kravlinjeType = kravlinjeType;
    }

    public PenPerson getPenPerson() {
        return penPerson;
    }

    public void setPenPerson(PenPerson penPerson) {
        this.penPerson = penPerson;
    }

    public Persongrunnlag getPREG_persongrunnlag() {
        return PREG_persongrunnlag;
    }

    public void setPREG_persongrunnlag(Persongrunnlag preg_persongrunnlag) {
        PREG_persongrunnlag = preg_persongrunnlag;
    }

    public VilkarsvedtakResultatCti getVilkarsvedtakResultat() {
        return vilkarsvedtakResultat;
    }

    public void setVilkarsvedtakResultat(VilkarsvedtakResultatCti vilkarsvedtakResultat) {
        this.vilkarsvedtakResultat = vilkarsvedtakResultat;
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

    public VilkarVurderingCti getAnvendtVurdering() {
        return anvendtVurdering;
    }

    public void setAnvendtVurdering(VilkarVurderingCti anvendtVurdering) {
        this.anvendtVurdering = anvendtVurdering;
    }

    public AbstraktVilkarsprovResultat getVilkarsprovresultat() {
        return vilkarsprovresultat;
    }

    public void setVilkarsprovresultat(AbstraktVilkarsprovResultat vilkarsprovresultat) {
        this.vilkarsprovresultat = vilkarsprovresultat;
    }

    public BegrunnelseTypeCti getBegrunnelse() {
        return begrunnelse;
    }

    public void setBegrunnelse(BegrunnelseTypeCti begrunnelse) {
        this.begrunnelse = begrunnelse;
    }

    @Override
    public int compareTo(VilkarsVedtak vv) {
        return DateCompareUtil.compareTo(getVirkFom(), vv.getVirkFom());
    }

    public boolean isAvslattKapittel19() {
        return avslattKapittel19;
    }

    public void setAvslattKapittel19(boolean avslattKapittel19) {
        this.avslattKapittel19 = avslattKapittel19;
    }

    public void setAvslattGarantipensjon(boolean avslattGarantipensjon) {
        this.avslattGarantipensjon = avslattGarantipensjon;
    }

    public boolean isAvslattGarantipensjon() {
        return avslattGarantipensjon;
    }

    public void setVurderSkattefritakET(boolean vurderSkattefritakET) {
        this.vurderSkattefritakET = vurderSkattefritakET;
    }

    public boolean isVurderSkattefritakET() {
        return vurderSkattefritakET;
    }

    public boolean isEpsAvkallEgenPensjon() {
        return epsAvkallEgenPensjon;
    }

    public void setEpsAvkallEgenPensjon(boolean epsAvkallEgenPensjon) {
        this.epsAvkallEgenPensjon = epsAvkallEgenPensjon;
    }

    public boolean isEpsRettEgenPensjon() {
        return epsRettEgenPensjon;
    }

    public void setEpsRettEgenPensjon(boolean epsRettEgenPensjon) {
        this.epsRettEgenPensjon = epsRettEgenPensjon;
    }

    public boolean isUnntakHalvMinstepensjon() {
        return unntakHalvMinstepensjon;
    }

    public void setUnntakHalvMinstepensjon(boolean unntakHalvMinstepensjon) {
        this.unntakHalvMinstepensjon = unntakHalvMinstepensjon;
    }

    /**
     * @return siste periode fra beregningsvilkarsPeriodeListe, null hvis ingen elementer i listen
     */

    public BeregningsvilkarPeriode getSisteBeregningsvilkarPeriode() {
        return !beregningsvilkarPeriodeListe.isEmpty() ? getSortedBeregningssvilkarPeriodeListeAsArray(true)[0] : null;
    }

    /**
     * Read only property for abstraktBeregningsvilkarListe as array.
     *
     * @return første periode fra beregningsvilkarsPeriodeListe, null hvis ingen elementer i listen
     */
    public BeregningsvilkarPeriode getFørsteBeregningsvilkarPeriode() {
        return !beregningsvilkarPeriodeListe.isEmpty() ? getSortedBeregningssvilkarPeriodeListeAsArray(false)[0] : null;
    }

    /**
     * @return beregningsvilkarPeriodeListe sortert etter dato i kronologisk rekkefølge etter dato fom
     * eller reversert rekkefølge dersom parameter reverse = true.
     */
    public BeregningsvilkarPeriode[] getSortedBeregningssvilkarPeriodeListeAsArray(boolean reverse) {
        if (!beregningsvilkarPeriodeListe.isEmpty()) {
            ArrayList<BeregningsvilkarPeriode> sortedBvp = new ArrayList<BeregningsvilkarPeriode>(beregningsvilkarPeriodeListe);
            if (reverse) {
                Collections.sort(sortedBvp, Collections.reverseOrder());
            } else {
                Collections.sort(sortedBvp);
            }
            return sortedBvp.toArray(new BeregningsvilkarPeriode[sortedBvp.size()]);
        } else {
            return new BeregningsvilkarPeriode[0];
        }
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
     * @return the beregningsvilkarPeriodeListe as a sorted array in ascending order
     */
    public BeregningsvilkarPeriode[] getSortedBeregningssvilkarPeriodeListeAsArray() {
        return getSortedBeregningssvilkarPeriodeListeAsArray(false);
    }

    /**
     * @return the beregningsvilkarsPeriode som gjaldt på oppgitt dato, tar utgangspunkt at det ikke kan finnes overlapp i perioder.
     */
    public BeregningsvilkarPeriode getGjeldendeBeregningsvilkarPeriodePaaDato(Date dato) {
        return ListUtil.finnGjeldendeBeregningsvilkaarPeriodePaaDato(beregningsvilkarPeriodeListe, dato);
    }

    /**
     * @param dato the cutoff date
     * @return the beregningsvilkarPeriodeListe that contains beregningsvilkarPeriode that are valid before or on the cutoff date, as a sorted array in ascending order.
     *
     * The method is used by the ruleservices to determine which beregningsvilkarPeriode are relevant (past and present period, relative to virk, is relevant).
     */
    public BeregningsvilkarPeriode[] getSortedBeregningssvilkarPeriodeListeTomDatoAsArray(Date dato) {
        ArrayList<BeregningsvilkarPeriode> resultList = new ArrayList<BeregningsvilkarPeriode>();

        for (BeregningsvilkarPeriode periode : beregningsvilkarPeriodeListe) {
            if( DateUtil.isBeforeDay(periode.getFomDato(), dato) || DateUtil.isSameDay(periode.getFomDato(), dato) ) {
                resultList.add(periode);
            }
        }

        Collections.sort(resultList);

        return resultList.toArray(new BeregningsvilkarPeriode[resultList.size()]);
    }


    /**
     *
     * @param virk
     * @return List of BeregningsvilkarPeriode i året for virk, sortert i kronologisk rekkefølge.
     */
    public BeregningsvilkarPeriode[] findBeregningsvilkarperioderForAr(Date virk){
        ArrayList<BeregningsvilkarPeriode> resultList = new ArrayList<BeregningsvilkarPeriode>();

        Calendar cal = Calendar.getInstance();
        cal.setTime(virk);

        Date fom = DateUtil.createDate(cal.get(Calendar.YEAR), Calendar.JANUARY,1);
        Date tom = DateUtil.createDate(cal.get(Calendar.YEAR), Calendar.DECEMBER, 31);

        for (BeregningsvilkarPeriode periode : beregningsvilkarPeriodeListe) {
            if(DateUtil.intersectsWithPossiblyOpenEndings(periode.getFomDato(), periode.getTomDato(), fom, tom, true)){
                resultList.add(periode);
            }
        }

        Collections.sort(resultList);

        return resultList.toArray(new BeregningsvilkarPeriode[resultList.size()]);
    }
}
