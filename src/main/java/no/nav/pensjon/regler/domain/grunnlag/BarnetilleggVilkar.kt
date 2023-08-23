package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.BarnetilleggVilkarTypeCti
import java.io.Serializable

/**
 * Representerer et vilkår for barnetillegg på uføretrygd. Saksbehandler gjår en vurdering av enkeltvilkår.
 *
 * @author Lars Hartvigsen (Decisive) - PK-20946
 */
class BarnetilleggVilkar : Serializable {
    var btVilkarType: BarnetilleggVilkarTypeCti? = null
    var isVurdertTil = false
}