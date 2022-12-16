package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.EksportlandCti;

import java.io.Serializable;

public class Eksportrett implements Serializable {



    /**
     * Angir om personen har eksportrett eller ikke.
     */
    private boolean eksportrett;

    /**
     * Angir land personen bor i.
     */
    EksportlandCti bostedsland;

}
