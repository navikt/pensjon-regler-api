package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Uforehistorikk implements Serializable {

    

    /**
     * Liste av uf�reperioder.
     */
    private List<Uforeperiode> uforeperiodeListe;

    /**
     * Uf�regraden pensjonen er blitt fryst fra.
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
     * Ved eksport og ung uf�re vil denne listen inneholde uf�rehistorikk med ung uf�re.
     * Intern PREG variabel
     */
    private List<Uforeperiode> PREG_originalUforeperiodeListe;



}
