package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat
import no.nav.pensjon.regler.domain.beregning2011.AfpOffentligLivsvarigGrunnlag
import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.grunnlag.NormertPensjonsalderGrunnlag
import no.nav.pensjon.regler.domain.grunnlag.Uttaksgrad
import java.util.*

class RegulerBeregning2011Request : ServiceRequest() {
    var virkFom: Date? = null
    var beregningsResultat: AbstraktBeregningsResultat? = null
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    var uttaksgradListe: ArrayList<Uttaksgrad> = ArrayList()
    var fodselsdato: Date? = null

    @Deprecated("Felt ikke i bruk. AfpOffentligLivsvarig er forventet satt på beregningsResultat")
    var afpOffentligLivsvarigGrunnlag: AfpOffentligLivsvarigGrunnlag? = null

    /**
     * Representerer grunnlaget for normert pensjonsalder
     *
     * Dette feltet inneholder normert, øvre og nedre pensjonsalder (i år og måneder)
     * som benyttes i saksbehandlingen.
     */
    var normertPensjonsalderGrunnlag: NormertPensjonsalderGrunnlag? = null
}