package no.nav.pensjon.regler.to

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat
import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.time.LocalDate
import java.util.*

class BeregnInstitusjonsoppholdRequest : ServiceRequest() {
    var virk: LocalDate? = null

    @Deprecated(
        "Bruk virk i stedet",
        ReplaceWith("virk"),
        level = DeprecationLevel.WARNING)
    @set:JsonProperty("fom")
    @get:JsonIgnore
    var fom: Any? // Any fordi gammel fom kunne være Long (Date)
        get() = virk
        set(value) { /* Verdien mappes via MixIn i mottaker-systemet */ }

    @Deprecated(
        "Bruk virk i stedet",
        ReplaceWith("virk"),
        level = DeprecationLevel.WARNING
    )
    @set:JsonProperty("fomLd")
    @get:JsonIgnore
    var fomLd: LocalDate?
        get() = virk
        set(value) {
            virk = value
        }

    // bruker1 beregning1967
    var bruker1Beregning: Beregning? = null
    var bruker1Kravhode: Kravhode? = null
    var bruker1VilkarsvedtakListe = Vector<VilkarsVedtak>()

    // bruker1  beregningsResultat(dekker 2011,2016 og 2025)
    var bruker1BeregningsResultat: AbstraktBeregningsResultat? = null
    var bruker1Kravhode2011: Kravhode? = null
    var bruker1VilkarsvedtakListe2011 = Vector<VilkarsVedtak>()
    var bruker1SisteAldersberegning2011: SisteAldersberegning2011? = null

    /* Informasjon om uføretrygdberegning for bruker1. Kun påkrevd dersom bruker1 har uføretrygd. */
    var bruker1BeregningsresultatUforetrygd: BeregningsresultatUforetrygd? = null

    /* Informasjon om afpPrivatberegning for bruker1. Kun påkrevd dersom bruker1 har AfpPrivat. */
    var bruker1afpPrivatLivsvarig: AfpPrivatLivsvarig? = null

    // bruker2 beregning1967
    var bruker2Beregning: Beregning? = null
    var bruker2Kravhode: Kravhode? = null
    var bruker2VilkarsvedtakListe = Vector<VilkarsVedtak>()

    // bruker2  beregningsResultat(dekker 2011,2016 og 2025)
    var bruker2BeregningsResultat: AbstraktBeregningsResultat? = null
    var bruker2Kravhode2011: Kravhode? = null
    var bruker2VilkarsvedtakListe2011 = Vector<VilkarsVedtak>()
    var bruker2SisteAldersberegning2011: SisteAldersberegning2011? = null

    /* Informasjon om afpPrivatberegning for bruker2. Kun påkrevd dersom bruker2 har AfpPrivat. */
    var bruker2AfpPrivatLivsvarig: AfpPrivatLivsvarig? = null
}