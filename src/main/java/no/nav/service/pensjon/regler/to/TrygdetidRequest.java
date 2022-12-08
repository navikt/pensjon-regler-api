package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import no.nav.domain.pensjon.regler.beregning2011.BeregningsvilkarPeriode;
import no.nav.domain.pensjon.regler.grunnlag.Persongrunnlag;
import no.nav.domain.pensjon.regler.grunnlag.Uttaksgrad;
import no.nav.domain.pensjon.regler.kode.KravlinjeTypeCti;
import no.nav.domain.pensjon.regler.kode.RegelverkTypeCti;

/**
 * Dataoverføringsobjekt, inndata, for tjenesten fastsettTrygdetid.
 */
public class TrygdetidRequest extends ServiceRequest {


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

}
