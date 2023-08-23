package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.vedtak.*
import java.io.Serializable
import java.util.*

/**
 * Husk at når du legger til nye "smarte metoder" som f.eks set/getInntektEtterUforhet(), at dette må gjøres også i VilkarsVedtak som da
 * agerer på seneste fomDato i beregningsvilkarperiodeListe.
 */
class BeregningsvilkarPeriode : Serializable {
    /**
     * Fom dato for perioden de angitte beregningsvilkår og vilkår gjelder for
     */
    @JvmField
    var fomDato: Date? = null
    /**
     * Tom dato for perioden de angitte beregningsvilkår og vilkår gjelder for
     */
    @JvmField
    var tomDato: Date? = null

    /**
     * Liste av beregningsvilkår til bruk ved beregning av uføretrygd.
     */
    var beregningsvilkarListe: List<AbstraktBeregningsvilkar> = mutableListOf()

    /**
     * Liste av vilkår til bruk ved beregning av uføretrygd.
     */
    var vilkarListe: List<AbstraktVilkar> = mutableListOf()

    /**
     * PREG variabel for å markere perioden at beregningsgrunnlagOrdiner er konvertert.
     */
    var isPREG_konvertertOrdiner = false

    /**
     * PREG variabel for å markere perioden at beregningsgrunnlagYrkesskade er konvertert.
     */
    var isPREG_konvertertYrkesskade = false

    /**
     * PREG variabel som angir hvorvidt perioden er av betydning for uføretrygdopptjening. Hvis satt er ufgFom/ufgTom relevante.
     */
    var isPREG_uforetrygdOpptjening = false

    /**
     * PREG variabel som angir hvilket år denne periodens Uføregrad gjelder fra mht. opptjening fra uføretrygd.
     */
    var pREG_ufgFom: Date? = null

    /**
     * PREG variabel som angir hvilket år denne periodens Uføregrad gjelder til mht. opptjening fra uføretrygd.
     */
    var pREG_ufgTom: Date? = null

    /**
     * PREG variabel som angir om perioden representerer et opphår eller en gjenoppliving av Uføreytelsen.
     */
    var pREG_opphorEllerGjenopplivingType = 0

}