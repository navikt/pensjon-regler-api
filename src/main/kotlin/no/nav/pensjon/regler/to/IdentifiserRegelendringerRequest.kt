package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

/**
 * Requestobjekt for BEF2001 Identifiser regelendringer.
 */
class IdentifiserRegelendringerRequest {
    /**
     * må minimum inneholde: fullt persongrunnlag for brukeren, med persondetaljer,
     * Uførehistorikk, instopphold etc og persongrunnlaget til
     * ektefelle/partner/samboer med persondetaljer. Ref. design for detaljer.
     */
    var kravhode: Kravhode? = null

    /**
     * Alle vedtakene som er innvilget og gyldige i perioden.
     */
    var vilkarsvedtakListe: MutableList<VilkarsVedtak> = mutableListOf()

    /**
     * Angir om brukeren har AFP-privat
     * (dvs. AFP-livsvarig del og eventuellt kronetillegg/kompensasjonstillegg).
     */
    var afpPrivat = false

    /**
     * Fra og med dato for regelendringer.
     */
    var fom: Date? = null

    /**
     * Til og med dato for regelendringer. Ved uviss tom-dato kan dagens dato benyttes.
     */
    var tom: Date? = null
}