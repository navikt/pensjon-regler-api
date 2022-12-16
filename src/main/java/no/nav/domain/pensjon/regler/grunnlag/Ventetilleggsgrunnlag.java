package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;

public class Ventetilleggsgrunnlag implements Serializable {

    
    /**
     * Ventetilleggprosenten.
     */
    private Double ventetilleggprosent;
    /**
     * Sluttpoengtallet til s�ker ved 67 �r.
     */
    private Double vt_spt;
    /**
     * Sluttpoengtallet til s�ker ved 67 �r relatert til overkompensasjon.
     */
    private Double vt_opt;
    /**
     * Antall poeng�r til s�ker ved 67 �r.
     */
    private Integer vt_pa;
    /**
     * Anvendt trygdetid til s�ker ved 67 �r.
     */
    private Integer tt_vent;

}
