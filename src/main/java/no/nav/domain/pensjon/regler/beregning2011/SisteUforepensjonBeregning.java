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
     * Betinget: Hvis uf�regraden > 0, yrkesskadegrad < uf�regrad.
     */
    private Konverteringsgrunnlag konverteringsgrunnlagUforedel;

    /**
     * Betinget: Hvis uf�regraden > 0, yrkesskadegrad < uf�regrad.
     */
    private Konverteringsgrunnlag konverteringsgrunnlagYrkesskade;

    /**
     * Betinget: Hvis det fantes en folketrygdberegning(ikke n�dvendigvis vinnende) i UP
     */
    private AnvendtTrygdetid anvendtTrygdetidFolketrygd;

    /**
     * Hvorvidt utbetalt uf�repensjonen per 31.12.2014 ble definert som minstepensjon.
     */
    private MinstepensjonTypeCti minstepensjonType;

    /**
     * Hvorvidt utbetalt uf�repensjonen per 31.12.2014 ble manuelt overstyrt eller ikke.
     */
    private ResultatKildeCti resultatKilde;

    /**
     * Netto s�rtillegg i utbetalt uf�repensjonen per 31.12.2014.
     */
    private int sertilleggNetto;

}
