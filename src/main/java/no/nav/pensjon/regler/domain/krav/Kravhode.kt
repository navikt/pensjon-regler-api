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
    var isAfptillegg = false

    /**
     * Angir om opptjeningen fra det 65 året skal brukes som opptjening i det 66 år fram til brukeren fyller 70 år.
     * Settes av Regelmotoren første gang.
     */
    var isBrukOpptjeningFra65I66Aret = false

    /**
     * Angir detaljering i kravet,brukes i barnepensjon.
     */
    var kravVelgType: KravVelgTypeCti? = null

    /**
     * Angir om personen som kravet gjelder har bodd eller arbeidet utenlands:
     */
    var isBoddEllerArbeidetIUtlandet = false

    /**
     * Flagg som angir om brukerens far har bodd eller arbeidet i utlandet.
     */
    var isBoddArbeidUtlandFar = false

    /**
     * Flagg som angir om brukerens mor har bodd eller arbeidet i utlandet.
     */
    var isBoddArbeidUtlandMor = false

    /**
     * Flagg som angir om brukerens avdøde E/P/S har bodd eller arbeidet i utlandet.
     */
    var isBoddArbeidUtlandAvdod = false
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

    /**
     * Angir om ektefellen mottar pensjon.
     * Innført ifm CR140475. BeregnYtelse blir kalt med flagget ektefelleMottarPensjon i Request-objektet.
     * Det flagget blir overfårt til PREG_epsMottarPensjon i startBeregnYtelse slik at det blir med inn
     * til initPREG(kravhode, ..). initPREG utvides til å kalle en ny funksjon settEpsMottarPensjon som
     * setter flagget tilknyttet.mottarPensjon lik ektefelleMottarPensjon i Request-objektet.
     * Dermed kan regelsettet TilknyttetHarPensjonRS i støttefunksjoner kun bytte innholdet til å bruke
     * tilknyttet.mottarPensjon istedet for å se etter PENF inntekt osv.
     */
    var isPREG_epsMottarPensjon = false

    /*
	* Felt for å tre p_satsGP fra SisteAldersberegning2011.basispensjon.gp.p_satsGP  inn til BestemPsatsGPRS
	* i forbindelse med kall tilBER 3152 RevurderingOpptjening. Innført ifm PK15267/PEN6372
	 */
    var overstyrendeP_satsGP = 0.0

    /*
    * Angir om barnetilleggsgrunnlag er på nytt format (Gjelder per i dag uføretrygd).
     */
    var isBtVurderingsperiodeBenyttet = false

    /**
     * Sorterer på nyeste fomDato - denne blir uttaksgradListe.get(0)
     */
    private fun sorterUttaksgradListe() {
        Collections.sort(uttaksgradListe, Collections.reverseOrder())
    }
}