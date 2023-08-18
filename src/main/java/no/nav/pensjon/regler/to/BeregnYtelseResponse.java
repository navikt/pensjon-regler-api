package no.nav.pensjon.regler.to;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning.Beregning;

/**
 * Klassen representerer hele resultatet fra et kall til en regeltjeneste for ytelsesberegning.
 */
public class BeregnYtelseResponse extends ServiceResponse {

	private static final long serialVersionUID = -3023598862987116732L;
	/**
	 * Pakkseddel for beregningene.
	 */
	private Pakkseddel pakkseddel = new Pakkseddel(true, true);
	/**
	 * En liste av beregninger som utgjør resultatet.
	 */
	private List <Beregning> beregningsListe = new Vector<Beregning>();

	public BeregnYtelseResponse(List<Beregning> beregningsListe) {
		super();
		this.beregningsListe = beregningsListe;
	}

	public BeregnYtelseResponse() {
		super();
		this.beregningsListe = new ArrayList<Beregning>();
	}

	public BeregnYtelseResponse(Pakkseddel pakkseddel, List <Beregning> beregningsListe) {
		super();
		this.pakkseddel = pakkseddel;
		this.beregningsListe = beregningsListe;
	}

	public List<Beregning> getBeregningsListe() {
		return beregningsListe;
	}

	/**
	 * Read only property for beregningsListe as array
	 * @return array of Beregning
	 */
	public Beregning[] getBeregningsListeAsArray() {
		return (beregningsListe != null ? this.beregningsListe.toArray(new Beregning[this.beregningsListe.size()]) : new Beregning[0]);
	}
	
	public void setBeregningsListe(List<Beregning> beregningsListe) {
		this.beregningsListe = beregningsListe;
	}
	public List<Beregning> getBeregningListe() {
		return beregningsListe;
	}

	public void setBeregningListe(List<Beregning> beregningsListe) {
		this.beregningsListe = beregningsListe;
	}
	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
}
