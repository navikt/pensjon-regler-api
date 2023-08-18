package no.nav.pensjon.regler.domain.vedtak;

import no.nav.pensjon.regler.domain.Merknad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Magnus Bakken (Accenture), PK-10597
 * @author Lars Hartviksen (Decisive), PK-6180
 */
public abstract class AbstraktBeregningsvilkar implements Serializable {

    private static final long serialVersionUID = 4276099703583366903L;

    protected List<Merknad> merknadListe;

    protected AbstraktBeregningsvilkar() {
        super();
        merknadListe = new ArrayList<Merknad>();
    }

    protected AbstraktBeregningsvilkar(AbstraktBeregningsvilkar abstraktBeregningsvilkar) {
        super();
        if(abstraktBeregningsvilkar.merknadListe != null) {
            merknadListe = new ArrayList<Merknad>();
            for(Merknad merknad:abstraktBeregningsvilkar.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    public Merknad[] retrieveMerknadListeAsArray(){
        return merknadListe != null ? merknadListe.toArray(new Merknad[merknadListe.size()]) : new Merknad[0];
    }

    /**
     * Metoden, når implementert i en klasse som implementerer abstraktberegningsvilkar skal returnere en kopi av input hvis den er av den implementerende klassen.
     * Dette gjør kopiering av lister av abstrakte beregningsvilkår lettere, og gjør at koden ikke kompilerer hvis implementasjon mangler.
     * Tidligere ble lister av abstrakte beregningsvilkår kopiert i BeregningsvilkarPeriode ved å sjekke om et gitt vilkår var av en gitt implementerende klasse,
     * for deretter å bruke denne klassens kopikonstruktør for å lage en kopi. Dette var imidlertid vanskelig å vedlikeholde, da man må oppdatere listekopieringen
     * i beregningsvilkarperiode for nye AbstraktBeregningsvilkar.
     *
     * @param abstraktBeregningsvilkar det abstrakte vilkaret som skal kopieres.
     * @return En dyp kopi av dette objektet hvis det er av samme klasse, ellers null.
     */
    public abstract AbstraktBeregningsvilkar dypKopi(AbstraktBeregningsvilkar abstraktBeregningsvilkar);

}
