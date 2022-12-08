package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsvilkarPeriode;
import no.nav.domain.pensjon.regler.grunnlag.Persongrunnlag;
import no.nav.domain.pensjon.regler.kode.BegrunnelseTypeCti;
import no.nav.domain.pensjon.regler.kode.KravlinjeTypeCti;
import no.nav.domain.pensjon.regler.kode.VilkarVurderingCti;
import no.nav.domain.pensjon.regler.kode.VilkarsvedtakResultatCti;
import no.nav.domain.pensjon.regler.krav.Kravlinje;

import java.io.Serializable;
import java.util.*;

/**
 * @author Magnus Bakken (Accenture) PK-10597, PK-9695, PKPYTON-923
 * @author Swiddy de Louw (Capgemini), PK-8704,PKPYTON-563
 */

public class VilkarsVedtak implements Serializable {

    

    /**
     * Kode som angir hvilket resultat PREG setter på vilkårsvedtaket. Se
     * K_VILKAR_RESUL_T for gyldige typer. Kun satt hvis PREG utfører
     * vilkårsprøving.
     */
    private VilkarsvedtakResultatCti anbefaltResultat;

    /**
     * Kode som angir det resultatet til vilkårsvedtaket. Settes av konsumenten
     * av tjenesten, eventuelt basert på anbefaltResultat. Se K_VILKAR_RESUL_T
     * for gyldige typer.
     */
    private VilkarsvedtakResultatCti vilkarsvedtakResultat;

    /**
     * Kode som angir hvilken type kravlinje vilkårsvedtaket relaterer seg til.
     * K_KRAVLINJE_T for gyldige typer.
     */
    private KravlinjeTypeCti kravlinjeType;

    /**
     * Beskriver hvilken vurdering saksbehandler har lagt til grunn for
     * resultatvurderingen. Se K_VILKAR_VURD_T.
     */
    private VilkarVurderingCti anvendtVurdering;

    /**
     * Dato vilkårsvedtaket har virkning fra.
     */
    private Date virkFom;

    /**
     * Dato vilkårsvedtaket har virkning til. Denne skal ikke være satt, og det
     * betyr at vedtaket har uendelig gyldighet. Skulle den likevel være satt
     * vil PREG sjekke at virken på ytelsen det beregnes for er nnnnenfor
     * virkFom-virkTom. Er den utenfor blir vedtaket behandlet som ikke gyldig.
     */
    private Date virkTom;

    /**
     * Dato første innvilgede vilkårsvedtak personen har fått fra trygden.
     * Eks: har personen tidligere hatt UP og får nå AP vil det være datoen for første UP-vedtaket.
     */
    private Date forsteVirk;

    /**
     * Dato dette vilkårsvedtakets kravlinje først ble innvilget.
     * Eks: personen fikk innvilget gjenlevenderett fom dette virkningstidspunkt.
     */
    private Date kravlinjeForsteVirk;

    /**
     * Kravlinje som er vilkårsprøvd.
     */
    private Kravlinje kravlinje;

    /**
     * Id for personen
     */
    private PenPerson penPerson;

    private AbstraktVilkarsprovResultat vilkarsprovresultat;

    private BegrunnelseTypeCti begrunnelse;
    private boolean avslattKapittel19;
    private boolean avslattGarantipensjon;
    private Persongrunnlag PREG_persongrunnlag;
    private boolean vurderSkattefritakET;
    // CR170026
    private boolean unntakHalvMinstepensjon;
    private boolean epsAvkallEgenPensjon;
    private boolean epsRettEgenPensjon;

    /**
     * List av Beregningsvilkarperioder
     */
    private List<BeregningsvilkarPeriode> beregningsvilkarPeriodeListe;

    /**
     * Liste av merknader - forklaringer,unntak og avvisningsgrunner fra
     * regelmotoren.
     */
    private List<Merknad> merknadListe;

}
