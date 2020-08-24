package no.nav.domain.pensjon.regler.util;

import no.nav.domain.pensjon.regler.IBeregning;
import no.nav.domain.pensjon.regler.beregning.BeregningRelasjon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implementerer Iterator pattern for beregningstre. Bruker prefix traversering.
 * 
 * @author Steinar Hjellvik
 */
public class BeregningstreIterator implements Iterator<IBeregning> {

    private ArrayList<IBeregning> beregningsliste = new ArrayList<IBeregning>();
    private Iterator<IBeregning> iterator;

    /**
     * Rekursiv metode som prefix traverserer beregningstre og legger hver delberegning
     * funnet i beregningsliste. Toppnoden blir lagt på som første element.
     * 
     * @param beregning
     */
    private void prefixTraverser(IBeregning beregning) {
        List<BeregningRelasjon> delberegningsliste = beregning.getDelberegningsListe();

        if (delberegningsliste != null && !delberegningsliste.isEmpty()) {
            for (BeregningRelasjon beregningrelasjon : delberegningsliste) {
                IBeregning delberegning = beregningrelasjon.getIBeregning();
                if (delberegning != null) {
                    beregningsliste.add(delberegning);
                    prefixTraverser(delberegning);
                }
            }
        }
    }

    public BeregningstreIterator(IBeregning beregning) {
        if (beregning != null) {
            beregningsliste.add(beregning);
            prefixTraverser(beregning);
            iterator = beregningsliste.iterator();
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public IBeregning next() {
        return iterator.next();
    }

    @Override
    public void remove() {
        iterator.remove();
    }
}
