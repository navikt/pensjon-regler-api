package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.BorMedTypeCti;
import no.nav.domain.pensjon.regler.kode.ResultatTypeCti;
import no.nav.domain.pensjon.regler.kode.SivilstandTypeCti;

import java.io.Serializable;
import java.util.Date;

/**
 * Felles grensesnitt for Siste beregninger slik som SisteBeregning1967, SisteAldersberegning2011, SisteGjenlevendeberegning
 */
public abstract class SisteBeregning implements Serializable {
    

    private Date virkDato;
    private int tt_anv;
    private ResultatTypeCti resultatType;
    private SivilstandTypeCti sivilstandType;
    private BorMedTypeCti benyttetSivilstand;

}
