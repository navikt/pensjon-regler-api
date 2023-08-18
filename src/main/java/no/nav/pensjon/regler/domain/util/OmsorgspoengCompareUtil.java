package no.nav.pensjon.regler.domain.util;

import no.nav.pensjon.regler.domain.Omsorgsopptjening;
import no.nav.pensjon.regler.domain.beregning2011.OpptjeningUT;

import java.util.Comparator;
import java.util.List;

/**
 * Klasse som holder på sammenligningsmetoder for
 * Omsorgspoeng og OmsorgspoengTrygdeavtale
 *
 * @author Lars Hartviksen (Decisive), PK-9695
 *         Date: 02.05.14
 *         Time: 11:54
 */
public class OmsorgspoengCompareUtil {

    public static class SynkendeArstallComparator implements Comparator<Omsorgsopptjening> {
        @Override
        public int compare(Omsorgsopptjening o1, Omsorgsopptjening o2) {
            return o2.getOpptjeningsar() - o1.getOpptjeningsar();
        }
    }

    public static class StigendeArstallComparator implements Comparator<Ref_pp> {
        @Override
        public int compare(Ref_pp o1, Ref_pp o2) {
            return o1.pt.getOpptjeningsar() - o2.pt.getOpptjeningsar();
        }
    }

    /**
     * Comparator for Poengtall
     * Den innebygde compareTo i Poengtall sorterer etter økende pp.
     * Denne metoden sorterer etter synkende pp.
     * JustertBelop er lagt til for å sikre at hvis Omsorgsopptjening er OpptjeningUT,
     * så sorteres disse på justertbelop etter at sorteringen er gjort på avkortetbeløp.
     * Ref: PKPYTON-1214
     * o1 < o2 hvis:
     * o1.avkortetBelop < o2.avkortetBelop
     * eller o1.avkortetBelop == o2.avkortetBelop og o1.justertBelop < o2.justertBelop
     * eller o1.avkortetBelop == o2.avkortetBelop og o1.justertBelop == o2.justertBelop og o1.ar < o2.ar
     * tilsvarende for o1 > o2.
     * o1 = o2 i sorteringen ellers.
     **/
    public static class PoengtallComparator implements Comparator<Omsorgsopptjening> {
        @Override
        public int compare(Omsorgsopptjening o1, Omsorgsopptjening o2) {
            if (o2.getVerdi() > o1.getVerdi()) {
                return 1;
            } else if (o2.getVerdi() < o1.getVerdi()) {
                return -1;
            }
            //OpptjeningUT kunne ikke distingveres på avkortetBelop.
            //Forsøker å sortere på justertBelop i stedet. Denne funksjonaliteten er med på å sikre at
            //vinnende kombinasjon har best mulig sum av justerte beløp for de tre beste årene.
            else if (o2.getJustertBelop() > o1.getJustertBelop()) {
                return 1;
            } else if (o2.getJustertBelop() < o1.getJustertBelop()) {
                return -1;
            }
            //OpptjeningUT kunne ikke distingveres på justertBelop heller. Sorter disse på dato.
            else {
                return o2.getOpptjeningsar() - o1.getOpptjeningsar();
            }
        }
    }

    /**
     * o1 < o2 hvis:
     * o1 ikke har ial og o2 har ial
     * eller hvis (o1 har ial hvis og bare hvis o2 har ial): o1.ar < o2.ar
     **/
    public abstract static class IalPoengtallComparator implements Comparator<Omsorgsopptjening> {

        @Override
        public int compare(Omsorgsopptjening o1, Omsorgsopptjening o2) {
            if (o2.isInntektIAvtaleland() && !o1.isInntektIAvtaleland()) {
                return 1;
            } else if (!o2.isInntektIAvtaleland() && o1.isInntektIAvtaleland()) {
                return -1;
            } else {
                return o2.getOpptjeningsar() - o1.getOpptjeningsar();
            }
        }
    }

    public static class IalPoengtallComparatorOmsorgsopptjeningTrygdeavtale extends IalPoengtallComparator {

        @Override
        public int compare(Omsorgsopptjening o1, Omsorgsopptjening o2) {
            return super.compare(o1, o2);
        }
    }

    /**
     * Comparator for IalPoengtall
     * IalPoengtall sorteres på en egen måte hvor 0.0 er best
     */
    public static class IalPoengtallComparatorOmsorgsopptjening extends IalPoengtallComparator {

        @Override
        public int compare(Omsorgsopptjening o1, Omsorgsopptjening o2) {
            if (o2.getVerdi() > o1.getVerdi()) {
                if (o1.isInntektIAvtaleland() && o1.getVerdi() == 0.0) {
                    return -1;
                }
                return 1;
            } else if (o2.getVerdi() < o1.getVerdi()) {
                if (o2.isInntektIAvtaleland() && o2.getVerdi() == 0.0) {
                    return 1;
                }
                return -1;
            }
            return super.compare(o1, o2);
        }
    }

    /**
     * Comparator for referert IalPoengtall
     */
    public static class IalRefppComparator implements Comparator<Ref_pp> {
        @Override
        public int compare(Ref_pp o1, Ref_pp o2) {
            return new IalPoengtallComparatorOmsorgsopptjening().compare(o1.pt, o2.pt);
        }
    }

    public static class StorrelseOgLeksikografiskArstallComparator implements Comparator<List<OpptjeningUT>> {
        @Override
        public int compare(List<OpptjeningUT> l1, List<OpptjeningUT> l2) {
            if (l1.size() != l2.size()) {
                return l2.size() - l1.size();
            }
            int i = 0;
            int j = 0;
            while (i < l1.size() && j < l2.size()) {
                if (l1.get(i).getOpptjeningsar() > l2.get(j).getOpptjeningsar()) {
                    return (-1);
                } else if (l1.get(i).getOpptjeningsar() < l2.get(j).getOpptjeningsar()) {
                    return (1);
                }
                //Case år på indeks i, j er samme år.
                i++;
                j++;
            }
            return 0;
        }
    }

    public abstract static class TreBesteComparator implements Comparator<Omsorgsopptjening> {

        protected final double nasjonaltSnitt;

        public TreBesteComparator(double nasjonaltSnitt) {
            this.nasjonaltSnitt = nasjonaltSnitt;
        }

        @Override
        public int compare(Omsorgsopptjening o1, Omsorgsopptjening o2) {
            //Hvis ikke brukt verdi er forskjellig, sorter på justert beløp.
            if (o2.getJustertBelop() > o1.getJustertBelop()) {
                return 1;
            } else if (o2.getJustertBelop() < o1.getJustertBelop()) {
                return -1;
            }
            //Hvis ikke justert beløp forskjellig, velg seneste opptjeningsår.
            else {
                return o2.getOpptjeningsar() - o1.getOpptjeningsar();
            }
        }
    }

    /**
     * Comparator for å finne hvilke år er de tre beste i denne kombinasjonen.
     */
    public static class UtvidetOmfangComparator extends TreBesteComparator {

        public UtvidetOmfangComparator(double nasjonaltSnitt) {
            super(nasjonaltSnitt);
        }

        @Override
        public int compare(Omsorgsopptjening o1, Omsorgsopptjening o2) {
            double o1BrukVerdi = o1.getVerdi();
            double o2BrukVerdi = o2.getVerdi();
            if (o1.getVerdi() == 0) {
                o1BrukVerdi = nasjonaltSnitt;
            }
            if (o2.getVerdi() == 0) {
                o2BrukVerdi = nasjonaltSnitt;
            }
            //Først så sorteres det på brukt verdi.
            if (o2BrukVerdi < o1BrukVerdi) {
                return -1;
            } else if (o1BrukVerdi < o2BrukVerdi) {
                return 1;
            }
            return super.compare(o1, o2);
        }
    }

    /**
     * Comparator for å finne hvilke år er de tre beste i denne kombinasjonen.
     */
    public static class OriginaltOmfangComparator extends TreBesteComparator {

        public OriginaltOmfangComparator(double nasjonaltSnitt) {
            super(nasjonaltSnitt);
        }

        @Override
        public int compare(Omsorgsopptjening o1, Omsorgsopptjening o2) {
            double o1BrukVerdi = o1.getVerdi();
            double o2BrukVerdi = o2.getVerdi();
            if (o1.isInntektIAvtaleland() && o1.getVerdi() < nasjonaltSnitt) {
                o1BrukVerdi = nasjonaltSnitt;
            }
            if (o2.isInntektIAvtaleland() && o2.getVerdi() < nasjonaltSnitt) {
                o2BrukVerdi = nasjonaltSnitt;
            }
            //Først så sorteres det på brukt verdi.
            if (o2BrukVerdi < o1BrukVerdi) {
                return -1;
            } else if (o1BrukVerdi < o2BrukVerdi) {
                return 1;
            }
            return super.compare(o1, o2);
        }
    }
}
