package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.beregning.Sluttpoengtall;
import no.nav.domain.pensjon.regler.kode.BeregningMetodeTypeCti;
import no.nav.domain.pensjon.regler.kode.JustertPeriodeCti;
import no.nav.domain.pensjon.regler.kode.LandCti;
import no.nav.domain.pensjon.regler.kode.ResultatTypeCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BeregningsInformasjon implements Serializable {

    //Fra IBeregningsInformasjon2011
    private double forholdstallUttak;
    private double forholdstall67;
    private double delingstallUttak;
    private double delingstall67;
    private Sluttpoengtall spt;
    private Sluttpoengtall opt;
    private Sluttpoengtall ypt;
    private boolean grunnpensjonAvkortet = false;
    private List<Merknad> gpAvkortingsArsakList = new ArrayList<Merknad>();
    private boolean mottarMinstePensjonsniva;
    private String minstepensjonArsak;
    private boolean rettPaGjenlevenderett;
    private boolean gjenlevenderettAnvendt;
    private boolean avdodesTilleggspensjonBrukt;
    private boolean avdodesTrygdetidBrukt;
    private boolean ungUfor;
    private boolean ungUforAnvendt;
    private boolean yrkesskadeRegistrert;
    private boolean yrkesskadeAnvendt;
    private int yrkesskadegrad;

    // Fra IBeregningsInformasjon
    private PenPerson penPerson;
    private BeregningMetodeTypeCti beregningsMetode;
    private boolean eksport;
    private ResultatTypeCti resultatType;
    private List<TapendeBeregningsmetode> tapendeBeregningsmetodeListe = new ArrayList<TapendeBeregningsmetode>();
    private Integer trygdetid;
    private int tt_anv;
    private LandCti vurdertBosattland;
    private boolean ensligPensjonInstOpph;
    private JustertPeriodeCti instOppholdType;
    private boolean instOpphAnvendt;
    // Avdødes tilleggspensjon
    private double tp;
    private int ttBeregnetForGrunnlagsrolle;

    private boolean ungUforGarantiFrafalt;


}
