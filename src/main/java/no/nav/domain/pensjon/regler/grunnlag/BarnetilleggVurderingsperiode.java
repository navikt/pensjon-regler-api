package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Objektet representerer en periode som det er vurdert vilkår for barnetillegg (på uføretrygd).
 * Objektet holder på et sett av vilkår som er relevante for perioden.
 * Disse benyttes videre i vilkårsprøving av barnetillegg.
 * 
 * @author Lars Hartvigsen (Decisive) - PK-20946
 */

public class BarnetilleggVurderingsperiode implements Serializable{
    private Date fomDato;
    private Date tomDato;
    private List<BarnetilleggVilkar> btVilkarListe;

}
