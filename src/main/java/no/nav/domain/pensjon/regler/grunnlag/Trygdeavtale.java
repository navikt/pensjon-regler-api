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
     * Hva slags type avtale som er inng�tt. Se /2/, arkfane K_AVTALE_T.
     */
    private AvtaleTypeCti avtaleType;
    /**
     * Felt for � registrere n�r avtalen tro i kraft, hvis avtaletypen tilsier at
     * landet har flere mulige avtaler med Norge. Se /2/, arkfane K_AVTALE_DATO.
     */
    private AvtaleDatoCti avtaledato;
    /**
     * Felt for � registrere kriterier som er oppfylt for � omfattes av trygdeavtalen.
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

}
