package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.beregning2011.BeregningsvilkarPeriode
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import no.nav.pensjon.regler.domain.kode.BegrunnelseTypeCti
import no.nav.pensjon.regler.domain.kode.KravlinjeTypeCti
import no.nav.pensjon.regler.domain.kode.VilkarVurderingCti
import no.nav.pensjon.regler.domain.kode.VilkarsvedtakResultatCti
import no.nav.pensjon.regler.domain.krav.Kravlinje
import java.io.Serializable
import java.util.*

/**
 * @author Magnus Bakken (Accenture) PK-10597, PK-9695, PKPYTON-923
 * @author Swiddy de Louw (Capgemini), PK-8704,PKPYTON-563
 */
class VilkarsVedtak : Serializable {
    /**
     * Kode som angir hvilket resultat PREG setter på vilkårsvedtaket. Se
     * K_VILKAR_RESUL_T for gyldige typer. Kun satt hvis PREG utfører
     * vilkårsprøving.
     */
    var anbefaltResultat: VilkarsvedtakResultatCti? = null

    /**
     * Kode som angir det resultatet til vilkårsvedtaket. Settes av konsumenten
     * av tjenesten, eventuelt basert på anbefaltResultat. Se K_VILKAR_RESUL_T
     * for gyldige typer.
     */
    var vilkarsvedtakResultat: VilkarsvedtakResultatCti? = null

    /**
     * Kode som angir hvilken type kravlinje vilkårsvedtaket relaterer seg til.
     * K_KRAVLINJE_T for gyldige typer.
     */
    var kravlinjeType: KravlinjeTypeCti? = null

    /**
     * Beskriver hvilken vurdering saksbehandler har lagt til grunn for
     * resultatvurderingen. Se K_VILKAR_VURD_T.
     */
    var anvendtVurdering: VilkarVurderingCti? = null

    /**
     * Dato vilkårsvedtaket har virkning fra.
     */
    var virkFom: Date? = null

    /**
     * Dato vilkårsvedtaket har virkning til. Denne skal ikke være satt, og det
     * betyr at vedtaket har uendelig gyldighet. Skulle den likevel være satt
     * vil PREG sjekke at virken på ytelsen det beregnes for er nnnnenfor
     * virkFom-virkTom. Er den utenfor blir vedtaket behandlet som ikke gyldig.
     */
    var virkTom: Date? = null

    /**
     * Dato Første innvilgede vilkårsvedtak personen har fått fra trygden.
     * Eks: har personen tidligere hatt UP og før nå AP vil det være datoen for Første UP-vedtaket.
     */
    var forsteVirk: Date? = null

    /**
     * Dato dette vilkårsvedtakets kravlinje fårst ble innvilget.
     * Eks: personen fikk innvilget gjenlevenderett fom dette virkningstidspunkt.
     */
    var kravlinjeForsteVirk: Date? = null

    /**
     * Kravlinje som er vilkårsprøvd.
     */
    var kravlinje: Kravlinje? = null

    /**
     * Id for personen
     */
    var penPerson: PenPerson? = null
    var vilkarsprovresultat: AbstraktVilkarsprovResultat? = null
    var begrunnelse: BegrunnelseTypeCti? = null
    var isAvslattKapittel19 = false
    var isAvslattGarantipensjon = false
    var pREG_persongrunnlag: Persongrunnlag? = null
    var isVurderSkattefritakET = false

    // CR170026
    var isUnntakHalvMinstepensjon = false
    var isEpsAvkallEgenPensjon = false
    var isEpsRettEgenPensjon = false

    /**
     * List av Beregningsvilkarperioder
     */
    var beregningsvilkarPeriodeListe: List<BeregningsvilkarPeriode> = mutableListOf()

    /**
     * Liste av merknader - forklaringer,unntak og avvisningsgrunner fra
     * regelmotoren.
     */
    var merknadListe: List<Merknad> = mutableListOf()

}