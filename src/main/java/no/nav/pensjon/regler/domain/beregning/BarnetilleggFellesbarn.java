package no.nav.pensjon.regler.domain.beregning;

import no.nav.pensjon.regler.domain.beregning2011.AbstraktBarnetillegg;
import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

public class BarnetilleggFellesbarn extends AbstraktBarnetillegg implements Serializable {

    private static final long serialVersionUID = -6889117943178977664L;

    public BarnetilleggFellesbarn() {
        super();
        setFormelKode(new FormelKodeCti("BTx"));
        ytelsekomponentType = new YtelsekomponentTypeCti("TFB");
    }

    /**
     * Copy Constructor
     * 
     * @param barnetilleggFellesbarn a <code>BarnetilleggFellesbarn</code> object
     */
    public BarnetilleggFellesbarn(BarnetilleggFellesbarn barnetilleggFellesbarn) {
        super(barnetilleggFellesbarn);
    }

    public BarnetilleggFellesbarn(int antallBarn, int fribelop, int samletInntektAvkort, int btDiff_eos) {
        this();
        setAntallBarn(antallBarn);
        setFribelop(fribelop);
        setSamletInntektAvkort(samletInntektAvkort);
        setBtDiff_eos(btDiff_eos);
    }

}
