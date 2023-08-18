package no.nav.pensjon.regler.domain.util;

import no.nav.pensjon.regler.domain.beregning2011.OpptjeningUT;

import java.util.*;

import static no.nav.pensjon.regler.domain.util.OmsorgspoengCompareUtil.*;

/**
 * @author Magnus Bakken (Accenture) PK-9695
 * @author Lars Hartviksen (Decisive) PK-9695
 */
public class OmsorgspoengTrygdeavtaleRek {
    /**
     * Holder orden på hvorvidt man har funnet beste kombinasjon med [n plasser før første år i rekken omsorgsopptjeninger][antall plasser]
     * Klassevariabel da man ikke leter beste kombinasjon fra forrige år med norsk opptjening rekursivt.
     **/
    private boolean[][] eksisterendeKombinasjon;

    /**
     * Holder orden på hvorvidt alle kombinasjoner fra utvidet omfang er
     */
    private boolean[][][] alleKombinasjonerFinnes;

    /**
     * Beste kombinasjon fra poengrekke, når man tar i betraktning omsorgsår og år med inntekt i avtaleland.
     * Kombinasjonen har følgende egenskaper:
     * Hvis det finnes flere kombinasjoner med samme uavrundede beregningsgrunnlag, så returneres:
     * - Kombinasjonen hvis sum av justert beløp tilhørende tre beste år er høyest.
     * Hvis det finnes flere kombinasjoner med samme uavrundede beregningsgrunnlag og samme sum av justert beløp til tre beste
     * så returneres den kombinasjonen av disse som kommer tidligst i den leksikografiske sorteringen av kombinasjoner på år:
     * Hvis seneste år til kombinasjon A er før kombinasjon B så er kombinasjon A før kombinasjon B.
     * Hvis kombinasjon A er tom, og kombinasjon B ikke er tom, så er kombinasjon B før kombinasjon A.
     * Alternativt, hvis seneste år i A og B er like, så er den leksikografiske sorteringen gitt av
     * den leksikografiske sorteringen av A og B uten deres respektive seneste år.
     *
     * @param opptjeningUTs
     * @return Beste kombinasjon fra poengrekke, når man tar i betraktning omsorgsår og år med inntekt i avtaleland.
     */
    public OmsorgspoengTrygdeavtaleKombinasjon finnBeste3Av5_trygdeavtale(List<OpptjeningUT> opptjeningUTs) {
        //Oppretter parametre for å finne gyldige kombinasjoner. Siste argument settes false da man initielt ikke starter i et utvidet omfang.
        Parametre param = new Parametre(opptjeningUTs, finnSenesteArFraListe(opptjeningUTs), 5);
        //Finner de fem inntektsårene, eller så mange som mulig hvis færre enn fem.
        //Finner for hvert intervall av omsorgsår, de mulige beste utvalgene av n omsorgsår fra intervallet, hvor n=< maksimum antall år fra intervall som kan inngå i kombinasjon.
        klargjorParametreFullIal(param, 5);
        //Utleder alle kombinasjoner som kan være beste kombinasjon.
        param = finnBesteKombinasjoner(param, new OmsorgspoengTrygdeavtaleKombinasjon(5, false), 0);
        //Forbereder kall til rekursiv metode som finner beste utvalg av år med verdi = 0 som har minst ett år med opptjening i avtaleland.
        //Initialiserer tabell som angir hvorvidt man har funnet beste kombinasjon med n plasser fra utvidet omfang fom. det i-ende året i opptjeningUT-lista.
        eksisterendeKombinasjon = new boolean[opptjeningUTs.size()][5 + 1];
        alleKombinasjonerFinnes = new boolean[opptjeningUTs.size() + 1][5 + 1][5 + 1];
        param = finnBesteKombinasjonerMedUtvidetOmfang(param, new OmsorgspoengTrygdeavtaleKombinasjon(5, false), param.senesteAr);
        OmsorgspoengTrygdeavtaleKombinasjon besteKombinasjon = param.finnBesteKombinasjon();
        //Hvis utvidet omfang, så er årene senere enn tidligste år i utvidet omfang relevante for output.
        //Disse settes på kombinasjonen.
        besteKombinasjon = finnRelevanteAr(besteKombinasjon, opptjeningUTs);
        return besteKombinasjon;
    }

    /**
     * @param os
     * @param ar
     * @return Sann hvis og bare hvis OpptjeningUT med ar finnes i liste av OpptjeningUT (os).
     */
    public static boolean finnesArIListe(List<OpptjeningUT> os, int ar) {
        for (OpptjeningUT o : os) {
            if (o.getOpptjeningsar() == ar) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finn beste år hvor alle år har inntekt = 0, finnes år med inntekt avtaleland ved rekursjon.
     * I både partielle og komplette kombinasjoner generert av metoden er det slik at alle opptjeninger har verdi = 0.
     * Dette er en forutsetning for at det skal være mulig å bytte ut årene med inntekt i avtaleland.
     * Metoden skiller seg fra brute-force generering av alle slike kombinasjoner på følgende vis:
     * - Hjelpemetoden som finner substitusjoner av n år med inntekt i avtaleland fra en indeks i med siste verdi > 0 kalles ikke unødig.
     * Tabellen eksisterendeKombinasjon holder styr på om metoden allerede har generert et kombinasjon hvor n år har inntekt i avtaleland, og vi fant erstatninger for disse årene
     * fra indeks i.
     * - Metoden unngår å utvide delvis genererte kombinasjoner når den vet at ingen utvidelser av disse kombinasjonene vil lede til nye kombinasjoner fra utvidet omfang.
     * Tabellen alleKombinasjonerFinnes holder styr på om vi har generert alle kombinasjoner som resulterer når man står i en posisjon i, har n ledige plasser, og har valgt m år
     * med inntekt i avtaleland.
     * Dersom vi på ny står i en slik posisjon i, har n ledige plasser og har valgt m år med inntekt i avtaleland vil ikke utvidelser av kombinasjonen lede til kombinasjoner hvor
     * vi skal erstatte et
     * nytt antall år med ial eller posisjonen j hvor det utvidede omfanget starter. Slike kombinasjoner har allerede ha blitt generert.
     * Om man hadde fortsatt likevel fra dette punktet hadde man kun fått kombinasjoner som var forskjellige fra allerede genererte kombinasjonen i form av at 0-årene som sender
     * algoritmen mot en utvidet omfang er forskjellige.
     * Den returnerte kombinasjonen vil være det kombinasjonet med erstatninger av n år med inntekt avtaleland som skal erstattes med år i utvidet omfang fra indeks i som er først
     * generert.
     * Det innebærer at den returnerte kombinasjonen vil være først i den leksikografiske sorteringen av slike kombinasjon:
     * For alle andre kombinasjon hvor n år med inntekt avtaleland skal erstattes av med år i utvidet omfang fra indeks i så vil:
     * - Første år på den returnerte kombinasjonen være tidligere, eller hvis første år er samme år:
     * - Neste år vil være tidligere, eller hvis neste år er samme år,...
     * ...
     * - Siste år er tidligere.
     */
    private Parametre finnBesteKombinasjonerMedUtvidetOmfang(Parametre param, OmsorgspoengTrygdeavtaleKombinasjon kombinasjon, int ar) {
        //hvis condition gjelder så består kombinasjonen utelukkende av opptjeninger med verdi 0.
        if (kombinasjon.getAntallPlasser() == 0 && !kombinasjon.isHarNorskOpptjening() && kombinasjon.getAntallValgteIal() > 0) {
            //Finner forrige år med norsk opptjening fra tidligste år som inngår i aktuell kombinasjon.
            //Dette er viktig for å unngå at man ikke bruker omsorgsår man allerede har sett bort i fra som startpunkt for utvidet omfang.
            int tidligsteArIKombinasjon = finnTidligsteArFraListe(kombinasjon.getKombinasjon());
            Integer forrigeInntektAr = finnForrigeOpptjeningArIkkeZero(param.alleArListe, tidligsteArIKombinasjon - 1);
            //Hvis ingen tidligere år med norsk opptjening finnes, må kombinasjonen forkastes.
            if (forrigeInntektAr != null) {
                //Finner listen av opptjeningUT som starter på forrige inntektsår fra tidligste år i aktuell kombinasjon.
                List<OpptjeningUT> listeFraForrigeInntektAr = lagListeAvOpptjeningerFør(param.alleArListe, forrigeInntektAr);
                //Ordinært sett skal man finne en kombinasjon fra utvidet omfang med like mange plasser som man hadde år med inntekt i avtaleland i kombinasjonen med 0-år.
                //Noen ganger vil det ikke finnes nok år i dette omfanget til å fylle alle plassene.
                //I såfall skal man finne en kombinasjon med så mange år som er mulig (minst 1) fra forrige inntektsår.
                int utvidetOmfangMaksVindu = Math.min(kombinasjon.getAntallValgteIal(), listeFraForrigeInntektAr.size());
                //Sjekker at algoritmen ikke allerede har funnet alle gyldige kombinasjoner med størrelse n fra dette punktet.
                if (!eksisterendeKombinasjon[param.senesteAr - forrigeInntektAr][utvidetOmfangMaksVindu]) {
                    //Merk at kombinasjon på dette punktet er best på leksikografisk sortering blant kombinasjoner med 0 på alle år og dette antall valgte ial.
                    //Opprett ny parameter for algoritmen.
                    Parametre nyParameter = new Parametre(listeFraForrigeInntektAr, forrigeInntektAr, utvidetOmfangMaksVindu);
                    //Finn inntektsårene og generer mulige beste kombinasjoner av omsorgsår for hvert intervall av omsorgsår fra forrige inntektsår
                    klargjorParametreFullIal(nyParameter, utvidetOmfangMaksVindu);
                    //Man trenger ikke lengre å finne beste kombinasjon med dette vinduet fra dette året.
                    eksisterendeKombinasjon[param.senesteAr - forrigeInntektAr][utvidetOmfangMaksVindu] = true;
                    nyParameter = finnBesteKombinasjoner(nyParameter, new OmsorgspoengTrygdeavtaleKombinasjon(utvidetOmfangMaksVindu, true), 0);
                    OmsorgspoengTrygdeavtaleKombinasjon besteKombinasjon = nyParameter.finnBesteKombinasjon();
                    //Den opprinnelige kombinasjonen får nå et felt med enda en kombinasjon som er beste fra utvidet omfang.
                    //Nasjonalt snitt og beregningsgrunnlagUavrundet arves fra denne kombinasjonen.
                    kombinasjon.setUtvidetOmfang(besteKombinasjon);
                    OmsorgspoengTrygdeavtaleKombinasjon nyKombinasjon = new OmsorgspoengTrygdeavtaleKombinasjon(kombinasjon);
                    //Lagre kombinasjonen
                    param.kombinasjonsliste.add(nyKombinasjon);
                }
            }
        }
        OpptjeningUT o = hentOpptjeningsArFraListe(param.alleArListe, ar);
        if (o != null && kombinasjon.getAntallPlasser() > 0
                //Hvis algoritmen har vært på dette året, med samme antall ledige plasser, likt antall valgte ial før, så har man også funnet beste kombinasjon fra eventuelle
                // utvidede omfang
                && !alleKombinasjonerFinnes[param.senesteAr - ar][kombinasjon.getAntallPlasser()][kombinasjon.getAntallValgteIal()]) {
            if (o.getVerdi() == 0.0) {
                OmsorgspoengTrygdeavtaleKombinasjon nyKombinasjon = new OmsorgspoengTrygdeavtaleKombinasjon(kombinasjon);
                nyKombinasjon.leggTilOpptjeningUT(o);
                param = finnBesteKombinasjonerMedUtvidetOmfang(param, nyKombinasjon, ar - 1);
            }
            if (o.isOmsorg()) {
                param = finnBesteKombinasjonerMedUtvidetOmfang(param, kombinasjon, ar - 1);
            }
            alleKombinasjonerFinnes[param.senesteAr - ar][kombinasjon.getAntallPlasser()][kombinasjon.getAntallValgteIal()] = true;
        }
        return param;
    }

    /**
     * Denne rekursive metoden genererer alle kombinasjoner som kan være den beste kombinasjonen.
     * Visse kombinasjoner kan aldri bli beste kombinasjon og er ekskludert.
     *
     * @param param
     * @param kombinasjon Bygges inkrementelt i rekursjonen. Når stoppkriteriet nås (fullt med år) tas en kopi og lagres i param. Initielt tom.
     * @param inum Hvilket inntektsår ser vi på nå? Initielt ser vi på inntektsår 0, i.e. vi ser ikke på et inntektsår. Telles fra seneste til tidligste.
     * @return Parametre som inneholder en liste med kombinasjoner hvor den beste er garantert å være inkludert.
     */
    private Parametre finnBesteKombinasjoner(
            Parametre param,
            OmsorgspoengTrygdeavtaleKombinasjon kombinasjon,
            int inum) {
        //Stoppkriterie for rekursjon. Om denne betingelsen gjelder, så er kombinasjon en ferdig generert kombinasjon.
        if (kombinasjon.getAntallPlasser() == 0) {
            //Aktuell ferdig kombinasjon lagres. Merk at dersom utvidet omfang skal genereres så vil en kombinasjon bli lagret både med og uten utvidet omfang.
            param.kombinasjonsliste.add(new OmsorgspoengTrygdeavtaleKombinasjon(kombinasjon));
        }
        //Rekursjonstilfelle.
        //Hvis vi har ledige plasser igjen, vi er på inntektsår 0 eller inntektsår inum finnes.
        if (kombinasjon.getAntallPlasser() > 0 && (inum == 0 || param.inntektsAr.get(inum) != null)) {
            //Legger til neste inntektsår hvis vi ser på inntektsår over 0.
            if (inum > 0) {
                kombinasjon.leggTilOpptjeningUT(param.inntektsAr.get(inum));
            }
            //Hvis det er mulig å legge til flere omsorgsår basert på antall inntektår som er valgt.
            //Vi kan ikke sjekke på antall plasser her, fordi det er nødvendig med enda et rekursivt kall for å nå basistilfellet.
            if (inum <= param.vindu) {
                //For hvert valg av 0,1,... antallPlasser omsorgsår som kan være med i beste kombinasjon,
                //Utvid kombinasjonen med disse. Merk at algoritmen ALLTID forsøker å utvide med ingen omsorgsår fra intervallet.
                //Merk at sorteringen av besteOmsorgsarUtvidelser er leksikografisk, og deretter på størrelse (største først).
                //Dette sikrer at algoritmen genererer leksikografisk tidligste kombinasjoner først.
                for (List<OpptjeningUT> utvidelse : param.besteOmsorgsarUtvidelser.get(inum)) {
                    if (utvidelse.size() <= kombinasjon.getAntallPlasser()) {
                        OmsorgspoengTrygdeavtaleKombinasjon nyKombinasjon = new OmsorgspoengTrygdeavtaleKombinasjon(kombinasjon);
                        nyKombinasjon.leggTilOpptjeningUTer(utvidelse);
                        param = finnBesteKombinasjoner(param, nyKombinasjon, inum + 1);
                    }
                }
            }
        }
        //Nå er alle kombinasjoner som kan være best generert.
        return param;
    }

    /**
     * Finner inntektsårene og kombinasjoner av beste omsorgsår fra hvert intervall av omsorgsår.
     *
     * @param param
     * @param vindu
     */
    private void klargjorParametreFullIal(Parametre param, int vindu) {
        finnInntektsar(param, vindu);
        finnOmsorgsarPermutasjoner(param, vindu);
    }

    /**
     * Finner de første inntektsårene i listen av OpptjeningUT i param, og lagrer disse i param (antall gitt av "vindu")
     *
     * @param param
     * @param vindu
     */
    private void finnInntektsar(Parametre param, int vindu) {
        param.inntektsAr = new HashMap<Integer, OpptjeningUT>();
        Collections.sort(param.alleArListe, new SynkendeArstallComparator());
        int i = 0;
        int antallInntektAr = 1;
        while (antallInntektAr <= vindu && i < param.alleArListe.size()) {
            if (!param.alleArListe.get(i).isOmsorg()) {
                param.inntektsAr.put(antallInntektAr, param.alleArListe.get(i));
                antallInntektAr++;
            }
            i++;
        }
    }

    /**
     * Finner årene etter utvidet omfang. I.e. år slik at året er senere enn tidligste år i utvidet omfang.
     *
     * @param kombinasjon
     * @param opptjeningUTs
     * @return
     */
    private OmsorgspoengTrygdeavtaleKombinasjon finnRelevanteAr(OmsorgspoengTrygdeavtaleKombinasjon kombinasjon, List<OpptjeningUT> opptjeningUTs) {
        List<OpptjeningUT> relevanteAr = new ArrayList<OpptjeningUT>();
        if (kombinasjon.getUtvidetOmfang() == null) {
            kombinasjon.setRelevanteArForUtvidetOmfang(relevanteAr);
        } else {
            int tidligsteAr = finnSenesteArFraListe(kombinasjon.getUtvidetOmfang().getKombinasjon());
            for (OpptjeningUT o : opptjeningUTs) {
                if (o.getOpptjeningsar() > tidligsteAr) {
                    relevanteAr.add(o);
                } else {
                    if (o.isOmsorg() && !finnesArIListe(kombinasjon.getUtvidetOmfang().getKombinasjon(), o.getOpptjeningsar() )) {
                        relevanteAr.add( o );
                    }
                }
            }
            kombinasjon.setRelevanteArForUtvidetOmfang(relevanteAr);
        }
        return kombinasjon;
    }

    /**
     * Inntektsår kan enumereres fra det seneste (1), til det tidligste (5 eller mindre).
     * Det nte og det (n+1)te inntektsåret for n+1 =< 5 definerer et intervall med omsorgsår.
     * Noen ganger finnes det omsorgsår senere enn det seneste inntektsåret, av disse kan man maksimum bruke 5, 4, 3, 2, 1 og 0 i den endelige kombinasjonen.
     * Dette defineres som intervallet av omsorgsår mellom inntektsår 0 (ikke-eksisterende) og inntektsår 1.
     * Et annet unntak er når det er færre enn vindu antall inntektsår, da finnes et intervall med omsorgsår etter det tidligste inntektsåret.
     * Maksimalt kan man inkludere (vindu-n) år omsorgsår fra et slikt intervall med omsorgsår i en kombinasjon.
     * Det er imidlertid komputasjonelt kostbart å forsøke alle utvalg av lengde i fra intervallet av omsorgsår etter inntektsåret n hvor 0 =< i =< (vindu-n).
     * Denne metoden genererer for hvert intervall av omsorgsår, et en begrenset mengde utvalg av omsorgsår (sammenlignet med å generere alle).
     * Disse utvalgene lagres så på param, til bruk i rekursiv generering av alternativer. Å lagre disse verdiene gjør at de ikke må genereres flere ganger.
     * Det er verdt å merke seg to egenskaper ved disse utvalgene:
     * - For hvert intervall av omsorgsår, så genereres det tomme utvalget omsorgsår.
     * I.e. algoritmen forsøker kombinasjoner som velger ingen omsorgsår mellom disse inntektsårene.
     * - Hvis det finnes to utvalg av omsorgsår med samme lengde fra samme intervall som er identiske både på årenes avkortede beløp og ial-status,
     * så foretrekker algoritmen til å begynne med utvalget hvis justerte beløp er høyest, og deretter det utvalget som har best leksikografisk sortering på år når
     * utvalgene er sortert i synkende rekkefølge på år.
     *
     * @param param
     * @param vindu
     */
    private void finnOmsorgsarPermutasjoner(Parametre param, int vindu) {
        //Hvilke omsorgsår man burde velge fra et gitt intervall avhenger av de øvrige årene som inngår i kombinsajonen.
        //Disse listene holder på ulike disjunkte men kollektivt uttømmende sorteringer av omsorgsårene i et intervall.
        //Hver liste representerer ulike måter et omsorgsår kan være best på - ulike måter å bidra i kombinasjonen på.
        //nStorsteOmsorgsarMellom sorterer omsorgsårene i intervallet som ikke har IAL med avkortet beløp over 0 på avkortet beløp, deretter justert beløp, deretter år (synkende).
        //Representerer tilfellet hvor et omsorgsår øker enten snitt av tre beste eller nasjonalt snitt, men ikke selv kan erstattes av nasjonalt snitt.
        List<OpptjeningUT> nStorsteOmsorgsarMellom;
        //nStorsteOmsorgsarMellom sorterer omsorgsårene i intervallet som har IAL med avkortet beløp over 0 på avkortet beløp, deretter justert beløp, deretter år (synkende).
        //Representerer tilfellet hvor et omsorgsår øker enten snitt av tre beste eller nasjonalt snitt, og som selv kan erstattes med nasjonalt snitt.
        List<OpptjeningUT> nStorsteIalArMellom;
        //nZeroArMellom sorterer omsorgsårene i intervallet med avkortet beløp lik 0 på hvorvidt de har ial, deretter årstall (synkende).
        //Representerer tilfellet hvor det er bedre år med avkortet beløp 0 enn år som har avkortet beløp over 0 da dette kan øke det nasjonale snittet.
        //I disse tilfellene vil det være minst like bra om 0-året har ial, da dette noen ganger kan erstattes med nasjonalt snitt og øke snittet.
        List<OpptjeningUT> nZeroArMellom;

        List<OpptjeningUT> kunNonZeroIalAr = new ArrayList<OpptjeningUT>();
        List<OpptjeningUT> kunNonZeroIkkeIalAr = new ArrayList<OpptjeningUT>();
        List<OpptjeningUT> kunZeroAr = new ArrayList<OpptjeningUT>();

        //Finn disjunkte, kollektivt uttømmende delmengder av omsorgsårene i hele listen av opptjeningUT.
        for (OpptjeningUT o : param.alleArListe) {
            if (!o.isInntektIAvtaleland() && o.getVerdi() > 0.0) {
                kunNonZeroIkkeIalAr.add(o);
            } else if (o.isInntektIAvtaleland() && o.getVerdi() > 0.0) {
                kunNonZeroIalAr.add(o);
            } else if (o.getVerdi() == 0.0) {
                kunZeroAr.add(o);
            }
        }

        //Iterer over hvert intervall av inntektsår.
        int startAr = 0;
        int stoppAr = 0;
        int antallMuligeAr = 0;
        for (int i = 0; i <= vindu; i++) {
            //Funksjonalitet for å finne start og stoppår for hvert intervall med omsorgsår
            //Spesialtilfelle hvis første intervall, da definerer ikke første inntektsår starten på intervallet.
            //Startår er definert av MAX_VALUE da vi ønsker å få med alle omsorgsårene før det første inntektsåret.
            if (i == 0) {
                startAr = Integer.MAX_VALUE;
                //I dette tilfellet er det ingen inntektsår overhodet.
                //MIN_VALUE gjør at intervallet dekker alle omsorgsår.
                if (param.inntektsAr.get(i + 1) == null) {
                    stoppAr = Integer.MIN_VALUE;
                }
                //Her finnes det minst ett inntektsår. Intervallet stopper nå på året til inntektsår i+1 = 1.
                else if (param.inntektsAr.get(i + 1) != null) {
                    stoppAr = param.inntektsAr.get(i + 1).getOpptjeningsar();
                }
                //Tilfelle hvor vi muligens har ett inntektsår som definerer starten på intervallet, som regel vil vi ha et slikt inntektsår.
            } else if (i > 0) {
                //Tilfelle hvor vi har både inntektsår i og inntektsår i+1.
                //Da går intervallet med omsorgsår fra året etter inntektsår i, til, men ikke med året til inntektsår i+1.
                if (param.inntektsAr.get(i) != null && param.inntektsAr.get(i + 1) != null) {
                    startAr = param.inntektsAr.get(i).getOpptjeningsar();
                    stoppAr = param.inntektsAr.get(i + 1).getOpptjeningsar();
                }
                //Tilfelle hvor vi har inntektsår i men ikke inntektsår i+1.
                //Intervallet omsorgsår går fra året til inntektsår i tom. tidligste år.
                else if (param.inntektsAr.get(i) != null && param.inntektsAr.get(i + 1) == null) {
                    startAr = param.inntektsAr.get(i).getOpptjeningsar();
                    stoppAr = Integer.MIN_VALUE;
                }
                //Hvis ingen av inntektsårene finnes, så er start=stopp. Intervallet er tomt.
                else if (param.inntektsAr.get(i) == null && param.inntektsAr.get(i + 1) == null) {
                    startAr = 0;
                    stoppAr = 0;
                }
            }
            //Antall omsorgsår vi kan velge fra det aktuelle intervallet.
            //Eks. for intervallet i=0, altså omsorgsårene før seneste inntektsår, da kan vi velge vindu mange omsorgsår maksimalt.
            //Som regel er dette 5.
            antallMuligeAr = vindu - i;

            //Finn de fire ordningene av omsorgsårene i det gitte intervallet.
            nStorsteOmsorgsarMellom = finnNBesteOmsorgsarMellom(kunNonZeroIkkeIalAr, startAr, stoppAr, antallMuligeAr, new PoengtallComparator());
            nStorsteIalArMellom = finnNBesteOmsorgsarMellom(kunNonZeroIalAr, startAr, stoppAr, antallMuligeAr, new PoengtallComparator());
            nZeroArMellom = finnNBesteOmsorgsarMellom(kunZeroAr, startAr, stoppAr, antallMuligeAr, new IalPoengtallComparatorOmsorgsopptjeningTrygdeavtale());
            List<List<OpptjeningUT>> permutasjoner = new ArrayList<List<OpptjeningUT>>();
            //Finn alle distinkte mengder av omsorgsår som kan trekkes fra toppen av de fire stablene.
            //Genererer også den tomme mengden omsorgsår, da j==0 til å begynne med.
            for (int j = 0; j <= antallMuligeAr; j++) {
                //Legg til alle utvalg / permutasjoner av omsorgsår med lengde j valgt fra toppen av de fire stablene / ordningene.
                permutasjoner.addAll(genererOmsorgsarAlternativer(
                        nStorsteOmsorgsarMellom,
                        nStorsteIalArMellom,
                        nZeroArMellom,
                        j));
            }
            //Sorter samlingen utvalg leksikografisk, først på størrelse, deretter leksikografisk på årstall.
            Collections.sort(permutasjoner, new StorrelseOgLeksikografiskArstallComparator());
            //Lagre på parametere
            param.besteOmsorgsarUtvidelser.put(i, permutasjoner);
        }
    }

    /**
     * Denne metoden finner alle utvalg av å velge antallPlasser omsorgsår fra de fire stablene.
     * Dvs for alle i,j,h >= 0 hvor i+j+k+l = antallPlasser
     * Så skal utvalget med de (i) første fra storsteArListe, velg de (j) første fra storsteIalArListe, (h) første fra zeroArListe skal være med.
     * Eksempelvis:
     * Utvalg med de (antallPlasser) første fra storsteArListe, velg de 0 første fra storsteIalArListe, 0 første fra zeroArListe
     * Utvalg med de (antallPlasser) første fra storsteArListe, velg de 0 første fra storsteIalArListe, 0 første fra zeroArListe
     * Utvalg med de (antallPlasser - 1) første fra storsteArListe, velg de 1 første fra storsteIalArListe, 0 første fra zeroArListe
     * ...
     * Utvalg med de 0 første fra storsteArListe, velg de 1 første fra storsteIalArListe, (antallPlasser -1) første fra zeroArListe
     * Utvalg med de 0 første fra storsteArListe, velg de 0 første fra storsteIalArListe, (antallPlasser) første fra zeroArListe
     *
     * @param storsteArListe
     * @param storsteIalArListe
     * @param antallPlasser
     * @return
     */
    private List<List<OpptjeningUT>> genererOmsorgsarAlternativer(
            List<OpptjeningUT> storsteArListe,
            List<OpptjeningUT> storsteIalArListe,
            List<OpptjeningUT> zeroArListe,
            int antallPlasser) {
        List<List<OpptjeningUT>> returListe = new ArrayList<List<OpptjeningUT>>();
        List<OpptjeningUT> alternativ;
        List<OpptjeningUT> fraStorsteArListe;
        List<OpptjeningUT> fraStorsteIalArListe;
        List<OpptjeningUT> fraZeroArListe;
        for (int i = 0; i <= antallPlasser && i <= storsteArListe.size(); i++) {
            for (int j = 0; j + i <= antallPlasser && j <= storsteIalArListe.size(); j++) {
                for (int h = 0; h + j + i <= antallPlasser && h <= zeroArListe.size(); h++) {
                    //Det er viktig å forsikre seg om at antall plasser brukt er eksakt så mange som skulle bli brukt før man legger til utvalget.
                    if (antallPlasser == h + j + i) {
                        fraStorsteArListe = storsteArListe.subList(0, i);
                        fraStorsteIalArListe = storsteIalArListe.subList(0, j);
                        fraZeroArListe = zeroArListe.subList(0, h);
                        alternativ = new ArrayList<OpptjeningUT>();
                        alternativ.addAll(fraStorsteArListe);
                        alternativ.addAll(fraStorsteIalArListe);
                        alternativ.addAll(fraZeroArListe);
                        returListe.add(alternativ);
                    }
                }
            }
        }
        return returListe;
    }

    /**
     * Finn de N beste opptjeningUT med omsorg i et intervall, gitt en sortering på slike.
     *
     * @param opptjeningUTs
     * @param ar1
     * @param ar2
     * @param antall
     * @param comp
     * @return
     */
    private List<OpptjeningUT> finnNBesteOmsorgsarMellom(List<OpptjeningUT> opptjeningUTs, int ar1, int ar2, int antall, Comparator comp) {
        List<OpptjeningUT> omsorgsArIIntervall = new ArrayList<OpptjeningUT>();
        //Legger alle omsorgsårene mellom forste og siste år inn i en liste
        for (OpptjeningUT o : opptjeningUTs) {
            if (o.getOpptjeningsar() < ar1 && o.getOpptjeningsar() > ar2 && o.isOmsorg()) {
                omsorgsArIIntervall.add(o);
            }
        }
        List<OpptjeningUT> deNBesteOmsorgsarene = new ArrayList<OpptjeningUT>();
        Collections.sort(omsorgsArIIntervall, comp);

        // Tar ut de (antall) største omsorgsårene og legger disse inn i deNStorsteOmsorgsarene
        deNBesteOmsorgsarene.addAll(omsorgsArIIntervall.subList(0, Math.min(antall + 1, omsorgsArIIntervall.size())));
        return deNBesteOmsorgsarene;
    }

    /**
     * Finn tidligste år i liste av OpptjeningUT. Null hvis listen er tom.
     *
     * @param liste
     * @return
     */
    private Integer finnTidligsteArFraListe(List<OpptjeningUT> liste) {
        Integer tidligsteAr = null;
        for (OpptjeningUT o : liste) {
            if (tidligsteAr == null || tidligsteAr != null && o.getOpptjeningsar() < tidligsteAr) {
                tidligsteAr = o.getOpptjeningsar();
            }
        }
        return tidligsteAr;
    }

    /**
     * Finn seneste år i liste av OpptjeningUT. Null hvis listen er tom.
     *
     * @param liste
     * @return
     */
    private Integer finnSenesteArFraListe(List<OpptjeningUT> liste) {
        Integer senesteAr = null;
        for (OpptjeningUT o : liste) {
            if (senesteAr == null || senesteAr != null && o.getOpptjeningsar() > senesteAr) {
                senesteAr = o.getOpptjeningsar();
            }
        }
        return senesteAr;
    }

    /**
     * Finn OpptjeningUT for et gitt årstall fra liste. Null hvis ingen slik finnes.
     *
     * @param liste
     * @param aar
     * @return
     */
    private OpptjeningUT hentOpptjeningsArFraListe(List<OpptjeningUT> liste, int aar) {
        for (OpptjeningUT o : liste) {
            if (o.getOpptjeningsar() == aar) {
                return o;
            }
        }
        return null;
    }

    /**
     * Finn forrige år med avkortetBelop>0. Null hvis dette året ikke finnes.
     * Brukes når man skal finne utvidet omfang dersom ingen norsk opptjening i noen av årene, noen av årene har ial.
     *
     * @param liste
     * @param ar
     * @return
     */
    private Integer finnForrigeOpptjeningArIkkeZero(List<OpptjeningUT> liste, int ar) {
        boolean notNull = true;
        OpptjeningUT op;
        while (notNull) {
            op = hentOpptjeningsArFraListe(liste, ar);
            notNull = op != null;
            if (notNull && op.getVerdi() > 0.0) {
                return ar;
            }
            ar--;
        }
        return null;
    }

    /**
     * Finn listen av OpptjeningUT med årstall minst like tidlig som ar.
     * Tom liste hvis ingen slike finnes.
     *
     * @param liste
     * @param ar
     * @return
     */
    private List<OpptjeningUT> lagListeAvOpptjeningerFør(List<OpptjeningUT> liste, int ar) {
        List<OpptjeningUT> nyListe = new ArrayList<OpptjeningUT>();
        for (OpptjeningUT o : liste) {
            if (o.getOpptjeningsar() <= ar) {
                nyListe.add(o);
            }
        }
        return nyListe;
    }

    /**
     * Hjelpeklasse for å finne beste kombinasjon av opptjeningUT med trygdeavtaler.
     */
    private class Parametre {
        public List<OpptjeningUT> alleArListe;
        public Map<Integer, List<List<OpptjeningUT>>> besteOmsorgsarUtvidelser;
        public Map<Integer, OpptjeningUT> inntektsAr;
        public List<OmsorgspoengTrygdeavtaleKombinasjon> kombinasjonsliste;
        public int senesteAr;
        public int vindu;

        public Parametre(List<OpptjeningUT> alleArListe, int senesteAr, int vindu) {
            this.alleArListe = alleArListe;
            besteOmsorgsarUtvidelser = new HashMap<Integer, List<List<OpptjeningUT>>>();
            inntektsAr = new HashMap<Integer, OpptjeningUT>();
            kombinasjonsliste = new ArrayList<OmsorgspoengTrygdeavtaleKombinasjon>();
            this.senesteAr = senesteAr;
            this.vindu = vindu;
        }

        /**
         * Finn den beste kombinasjonen. Forutsetter at alle kombinasjoner er generert, og at kombinasjoner med utvidet omfang har fått fastsatt nasjonalt snitt fra utvidet omfang.
         */
        public OmsorgspoengTrygdeavtaleKombinasjon finnBesteKombinasjon() {
            OmsorgspoengTrygdeavtaleKombinasjon hittilBeste = null;
            for (OmsorgspoengTrygdeavtaleKombinasjon k : kombinasjonsliste) {
                if (k.getUtvidetOmfang() == null) {
                    k.regnNasjonaltSnitt();
                }
                k.regnBeregningsgrunnlagUavrundet();
                if (hittilBeste == null) {
                    hittilBeste = k;
                }
                //Sammenligner på uavrundet beregningsgrunnlag, deretter sum av de tre beste sine avkortede beløp,
                //deretter leksikografisk på årstall når kombinasjoner (ikke fra utvidet omfang) er sortert synkende på år.
                else if (hittilBeste.compareTo(k) > 0) {
                    hittilBeste = k;
                }
            }
            return hittilBeste;
        }
    }
}
