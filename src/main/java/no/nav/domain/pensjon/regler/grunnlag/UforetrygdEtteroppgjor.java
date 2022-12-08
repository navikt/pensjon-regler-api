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
     * Angir om det har v�rt arbeidsfors�k i etteroppgj�rs�ret.
     */
    private boolean arbeidsforsok;

    /**
     * Angir start av arbeidsfors�k.
     */
    private Date arbeidsforsokFom;

    /**
     * Angir slutt av arbeidsfors�k.
     */
    private Date arbeidsforsokTom;

    private List<UforetrygdEtteroppgjorDetalj> detaljer = new ArrayList<UforetrygdEtteroppgjorDetalj>();

    /**
     * Angir start av uf�retrygd i etteroppgj�rs�ret.
     */
    private Date periodeFom;

    /**
     * Angir slutt av uf�retrygd i etteroppgj�rs�ret.
     */
    private Date periodeTom;

}
