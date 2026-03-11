package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*
import java.time.LocalDate

class BeregnAfpPrivatRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
    var vilkarsvedtakListe: ArrayList<VilkarsVedtak> = ArrayList()
    @Deprecated("Use virkFomLd instead")
    var virkFom: Date? = null
    var virkFomLd: LocalDate? = null
    var justeringsbelop = 0
    var referansebelop = 0
    var ftKompensasjonstillegg = 0.0
    var sisteAfpPrivatBeregning: BeregningsResultatAfpPrivat? = null
    @Deprecated("Use virkFomAfpPrivatUttakLd instead")
    var virkFomAfpPrivatUttak: Date? = null
    var virkFomAfpPrivatUttakLd: LocalDate? = null
}