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
 * Kravhode utgjør, sammen med en liste av VilkarsVedtak, hele inndata for
 * de fleste regeltjenestene.
 *
 * @author Magnus Bakken (Accenture), PK-10597
 * @author Dag Brenna (Accenture), PK-15267
 */
public class Kravhode implements Serializable {

    /**
     * Liste av personer som inngår som datagrunnlag.
     * Nøyaktig en person i listen må ha rollen "SOKER".
     */
    private List<Persongrunnlag> persongrunnlagListe;

    /**
     * Liste av krav søkeren fremmer.
     */
    private List<Kravlinje> kravlinjeListe;
    /**
     * Angir type AFPordning.
     */
    private AfpOrdningTypeCti afpOrdning;

    /**
     * Angir om søker skal ha afptillegg.
     */
    private boolean afptillegg;
    /*
     * Angir om opptjeningen fra det 65 året skal brukes som opptjening i det 66 år fram til brukeren fyller 70 år.
     * Settes av Regelmotoren første gang.
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
     * Flagg som angir om brukerens avdøde E/P/S har bodd eller arbeidet i utlandet.
     */
    private boolean boddArbeidUtlandAvdod;

    private List<Uttaksgrad> uttaksgradListe;

    private RegelverkTypeCti regelverkTypeCti;
    /**
     * Angir siste sakstype før overgang til AP.
     */
    private SakTypeCti sisteSakstypeForAP;

	/*
	* Felt for å tre p_satsGP fra SisteAldersberegning2011.basispensjon.gp.p_satsGP  inn til BestemPsatsGPRS
	* i forbindelse med kall tilBER 3152 RevurderingOpptjening. Innført ifm PK15267/PEN6372
	 */
	private double overstyrendeP_satsGP;

    /*
    * Angir om barnetilleggsgrunnlag er på nytt format (Gjelder per i dag uføretrygd).
     */
    private boolean btVurderingsperiodeBenyttet;

}
