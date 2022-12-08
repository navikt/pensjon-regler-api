package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.AvtaleDatoCti;
import no.nav.domain.pensjon.regler.kode.AvtaleKritCti;
import no.nav.domain.pensjon.regler.kode.AvtaleTypeCti;
import no.nav.domain.pensjon.regler.kode.LandCti;

import java.io.Serializable;
import java.util.Date;

public class Trygdeavtale implements Serializable {

    
    /**
     * Hvilket land personen bor i. Se /2/, arkfane K_AVTALELAND_T
     */
    private LandCti bostedsland;
    /**
     * Hva slags type avtale som er inngått. Se /2/, arkfane K_AVTALE_T.
     */
    private AvtaleTypeCti avtaleType;
    /**
     * Felt for å registrere når avtalen tro i kraft, hvis avtaletypen tilsier at
     * landet har flere mulige avtaler med Norge. Se /2/, arkfane K_AVTALE_DATO.
     */
    private AvtaleDatoCti avtaledato;
    /**
     * Felt for å registrere kriterier som er oppfylt for å omfattes av trygdeavtalen.
     * Se /2/, arkfane K_AVTALE_KRIT_T.
     */
    private AvtaleKritCti avtaleKriterie;
    /**
     * Angir om personen omfattes av avtalens personkrets
     */
    private boolean omfattesavAvtalensPersonkrets;
    /**
     * Dato for kravdato i avtale
     */
    private Date kravDatoIAvtaleland;

    /**
     * Copy Constructor
     * 
     * @param trygdeavtale a <code>Trygdeavtale</code> object
     */
    public Trygdeavtale(Trygdeavtale trygdeavtale) {
        if (trygdeavtale.bostedsland != null) {
            bostedsland = new LandCti(trygdeavtale.bostedsland);
        }
        if (trygdeavtale.avtaleType != null) {
            avtaleType = new AvtaleTypeCti(trygdeavtale.avtaleType);
        }
        if (trygdeavtale.avtaledato != null) {
            avtaledato = new AvtaleDatoCti(trygdeavtale.avtaledato);
        }
        if (trygdeavtale.avtaleKriterie != null) {
            avtaleKriterie = new AvtaleKritCti(trygdeavtale.avtaleKriterie);
        }
        omfattesavAvtalensPersonkrets = trygdeavtale.omfattesavAvtalensPersonkrets;
        if (trygdeavtale.kravDatoIAvtaleland != null) {
            kravDatoIAvtaleland = (Date) trygdeavtale.kravDatoIAvtaleland.clone();
        }
    }

    public Trygdeavtale() {
        super();
    }

    public Trygdeavtale(LandCti bostedsland, AvtaleTypeCti avtaleType, AvtaleDatoCti avtaledato, AvtaleKritCti avtaleKriterie, boolean omfattesavAvtalensPersonkrets,
                        Date kravDatoIAvtaleland) {
        super();
        this.bostedsland = bostedsland;
        this.avtaleType = avtaleType;
        this.avtaledato = avtaledato;
        this.avtaleKriterie = avtaleKriterie;
        this.omfattesavAvtalensPersonkrets = omfattesavAvtalensPersonkrets;
        this.kravDatoIAvtaleland = kravDatoIAvtaleland;
    }

    public AvtaleDatoCti getAvtaledato() {
        return avtaledato;
    }

    public void setAvtaledato(AvtaleDatoCti avtaledato) {
        this.avtaledato = avtaledato;
    }

    public AvtaleKritCti getAvtaleKriterie() {
        return avtaleKriterie;
    }

    public void setAvtaleKriterie(AvtaleKritCti avtaleKriterie) {
        this.avtaleKriterie = avtaleKriterie;
    }

    public AvtaleTypeCti getAvtaleType() {
        return avtaleType;
    }

    public void setAvtaleType(AvtaleTypeCti avtaleType) {
        this.avtaleType = avtaleType;
    }

    public LandCti getBostedsland() {
        return bostedsland;
    }

    public void setBostedsland(LandCti bostedsland) {
        this.bostedsland = bostedsland;
    }

    public Date getKravDatoIAvtaleland() {
        return kravDatoIAvtaleland;
    }

    public void setKravDatoIAvtaleland(Date kravDatoIAvtaleland) {
        this.kravDatoIAvtaleland = kravDatoIAvtaleland;
    }

    public boolean isOmfattesavAvtalensPersonkrets() {
        return omfattesavAvtalensPersonkrets;
    }

    public void setOmfattesavAvtalensPersonkrets(boolean omfattesavAvtalensPersonkrets) {
        this.omfattesavAvtalensPersonkrets = omfattesavAvtalensPersonkrets;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     * 
     * @return a <code>String</code> representation
     *         of this object.
     */
    @Override
    public String toString() {
        final String TAB = "    ";

        StringBuilder retValue = new StringBuilder();

        retValue.append("Trygdeavtale ( ").append(super.toString()).append(TAB).append("bostedsland = ").append(bostedsland).append(TAB).append("avtaleType = ").append(avtaleType)
                .append(TAB).append("avtaledato = ").append(avtaledato).append(TAB).append("avtaleKriterie = ").append(avtaleKriterie).append(TAB)
                .append("omfattesavAvtalensPersonkrets = ").append(omfattesavAvtalensPersonkrets).append(TAB).append("kravDatoIAvtaleland = ").append(kravDatoIAvtaleland)
                .append(TAB).append(" )");

        return retValue.toString();
    }

}
