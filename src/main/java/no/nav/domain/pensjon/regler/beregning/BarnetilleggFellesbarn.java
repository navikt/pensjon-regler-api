package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.beregning2011.AbstraktBarnetillegg;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

public class BarnetilleggFellesbarn extends AbstraktBarnetillegg implements Serializable {



    public BarnetilleggFellesbarn() {
        super();
        setFormelKode(new FormelKodeCti("BTx"));
        ytelsekomponentType = new YtelsekomponentTypeCti("TFB");
    }


}
