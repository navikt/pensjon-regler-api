package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;

public class Ventetilleggsgrunnlag implements Serializable {

    
    /**
     * Ventetilleggprosenten.
     */
    private Double ventetilleggprosent;
    /**
     * Sluttpoengtallet til søker ved 67 år.
     */
    private Double vt_spt;
    /**
     * Sluttpoengtallet til søker ved 67 år relatert til overkompensasjon.
     */
    private Double vt_opt;
    /**
     * Antall poengår til søker ved 67 år.
     */
    private Integer vt_pa;
    /**
     * Anvendt trygdetid til søker ved 67 år.
     */
    private Integer tt_vent;

}
