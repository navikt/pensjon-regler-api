package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.kode.ProRataBeregningTypeCti;

import java.io.Serializable;

public class EosEkstra implements Serializable {

    private static final long serialVersionUID = -3564186802236079931L;

    private ProRataBeregningTypeCti proRataBeregningType;

    private Integer redusertAntFppAr;

    private Double spt_eos;

    private Integer spt_pa_f92_eos;

    private Integer spt_pa_e91_eos;

    private Boolean vilkar3_17Aok;

    /**
     * Copy Constructor
     * 
     * @param eosEkstra a <code>EosEkstra</code> object
     */
    public EosEkstra(EosEkstra eosEkstra) {
        if (eosEkstra.proRataBeregningType != null) {
            proRataBeregningType = new ProRataBeregningTypeCti(eosEkstra.proRataBeregningType);
        }
        if (eosEkstra.redusertAntFppAr != null) {
            redusertAntFppAr = new Integer(eosEkstra.redusertAntFppAr);
        }
        if (eosEkstra.spt_eos != null) {
            spt_eos = new Double(eosEkstra.spt_eos);
        }
        if (eosEkstra.spt_pa_f92_eos != null) {
            spt_pa_f92_eos = new Integer(eosEkstra.spt_pa_f92_eos);
        }
        if (eosEkstra.spt_pa_e91_eos != null) {
            spt_pa_e91_eos = new Integer(eosEkstra.spt_pa_e91_eos);
        }
        if (eosEkstra.vilkar3_17Aok != null) {
            vilkar3_17Aok = new Boolean(eosEkstra.vilkar3_17Aok);
        }
    }

    public EosEkstra() {
        super();
    }

    public EosEkstra(ProRataBeregningTypeCti proRataBeregningType, Integer redusertAntFppAr, Double spt_eos, Integer spt_pa_f92_eos, Integer spt_pa_e91_eos, Boolean vilkar3_17Aok) {
        super();
        this.proRataBeregningType = proRataBeregningType;
        this.redusertAntFppAr = redusertAntFppAr;
        this.spt_eos = spt_eos;
        this.spt_pa_f92_eos = spt_pa_f92_eos;
        this.spt_pa_e91_eos = spt_pa_e91_eos;
        this.vilkar3_17Aok = vilkar3_17Aok;
    }

    public ProRataBeregningTypeCti getProRataBeregningType() {
        return proRataBeregningType;
    }

    public void setProRataBeregningType(ProRataBeregningTypeCti proRataBeregningType) {
        this.proRataBeregningType = proRataBeregningType;
    }

    public Integer getRedusertAntFppAr() {
        return redusertAntFppAr;
    }

    public void setRedusertAntFppAr(Integer redusertAntFppAr) {
        this.redusertAntFppAr = redusertAntFppAr;
    }

    public Double getSpt_eos() {
        return spt_eos;
    }

    public void setSpt_eos(Double spt_eos) {
        this.spt_eos = spt_eos;
    }

    public Integer getSpt_pa_e91_eos() {
        return spt_pa_e91_eos;
    }

    public void setSpt_pa_e91_eos(Integer spt_pa_e91_eos) {
        this.spt_pa_e91_eos = spt_pa_e91_eos;
    }

    public Integer getSpt_pa_f92_eos() {
        return spt_pa_f92_eos;
    }

    public void setSpt_pa_f92_eos(Integer spt_pa_f92_eos) {
        this.spt_pa_f92_eos = spt_pa_f92_eos;
    }

    public Boolean getVilkar3_17Aok() {
        return vilkar3_17Aok;
    }

    public void setVilkar3_17Aok(Boolean vilkar3_17Aok) {
        this.vilkar3_17Aok = vilkar3_17Aok;
    }

}
