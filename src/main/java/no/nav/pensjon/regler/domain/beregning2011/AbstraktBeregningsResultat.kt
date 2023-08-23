package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.kode.BeregningArsakCti
import no.nav.pensjon.regler.domain.kode.BorMedTypeCti
import no.nav.pensjon.regler.domain.kode.SivilstandTypeCti
import java.io.Serializable
import java.util.*

abstract class AbstraktBeregningsResultat protected constructor() : Serializable {
    var virkFom: Date? = null
    var pensjonUnderUtbetaling: PensjonUnderUtbetaling? = null
    /**
     * @return the uttaksgrad
     */
    /**
     * @param uttaksgrad the uttaksgrad to set
     */
    var uttaksgrad = 0

    /**
     * Snittet av uttaksgradene i perioden fra (virk bakover i tid til 1 mai) og til (virk fremover i tid til 1 mai).
     */
    var brukersSivilstand: SivilstandTypeCti? = null
    var benyttetSivilstand: BorMedTypeCti? = null
    var beregningArsak: BeregningArsakCti? = null
    var lonnsvekstInformasjon: LonnsvekstInformasjon? = null
    var merknadListe: List<Merknad> = mutableListOf()
    var gjennomsnittligUttaksgradSisteAr = 0.0

    /**
     * PREG versjonsnummer.
     */
    var pREG_versjon: String? = null

}