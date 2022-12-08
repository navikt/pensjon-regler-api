package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class FremskrevetAfpLivsvarig extends AfpLivsvarig {
    

    private double reguleringsfaktor;
    private int gap;
    private double gjennomsnittligUttaksgradSisteAr;

    public FremskrevetAfpLivsvarig() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("FREM_AFP_LIVSVARIG");
    }


}
