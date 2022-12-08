package no.nav.domain.pensjon.regler;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Liste med forklaringer, unntak og avvisningsgrunner. Merknader legges i
 * resultatet av et kall til en regeltjeneste.
 */
public class Merknad implements Serializable {

    

    /**
     * Identifiserer merknaden. Navnekonvensjonen er:
     * Regelsettnavn.regelnavn.index, der ".index" er en opsjon.
     */
    private String kode;

    /**
     * Beskrivende
     */
    private List<String> argumentListe;


}
