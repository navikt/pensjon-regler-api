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
    private static final long serialVersionUID = 9218448728338191218L;

    private Date virkDato;
    private int tt_anv;
    private ResultatTypeCti resultatType;
    private SivilstandTypeCti sivilstandType;
    private BorMedTypeCti benyttetSivilstand;

    protected SisteBeregning() {
        super();
    }

    protected SisteBeregning(SisteBeregning sb) {
        super();
        virkDato = sb.virkDato;
        tt_anv = sb.tt_anv;
        if (sb.resultatType != null) {
            resultatType = new ResultatTypeCti(sb.resultatType);
        }
        if (sb.sivilstandType != null) {
            sivilstandType = new SivilstandTypeCti(sb.sivilstandType);
        }
        if (sb.benyttetSivilstand != null) {
            benyttetSivilstand = new BorMedTypeCti(sb.benyttetSivilstand);
        }
    }

    public Date getVirkDato() {
        return virkDato;
    }

    public void setVirkDato(Date virkDato) {
        this.virkDato = virkDato;
    }

    public int getTt_anv() {
        return tt_anv;
    }

    public void setTt_anv(int ttAnv) {
        tt_anv = ttAnv;
    }

    public ResultatTypeCti getResultatType() {
        return resultatType;
    }

    public void setResultatType(ResultatTypeCti resultatType) {
        this.resultatType = resultatType;
    }

    public SivilstandTypeCti getSivilstandType() {
        return sivilstandType;
    }

    public void setSivilstandType(SivilstandTypeCti sivilstandType) {
        this.sivilstandType = sivilstandType;
    }

    public BorMedTypeCti getBenyttetSivilstand() {
        return benyttetSivilstand;
    }

    public void setBenyttetSivilstand(BorMedTypeCti benyttetSivilstand) {
        this.benyttetSivilstand = benyttetSivilstand;
    }

}
