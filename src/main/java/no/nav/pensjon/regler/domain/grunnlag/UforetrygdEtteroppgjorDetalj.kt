package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.GrunnlagsrolleCti
import java.io.Serializable
import java.util.*

class UforetrygdEtteroppgjorDetalj : Serializable {
    /**
     * Angir gyldighetsperioden for detaljen. Avgrenset av Uføreperioden og året som etteroppgjørsgrunnlaget gjelder for.
     */
    var fomDato: Date? = null

    /**
     * Liste over inntektsfratrekk for etteroppgjøret (for perioder uten uføretrygd og andre registrerte fradrag).
     */
    var fratrekk: List<Inntektsgrunnlag> = ArrayList()

    /**
     * Kode som angir hvilken rolle personen har på kravet. De ulike rollene er definert i Kodeverk, ark K_GRNL_ROLLE_T.
     */
    var grunnlagsrolle: GrunnlagsrolleCti? = null

    /**
     * Liste over alle inntekter som skal benyttes i etteroppgjøret.
     */
    var inntekter: List<Inntektsgrunnlag> = ArrayList()

    /**
     * Angir gyldighetsperioden for detaljen. Avgrenset av Uføreperioden og året som etteroppgjørsgrunnlaget gjelder for.
     */
    var tomDato: Date? = null

}