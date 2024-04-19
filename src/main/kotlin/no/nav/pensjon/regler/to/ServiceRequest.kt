package no.nav.pensjon.regler.to

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.vedtak.VilkarsprovInformasjon2011
import no.nav.pensjon.regler.domain.vedtak.VilkarsprovInformasjon2016
import no.nav.pensjon.regler.domain.vedtak.VilkarsprovInformasjon2025
import java.io.Serializable

//@JsonSubTypes(
//    JsonSubTypes.Type(value = KonverterTilUforetrygdRequest::class),
//    JsonSubTypes.Type(value = RegulerAfpPrivatBeregningRequest::class),
//    JsonSubTypes.Type(value = VilkarsprovAlderpensjonOvergangskullRequest::class),
//    JsonSubTypes.Type(value = RegulerBeregning2011Request::class),
//    JsonSubTypes.Type(value = InntektsavkortningUforetrygdRequest::class),
//    JsonSubTypes.Type(value = HentVeietGrunnbelopListeRequest::class),
//    JsonSubTypes.Type(value = BeregnOpptjeningRequest::class),
//    JsonSubTypes.Type(value = BeregnOvergangskullRequest::class),
//    JsonSubTypes.Type(value = BeregnPoengrekkeRequest::class),
//    JsonSubTypes.Type(value = BeregnPoengtallBatchRequest::class),
//    JsonSubTypes.Type(value = BeregnPoengtallRequest::class),
//    JsonSubTypes.Type(value = BeregnUforetrygdRequest::class),
//    JsonSubTypes.Type(value = BeregnYtelseRequest::class),
//    JsonSubTypes.Type(value = BeslutningsstotteRequest::class),
//    JsonSubTypes.Type(value = FaktoromregnBeregningBatchRequest::class),
//    JsonSubTypes.Type(value = FaktoromregnInntektBatchRequest::class),
//    JsonSubTypes.Type(value = FerdigstillEtteroppgjorUforetrygdRequest::class),
//    JsonSubTypes.Type(value = HentGrunnbelopListeRequest::class),
//    JsonSubTypes.Type(value = HentGyldigSatsRequest::class),
//    JsonSubTypes.Type(value = IdentifiserRegelendringerRequest::class),
//    JsonSubTypes.Type(value = InstitusjonsOppholdRequest::class),
//    JsonSubTypes.Type(value = KategoriserAfpEtteroppgjorRequest::class),
//    JsonSubTypes.Type(value = KontrollerInformasjonsgrunnlagRequest::class),
//    JsonSubTypes.Type(value = KonverterAP1967TilAP2011Request::class),
//    JsonSubTypes.Type(value = VilkarsprovAlderpensjon2016Request::class),
//    JsonSubTypes.Type(value = VilkarsprovEktefelletillegg2011Request::class),
//    JsonSubTypes.Type(value = VilkarsprovAlderpensjonForsteUttakRequest::class),
//    JsonSubTypes.Type(value = VilkarsprovRequest::class),
//    JsonSubTypes.Type(value = RegulerBeregningMangelfulltGrunnlagRequest::class),
//    JsonSubTypes.Type(value = SimulerAP2011For2025Request::class),
//    JsonSubTypes.Type(value = BeregnAlderspensjon2025ForsteUttakRequest::class),
//    JsonSubTypes.Type(value = VilkarsprovHalvpensjonRequest::class),
//    JsonSubTypes.Type(value = BeregnAfpEtteroppgjorRequest::class),
//    JsonSubTypes.Type(value = SamletEktefellepensjonRequest::class),
//    JsonSubTypes.Type(value = RevurderingYtelse1967Request::class),
//    JsonSubTypes.Type(value = RevurderingAlderspensjon2011Request::class),
//    JsonSubTypes.Type(value = BeregnInstitusjonsoppholdRequest::class),
//    JsonSubTypes.Type(value = TrygdetidRequest::class),
//    JsonSubTypes.Type(value = RevurderingAlderspensjon2025Request::class),
//    JsonSubTypes.Type(value = RevurderingOvergangskullRequest::class),
//    JsonSubTypes.Type(value = BeregnAfpPrivatRequest::class),
//    JsonSubTypes.Type(value = RegulerPensjonsbeholdningRequest::class),
//    JsonSubTypes.Type(value = VilkarsprovForsorgingstilleggRequest::class),
//    JsonSubTypes.Type(value = BeregnAlderspensjon2016ForsteUttakRequest::class),
//    JsonSubTypes.Type(value = RegulerBeregningRequest::class),
//    JsonSubTypes.Type(value = BeregnForsorgingstilleggRequest::class),
//    JsonSubTypes.Type(value = VilkarsprovAlderpensjon2025Request::class),
//    JsonSubTypes.Type(value = BeregnAlderspensjon2011ForsteUttakRequest::class),
//    JsonSubTypes.Type(value = RevurderingAlderspensjon2016Request::class),
//    JsonSubTypes.Type(value = VilkarsprovAlderpensjon2011Request::class),
//    JsonSubTypes.Type(value = SimulerRevurderAP2011For2025Request::class),
//    JsonSubTypes.Type(value = BeregnMinstepensjonRequest::class),
//    JsonSubTypes.Type(value = SimuleringRequest::class)
//)
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class ServiceRequest : Serializable