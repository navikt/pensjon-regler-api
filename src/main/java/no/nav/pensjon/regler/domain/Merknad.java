package no.nav.pensjon.regler.domain;

import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Liste med forklaringer, unntak og avvisningsgrunner. Merknader legges i
 * resultatet av et kall til en regeltjeneste.
 */
public class Merknad implements Serializable {

    private static final long serialVersionUID = -8747927112624332488L;

    /**
     * Identifiserer merknaden. Navnekonvensjonen er:
     * Regelsettnavn.regelnavn.index, der ".index" er en opsjon.
     */
    private String kode;

    /**
     * Beskrivende
     */
    private List<String> argumentListe;

    /**
     * Copy Constructor
     * 
     * @param merknad a <code>Merknad</code> object
     */
    public Merknad(Merknad merknad) {
        kode = merknad.kode;
        argumentListe = new ArrayList<String>(merknad.argumentListe);
    }

    public Merknad() {
        argumentListe = new ArrayList<String>();
    }

    /**
     * @return Returns the kode.
     */
    public String getKode() {
        return kode;
    }

    /**
     * @param kode
     *            The kode to set.
     */
    public void setKode(String kode) {
        this.kode = kode;
    }

    /**
     * @return Returns the argumentListe.
     */
    public List<String> getArgumentListe() {
        return argumentListe;
    }

    /**
     * @param argumentListe
     *            The argumentListe to set.
     */
    public void setArgumentListe(List<String> argumentListe) {
        this.argumentListe = argumentListe;
    }

    /**
     * @param arg
     *            The argument to add.
     */
    public void addArgument(String arg) {
        argumentListe.add(arg);
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
