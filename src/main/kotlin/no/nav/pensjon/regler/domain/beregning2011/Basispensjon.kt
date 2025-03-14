package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import java.io.Serializable

/**
 * Kopi av PEN 28/8/2009 - ruller tilbake til pensjon-regler domenemodell
 */
class Basispensjon : Serializable {
    /** utgjør summen av basisgrunnpensjon, basistilleggspensjon og i basispensjonstillegg.  */
    var totalbelop = 0.0

    /** Basisgrunnpensjon slik det er definert i nytt regelverk på gammel opptjening (kapittel 19).  */
    var gp: BasisGrunnpensjon? = null

    /** Basistilleggspensjon slik det er definert i nytt regelverk på gammel opptjening (kapittel 19).  */
    var tp: BasisTilleggspensjon? = null

    /** Basispensjonstillegg slik det er definert i nytt regelverk på gammel opptjening (kapittel 19).  */
    var pt: BasisPensjonstillegg? = null

    /** Formelkode kun for bruk for restpensjon  */
    var formelKodeEnum: FormelKodeEnum = FormelKodeEnum.ResPx
}