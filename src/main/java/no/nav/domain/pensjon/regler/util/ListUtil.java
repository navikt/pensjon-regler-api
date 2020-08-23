package no.nav.domain.pensjon.regler.util;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.TTPeriode;
import no.nav.domain.pensjon.regler.afpoppgjor.AfpUtbetalingsperiode;
import no.nav.domain.pensjon.regler.beregning.Poengtall;
import no.nav.domain.pensjon.regler.beregning2011.BeregnetUtbetalingsperiode;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsvilkarPeriode;
import no.nav.domain.pensjon.regler.beregning2011.Regelendring;
import no.nav.domain.pensjon.regler.grunnlag.*;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;
import no.stelvio.common.util.DateUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ListUtil {
    public static Poengtall[] kopierPoengtallListToArray(List<Poengtall> innPoengtallListe) {
        return kopierPoengtallListToList(innPoengtallListe).toArray(new Poengtall[] {});
    }

    public static List<VilkarsVedtak> kopierVilkarsVedtakArrayToList(VilkarsVedtak[] innVilkarsVedtakArray) {
        return kopierVilkarsVedtakListToList(Arrays.asList(innVilkarsVedtakArray));
    }

    public static List<Poengtall> kopierPoengtallArrayToList(Poengtall[] innPoengtallArray) {
        return kopierPoengtallListToList(Arrays.asList(innPoengtallArray));
    }

    public static List<Merknad> kopierMerknadArrayToList(Merknad[] innMerknadArray) {
        return kopierMerknadListToList(Arrays.asList(innMerknadArray));
    }

    public static List<VilkarsVedtak> kopierVilkarsVedtakListToList(List<VilkarsVedtak> innVilkarsVedtakListe) {
        List<VilkarsVedtak> vilkarsVedtakList = new ArrayList<VilkarsVedtak>();
        for (VilkarsVedtak vilkarsVedtak : innVilkarsVedtakListe) {
            vilkarsVedtakList.add(new VilkarsVedtak(vilkarsVedtak));
        }
        return vilkarsVedtakList;
    }

    public static List<Poengtall> kopierPoengtallListToList(List<Poengtall> innPoengtallListe) {
        List<Poengtall> poengtallList = new ArrayList<Poengtall>();
        for (Poengtall poengtall : innPoengtallListe) {
            poengtallList.add(new Poengtall(poengtall));
        }
        return poengtallList;
    }

    public static List<Merknad> kopierMerknadListToList(List<Merknad> innMerknadListe) {
        List<Merknad> merknadList = new ArrayList<Merknad>();
        for (Merknad merknad : innMerknadListe) {
            merknadList.add(new Merknad(merknad));
        }
        return merknadList;
    }

    public static InstOpphPeriodegrunnlag[] sorterInstOpphPeriodegrunnlagListeAsArray(InstOpphPeriodegrunnlag[] innInstOpphListe) {
        ArrayList<InstOpphPeriodegrunnlag> sortedInstOpph = new ArrayList<InstOpphPeriodegrunnlag>(Arrays.asList(innInstOpphListe));
        Collections.sort(sortedInstOpph, Collections.reverseOrder());
        return sortedInstOpph.toArray(new InstOpphPeriodegrunnlag[0]);
    }

    public static Uforeperiode[] sorterUforeperiodeListeAsArray(Uforeperiode[] innUforeperiodeListe) {
        ArrayList<Uforeperiode> sortedUforeperiodeListe = new ArrayList<Uforeperiode>(Arrays.asList(innUforeperiodeListe));
        Collections.sort(sortedUforeperiodeListe);
        return sortedUforeperiodeListe.toArray(new Uforeperiode[0]);
    }

    public static AfpHistorikk[] sorterAfpHistorikkListeAsArray(AfpHistorikk[] innAfpHistorikkListe) {
        ArrayList<AfpHistorikk> sortedAfpHistorikkListe = new ArrayList<AfpHistorikk>(Arrays.asList(innAfpHistorikkListe));
        Collections.sort(sortedAfpHistorikkListe);
        return sortedAfpHistorikkListe.toArray(new AfpHistorikk[0]);
    }

    public static PersonDetalj[] sorterPersonDetaljListeAsArray(PersonDetalj[] innPersonDetaljListe) {
        ArrayList<PersonDetalj> sortedPersonDetaljListe = new ArrayList<PersonDetalj>(Arrays.asList(innPersonDetaljListe));
        Collections.sort(sortedPersonDetaljListe);
        return sortedPersonDetaljListe.toArray(new PersonDetalj[0]);
    }

    public static Inntektsgrunnlag[] sorterInntektsgrunnlagListeAsArray(Inntektsgrunnlag[] innInntektsgrunnlagListe) {
        ArrayList<Inntektsgrunnlag> sortedInntektsgrunnlagListe = new ArrayList<Inntektsgrunnlag>(Arrays.asList(innInntektsgrunnlagListe));
        Collections.sort(sortedInntektsgrunnlagListe);
        return sortedInntektsgrunnlagListe.toArray(new Inntektsgrunnlag[0]);
    }

    public static Opptjeningsgrunnlag[] sorterOpptjeningsgrunnlagListeAsArray(Opptjeningsgrunnlag[] innOpptjeningsgrunnlagListe) {
        ArrayList<Opptjeningsgrunnlag> sortedOpptjeningsgrunnlagListe = new ArrayList<Opptjeningsgrunnlag>(Arrays.asList(innOpptjeningsgrunnlagListe));
        Collections.sort(sortedOpptjeningsgrunnlagListe);
        return sortedOpptjeningsgrunnlagListe.toArray(new Opptjeningsgrunnlag[0]);
    }

    public static TTPeriode[] sorterTTPeriodeListeAsArray(TTPeriode[] innTTPeriodeListe) {
        ArrayList<TTPeriode> sortedTTPeriodeListe = new ArrayList<TTPeriode>(Arrays.asList(innTTPeriodeListe));
        Collections.sort(sortedTTPeriodeListe);
        return sortedTTPeriodeListe.toArray(new TTPeriode[0]);
    }

    public static InstOpphReduksjonsperiode[] sorterInstOpphReduksjonsperiodeListeAsArray(InstOpphReduksjonsperiode[] innInstOpphReduksjonsperiodeListe) {
        ArrayList<InstOpphReduksjonsperiode> sortedInstOpphReduksjonsperiodeListe = new ArrayList<InstOpphReduksjonsperiode>(Arrays.asList(innInstOpphReduksjonsperiodeListe));
        Collections.sort(sortedInstOpphReduksjonsperiodeListe);
        return sortedInstOpphReduksjonsperiodeListe.toArray(new InstOpphReduksjonsperiode[0]);
    }

    public static InstOpphFasteUtgifterperiode[] sorterInstOpphFasteUtgifterperiodeListeAsArray(InstOpphFasteUtgifterperiode[] innInstOpphFasteUtgifterperiodeListe) {
        ArrayList<InstOpphFasteUtgifterperiode> sortedInstOpphFasteUtgifterperiodeListe = new ArrayList<InstOpphFasteUtgifterperiode>(
                Arrays.asList(innInstOpphFasteUtgifterperiodeListe));
        Collections.sort(sortedInstOpphFasteUtgifterperiodeListe);
        return sortedInstOpphFasteUtgifterperiodeListe.toArray(new InstOpphFasteUtgifterperiode[0]);
    }

    public static PoengarManuell[] sorterPoengarManuellListeAsArray(PoengarManuell[] innPoengarManuellListe) {
        ArrayList<PoengarManuell> sortedPoengarManuellListe = new ArrayList<PoengarManuell>(Arrays.asList(innPoengarManuellListe));
        Collections.sort(sortedPoengarManuellListe);
        return sortedPoengarManuellListe.toArray(new PoengarManuell[0]);
    }

    public static AfpUtbetalingsperiode[] sorterAfpUtbetalingsperiodeListeAsArray(AfpUtbetalingsperiode[] innAfpUtbetalingsperiodeListe) {
        ArrayList<AfpUtbetalingsperiode> sortedAfpUtbetalingsperiodeListe = new ArrayList<AfpUtbetalingsperiode>(Arrays.asList(innAfpUtbetalingsperiodeListe));
        Collections.sort(sortedAfpUtbetalingsperiodeListe);
        return sortedAfpUtbetalingsperiodeListe.toArray(new AfpUtbetalingsperiode[0]);
    }

    public static VilkarsVedtak[] sorterVilkarsVedtakListeAsArray(VilkarsVedtak[] innVilkarsVedtakListe) {
        ArrayList<VilkarsVedtak> sortedVilkarsVedtakListe = new ArrayList<VilkarsVedtak>(Arrays.asList(innVilkarsVedtakListe));
        Collections.sort(sortedVilkarsVedtakListe);
        return sortedVilkarsVedtakListe.toArray(new VilkarsVedtak[0]);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Comparable[] sorterListeAsArray(Comparable[] innListe) {
        ArrayList<Comparable> sortedListe = new ArrayList<Comparable>(Arrays.asList(innListe));
        Collections.sort(sortedListe);
        return sortedListe.toArray(new Comparable[0]);
    }

    public static Regelendring[] sorterRegelendringListeAsArray(Regelendring[] innRegelendringListe) {
        ArrayList<Regelendring> sortedRegelendringListe = new ArrayList<Regelendring>(Arrays.asList(innRegelendringListe));
        Collections.sort(sortedRegelendringListe);
        return sortedRegelendringListe.toArray(new Regelendring[0]);
    }

    public static ForstegangstjenestePeriode[] sorterForstegangstjenestePeriodeListeAsArray(ForstegangstjenestePeriode[] innForstegangstjenestePeriodeListe) {
        ArrayList<ForstegangstjenestePeriode> sortedForstegangstjenestePeriodeListe = new ArrayList<ForstegangstjenestePeriode>(Arrays.asList(innForstegangstjenestePeriodeListe));
        Collections.sort(sortedForstegangstjenestePeriodeListe);
        return sortedForstegangstjenestePeriodeListe.toArray(new ForstegangstjenestePeriode[0]);
    }

    public static ForstegangstjenestePeriode[] sorterForstegangstjenestePeriodeListeAsArray(List<ForstegangstjenestePeriode> innForstegangstjenestePeriodeListe) {
        Collections.sort(innForstegangstjenestePeriodeListe);
        return innForstegangstjenestePeriodeListe.toArray(new ForstegangstjenestePeriode[0]);
    }

//	public static Date[] sorterDateListeAsArray(List<Date> innDateListe) {
//        Collections.sort(innDateListe);
//        return innDateListe.toArray(new Date[0]);
//    }

    public static Date[] sorterDateListeAsArray(Date[] innDateListe) {
        ArrayList<Date> sortedDateListe = new ArrayList<Date>(Arrays.asList(innDateListe));
        Collections.sort(sortedDateListe);
        return sortedDateListe.toArray(new Date[0]);
    }

    public static BeregnetUtbetalingsperiode[] sorterBeregnetUtbetalingsperiodeListeAsArray(BeregnetUtbetalingsperiode[] innBeregnetUtbetalingsperiodeArray) {
        ArrayList<BeregnetUtbetalingsperiode> sortertBeregnetUtbetalingsperiodeListe =
                new ArrayList<BeregnetUtbetalingsperiode>(Arrays.asList(innBeregnetUtbetalingsperiodeArray));
        Collections.sort(sortertBeregnetUtbetalingsperiodeListe);
        return sortertBeregnetUtbetalingsperiodeListe.toArray(new BeregnetUtbetalingsperiode[0]);
    }

    public static Vector<VilkarsVedtak> lagVilkarsVedtakVector() {
        return new Vector<VilkarsVedtak>();
    }

    /**
     * Returnerer {@link no.nav.domain.pensjon.regler.beregning2011.BeregningsvilkarPeriode} som gjelder på dato.
     * Forventer at det ikke er overlapp i listen.
     * 
     * @param beregningsvilkarPeriodeListe
     * @param dato
     * @return
     */
    public static BeregningsvilkarPeriode finnGjeldendeBeregningsvilkaarPeriodePaaDato(List<BeregningsvilkarPeriode> beregningsvilkarPeriodeListe, Date dato) {
        if (beregningsvilkarPeriodeListe != null)
        {
            for (BeregningsvilkarPeriode bvp : beregningsvilkarPeriodeListe) {
                if (DateUtil.isDateInPeriod(dato, bvp.getFomDato(), bvp.getTomDato())) {
                    return bvp;
                }
            }
        }

        return null;
    }

    /**
     * A way to copy all the elements of a list by calling the constructor of the class of whatever object is contained within the list.
     * E.g. If the list contains Ytelseskomponenter, then the specific copyconstructor for Grunnpensjon, Tilleggspensjon,
     * etc will be called, and thus all properties will be copied.
     * Originally made to copy the six lists in InntektKontrollGrunnlag in PK-25612.
     * According to our coding standard, every PREG class should have a copy constructor. If this is not the case, then this method will fail.
     * 
     * @param listToCopy A list containing any class
     * @return An new list containing actual copies, not just copied references, of the objects in the listToCopy
     */
    public static <A> List<A> deepCopyReflection(List<A> listToCopy) {
        List<A> copyOfList = new ArrayList<A>();
        for (A a : listToCopy) {
            try {
                copyOfList.add((A) Class.forName(a.getClass().getName()).getConstructor(a.getClass()).newInstance(a));
            } catch (IllegalArgumentException e) {
            } catch (SecurityException e) {
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            } catch (NoSuchMethodException e) {
            } catch (ClassNotFoundException e) {
            }
        }
        return copyOfList;
    }

    public static <A extends Copyable<A>> List<A> deepCopyList(List<A> listToCopy) {
        List<A> copyOfList = new ArrayList<A>();
        for (A a : listToCopy) {
            copyOfList.add(a.deepCopy());
        }
        return copyOfList;
    }

    public static <K, V extends Copyable<V>> Map<K, V> deepCopyMap(Map<K, V> mapToCopy) {
        Map<K, V> copyOfMap = new HashMap<K, V>();
        for (K key : mapToCopy.keySet()) {
            copyOfMap.put(key, mapToCopy.get(key).deepCopy());
        }
        return copyOfMap;
    }
}
