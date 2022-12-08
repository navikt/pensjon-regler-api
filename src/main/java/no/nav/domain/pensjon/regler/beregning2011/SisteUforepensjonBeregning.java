package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.Trygdetid;
import no.nav.domain.pensjon.regler.beregning.Ektefelletillegg;
import no.nav.domain.pensjon.regler.beregning.UforeEkstra;
import no.nav.domain.pensjon.regler.kode.MinstepensjonTypeCti;
import no.nav.domain.pensjon.regler.kode.ResultatKildeCti;
import no.nav.domain.pensjon.regler.trygdetid.AnvendtTrygdetid;

/**
 * @auhtor Magnus Bakken (Accenture) PK-9158
 * @author Aasmund Nordstoga (Accenture) PK-5549
 * @author Swiddy de Louw (Capgemini) PK-7113
 *
 */
public class SisteUforepensjonBeregning extends SisteBeregning {

    private Ektefelletillegg et;

    private Trygdetid tt;

    private UforeEkstra uforeEkstra;

    /**
     * Konverteringsgrunnlaget for brukers rettigheter
     */
    private Konverteringsgrunnlag konverteringsgrunnlagOrdinert;

    /**
     * Betinget, Konverteringsgrunnlag hvis gjenlevenderetten vant
     */
    private Konverteringsgrunnlag konverteringsgrunnlagGJT;

    /**
     * Betinget: Hvis uføregraden > 0, yrkesskadegrad < uføregrad.
     */
    private Konverteringsgrunnlag konverteringsgrunnlagUforedel;

    /**
     * Betinget: Hvis uføregraden > 0, yrkesskadegrad < uføregrad.
     */
    private Konverteringsgrunnlag konverteringsgrunnlagYrkesskade;

    /**
     * Betinget: Hvis det fantes en folketrygdberegning(ikke nødvendigvis vinnende) i UP
     */
    private AnvendtTrygdetid anvendtTrygdetidFolketrygd;

    /**
     * Hvorvidt utbetalt uførepensjonen per 31.12.2014 ble definert som minstepensjon.
     */
    private MinstepensjonTypeCti minstepensjonType;

    /**
     * Hvorvidt utbetalt uførepensjonen per 31.12.2014 ble manuelt overstyrt eller ikke.
     */
    private ResultatKildeCti resultatKilde;

    /**
     * Netto særtillegg i utbetalt uførepensjonen per 31.12.2014.
     */
    private int sertilleggNetto;

}
