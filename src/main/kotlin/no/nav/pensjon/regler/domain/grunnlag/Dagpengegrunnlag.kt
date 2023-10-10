package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.DagpengeTypeCti
import java.io.Serializable

class Dagpengegrunnlag : Serializable {
    var ar = 0
    var dagpengeType: DagpengeTypeCti? = null
    var uavkortetDagpengegrunnlag = 0
    var utbetalteDagpenger = 0
    var ferietillegg = 0
    var barnetillegg = 0

}