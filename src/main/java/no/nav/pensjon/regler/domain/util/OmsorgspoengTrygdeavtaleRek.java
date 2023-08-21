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
     * Holder orden p� hvorvidt man har funnet beste kombinasjon med [n plasser f�r f�rste �r i rekken omsorgsopptjeninger][antall plasser]
     * Klassevariabel da man ikke leter beste kombinasjon fra forrige �r med norsk opptjening rekursivt.
     **/
    private boolean[][] eksisterendeKombinasjon;

    /**
     * Holder orden p� hvorvidt alle kombinasjoner fra utvidet omfang er
     */
    private boolean[][][] alleKombinasjonerFinnes;

    /**
     * Beste kombinasjon fra poengrekke, n�r man tar i betraktning omsorgs�r og �r med inntekt i avtaleland.
     * Kombinasjonen har f�lgende egenskaper:
     * Hvis det finnes flere kombinasjoner med samme uavrundede beregningsgrunnlag, s� returneres:
     * - Kombinasjonen hvis sum av justert bel�p tilh�rende tre beste �r er h�yest.
     * Hvis det finnes flere kombinasjoner med samme uavrundede beregningsgrunnlag og samme sum av justert bel�p til tre beste
     * s� returneres den kombinasjonen av disse som kommer tidligst i den leksikografiske sorteringen av kombinasjoner p� �r:
     * Hvis seneste �r til kombinasjon A er f�r kombinasjon B s� er kombinasjon A f�r kombinasjon B.
     * Hvis kombinasjon A er tom, og kombinasjon B ikke er tom, s� er kombinasjon B f�r kombinasjon A.
     * Alternativt, hvis seneste �r i A og B er like, s� er den leksikografiske sorteringen gitt av
     * den leksikografiske sorteringen av A og B uten deres respektive seneste �r.
     *
     * @param opptjeningUTs
     * @return Beste kombinasjon fra poengrekke, n�r man tar i betraktning omsorgs�r og �r med inntekt i avtaleland.
     */
    public OmsorgspoengTrygdeavtaleKombinasjon finnBeste3Av5_trygdeavtale(List<OpptjeningUT> opptjeningUTs) {
        //Oppretter parametre for � finne gyldige kombinasjoner. Siste argument settes false da man initielt ikke starter i et utvidet omfang.
        Parametre param = new Parametre(opptjeningUTs, finnSenesteArFraListe(opptjeningUTs), 5);
        //Finner de fem inntekts�rene, eller s� mange som mulig hvis f�rre enn fem.
        //Finner for hvert intervall av omsorgs�r, de mulige beste utvalgene av n omsorgs�r fra intervallet, hvor n=< maksimum antall �r fra intervall som kan inng� i kombinasjon.
        klargjorParametreFullIal(param, 5);
        //Utleder alle kombinasjoner som kan v�re beste kombinasjon.
        param = finnBesteKombinasjoner(param, new OmsorgspoengTrygdeavtaleKombinasjon(5, false), 0);
        //Forbereder kall til rekursiv metode som finner beste utvalg av �r med verdi = 0 som har minst ett �r med opptjening i avtaleland.
        //Initialiserer tabell som angir hvorvidt man har funnet beste kombinasjon med n plasser fra utvidet omfang fom. det i-ende �ret i opptjeningUT-lista.
        eksisterendeKombinasjon = new boolean[opptjeningUTs.size()][5 + 1];
        alleKombinasjonerFinnes = new boolean[opptjeningUTs.size() + 1][5 + 1][5 + 1];
        param = finnBesteKombinasjonerMedUtvidetOmfang(param, new OmsorgspoengTrygdeavtaleKombinasjon(5, false), param.senesteAr);
        OmsorgspoengTrygdeavtaleKombinasjon besteKombinasjon = param.finnBesteKombinasjon();
        //Hvis utvidet omfang, s� er �rene senere enn tidligste �r i utvidet omfang relevante for output.
        //Disse settes p� kombinasjonen.
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
     * Finn beste �r hvor alle �r har inntekt = 0, finnes �r med inntekt avtaleland ved rekursjon.
     * I b�de partielle og komplette kombinasjoner generert av metoden er det slik at alle opptjeninger har verdi = 0.
     * Dette er en forutsetning for at det skal v�re mulig � bytte ut �rene med inntekt i avtaleland.
     * Metoden skiller seg fra brute-force generering av alle slike kombinasjoner p� f�lgende vis:
     * - Hjelpemetoden som finner substitusjoner av n �r med inntekt i avtaleland fra en indeks i med siste verdi > 0 kalles ikke un�dig.
     * Tabellen eksisterendeKombinasjon holder styr p� om metoden allerede har generert et kombinasjon hvor n �r har inntekt i avtaleland, og vi fant erstatninger for disse �rene
     * fra indeks i.
     * - Metoden unng�r � utvide delvis genererte kombinasjoner n�r den vet at ingen utvidelser av disse kombinasjonene vil lede til nye kombinasjoner fra utvidet omfang.
     * Tabellen alleKombinasjonerFinnes holder styr p� om vi har generert alle kombinasjoner som resulterer n�r man st�r i en posisjon i, har n ledige plasser, og har valgt m �r
     * med inntekt i avtaleland.
     * Dersom vi p� ny st�r i en slik posisjon i, har n ledige plasser og har valgt m �r med inntekt i avtaleland vil ikke utvidelser av kombinasjonen lede til kombinasjoner hvor
     * vi skal erstatte et
     * nytt antall �r med ial eller posisjonen j hvor det utvidede omfanget starter. Slike kombinasjoner har allerede ha blitt generert.
     * Om man hadde fortsatt likevel fra dette punktet hadde man kun f�tt kombinasjoner som var forskjellige fra allerede genererte kombinasjonen i form av at 0-�rene som sender
     * algoritmen mot en utvidet omfang er forskjellige.
     * Den returnerte kombinasjonen vil v�re det kombinasjonet med erstatninger av n �r med inntekt avtaleland som skal erstattes med �r i utvidet omfang fra indeks i som er f�rst
     * generert.
     * Det inneb�rer at den returnerte kombinasjonen vil v�re f�rst i den leksikografiske sorteringen av slike kombinasjon:
     * For alle andre kombinasjon hvor n �r med inntekt avtaleland skal erstattes av med �r i utvidet omfang fra indeks i s� vil:
     * - F�rste �r p� den returnerte kombinasjonen v�re tidligere, eller hvis f�rste �r er samme �r:
     * - Neste �r vil v�re tidligere, eller hvis neste �r er samme �r,...
     * ...
     * - Siste �r er tidligere.
     */
    private Parametre finnBesteKombinasjonerMedUtvidetOmfang(Parametre param, OmsorgspoengTrygdeavtaleKombinasjon kombinasjon, int ar) {
        //hvis condition gjelder s� best�r kombinasjonen utelukkende av opptjeninger med verdi 0.
        if (kombinasjon.getAntallPlasser() == 0 && !kombinasjon.isHarNorskOpptjening() && kombinasjon.getAntallValgteIal() > 0) {
            //Finner forrige �r med norsk opptjening fra tidligste �r som inng�r i aktuell kombinasjon.
            //Dette er viktig for � unng� at man ikke bruker omsorgs�r man allerede har sett bort i fra som startpunkt for utvidet omfang.
            int tidligsteArIKombinasjon = finnTidligsteArFraListe(kombinasjon.getKombinasjon());
            Integer forrigeInntektAr = finnForrigeOpptjeningArIkkeZero(param.alleArListe, tidligsteArIKombinasjon - 1);
            //Hvis ingen tidligere �r med norsk opptjening finnes, m� kombinasjonen forkastes.
            if (forrigeInntektAr != null) {
                //Finner listen av opptjeningUT som starter p� forrige inntekts�r fra tidligste �r i aktuell kombinasjon.
                List<OpptjeningUT> listeFraForrigeInntektAr = lagListeAvOpptjeningerF�r(param.alleArListe, forrigeInntektAr);
                //Ordin�rt sett skal man finne en kombinasjon fra utvidet omfang med like mange plasser som man hadde �r med inntekt i avtaleland i kombinasjonen med 0-�r.
                //Noen ganger vil det ikke finnes nok �r i dette omfanget til � fylle alle plassene.
                //I s�fall skal man finne en kombinasjon med s� mange �r som er mulig (minst 1) fra forrige inntekts�r.
                int utvidetOmfangMaksVindu = Math.min(kombinasjon.getAntallValgteIal(), listeFraForrigeInntektAr.size());
                //Sjekker at algoritmen ikke allerede har funnet alle gyldige kombinasjoner med st�rrelse n fra dette punktet.
                if (!eksisterendeKombinasjon[param.senesteAr - forrigeInntektAr][utvidetOmfangMaksVindu]) {
                    //Merk at kombinasjon p� dette punktet er best p� leksikografisk sortering blant kombinasjoner med 0 p� alle �r og dette antall valgte ial.
                    //Opprett ny parameter for algoritmen.
                    Parametre nyParameter = new Parametre(listeFraForrigeInntektAr, forrigeInntektAr, utvidetOmfangMaksVindu);
                    //Finn inntekts�rene og generer mulige beste kombinasjoner av omsorgs�r for hvert intervall av omsorgs�r fra forrige inntekts�r
                    klargjorParametreFullIal(nyParameter, utvidetOmfangMaksVindu);
                    //Man trenger ikke lengre � finne beste kombinasjon med dette vinduet fra dette �ret.
                    eksisterendeKombinasjon[param.senesteAr - forrigeInntektAr][utvidetOmfangMaksVindu] = true;
                    nyParameter = finnBesteKombinasjoner(nyParameter, new OmsorgspoengTrygdeavtaleKombinasjon(utvidetOmfangMaksVindu, true), 0);
                    OmsorgspoengTrygdeavtaleKombinasjon besteKombinasjon = nyParameter.finnBesteKombinasjon();
                    //Den opprinnelige kombinasjonen f�r n� et felt med enda en kombinasjon som er beste fra utvidet omfang.
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
                //Hvis algoritmen har v�rt p� dette �ret, med samme antall ledige plasser, likt antall valgte ial f�r, s� har man ogs� funnet beste kombinasjon fra eventuelle
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
     * Denne rekursive metoden genererer alle kombinasjoner som kan v�re den beste kombinasjonen.
     * Visse kombinasjoner kan aldri bli beste kombinasjon og er ekskludert.
     *
     * @param param
     * @param kombinasjon Bygges inkrementelt i rekursjonen. N�r stoppkriteriet n�s (fullt med �r) tas en kopi og lagres i param. Initielt tom.
     * @param inum Hvilket inntekts�r ser vi p� n�? Initielt ser vi p� inntekts�r 0, i.e. vi ser ikke p� et inntekts�r. Telles fra seneste til tidligste.
     * @return Parametre som inneholder en liste med kombinasjoner hvor den beste er garantert � v�re inkludert.
     */
    private Parametre finnBesteKombinasjoner(
            Parametre param,
            OmsorgspoengTrygdeavtaleKombinasjon kombinasjon,
            int inum) {
        //Stoppkriterie for rekursjon. Om denne betingelsen gjelder, s� er kombinasjon en ferdig generert kombinasjon.
        if (kombinasjon.getAntallPlasser() == 0) {
            //Aktuell ferdig kombinasjon lagres. Merk at dersom utvidet omfang skal genereres s� vil en kombinasjon bli lagret b�de med og uten utvidet omfang.
            param.kombinasjonsliste.add(new OmsorgspoengTrygdeavtaleKombinasjon(kombinasjon));
        }
        //Rekursjonstilfelle.
        //Hvis vi har ledige plasser igjen, vi er p� inntekts�r 0 eller inntekts�r inum finnes.
        if (kombinasjon.getAntallPlasser() > 0 && (inum == 0 || param.inntektsAr.get(inum) != null)) {
            //Legger til neste inntekts�r hvis vi ser p� inntekts�r over 0.
            if (inum > 0) {
                kombinasjon.leggTilOpptjeningUT(param.inntektsAr.get(inum));
            }
            //Hvis det er mulig � legge til flere omsorgs�r basert p� antall inntekt�r som er valgt.
            //Vi kan ikke sjekke p� antall plasser her, fordi det er n�dvendig med enda et rekursivt kall for � n� basistilfellet.
            if (inum <= param.vindu) {
                //For hvert valg av 0,1,... antallPlasser omsorgs�r som kan v�re med i beste kombinasjon,
                //Utvid kombinasjonen med disse. Merk at algoritmen ALLTID fors�ker � utvide med ingen omsorgs�r fra intervallet.
                //Merk at sorteringen av besteOmsorgsarUtvidelser er leksikografisk, og deretter p� st�rrelse (st�rste f�rst).
                //Dette sikrer at algoritmen genererer leksikografisk tidligste kombinasjoner f�rst.
                for (List<OpptjeningUT> utvidelse : param.besteOmsorgsarUtvidelser.get(inum)) {
                    if (utvidelse.size() <= kombinasjon.getAntallPlasser()) {
                        OmsorgspoengTrygdeavtaleKombinasjon nyKombinasjon = new OmsorgspoengTrygdeavtaleKombinasjon(kombinasjon);
                        nyKombinasjon.leggTilOpptjeningUTer(utvidelse);
                        param = finnBesteKombinasjoner(param, nyKombinasjon, inum + 1);
                    }
                }
            }
        }
        //N� er alle kombinasjoner som kan v�re best generert.
        return param;
    }

    /**
     * Finner inntekts�rene og kombinasjoner av beste omsorgs�r fra hvert intervall av omsorgs�r.
     *
     * @param param
     * @param vindu
     */
    private void klargjorParametreFullIal(Parametre param, int vindu) {
        finnInntektsar(param, vindu);
        finnOmsorgsarPermutasjoner(param, vindu);
    }

    /**
     * Finner de f�rste inntekts�rene i listen av OpptjeningUT i param, og lagrer disse i param (antall gitt av "vindu")
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
     * Finner �rene etter utvidet omfang. I.e. �r slik at �ret er senere enn tidligste �r i utvidet omfang.
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
     * Inntekts�r kan enumereres fra det seneste (1), til det tidligste (5 eller mindre).
     * Det nte og det (n+1)te inntekts�ret for n+1 =< 5 definerer et intervall med omsorgs�r.
     * Noen ganger finnes det omsorgs�r senere enn det seneste inntekts�ret, av disse kan man maksimum bruke 5, 4, 3, 2, 1 og 0 i den endelige kombinasjonen.
     * Dette defineres som intervallet av omsorgs�r mellom inntekts�r 0 (ikke-eksisterende) og inntekts�r 1.
     * Et annet unntak er n�r det er f�rre enn vindu antall inntekts�r, da finnes et intervall med omsorgs�r etter det tidligste inntekts�ret.
     * Maksimalt kan man inkludere (vindu-n) �r omsorgs�r fra et slikt intervall med omsorgs�r i en kombinasjon.
     * Det er imidlertid komputasjonelt kostbart � fors�ke alle utvalg av lengde i fra intervallet av omsorgs�r etter inntekts�ret n hvor 0 =< i =< (vindu-n).
     * Denne metoden genererer for hvert intervall av omsorgs�r, et en begrenset mengde utvalg av omsorgs�r (sammenlignet med � generere alle).
     * Disse utvalgene lagres s� p� param, til bruk i rekursiv generering av alternativer. � lagre disse verdiene gj�r at de ikke m� genereres flere ganger.
     * Det er verdt � merke seg to egenskaper ved disse utvalgene:
     * - For hvert intervall av omsorgs�r, s� genereres det tomme utvalget omsorgs�r.
     * I.e. algoritmen fors�ker kombinasjoner som velger ingen omsorgs�r mellom disse inntekts�rene.
     * - Hvis det finnes to utvalg av omsorgs�r med samme lengde fra samme intervall som er identiske b�de p� �renes avkortede bel�p og ial-status,
     * s� foretrekker algoritmen til � begynne med utvalget hvis justerte bel�p er h�yest, og deretter det utvalget som har best leksikografisk sortering p� �r n�r
     * utvalgene er sortert i synkende rekkef�lge p� �r.
     *
     * @param param
     * @param vindu
     */
    private void finnOmsorgsarPermutasjoner(Parametre param, int vindu) {
        //Hvilke omsorgs�r man burde velge fra et gitt intervall avhenger av de �vrige �rene som inng�r i kombinsajonen.
        //Disse listene holder p� ulike disjunkte men kollektivt utt�mmende sorteringer av omsorgs�rene i et intervall.
        //Hver liste representerer ulike m�ter et omsorgs�r kan v�re best p� - ulike m�ter � bidra i kombinasjonen p�.
        //nStorsteOmsorgsarMellom sorterer omsorgs�rene i intervallet som ikke har IAL med avkortet bel�p over 0 p� avkortet bel�p, deretter justert bel�p, deretter �r (synkende).
        //Representerer tilfellet hvor et omsorgs�r �ker enten snitt av tre beste eller nasjonalt snitt, men ikke selv kan erstattes av nasjonalt snitt.
        List<OpptjeningUT> nStorsteOmsorgsarMellom;
        //nStorsteOmsorgsarMellom sorterer omsorgs�rene i intervallet som har IAL med avkortet bel�p over 0 p� avkortet bel�p, deretter justert bel�p, deretter �r (synkende).
        //Representerer tilfellet hvor et omsorgs�r �ker enten snitt av tre beste eller nasjonalt snitt, og som selv kan erstattes med nasjonalt snitt.
        List<OpptjeningUT> nStorsteIalArMellom;
        //nZeroArMellom sorterer omsorgs�rene i intervallet med avkortet bel�p lik 0 p� hvorvidt de har ial, deretter �rstall (synkende).
        //Representerer tilfellet hvor det er bedre �r med avkortet bel�p 0 enn �r som har avkortet bel�p over 0 da dette kan �ke det nasjonale snittet.
        //I disse tilfellene vil det v�re minst like bra om 0-�ret har ial, da dette noen ganger kan erstattes med nasjonalt snitt og �ke snittet.
        List<OpptjeningUT> nZeroArMellom;

        List<OpptjeningUT> kunNonZeroIalAr = new ArrayList<OpptjeningUT>();
        List<OpptjeningUT> kunNonZeroIkkeIalAr = new ArrayList<OpptjeningUT>();
        List<OpptjeningUT> kunZeroAr = new ArrayList<OpptjeningUT>();

        //Finn disjunkte, kollektivt utt�mmende delmengder av omsorgs�rene i hele listen av opptjeningUT.
        for (OpptjeningUT o : param.alleArListe) {
            if (!o.isInntektIAvtaleland() && o.getVerdi() > 0.0) {
                kunNonZeroIkkeIalAr.add(o);
            } else if (o.isInntektIAvtaleland() && o.getVerdi() > 0.0) {
                kunNonZeroIalAr.add(o);
            } else if (o.getVerdi() == 0.0) {
                kunZeroAr.add(o);
            }
        }

        //Iterer over hvert intervall av inntekts�r.
        int startAr = 0;
        int stoppAr = 0;
        int antallMuligeAr = 0;
        for (int i = 0; i <= vindu; i++) {
            //Funksjonalitet for � finne start og stopp�r for hvert intervall med omsorgs�r
            //Spesialtilfelle hvis f�rste intervall, da definerer ikke f�rste inntekts�r starten p� intervallet.
            //Start�r er definert av MAX_VALUE da vi �nsker � f� med alle omsorgs�rene f�r det f�rste inntekts�ret.
            if (i == 0) {
                startAr = Integer.MAX_VALUE;
                //I dette tilfellet er det ingen inntekts�r overhodet.
                //MIN_VALUE gj�r at intervallet dekker alle omsorgs�r.
                if (param.inntektsAr.get(i + 1) == null) {
                    stoppAr = Integer.MIN_VALUE;
                }
                //Her finnes det minst ett inntekts�r. Intervallet stopper n� p� �ret til inntekts�r i+1 = 1.
                else if (param.inntektsAr.get(i + 1) != null) {
                    stoppAr = param.inntektsAr.get(i + 1).getOpptjeningsar();
                }
                //Tilfelle hvor vi muligens har ett inntekts�r som definerer starten p� intervallet, som regel vil vi ha et slikt inntekts�r.
            } else if (i > 0) {
                //Tilfelle hvor vi har b�de inntekts�r i og inntekts�r i+1.
                //Da g�r intervallet med omsorgs�r fra �ret etter inntekts�r i, til, men ikke med �ret til inntekts�r i+1.
                if (param.inntektsAr.get(i) != null && param.inntektsAr.get(i + 1) != null) {
                    startAr = param.inntektsAr.get(i).getOpptjeningsar();
                    stoppAr = param.inntektsAr.get(i + 1).getOpptjeningsar();
                }
                //Tilfelle hvor vi har inntekts�r i men ikke inntekts�r i+1.
                //Intervallet omsorgs�r g�r fra �ret til inntekts�r i tom. tidligste �r.
                else if (param.inntektsAr.get(i) != null && param.inntektsAr.get(i + 1) == null) {
                    startAr = param.inntektsAr.get(i).getOpptjeningsar();
                    stoppAr = Integer.MIN_VALUE;
                }
                //Hvis ingen av inntekts�rene finnes, s� er start=stopp. Intervallet er tomt.
                else if (param.inntektsAr.get(i) == null && param.inntektsAr.get(i + 1) == null) {
                    startAr = 0;
                    stoppAr = 0;
                }
            }
            //Antall omsorgs�r vi kan velge fra det aktuelle intervallet.
            //Eks. for intervallet i=0, alts� omsorgs�rene f�r seneste inntekts�r, da kan vi velge vindu mange omsorgs�r maksimalt.
            //Som regel er dette 5.
            antallMuligeAr = vindu - i;

            //Finn de fire ordningene av omsorgs�rene i det gitte intervallet.
            nStorsteOmsorgsarMellom = finnNBesteOmsorgsarMellom(kunNonZeroIkkeIalAr, startAr, stoppAr, antallMuligeAr, new PoengtallComparator());
            nStorsteIalArMellom = finnNBesteOmsorgsarMellom(kunNonZeroIalAr, startAr, stoppAr, antallMuligeAr, new PoengtallComparator());
            nZeroArMellom = finnNBesteOmsorgsarMellom(kunZeroAr, startAr, stoppAr, antallMuligeAr, new IalPoengtallComparatorOmsorgsopptjeningTrygdeavtale());
            List<List<OpptjeningUT>> permutasjoner = new ArrayList<List<OpptjeningUT>>();
            //Finn alle distinkte mengder av omsorgs�r som kan trekkes fra toppen av de fire stablene.
            //Genererer ogs� den tomme mengden omsorgs�r, da j==0 til � begynne med.
            for (int j = 0; j <= antallMuligeAr; j++) {
                //Legg til alle utvalg / permutasjoner av omsorgs�r med lengde j valgt fra toppen av de fire stablene / ordningene.
                permutasjoner.addAll(genererOmsorgsarAlternativer(
                        nStorsteOmsorgsarMellom,
                        nStorsteIalArMellom,
                        nZeroArMellom,
                        j));
            }
            //Sorter samlingen utvalg leksikografisk, f�rst p� st�rrelse, deretter leksikografisk p� �rstall.
            Collections.sort(permutasjoner, new StorrelseOgLeksikografiskArstallComparator());
            //Lagre p� parametere
            param.besteOmsorgsarUtvidelser.put(i, permutasjoner);
        }
    }

    /**
     * Denne metoden finner alle utvalg av � velge antallPlasser omsorgs�r fra de fire stablene.
     * Dvs for alle i,j,h >= 0 hvor i+j+k+l = antallPlasser
     * S� skal utvalget med de (i) f�rste fra storsteArListe, velg de (j) f�rste fra storsteIalArListe, (h) f�rste fra zeroArListe skal v�re med.
     * Eksempelvis:
     * Utvalg med de (antallPlasser) f�rste fra storsteArListe, velg de 0 f�rste fra storsteIalArListe, 0 f�rste fra zeroArListe
     * Utvalg med de (antallPlasser) f�rste fra storsteArListe, velg de 0 f�rste fra storsteIalArListe, 0 f�rste fra zeroArListe
     * Utvalg med de (antallPlasser - 1) f�rste fra storsteArListe, velg de 1 f�rste fra storsteIalArListe, 0 f�rste fra zeroArListe
     * ...
     * Utvalg med de 0 f�rste fra storsteArListe, velg de 1 f�rste fra storsteIalArListe, (antallPlasser -1) f�rste fra zeroArListe
     * Utvalg med de 0 f�rste fra storsteArListe, velg de 0 f�rste fra storsteIalArListe, (antallPlasser) f�rste fra zeroArListe
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
                    //Det er viktig � forsikre seg om at antall plasser brukt er eksakt s� mange som skulle bli brukt f�r man legger til utvalget.
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
     * Finn de N beste opptjeningUT med omsorg i et intervall, gitt en sortering p� slike.
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
        //Legger alle omsorgs�rene mellom forste og siste �r inn i en liste
        for (OpptjeningUT o : opptjeningUTs) {
            if (o.getOpptjeningsar() < ar1 && o.getOpptjeningsar() > ar2 && o.isOmsorg()) {
                omsorgsArIIntervall.add(o);
            }
        }
        List<OpptjeningUT> deNBesteOmsorgsarene = new ArrayList<OpptjeningUT>();
        Collections.sort(omsorgsArIIntervall, comp);

        // Tar ut de (antall) st�rste omsorgs�rene og legger disse inn i deNStorsteOmsorgsarene
        deNBesteOmsorgsarene.addAll(omsorgsArIIntervall.subList(0, Math.min(antall + 1, omsorgsArIIntervall.size())));
        return deNBesteOmsorgsarene;
    }

    /**
     * Finn tidligste �r i liste av OpptjeningUT. Null hvis listen er tom.
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
     * Finn seneste �r i liste av OpptjeningUT. Null hvis listen er tom.
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
     * Finn OpptjeningUT for et gitt �rstall fra liste. Null hvis ingen slik finnes.
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
     * Finn forrige �r med avkortetBelop>0. Null hvis dette �ret ikke finnes.
     * Brukes n�r man skal finne utvidet omfang dersom ingen norsk opptjening i noen av �rene, noen av �rene har ial.
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
     * Finn listen av OpptjeningUT med �rstall minst like tidlig som ar.
     * Tom liste hvis ingen slike finnes.
     *
     * @param liste
     * @param ar
     * @return
     */
    private List<OpptjeningUT> lagListeAvOpptjeningerF�r(List<OpptjeningUT> liste, int ar) {
        List<OpptjeningUT> nyListe = new ArrayList<OpptjeningUT>();
        for (OpptjeningUT o : liste) {
            if (o.getOpptjeningsar() <= ar) {
                nyListe.add(o);
            }
        }
        return nyListe;
    }

    /**
     * Hjelpeklasse for � finne beste kombinasjon av opptjeningUT med trygdeavtaler.
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
         * Finn den beste kombinasjonen. Forutsetter at alle kombinasjoner er generert, og at kombinasjoner med utvidet omfang har f�tt fastsatt nasjonalt snitt fra utvidet omfang.
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
                //Sammenligner p� uavrundet beregningsgrunnlag, deretter sum av de tre beste sine avkortede bel�p,
                //deretter leksikografisk p� �rstall n�r kombinasjoner (ikke fra utvidet omfang) er sortert synkende p� �r.
                else if (hittilBeste.compareTo(k) > 0) {
                    hittilBeste = k;
                }
            }
            return hittilBeste;
        }
    }
}
