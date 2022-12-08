package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.beregning2011.AbstraktBarnetillegg;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

public class BarnetilleggSerkullsbarn extends AbstraktBarnetillegg implements Serializable {



    public BarnetilleggSerkullsbarn() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("TSB");
        setFormelKode(new FormelKodeCti("BTx"));
    }



}
