package no.nav.pensjon.regler.domain.beregning;

import no.nav.pensjon.regler.domain.beregning2011.AbstraktBarnetillegg;
import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

public class BarnetilleggSerkullsbarn extends AbstraktBarnetillegg implements Serializable {

    private static final long serialVersionUID = -6889117943178977664L;

    public BarnetilleggSerkullsbarn() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("TSB");
        setFormelKode(new FormelKodeCti("BTx"));
    }

    /**
     * Copy Constructor
     * 
     * @param barnetilleggSerkullsbarn a <code>BarnetilleggSerkullsbarn</code> object
     */
    public BarnetilleggSerkullsbarn(BarnetilleggSerkullsbarn barnetilleggSerkullsbarn) {
        super(barnetilleggSerkullsbarn);
    }

    public BarnetilleggSerkullsbarn(int antallBarn, int fribelop, int samletInntektAvkort, int btDiff_eos) {
        this();
        setAntallBarn(antallBarn);
        setFribelop(fribelop);
        setSamletInntektAvkort(samletInntektAvkort);
        setBtDiff_eos(btDiff_eos);
    }

}
