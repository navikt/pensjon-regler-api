package no.nav.pensjon.regler.domain.util;

import no.nav.pensjon.regler.domain.Omsorgsopptjening;

/**
 * Created with IntelliJ IDEA.
 * User: h135685
 * Date: 01.04.14
 * Time: 10:59
 * To change this template use File | Settings | File Templates.
 */
public class Ref_pp implements Comparable<Ref_pp> {
    Omsorgsopptjening pt;
    double poengtall;
    int antall�r;
    boolean omsorg;
    boolean erDummy;

    Ref_pp(Omsorgsopptjening pt, double verdi, int i, boolean omsorg, boolean dummy) {
        this.pt = pt;
        poengtall = verdi;
        antall�r = i;
        this.omsorg = omsorg;
        this.erDummy = dummy;
    }

    @Override
    public int compareTo(Ref_pp o) {
        if (poengtall > o.poengtall) {
            return -1;
        } else if (poengtall < o.poengtall) {
            return 1;
        } else if (o.pt.getJustertBelop() > pt.getJustertBelop()) {
            return 1;
        } else if (o.pt.getJustertBelop() < pt.getJustertBelop()) {
            return -1;
        } else {
            return o.pt.getOpptjeningsar() - pt.getOpptjeningsar();
        }
    }
}