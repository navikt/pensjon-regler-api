package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author Tatyana Lochehina PK-13673
 * @author Swiddy de Louw (Capgemini) PK-13673
 */
public class UforetrygdEtteroppgjor implements Serializable {

    /**
     * Angir om det har vært arbeidsforsøk i etteroppgjørsåret.
     */
    private boolean arbeidsforsok;

    /**
     * Angir start av arbeidsforsøk.
     */
    private Date arbeidsforsokFom;

    /**
     * Angir slutt av arbeidsforsøk.
     */
    private Date arbeidsforsokTom;

    private List<UforetrygdEtteroppgjorDetalj> detaljer = new ArrayList<UforetrygdEtteroppgjorDetalj>();

    /**
     * Angir start av uføretrygd i etteroppgjørsåret.
     */
    private Date periodeFom;

    /**
     * Angir slutt av uføretrygd i etteroppgjørsåret.
     */
    private Date periodeTom;

}
