package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.BeregningMetodeTypeCti;

import java.io.Serializable;

/**
 * Wrapper classe som PEN trenger
 * 
 * @author Torje Coldevin
 */
public class TapendeBeregningsmetode implements Serializable {

    

    private BeregningMetodeTypeCti beregningMetodeTypeCti;
    private long tapendeBeregningsmetodeId;

    /**
     * Default constructor
     * 
     * @param beregningMetodeTypeCti
     */
    public TapendeBeregningsmetode(BeregningMetodeTypeCti beregningMetodeTypeCti) {
        this.beregningMetodeTypeCti = beregningMetodeTypeCti;
    }

    public TapendeBeregningsmetode() {
    }

    /**
     * Copy constructor
     * 
     * @param tapendeBeregningsmetode
     */
    public TapendeBeregningsmetode(TapendeBeregningsmetode tapendeBeregningsmetode) {
        if (tapendeBeregningsmetode.beregningMetodeTypeCti != null) {
            beregningMetodeTypeCti = new BeregningMetodeTypeCti(tapendeBeregningsmetode.beregningMetodeTypeCti);
        }
        tapendeBeregningsmetodeId = tapendeBeregningsmetode.tapendeBeregningsmetodeId;
    }

    public BeregningMetodeTypeCti getBeregningMetodeTypeCti() {
        return beregningMetodeTypeCti;
    }

    public void setBeregningMetodeTypeCti(BeregningMetodeTypeCti beregningMetodeTypeCti) {
        this.beregningMetodeTypeCti = beregningMetodeTypeCti;
    }

    public long getTapendeBeregningsmetodeId() {
        return tapendeBeregningsmetodeId;
    }

    public void setTapendeBeregningsmetodeId(long tapendeBeregningsmetodeId) {
        this.tapendeBeregningsmetodeId = tapendeBeregningsmetodeId;
    }

}
