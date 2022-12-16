package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.ProRataBeregningTypeCti;

import java.io.Serializable;

public class EosEkstra implements Serializable {

    

    private ProRataBeregningTypeCti proRataBeregningType;

    private Integer redusertAntFppAr;

    private Double spt_eos;

    private Integer spt_pa_f92_eos;

    private Integer spt_pa_e91_eos;

    private Boolean vilkar3_17Aok;

}
