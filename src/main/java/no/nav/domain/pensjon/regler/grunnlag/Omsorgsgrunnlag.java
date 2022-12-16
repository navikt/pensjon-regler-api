package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.kode.OmsorgTypeCti;

import java.io.Serializable;

public class Omsorgsgrunnlag implements Serializable {
    

    private int ar;
    private OmsorgTypeCti omsorgType;
    private PenPerson personOmsorgFor;
    private boolean bruk;


}
