package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Objektet representerer en periode som det er vurdert vilk�r for barnetillegg (p� uf�retrygd).
 * Objektet holder p� et sett av vilk�r som er relevante for perioden.
 * Disse benyttes videre i vilk�rspr�ving av barnetillegg.
 * 
 * @author Lars Hartvigsen (Decisive) - PK-20946
 */

public class BarnetilleggVurderingsperiode implements Serializable{
    private Date fomDato;
    private Date tomDato;
    private List<BarnetilleggVilkar> btVilkarListe;

}
