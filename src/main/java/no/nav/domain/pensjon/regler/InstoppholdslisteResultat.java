package no.nav.domain.pensjon.regler;

import no.nav.domain.pensjon.regler.grunnlag.InstOpphPeriodegrunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InstoppholdslisteResultat implements Serializable {


    /**
     * Merknaden innholder feilkoden fra regeltjenesten.
     */
    private Merknad merknad;
    /**
     * Returlisten av periodegrunnlagene. Utfylt når merknad er null.
     */
    private List<InstOpphPeriodegrunnlag> instOpphPeriodegrunnlagListe;

}
