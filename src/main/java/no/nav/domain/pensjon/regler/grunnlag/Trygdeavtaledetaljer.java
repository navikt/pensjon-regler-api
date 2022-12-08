package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.BarnepensjonEOSKapittelCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Trygdeavtaledetaljer implements Serializable {

    /**
     * Angir om arbeidsinntekten er på minst 1G på uføre-/dødstidspunktet.
     */
    private Boolean arbeidsinntektMinst1G;
    /**
     * Liste med poengår i avtaleland av typen PoengarManuell
     */
    private List<PoengarManuell> poengarListe;
    /**
     * Faktisk trygdetid i andre EØS-land for alternativ pro rata beregning
     */
    private AntallArOgMnd ftt_andreEOSLand;
    /**
     * Faktisk trygdetid garantitillegg
     */
    private AntallArOgMnd ftt_garanti;
    /**
     * Faktisk trygdetid annet nordisk land
     */
    private AntallArOgMnd ftt_annetNordiskLand;
    /**
     * Sum pensjon i andre avtaleland
     */
    private int sumPensjonAndreAvtaleland;
    /**
     * Inntektsprøvet pensjon fra annet avtaleland
     */
    private Boolean inntektsprovetPensjonAvtaleland;
    /**
     * Art.10 anvendes på grunnpensjon
     */
    private Boolean erArt10BruktGP;
    /**
     * Art.10 anvendes på tilleggspensjon
     */
    private Boolean erArt10BruktTP;
    /**
     * Antall faktiske poengår i annet nordisk land
     */
    private int fpa_nordisk;
    /**
     * Angir hvilket kapittel (3 eller 8) i forordning 1408/71 barnepensjon skal beregnes etter ved EØS-saker.
     */
    private BarnepensjonEOSKapittelCti barnepensjonForordning1408_71;

}
