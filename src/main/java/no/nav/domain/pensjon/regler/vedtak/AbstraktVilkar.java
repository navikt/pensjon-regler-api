package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.kode.VilkarOppfyltUTCti;

import java.io.Serializable;

/**
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063
 */
public abstract class AbstraktVilkar implements Serializable {
    public AbstraktVilkar() {
    }

    private VilkarOppfyltUTCti resultat;



    protected AbstraktVilkar(AbstraktVilkar abstraktVilkar) {
        if (abstraktVilkar.resultat != null) {
            this.resultat = new VilkarOppfyltUTCti(abstraktVilkar.resultat);
        }
    }

    protected AbstraktVilkar(VilkarOppfyltUTCti resultat) {
        this.resultat = resultat;
    }

    public VilkarOppfyltUTCti getResultat() {
        return resultat;
    }

    public void setResultat(VilkarOppfyltUTCti resultat) {
        this.resultat = resultat;
    }

    /**
     * Metoden, n�r implementert i en klasse som implementerer abstraktvilkar skal returnere en kopi av input hvis den er av den implementerende klassen.
     * Dette gj�r kopiering av lister av abstrakte vilk�r lettere, og gj�r at koden ikke kompilerer hvis implementasjon mangler.
     * Tidligere ble lister av abstrakte vilk�r kopiert i BeregningsvilkarPeriode ved � sjekke om et gitt vilk�r var av en gitt implementerende klasse,
     * for deretter � bruke denne klassens kopikonstrukt�r for � lage en kopi. Dette var imidlertid vanskelig � vedlikeholde, da man m� oppdatere listekopieringen
     * i beregningsvilkarperiode for nye AbstrakteVilkar.
     *
     * @param abstraktVilkar det abstrakte vilkaret som skal kopieres.
     * @return En dyp kopi av dette objektet hvis det er av samme klasse, ellers null.
     */
    public abstract AbstraktVilkar dypKopi(AbstraktVilkar abstraktVilkar);
}
