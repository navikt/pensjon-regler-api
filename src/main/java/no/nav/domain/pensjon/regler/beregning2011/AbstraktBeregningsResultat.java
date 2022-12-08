package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.kode.BeregningArsakCti;
import no.nav.domain.pensjon.regler.kode.BorMedTypeCti;
import no.nav.domain.pensjon.regler.kode.SivilstandTypeCti;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public abstract class AbstraktBeregningsResultat implements Serializable {

    private Date virkFom;

    private PensjonUnderUtbetaling pensjonUnderUtbetaling;

    private int uttaksgrad;
    /**
     * Snittet av uttaksgradene i perioden fra (virk bakover i tid til 1 mai) og til (virk fremover i tid til 1 mai).
     */

    private SivilstandTypeCti brukersSivilstand;

    private BorMedTypeCti benyttetSivilstand;

    private BeregningArsakCti beregningArsak;

    private LonnsvekstInformasjon lonnsvekstInformasjon;

    private List<Merknad> merknadListe = new Vector<Merknad>();

    private double gjennomsnittligUttaksgradSisteAr;

    protected AbstraktBeregningsResultat() {
        super();
    }
}
