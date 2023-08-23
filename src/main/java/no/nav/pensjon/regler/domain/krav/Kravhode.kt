package no.nav.pensjon.regler.domain.krav

import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import no.nav.pensjon.regler.domain.grunnlag.Uttaksgrad
import no.nav.pensjon.regler.domain.kode.AfpOrdningTypeCti
import no.nav.pensjon.regler.domain.kode.KravVelgTypeCti
import no.nav.pensjon.regler.domain.kode.RegelverkTypeCti
import no.nav.pensjon.regler.domain.kode.SakTypeCti
import java.io.Serializable
import java.util.*

/**
 * Kravhode utgjør, sammen med en liste av VilkarsVedtak, hele inndata for
 * de fleste regeltjenestene.
 */
class Kravhode : Serializable {
    /**
     * Liste av personer som inngår som datagrunnlag.
     * nøyaktig en person i listen må ha rollen "SOKER".
     */
    var persongrunnlagListe: List<Persongrunnlag> = mutableListOf()

    /**
     * Liste av krav søkeren fremmer.
     */
    var kravlinjeListe: List<Kravlinje> = mutableListOf()

    /**
     * Angir type AFPordning.
     */
    var afpOrdning: AfpOrdningTypeCti? = null

    /**
     * Angir om søker skal ha afptillegg.
     */
    var afptillegg = false

    /**
     * Angir om opptjeningen fra det 65 året skal brukes som opptjening i det 66 år fram til brukeren fyller 70 år.
     * Settes av Regelmotoren første gang.
     */
    var brukOpptjeningFra65I66Aret = false

    /**
     * Angir detaljering i kravet,brukes i barnepensjon.
     */
    var kravVelgType: KravVelgTypeCti? = null

    /**
     * Angir om personen som kravet gjelder har bodd eller arbeidet utenlands:
     */
    var boddEllerArbeidetIUtlandet = false

    /**
     * Flagg som angir om brukerens far har bodd eller arbeidet i utlandet.
     */
    var boddArbeidUtlandFar = false

    /**
     * Flagg som angir om brukerens mor har bodd eller arbeidet i utlandet.
     */
    var boddArbeidUtlandMor = false

    /**
     * Flagg som angir om brukerens avdøde E/P/S har bodd eller arbeidet i utlandet.
     */
    var boddArbeidUtlandAvdod = false
    var uttaksgradListe: List<Uttaksgrad> = mutableListOf()
        set(value) {
            field = value
            sorterUttaksgradListe()
        }
    var regelverkTypeCti: RegelverkTypeCti? = null

    /**
     * Angir siste sakstype før overgang til AP.
     */
    var sisteSakstypeForAP: SakTypeCti? = null

    /*
	* Felt for å tre p_satsGP fra SisteAldersberegning2011.basispensjon.gp.p_satsGP  inn til BestemPsatsGPRS
	* i forbindelse med kall tilBER 3152 RevurderingOpptjening. Innført ifm PK15267/PEN6372
	 */
    var overstyrendeP_satsGP = 0.0

    /*
    * Angir om barnetilleggsgrunnlag er på nytt format (Gjelder per i dag uføretrygd).
     */
    var btVurderingsperiodeBenyttet = false

    /**
     * Sorterer på nyeste fomDato - denne blir uttaksgradListe.get(0)
     */
    private fun sorterUttaksgradListe() {
        Collections.sort(uttaksgradListe, Collections.reverseOrder())
    }
}