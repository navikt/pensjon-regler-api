package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.DagpengetypeEnum
import java.io.Serializable

class Dagpengegrunnlag : Serializable {
    var ar = 0
    var dagpengetypeEnum: DagpengetypeEnum? = null
    var uavkortetDagpengegrunnlag = 0
    var utbetalteDagpenger = 0
    var ferietillegg = 0
    var barnetillegg = 0

}