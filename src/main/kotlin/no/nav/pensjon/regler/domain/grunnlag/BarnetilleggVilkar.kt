package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.BarnetilleggVilkarTypeEnum
import no.nav.pensjon.regler.domain.kode.BarnetilleggVilkarTypeCti
import java.io.Serializable

/**
 * Representerer et vilkår for barnetillegg på uføretrygd. Saksbehandler gjår en vurdering av enkeltvilkår.
 */
class BarnetilleggVilkar : Serializable {
    var btVilkarType: BarnetilleggVilkarTypeCti? = null
    var btVilkarTypeEnum: BarnetilleggVilkarTypeEnum? = null
    var vurdertTil = false
}