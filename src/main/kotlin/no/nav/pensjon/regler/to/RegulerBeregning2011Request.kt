package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat
import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.grunnlag.DelingstallUtvalg
import no.nav.pensjon.regler.domain.grunnlag.ForholdstallUtvalg
import no.nav.pensjon.regler.domain.grunnlag.Uttaksgrad
import java.util.*

class RegulerBeregning2011Request {
    var virkFom: Date? = null
    var beregningsResultat: AbstraktBeregningsResultat? = null
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    var uttaksgradListe: ArrayList<Uttaksgrad> = ArrayList()
    var fodselsdato: Date? = null
    var forholdstallUtvalg: ForholdstallUtvalg? = null
    var delingstallUtvalg: DelingstallUtvalg? = null
}