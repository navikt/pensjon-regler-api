package no.nav.pensjon.regler.domain.vedtak

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import java.io.Serializable

@JsonSubTypes(
    JsonSubTypes.Type(value = VilkarsprovAlderspensjon67Resultat::class),
    JsonSubTypes.Type(value = VilkarsprovAlderspensjonResultat::class),
    JsonSubTypes.Type(value = VilkarsprovUforetrygdResultat::class),
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class AbstraktVilkarsprovResultat : Serializable