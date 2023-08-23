package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.IBeregning
import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.beregning.BeregningRelasjon
import no.nav.pensjon.regler.domain.kode.BeregningGjelderTypeCti
import no.nav.pensjon.regler.domain.kode.BeregningMetodeTypeCti
import no.nav.pensjon.regler.domain.kode.BeregningTypeCti
import no.nav.pensjon.regler.domain.kode.ResultatTypeCti
import java.io.Serializable

abstract class Beregning2011 : IBeregning, Serializable {
    /**
     * @param pREGBeregningId the PREG_beregningsnavn to set
     */
    var pREG_beregningsnavn: String? = null
    var gjelderPerson: PenPerson? = null
    open var grunnbelop = 0
    var tt_anv = 0
    var resultatType: ResultatTypeCti? = null
    var beregningsMetode: BeregningMetodeTypeCti? = null
    var beregningType: BeregningTypeCti? = null
    var delberegning2011Liste: List<BeregningRelasjon> = mutableListOf()
    var merknadListe: List<Merknad> = mutableListOf()

    override val delberegningsListe: List<BeregningRelasjon>
        get() = delberegning2011Liste

    /**
     * Referanse tilbake til beregningsrelasjon dersom denne beregning inngår i en beregningsrelasjon.
     */
    var pREG_beregningsrelasjon: BeregningRelasjon? = null

    /**
     * Feltet støtter navngivning av beregningen i beregningstreet.
     * Ifbm. Gjenlevendetillegg settes koden avhengig av hvilke grunnlagsroller som beregningen angår.
     */
    var beregningGjelderType: BeregningGjelderTypeCti? = null
}