package no.nav.pensjon.regler.domain.beregning2011;


import no.nav.pensjon.regler.domain.kode.AvviksjusteringCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Angir detaljer rund avkortingen av barnetillegg.
 */
public class AvkortingsinformasjonBT extends AbstraktAvkortingsinformasjon implements Serializable {

    private static final long serialVersionUID = 4325412034276487756L;

    /**
     * Angir liste over fremtidige perioder.
     */

    private List<AbstraktBarnetilleggperiode> barnetilleggPeriodeListe = new ArrayList<AbstraktBarnetilleggperiode>();

    /**
     * Fribeløp for antall barn ved virk.
     */

    private int fribelopVedVirk;

    /**
     * Hva gjenstår å utbetale for resten av året uten hensyn til justeringsbeløp.
     */
    private double restTilUtbetalingForJustering;

    /**
     * Sum av alle avviksbeløp fra alle tidligere barnetilleggperioder i et år.
     */
    private double avviksbelop;

    /**
     * Nødvendig justering av avkortingsbeløp.
     */
    private double justeringsbelopUbegrensetPerAr;

    /**
     * Det justeringsbeløpet som er praktisk mulig å effektuere.
     */
    private double justeringsbelopPerAr;

    /**
     * Gitt at forventet inntekt ikke endres, hva blir forventet etteroppgjør.
     */
    private double forventetEtteroppgjor;

    /**
     * Angir en konklusjon for behovsprøvingen. Innenfor eller utenfor rammene for justering. Kodeverk K_AVVIKSJUSTERING_T
     */
    private AvviksjusteringCti avviksjusteringType;

    /**
     * Flagg som angir om inntekt er periodisert pga kortere periode med barnetillegg enn uføretrygd.
     */
    private boolean inntektPeriodisert;

    /**
     * Flagg som angir at fribeløp er periodisert pga barnetillegg i deler av året.
     */
    private boolean fribelopPeriodisert;

    public AvkortingsinformasjonBT() {
        super();
    }

    public AvkortingsinformasjonBT(AvkortingsinformasjonBT avkortingsinformasjonBT) {
        super(avkortingsinformasjonBT);

        fribelopVedVirk = avkortingsinformasjonBT.fribelopVedVirk;
        restTilUtbetalingForJustering = avkortingsinformasjonBT.restTilUtbetalingForJustering;
        avviksbelop = avkortingsinformasjonBT.avviksbelop;
        justeringsbelopUbegrensetPerAr = avkortingsinformasjonBT.justeringsbelopUbegrensetPerAr;
        justeringsbelopPerAr = avkortingsinformasjonBT.justeringsbelopPerAr;
        forventetEtteroppgjor = avkortingsinformasjonBT.forventetEtteroppgjor;
        inntektPeriodisert = avkortingsinformasjonBT.inntektPeriodisert;
        fribelopPeriodisert = avkortingsinformasjonBT.fribelopPeriodisert;

        if (avkortingsinformasjonBT.avviksjusteringType != null) {
            avviksjusteringType = new AvviksjusteringCti(avkortingsinformasjonBT.avviksjusteringType);
        }

        for (AbstraktBarnetilleggperiode btp : avkortingsinformasjonBT.barnetilleggPeriodeListe) {
            if ( btp instanceof TidligereBarnetilleggperiode ) {
                barnetilleggPeriodeListe.add(new TidligereBarnetilleggperiode( (TidligereBarnetilleggperiode)btp));
            }
            if ( btp instanceof FremtidigBarnetilleggperiode ) {
                barnetilleggPeriodeListe.add(new FremtidigBarnetilleggperiode( (FremtidigBarnetilleggperiode)btp));
            }
        }
    }

    public List<AbstraktBarnetilleggperiode> getBarnetilleggPeriodeListe() {
        return barnetilleggPeriodeListe;
    }

    public int getFribelopVedVirk() {
        return fribelopVedVirk;
    }

    public AbstraktBarnetilleggperiode[] getBarnetilleggPeriodeListeAsArray() {
        return barnetilleggPeriodeListe != null ? barnetilleggPeriodeListe.toArray(new AbstraktBarnetilleggperiode[barnetilleggPeriodeListe.size()]) : new AbstraktBarnetilleggperiode[0];
    }

    public AbstraktBarnetilleggperiode[] getSortertBarnetilleggperiodelisteAsArray() {
        if (barnetilleggPeriodeListe != null) {
            ArrayList<AbstraktBarnetilleggperiode> sortedList = new ArrayList<AbstraktBarnetilleggperiode>(barnetilleggPeriodeListe);
            Collections.sort(sortedList);
            return sortedList.toArray(new AbstraktBarnetilleggperiode[barnetilleggPeriodeListe.size()]);
        } else {
            return new AbstraktBarnetilleggperiode[0];
        }
    }

    public TidligereBarnetilleggperiode[] getSortertTidligereBarnetilleggperiodelisteAsArray() {

        if (barnetilleggPeriodeListe != null) {
            ArrayList<TidligereBarnetilleggperiode> sortedTidligereList = new ArrayList<TidligereBarnetilleggperiode>();
            for (AbstraktBarnetilleggperiode btp : barnetilleggPeriodeListe) {
                if (btp instanceof TidligereBarnetilleggperiode) {
                    sortedTidligereList.add((TidligereBarnetilleggperiode) btp);
                }
            }

            Collections.sort(sortedTidligereList);
            return sortedTidligereList.toArray(new TidligereBarnetilleggperiode[sortedTidligereList.size()]);

        } else {
            return new TidligereBarnetilleggperiode[0];
        }
    }

    public FremtidigBarnetilleggperiode[] getSortertFremtidigBarnetilleggperiodelisteAsArray() {

        if (barnetilleggPeriodeListe != null) {
            ArrayList<FremtidigBarnetilleggperiode> sortedFremtidigList = new ArrayList<FremtidigBarnetilleggperiode>();
            for (AbstraktBarnetilleggperiode btp : barnetilleggPeriodeListe) {
                if (btp instanceof FremtidigBarnetilleggperiode) {
                    sortedFremtidigList.add((FremtidigBarnetilleggperiode) btp);
                }
            }

            Collections.sort(sortedFremtidigList);
            return sortedFremtidigList.toArray(new FremtidigBarnetilleggperiode[sortedFremtidigList.size()]);

        } else {
            return new FremtidigBarnetilleggperiode[0];
        }
    }

    public void setBarnetilleggPeriodeListe(List<AbstraktBarnetilleggperiode> barnetilleggPeriodeListe) {
        this.barnetilleggPeriodeListe = barnetilleggPeriodeListe;
    }

    public void setFribelopVedVirk(int fribelopVedVirk) {
        this.fribelopVedVirk = fribelopVedVirk;
    }

    public double getRestTilUtbetalingForJustering() {
        return restTilUtbetalingForJustering;
    }

    public void setRestTilUtbetalingForJustering(double restTilUtbetalingForJustering) {
        this.restTilUtbetalingForJustering = restTilUtbetalingForJustering;
    }

    public double getAvviksbelop() {
        return avviksbelop;
    }

    public void setAvviksbelop(double avviksbelop) {
        this.avviksbelop = avviksbelop;
    }

    public double getJusteringsbelopUbegrensetPerAr() {
        return justeringsbelopUbegrensetPerAr;
    }

    public void setJusteringsbelopUbegrensetPerAr(double justeringsbelopUbegrensetPerAr) {
        this.justeringsbelopUbegrensetPerAr = justeringsbelopUbegrensetPerAr;
    }

    public double getJusteringsbelopPerAr() {
        return justeringsbelopPerAr;
    }

    public void setJusteringsbelopPerAr(double justeringsbelopPerAr) {
        this.justeringsbelopPerAr = justeringsbelopPerAr;
    }

    public double getForventetEtteroppgjor() {
        return forventetEtteroppgjor;
    }

    public void setForventetEtteroppgjor(double forventetEtteroppgjor) {
        this.forventetEtteroppgjor = forventetEtteroppgjor;
    }

    public AvviksjusteringCti getAvviksjusteringType() {
        return avviksjusteringType;
    }

    public void setAvviksjusteringType(AvviksjusteringCti avviksjusteringType) {
        this.avviksjusteringType = avviksjusteringType;
    }

    public boolean isFribelopPeriodisert() {
        return fribelopPeriodisert;
    }

    public void setFribelopPeriodisert(boolean fribelopPeriodisert) {
        this.fribelopPeriodisert = fribelopPeriodisert;
    }

    public boolean isInntektPeriodisert() {
        return inntektPeriodisert;
    }

    public void setInntektPeriodisert(boolean inntektPeriodisert) {
        this.inntektPeriodisert = inntektPeriodisert;
    }
}
