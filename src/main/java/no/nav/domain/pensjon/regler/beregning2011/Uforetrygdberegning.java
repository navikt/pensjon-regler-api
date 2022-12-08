package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.kode.JustertPeriodeCti;
import no.nav.domain.pensjon.regler.kode.YtelseVedDodCti;
import no.nav.domain.pensjon.regler.trygdetid.Brok;

import java.util.Date;

/**
 * @author Swiddy de Louw (Capgemini) - PK-10228
 * @author Aasmund Nordstoga (Accenture) - PKFEIL-2605
 * @author Steinar Hjellvik (Decisive) - PK-11391
 * @author Lars Hartvigsen (Decisive) - PK-12169
 * @author Nabil Safadi (Decisive) - PK-8518
 */
public class Uforetrygdberegning extends Beregning2011 {

    private int bruttoPerAr;

    private FormelKodeCti formelKode;

    private int grunnbelop;

    private Minsteytelse minsteytelse;

    private Brok prorataBrok;

    private int uforegrad;

    private Date uforetidspunkt;

    private EgenopptjentUforetrygd egenopptjentUforetrygd;

    private boolean egenopptjentUforetrygdBest;

    private int yrkesskadegrad;

    private Date yrkesskadetidspunkt;

    private boolean mottarMinsteytelse;

    /* Bygger opp �rsakskoder som viser hvorfor personen mottar minsteytelse */
    private String minsteytelseArsak;

    /* Viser hvilken type institusjonsopphold det er beregnet for. Kodene hentes fra K_JUST_PERIODE */
    private JustertPeriodeCti instOppholdType;

    /* Angir om ytelsen er endret, enten  �kt eller redusert. */
    private boolean instOpphAnvendt;

    /*
     * Ekstra informasjon til beregnet uf�retrygd.
     * Brukes for at PREG skal beregne en uf�rehistorikk for uf�retrygd.
     */
    private UforeEkstraUT uforeEkstra;

    /**
     * Satt p� de beregninger hvor avd�des ytelse har p�virket beregningen.
     */
    private YtelseVedDodCti ytelseVedDod;


}
