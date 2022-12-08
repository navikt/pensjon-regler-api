package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning.BeregningRelasjon;
import no.nav.domain.pensjon.regler.kode.BeregningGjelderTypeCti;
import no.nav.domain.pensjon.regler.kode.BeregningMetodeTypeCti;
import no.nav.domain.pensjon.regler.kode.BeregningTypeCti;
import no.nav.domain.pensjon.regler.kode.ResultatTypeCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lars Hartvigsen (Decisive) - PK-12169 HL3 2015
 */

public abstract class Beregning2011 implements Serializable {

    private PenPerson gjelderPerson;
    private int grunnbelop;
    private int tt_anv;
    private ResultatTypeCti resultatType;
    private BeregningMetodeTypeCti beregningsMetode;
    private BeregningTypeCti beregningType;

    private List<BeregningRelasjon> delberegning2011Liste = new ArrayList<BeregningRelasjon>();
    private List<Merknad> merknadListe = new ArrayList<Merknad>();

    /**
     * Feltet støtter navngivning av beregningen i beregningstreet.
     * Ifbm. Gjenlevendetillegg settes koden avhengig av hvilke grunnlagsroller som beregningen angår.
     */
    private BeregningGjelderTypeCti beregningGjelderType;

}
