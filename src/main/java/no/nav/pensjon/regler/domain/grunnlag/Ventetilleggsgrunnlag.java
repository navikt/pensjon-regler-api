package no.nav.pensjon.regler.domain.grunnlag;

import java.io.Serializable;

public class Ventetilleggsgrunnlag implements Serializable {

    private static final long serialVersionUID = -2339458615471581628L;
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

    /**
     * Copy Constructor
     * 
     * @param ventetilleggsgrunnlag a <code>Ventetilleggsgrunnlag</code> object
     */
    public Ventetilleggsgrunnlag(Ventetilleggsgrunnlag ventetilleggsgrunnlag) {
        if (ventetilleggsgrunnlag.ventetilleggprosent != null) {
            ventetilleggprosent = new Double(ventetilleggsgrunnlag.ventetilleggprosent);
        }
        if (ventetilleggsgrunnlag.vt_spt != null) {
            vt_spt = new Double(ventetilleggsgrunnlag.vt_spt);
        }
        if (ventetilleggsgrunnlag.vt_opt != null) {
            vt_opt = new Double(ventetilleggsgrunnlag.vt_opt);
        }
        if (ventetilleggsgrunnlag.vt_pa != null) {
            vt_pa = new Integer(ventetilleggsgrunnlag.vt_pa);
        }
        if (ventetilleggsgrunnlag.tt_vent != null) {
            tt_vent = new Integer(ventetilleggsgrunnlag.tt_vent);
        }
    }

    public Ventetilleggsgrunnlag(Double ventetilleggprosent, Double vt_spt, Double vt_opt, Integer vt_pa, Integer tt_vent) {
        super();
        this.ventetilleggprosent = ventetilleggprosent;
        this.vt_spt = vt_spt;
        this.vt_opt = vt_opt;
        this.vt_pa = vt_pa;
        this.tt_vent = tt_vent;
    }

    public Ventetilleggsgrunnlag() {
        super();
    }

    public Integer getTt_vent() {
        return tt_vent;
    }

    public void setTt_vent(Integer tt_vent) {
        this.tt_vent = tt_vent;
    }

    public Double getVentetilleggprosent() {
        return ventetilleggprosent;
    }

    public void setVentetilleggprosent(Double ventetilleggprosent) {
        this.ventetilleggprosent = ventetilleggprosent;
    }

    public Double getVt_opt() {
        return vt_opt;
    }

    public void setVt_opt(Double vt_opt) {
        this.vt_opt = vt_opt;
    }

    public Integer getVt_pa() {
        return vt_pa;
    }

    public void setVt_pa(Integer vt_pa) {
        this.vt_pa = vt_pa;
    }

    public Double getVt_spt() {
        return vt_spt;
    }

    public void setVt_spt(Double vt_spt) {
        this.vt_spt = vt_spt;
    }

}
