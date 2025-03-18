package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat
import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.AfpOffentligLivsvarigGrunnlag
import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.grunnlag.Uttaksgrad
import java.util.*

class RegulerBeregning2011Request : ServiceRequest() {
    var virkFom: Date? = null
    var beregningsResultat: AbstraktBeregningsResultat? = null
    @Deprecated("Avvikles. Erstattes av afpPrivatLivsvarig.")
    var afpLivsvarig: AfpLivsvarig? = null
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    var uttaksgradListe: ArrayList<Uttaksgrad> = ArrayList()
    var fodselsdato: Date? = null
    var afpOffentligLivsvarigGrunnlag: AfpOffentligLivsvarigGrunnlag? = null
}