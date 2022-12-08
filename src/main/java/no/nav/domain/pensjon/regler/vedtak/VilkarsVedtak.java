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
     * Kode som angir hvilket resultat PREG setter p� vilk�rsvedtaket. Se
     * K_VILKAR_RESUL_T for gyldige typer. Kun satt hvis PREG utf�rer
     * vilk�rspr�ving.
     */
    private VilkarsvedtakResultatCti anbefaltResultat;

    /**
     * Kode som angir det resultatet til vilk�rsvedtaket. Settes av konsumenten
     * av tjenesten, eventuelt basert p� anbefaltResultat. Se K_VILKAR_RESUL_T
     * for gyldige typer.
     */
    private VilkarsvedtakResultatCti vilkarsvedtakResultat;

    /**
     * Kode som angir hvilken type kravlinje vilk�rsvedtaket relaterer seg til.
     * K_KRAVLINJE_T for gyldige typer.
     */
    private KravlinjeTypeCti kravlinjeType;

    /**
     * Beskriver hvilken vurdering saksbehandler har lagt til grunn for
     * resultatvurderingen. Se K_VILKAR_VURD_T.
     */
    private VilkarVurderingCti anvendtVurdering;

    /**
     * Dato vilk�rsvedtaket har virkning fra.
     */
    private Date virkFom;

    /**
     * Dato vilk�rsvedtaket har virkning til. Denne skal ikke v�re satt, og det
     * betyr at vedtaket har uendelig gyldighet. Skulle den likevel v�re satt
     * vil PREG sjekke at virken p� ytelsen det beregnes for er nnnnenfor
     * virkFom-virkTom. Er den utenfor blir vedtaket behandlet som ikke gyldig.
     */
    private Date virkTom;

    /**
     * Dato f�rste innvilgede vilk�rsvedtak personen har f�tt fra trygden.
     * Eks: har personen tidligere hatt UP og f�r n� AP vil det v�re datoen for f�rste UP-vedtaket.
     */
    private Date forsteVirk;

    /**
     * Dato dette vilk�rsvedtakets kravlinje f�rst ble innvilget.
     * Eks: personen fikk innvilget gjenlevenderett fom dette virkningstidspunkt.
     */
    private Date kravlinjeForsteVirk;

    /**
     * Kravlinje som er vilk�rspr�vd.
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
