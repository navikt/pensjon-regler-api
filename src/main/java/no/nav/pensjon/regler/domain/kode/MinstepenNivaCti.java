package no.nav.pensjon.regler.domain.kode;

public class MinstepenNivaCti extends TypeCti {

    /**
	 * 
	 */
    private static final long serialVersionUID = 726844924501195949L;

    public MinstepenNivaCti() {
        super();
    }

    public MinstepenNivaCti(String kode) {
        super(kode);
    }

    public MinstepenNivaCti(MinstepenNivaCti minstepensjonTypeCti) {
        super(minstepensjonTypeCti);
    }
}
