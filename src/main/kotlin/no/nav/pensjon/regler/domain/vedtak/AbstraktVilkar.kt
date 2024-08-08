package no.nav.pensjon.regler.domain.vedtak

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning2011.BeregningsvilkarPeriode
import no.nav.pensjon.regler.domain.enum.VilkarOppfyltUTEnum
import no.nav.pensjon.regler.domain.kode.VilkarOppfyltUTCti
import java.io.Serializable

@JsonSubTypes(
    JsonSubTypes.Type(value = BeregningsvilkarPeriode::class),
    JsonSubTypes.Type(value = MedlemskapForUTEtterTrygdeavtaler::class),
    JsonSubTypes.Type(value = RettTilEksportEtterTrygdeavtaler::class),
    JsonSubTypes.Type(value = RettTilGjenlevendetillegg::class),
    JsonSubTypes.Type(value = ForutgaendeMedlemskap::class),
    JsonSubTypes.Type(value = Yrkesskade::class),
    JsonSubTypes.Type(value = FortsattMedlemskap::class),
    JsonSubTypes.Type(value = UngUfor::class)

)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class AbstraktVilkar : Serializable {

    var resultat: VilkarOppfyltUTCti? = null
    var resultatEnum: VilkarOppfyltUTEnum? = null

}