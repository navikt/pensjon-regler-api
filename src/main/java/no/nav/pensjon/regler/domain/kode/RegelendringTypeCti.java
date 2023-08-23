package no.nav.pensjon.regler.domain.kode;

/**
 * Dataholder for type regelendring til tjenesten BEF2001 Identifiser Regelendringer.
 * Er per tidspunkt for utvikling av tjenesten ikke en del av det offisielle kodeverket, kun en utility-klasse.
 */
public class RegelendringTypeCti extends TypeCti {

    private static final long serialVersionUID = -1688022988891041840L;

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
