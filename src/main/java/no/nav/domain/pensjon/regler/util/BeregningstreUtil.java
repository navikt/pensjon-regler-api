package no.nav.domain.pensjon.regler.util;

import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning.BeregningRelasjon;
import no.nav.domain.pensjon.regler.beregning2011.Beregning2011;

import java.util.List;

/**
 * Utility som traverserer et Beregningstre
 * 
 * @author Torje Coldevin
 */
public class BeregningstreUtil {
    public boolean kontrollerBeregningstreTotalVinner(Beregning2011 beregning2011) {
        return traverser(new BeregningRelasjon(beregning2011, true));
    }

    private boolean traverser(BeregningRelasjon beregningRelasjon) {
        List<BeregningRelasjon> delberegningliste;
        if (erBeregning1967(beregningRelasjon)) {
            Beregning delberegning1967 = beregningRelasjon.getBeregning();
            if (delberegning1967.isTotalVinner()) {
                return false;
            }
            delberegningliste = delberegning1967.getDelberegningsListe();
        } else {
            Beregning2011 delberegning2011 = beregningRelasjon.getBeregning2011();
            delberegningliste = delberegning2011.getDelberegning2011Liste();
        }

        if (delberegningliste.size() > 0) {
            for (BeregningRelasjon delberegningBeregningRelasjon : delberegningliste) {
                if (!traverser(delberegningBeregningRelasjon)) {
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * Sjekker om beregningRelasjon er gammel beregning (1967)
     * Hvis BeregningRelasjon eller Beregning er null returneres true.
     * 
     * @param toCheck
     * @return beregning1967
     */
    private boolean erBeregning1967(BeregningRelasjon toCheck) {
        if (toCheck != null) {
            if (toCheck.getBeregning2011() != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Setter totalVinner false på alle noder av type Beregning i et beregningstre.
     * 
     * @param beregning2011
     */
    public void totalVinnerFalse(Beregning2011 beregning2011) {
        setTotalVinnerFalseRecursively(new BeregningRelasjon(beregning2011, true));
    }

    private void setTotalVinnerFalseRecursively(BeregningRelasjon beregningRelasjon) {
        List<BeregningRelasjon> delberegningliste;
        if (erBeregning1967(beregningRelasjon)) {
            Beregning delberegning1967 = beregningRelasjon.getBeregning();
            delberegning1967.setTotalVinner(false);
            delberegningliste = delberegning1967.getDelberegningsListe();
        } else {
            Beregning2011 delberegning2011 = beregningRelasjon.getBeregning2011();
            delberegningliste = delberegning2011.getDelberegning2011Liste();
        }

        if (delberegningliste.size() > 0) {
            for (BeregningRelasjon delberegningBeregningRelasjon : delberegningliste) {
                setTotalVinnerFalseRecursively(delberegningBeregningRelasjon);
            }
        }
    }
}
