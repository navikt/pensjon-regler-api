package no.nav.domain.pensjon.regler.krav;

import no.nav.domain.pensjon.regler.grunnlag.Persongrunnlag;
import no.nav.domain.pensjon.regler.grunnlag.Uttaksgrad;
import no.nav.domain.pensjon.regler.kode.AfpOrdningTypeCti;
import no.nav.domain.pensjon.regler.kode.KravVelgTypeCti;
import no.nav.domain.pensjon.regler.kode.RegelverkTypeCti;
import no.nav.domain.pensjon.regler.kode.SakTypeCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Kravhode utgj�r, sammen med en liste av VilkarsVedtak, hele inndata for
 * de fleste regeltjenestene.
 *
 * @author Magnus Bakken (Accenture), PK-10597
 * @author Dag Brenna (Accenture), PK-15267
 */
public class Kravhode implements Serializable {

    /**
     * Liste av personer som inng�r som datagrunnlag.
     * N�yaktig en person i listen m� ha rollen "SOKER".
     */
    private List<Persongrunnlag> persongrunnlagListe;

    /**
     * Liste av krav s�keren fremmer.
     */
    private List<Kravlinje> kravlinjeListe;
    /**
     * Angir type AFPordning.
     */
    private AfpOrdningTypeCti afpOrdning;

    /**
     * Angir om s�ker skal ha afptillegg.
     */
    private boolean afptillegg;
    /*
     * Angir om opptjeningen fra det 65 �ret skal brukes som opptjening i det 66 �r fram til brukeren fyller 70 �r.
     * Settes av Regelmotoren f�rste gang.
     */
    private boolean brukOpptjeningFra65I66Aret;
    /**
     * Angir detaljering i kravet,brukes i barnepensjon.
     */
    private KravVelgTypeCti kravVelgType;

    /**
     * Angir om personen som kravet gjelder har bodd eller arbeidet utenlands:
     */
    private boolean boddEllerArbeidetIUtlandet;

    /**
     * Flagg som angir om brukerens far har bodd eller arbeidet i utlandet.
     */
    private boolean boddArbeidUtlandFar;

    /**
     * Flagg som angir om brukerens mor har bodd eller arbeidet i utlandet.
     */
    private boolean boddArbeidUtlandMor;

    /**
     * Flagg som angir om brukerens avd�de E/P/S har bodd eller arbeidet i utlandet.
     */
    private boolean boddArbeidUtlandAvdod;

    private List<Uttaksgrad> uttaksgradListe;

    private RegelverkTypeCti regelverkTypeCti;
    /**
     * Angir siste sakstype f�r overgang til AP.
     */
    private SakTypeCti sisteSakstypeForAP;

	/*
	* Felt for � tre p_satsGP fra SisteAldersberegning2011.basispensjon.gp.p_satsGP  inn til BestemPsatsGPRS
	* i forbindelse med kall tilBER 3152 RevurderingOpptjening. Innf�rt ifm PK15267/PEN6372
	 */
	private double overstyrendeP_satsGP;

    /*
    * Angir om barnetilleggsgrunnlag er p� nytt format (Gjelder per i dag uf�retrygd).
     */
    private boolean btVurderingsperiodeBenyttet;

}
