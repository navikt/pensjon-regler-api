package no.nav.domain.pensjon.regler;

import no.nav.domain.pensjon.regler.beregning.BeregningRelasjon;

import java.util.List;

/**
 * Felles interface for Beregning og Beregning2011 klasser.
 * 
 * @author Tore Engvig
 * @author Ørnulf Moen
 * @author Steinar Hjellvik
 */
public interface IBeregning {
    //	public List<BeregningNode> hentUndernodeliste();
    //	public BeregningNode hentForeldrenode();
    //	public boolean erToppnode();
    //	public boolean erLovNode();
    public List<BeregningRelasjon> getDelberegningsListe();
}
