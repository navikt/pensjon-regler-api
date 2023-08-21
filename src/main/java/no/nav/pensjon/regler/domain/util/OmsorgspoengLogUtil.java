package no.nav.pensjon.regler.domain.util;

import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.Omsorgsopptjening;
import no.nav.pensjon.regler.domain.beregning.Poengtall;
import no.nav.pensjon.regler.domain.beregning2011.OpptjeningUT;
import org.slf4j.Logger;

import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/**
 * Klasse for å logge fra klassene
 * Omsorgspoeng og OmsorgspoengTrygdeavtale
 *
 * @author Lars Hartviksen (Decisive), PK-9695
 * Date: 02.05.14
 * Time: 11:54
 */
public class OmsorgspoengLogUtil {
    private static String finnesIkke = " - ";
    private static String nl = String.format("%1$3s", System.getProperty("line.separator") + " ");

    public static void printOmsorgsopptjeningListe(List<Omsorgsopptjening> list, Logger log) {
        String s = "";
        for (Omsorgsopptjening o : list){
            s+=(String.format("%14d", o.getOpptjeningsar()));
        }
        log.debug("Arstallene: "+s);
        s="";
        for (Omsorgsopptjening o : list){
            s+=(String.format("%13.2f", Math.round(100*o.getVerdi())/100.0));
            s+=(""+((o.isInntektIAvtaleland())?"*":" "));
        }
        log.debug("Opptjening: "+s);
    }

    public static void printRefppListe(List<Ref_pp> list, boolean visBrukt, Logger log) {
        String s = "";
        for (Ref_pp r : list){
            s += (String.format("%14d", r.pt.getOpptjeningsar()));
        }
        log.debug("Arstallene: "+s);
        s="";
        for (Ref_pp r: list){
            s+=(String.format("%13.2f", r.pt.getVerdi()));
            s+=(""+((r.pt.isInntektIAvtaleland())?"*":" "));
        }
        log.debug("Opptjening: "+s);
        s="";
        for (Ref_pp r: list){
            s+=(String.format("%14.2f", r.poengtall));
        }
        if (visBrukt) log.debug("Brukt:      "+s);
    }
    public static void printRekke(String tittel, List<Omsorgsopptjening> list, Logger log) {
        log.debug(tittel);
        log.debug(poengtallListeString(list));
    }
    private static String poengtallListeString(List<Omsorgsopptjening> list) {
        if (list == null || list.size() == 0) {
            return finnesIkke;
        }
        StringBuilder buf = new StringBuilder();
        buf.append(String.format("%1$3s %2$6s %3$5s %4$5s %5$7s %6$7s %7$6s %8$6s %9$5s %10$1s %11$s",nl,"type","ar","pp","pi","pia","gv","brukt","maksUfg","","Merknader"));
        for (Omsorgsopptjening pt : list) {
            if (pt != null && pt instanceof Poengtall) buf.append(nl+poengtallString(pt));
            if (pt != null && pt instanceof OpptjeningUT) buf.append(nl+opptjeningUTString(pt));
        }
        return buf.toString();
    }
    private static String opptjeningUTString(Omsorgsopptjening o) {
        if (o == null || !(o instanceof OpptjeningUT)) {
            return finnesIkke;
        }
        OpptjeningUT p= (OpptjeningUT) o;
        StringBuilder buf = new StringBuilder();
        String ial = (p.isInntektIAvtaleland()?"IAL":finnesIkke);
        String omsorg = (p.isOmsorg()?"OMSORG":finnesIkke);
        Formatter f = new Formatter(buf, Locale.US);
        f.format("%1$6s %2$5d %3$7s %4$7s %5$7s %6$6s %7$6s %8$5s %9$1s %10$s", omsorg, p.getAr(), p.getAvkortetBelop(), ial, finnesIkke, finnesIkke, finnesIkke,
                finnesIkke, "", finnesIkke);
        f.close();
        return buf.toString();
    }
    private static String poengtallString(Omsorgsopptjening o) {
        if (o == null || !(o instanceof Poengtall)) {
            return finnesIkke;
        }
        Poengtall p = (Poengtall) o;
        StringBuilder buf = new StringBuilder();
        String kode = finnesIkke;
        if (p.getPoengtallType() != null) {
            kode = p.getPoengtallType().getKode();
        }
        Formatter f = new Formatter(buf, Locale.US);
        f.format("%2$6s %3$5d %4$5s %5$7d %6$7d %7$6d %8$6b %9$5d %10$1s %11$s", null, kode, p.getAr(), p.getPp(), p.getPi(), p.getPia(), p.getGv(), p.getBruktIBeregning(),
                p.getMaksUforegrad(), "", merknaderEnLinjeString(p.getMerknadListe()));
        f.close();
        return buf.toString();
    }
    private static String merknaderEnLinjeString(List<Merknad> list) {
        if (list == null || list.size() == 0) {
            return finnesIkke;
        }
        StringBuilder buf = new StringBuilder();
        for (Merknad m : list) {
            buf.append(m.getKode()).append(", ");
        }
        return buf.toString();
    }
    public static void printRedusertRekke(List<Ref_pp> ikkeOmsorgsar, List<Ref_pp>[] o, Logger log) {
        String s = "";
        s+= String.format("%1$3s %2$13s %3$15s %4$2s %5$15s %6$2s %7$15s %8$2s %9$30s %10$2s %11$15s %12$2s %13$45s %14$2s %15$15s %16$15s"
                ,nl,"Redusert til:", "i1", " {","o1","} ", "i2", " {","o2","} ", "i3", " {","o3","} ", "i4", "i5");
        s+= String.format("%1$3s %2$13s %3$15s %4$2s %5$15s %6$2s %7$15s %8$2s %9$30s %10$2s %11$15s %12$2s %13$45s %14$2s %15$15s %16$15s",
                            nl,//1
                            "arstall:",//2
                            ikkeOmsorgsar.get(0).pt.getOpptjeningsar(),//3
                            " {",//4
                            refArListString(o[0]),//5
                            "} ",//6
                            refarString(ikkeOmsorgsar.get(1)),//7
                            " {",//8
                            refArListString(o[1]),//9
                            "} ",//10
                refarString(ikkeOmsorgsar.get(2)),//11
                            " {",//12
                            refArListString(o[2]),//13
                            "} ",//14
                refarString(ikkeOmsorgsar.get(3)),//15
                refarString(ikkeOmsorgsar.get(4)));//16

        log.debug(s+ String.format("%1$3s %2$13s %3$15s %4$2s %5$15s %6$2s %7$15s %8$2s %9$30s %10$2s %11$15s %12$2s %13$45s %14$2s %15$15s %16$15s",
                nl,
                "opptjening:",
                refppString(ikkeOmsorgsar.get(0)),
                " {",
                refppListString(o[0]),
                "} ",
                refppString(ikkeOmsorgsar.get(1)),
                " {",
                refppListString(o[1]),
                "} ",
                refppString(ikkeOmsorgsar.get(2)),
                " {",
                refppListString(o[2]),
                "} ",
                refppString(ikkeOmsorgsar.get(3)),
                refppString(ikkeOmsorgsar.get(4))));
    }

    private static String refarString(Ref_pp r){
        if (r.pt != null) return String.format("%1$12d %2$2s",r.pt.getOpptjeningsar(), "  ");
        return String.format("%1$12d %2$3s","NULLAR", "#_#");
    }

    private static String refppString(Ref_pp r){
        if (r.pt != null) return String.format("%1$12.2f %2$2s",r.pt.getVerdi(), ((r.pt.isInntektIAvtaleland())? "* ": "  "));
        return String.format("%1$12s %2$3s","NULL", "#_#");
    }

    public static String refppListString(List<Ref_pp> o) {
        String s = "";
        if (o != null) {
            for (Ref_pp p : o) {
                if (p.pt != null) {
                    s = s + String.format("%1$12.2f %2$2s",p.pt.getVerdi(),((p.pt.isInntektIAvtaleland())? "* " : "  " ));
                }
            }
        }
        return s.trim();
    }

    public static String refArListString(List<Ref_pp> o) {
        String s = "";
        if (o != null) {
            for (Ref_pp p : o) {
                if (p.pt != null) {
                    s = s + String.format("%1$12d %2$2s", p.pt.getOpptjeningsar(), "  ");
                }
            }
        }
        return s.trim();
    }
}
