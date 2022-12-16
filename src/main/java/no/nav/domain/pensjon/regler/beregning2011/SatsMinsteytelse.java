package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.BorMedTypeCti;
import no.nav.domain.pensjon.regler.kode.MinsteytelseNivaCti;

import java.io.Serializable;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class SatsMinsteytelse implements Serializable {


    private double sats;

    private MinsteytelseNivaCti satsType;

    private BorMedTypeCti benyttetSivilstand;

    private boolean benyttetUngUfor;

    private boolean oppfyltUngUfor;

    /**
     * Angir om ung uføregaranti ikke er benyttet pga eksportforbud.
     */
    private boolean eksportForbudUngUfor;

}
