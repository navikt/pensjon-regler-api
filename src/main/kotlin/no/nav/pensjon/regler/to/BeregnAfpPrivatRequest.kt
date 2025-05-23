package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class BeregnAfpPrivatRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
    var vilkarsvedtakListe: ArrayList<VilkarsVedtak> = ArrayList()
    var virkFom: Date? = null
    var justeringsbelop = 0
    var referansebelop = 0
    var ftKompensasjonstillegg = 0.0
    var sisteAfpPrivatBeregning: BeregningsResultatAfpPrivat? = null
    var virkFomAfpPrivatUttak: Date? = null
}