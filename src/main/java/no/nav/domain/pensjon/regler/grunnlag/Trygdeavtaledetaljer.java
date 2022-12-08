package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.BarnepensjonEOSKapittelCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Trygdeavtaledetaljer implements Serializable {

    /**
     * Angir om arbeidsinntekten er p� minst 1G p� uf�re-/d�dstidspunktet.
     */
    private Boolean arbeidsinntektMinst1G;
    /**
     * Liste med poeng�r i avtaleland av typen PoengarManuell
     */
    private List<PoengarManuell> poengarListe;
    /**
     * Faktisk trygdetid i andre E�S-land for alternativ pro rata beregning
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
     * Inntektspr�vet pensjon fra annet avtaleland
     */
    private Boolean inntektsprovetPensjonAvtaleland;
    /**
     * Art.10 anvendes p� grunnpensjon
     */
    private Boolean erArt10BruktGP;
    /**
     * Art.10 anvendes p� tilleggspensjon
     */
    private Boolean erArt10BruktTP;
    /**
     * Antall faktiske poeng�r i annet nordisk land
     */
    private int fpa_nordisk;
    /**
     * Angir hvilket kapittel (3 eller 8) i forordning 1408/71 barnepensjon skal beregnes etter ved E�S-saker.
     */
    private BarnepensjonEOSKapittelCti barnepensjonForordning1408_71;

}
