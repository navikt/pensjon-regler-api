package no.nav.domain.pensjon.regler.kode;

/**
 * Dataholder for type regelendring til tjenesten BEF2001 Identifiser Regelendringer.
 * Er per tidspunkt for utvikling av tjenesten ikke en del av det offisielle kodeverket, kun en utility-klasse.
 * 
 * @author and2812
 */
public class RegelendringTypeCti extends TypeCti {



    public RegelendringTypeCti() {
        super();
    }

    public RegelendringTypeCti(String kode) {
        super(kode);
    }

    public RegelendringTypeCti(RegelendringTypeCti regelendringTypeCti) {
        super(regelendringTypeCti);
    }

}
