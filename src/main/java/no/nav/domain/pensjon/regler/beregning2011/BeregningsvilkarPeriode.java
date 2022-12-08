package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.vedtak.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063, PK-9695, PKPYTON-923
 * @author Swiddy de Louw (Capgemini), PK-8704,PKPYTON-563
 * Husk at n�r du legger til nye "smarte metoder" som f.eks set/getInntektEtterUforhet(), at dette m� gj�res ogs� i VilkarsVedtak som da
 * agerer p� seneste fomDato i beregningsvilkarperiodeListe.
 * @author Steinar Hjellvik (Decisive) - PK-11391, PKPYTON-1447 Rettet feil i copy constructor. Den var ikke nullpointer safe ved kall til dypKopi metode.
 */

public class BeregningsvilkarPeriode implements Serializable {



    /**
     * Fom dato for perioden de angitte beregningsvilk�r og vilk�r gjelder for
     */
    private Date fomDato;

    /**
     * Tom dato for perioden de angitte beregningsvilk�r og vilk�r gjelder for
     */
    private Date tomDato;

    /**
     * Liste av beregningsvilk�r til bruk ved beregning av uf�retrygd.
     */
    private List<AbstraktBeregningsvilkar> beregningsvilkarListe;

    /**
     * Liste av vilk�r til bruk ved beregning av uf�retrygd.
     */
    private List<AbstraktVilkar> vilkarListe;


}
