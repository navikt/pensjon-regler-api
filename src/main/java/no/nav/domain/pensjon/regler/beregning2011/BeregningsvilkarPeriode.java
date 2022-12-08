package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.vedtak.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063, PK-9695, PKPYTON-923
 * @author Swiddy de Louw (Capgemini), PK-8704,PKPYTON-563
 * Husk at når du legger til nye "smarte metoder" som f.eks set/getInntektEtterUforhet(), at dette må gjøres også i VilkarsVedtak som da
 * agerer på seneste fomDato i beregningsvilkarperiodeListe.
 * @author Steinar Hjellvik (Decisive) - PK-11391, PKPYTON-1447 Rettet feil i copy constructor. Den var ikke nullpointer safe ved kall til dypKopi metode.
 */

public class BeregningsvilkarPeriode implements Serializable {



    /**
     * Fom dato for perioden de angitte beregningsvilkår og vilkår gjelder for
     */
    private Date fomDato;

    /**
     * Tom dato for perioden de angitte beregningsvilkår og vilkår gjelder for
     */
    private Date tomDato;

    /**
     * Liste av beregningsvilkår til bruk ved beregning av uføretrygd.
     */
    private List<AbstraktBeregningsvilkar> beregningsvilkarListe;

    /**
     * Liste av vilkår til bruk ved beregning av uføretrygd.
     */
    private List<AbstraktVilkar> vilkarListe;


}
