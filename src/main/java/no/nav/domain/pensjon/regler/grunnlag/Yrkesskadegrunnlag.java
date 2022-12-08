package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.YrkeYrkesskadeCti;

import java.io.Serializable;
import java.util.Date;

/**
 * Grunnlagsdata for yrkesskade. Denne er et tillegg til Uforegrunnlag. Hvis
 * dette objektet finnes (!=null) må det finnes et Uforegrunnlag. Dersom dette
 * objektet er null og Uforegrunnlaget != null betyr det at personen ikke har
 * yrkesskade.
 */
public class Yrkesskadegrunnlag implements Serializable {



    /**
     * Dato for skadetidspunkt.
     */
    private Date yst;

    /**
     * Uføregrad ved yrkesskade, heltall 0-100.Kan ikke være større enn
     * uføregraden(ufg).For avdød pga yrkesskade settes yug til 100.
     */
    private int yug;

    /**
     * Angir om yrkesskaden skyldes yrkessykdom.
     */
    private boolean yrkessykdom;

    /**
     * Det er en minimumsgaranti mht poengtall for som gjelder for spesielle
     * yrkesgrupper, f.eks fiskere,fangstmenn, militære,ungdom under utdanning
     * osv.
     */
    private YrkeYrkesskadeCti yrke;

    /**
     * Bruker forsørget av avdød iht paragraf 17-12.2
     */
    private boolean brukerForsorgetAvAvdod;

    /**
     * Antatt årlig inntekt på skadetidspunktet.
     */
    private int antattArligInntekt;

    /**
     * Angir om yrkesskadegrunnlaget brukes som grunnlag på kravet.
     */
    private boolean bruk;
}
