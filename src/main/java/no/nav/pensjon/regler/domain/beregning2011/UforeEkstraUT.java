package no.nav.pensjon.regler.domain.beregning2011;


import no.nav.pensjon.regler.domain.beregning.BeregningUforeperiode;
import no.nav.pensjon.regler.domain.grunnlag.Uforeperiode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* Ekstra informasjon til beregnet uføretrygd. Brukes for at PREG skal beregne en uførehistorikk for uføretrygd.
 * 
 * @author Swiddy de Louw (Capgemini) - PK-10228
 */
public class UforeEkstraUT implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * Beregnede uføreperioder for uføretrygd.
     * Dette er uføreperioder som beregnes av PREG, og ligger ved beregningen for en uføretrygd.
     */

    private List<BeregningUforeperiode> beregnetUforeperiodeListe;

    /*
     * Default constructor
     */
    public UforeEkstraUT() {
        super();
        beregnetUforeperiodeListe = new ArrayList<BeregningUforeperiode>();
    }

    /*
     * Copy copnstructor
     */
    public UforeEkstraUT(UforeEkstraUT ue) {
        beregnetUforeperiodeListe = new ArrayList<BeregningUforeperiode>();
        if (ue.beregnetUforeperiodeListe != null) {
            for (BeregningUforeperiode bu : ue.beregnetUforeperiodeListe) {
                beregnetUforeperiodeListe.add(new BeregningUforeperiode(bu));
            }
        }
    }

    /**
     * @return the beregnetUforeperiodeListe
     */
    public List<BeregningUforeperiode> getBeregnetUforeperiodeListe() {
        return beregnetUforeperiodeListe;
    }

    /**
     * Read only property for BeregnetUforeperiodeListe as array.
     * 
     * @return array of BeregningUforeperiode
     */
    public BeregningUforeperiode[] getUforeperiodeListeAsArray() {
        return beregnetUforeperiodeListe != null ? beregnetUforeperiodeListe.toArray(new BeregningUforeperiode[beregnetUforeperiodeListe.size()]) : new BeregningUforeperiode[0];
    }

    /**
     * @param beregnetUforeperiodeListe the beregnetUforeperiodeListe to set
     */
    public void setBeregnetUforeperiodeListe(List<BeregningUforeperiode> beregnetUforeperiodeListe) {
        this.beregnetUforeperiodeListe = beregnetUforeperiodeListe;
    }

    /**
     * Metoden gjør det enkelt i regelmotor å adde en hel array til beregnetUforeperiodeListe.
     * I noen tilfeller er beregnetUforeperiodeListe fortsatt null og da instansieres listen.
     * 
     * @param ba the BeregningUforeperiode array to add to beregnetUforeperiodeListe
     */
    public void addArrayToBeregnetUforeperiodeListe(Uforeperiode[] upListe) {
        if (beregnetUforeperiodeListe == null) {
            beregnetUforeperiodeListe = new ArrayList<BeregningUforeperiode>();
        }
        for (Uforeperiode up : upListe) {
            beregnetUforeperiodeListe.add(new BeregningUforeperiode(up));
        }
    }
}
