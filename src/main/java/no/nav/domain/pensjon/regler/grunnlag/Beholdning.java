package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.Opptjening;
import no.nav.domain.pensjon.regler.beregning2011.LonnsvekstInformasjon;
import no.nav.domain.pensjon.regler.beregning2011.ReguleringsInformasjon;
import no.nav.domain.pensjon.regler.kode.BeholdningsTypeCti;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Beholdning implements Serializable {
    private int ar;
    private double totalbelop;
    private Opptjening opptjening;
    private LonnsvekstInformasjon lonnsvekstInformasjon;
    private ReguleringsInformasjon reguleringsInformasjon;
    private FormelKodeCti formelkode;

    protected BeholdningsTypeCti beholdningsType;
    private List<Merknad> merknadListe;

}
