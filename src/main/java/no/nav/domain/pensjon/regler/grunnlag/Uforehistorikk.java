package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Uforehistorikk implements Serializable {

    

    /**
     * Liste av uføreperioder.
     */
    private List<Uforeperiode> uforeperiodeListe;

    /**
     * Uføregraden pensjonen er blitt fryst fra.
     */
    private int garantigrad;

    /**
     * Yrkesskadegraden pensjonen er blitt fryst fra.
     */
    private int garantigradYrke;

    /**
     * Dato for sist innmeldt i Folketrygden- for fremtidig trygdetid.
     * Lagt inn ifm PENPORT-2222
     */
    private Date sistMedlITrygden;

    /**
     * Ved eksport og ung uføre vil denne listen inneholde uførehistorikk med ung uføre.
     * Intern PREG variabel
     */
    private List<Uforeperiode> PREG_originalUforeperiodeListe;



}
