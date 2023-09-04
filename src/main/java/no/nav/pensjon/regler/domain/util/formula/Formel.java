package no.nav.pensjon.regler.domain.util.formula;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Formel implements Serializable {
    private static final long serialVersionUID = 111864321440574836L;

    private String navn;
    private String emne;
    private String prefix;
    private String felt;
    private Number resultat;
    private String notasjon;
    private String innhold;
    private int vekt;
    private boolean requiresValidation;
    private boolean renameAllowed;
    private boolean domain;
    private boolean autoResolve;
    private HashMap<String, Number> varMap;
    private HashMap<String, Formel> formelVarMap;
    private ArrayList<Formel> subFormelList;
    private HashSet<String> tokenSet;

    public Formel() {
        this.emne = "";
        this.prefix = "";
        this.notasjon = "";
        this.varMap = new HashMap<>();
        this.formelVarMap = new HashMap<>();
        this.subFormelList = new ArrayList<>();
        this.tokenSet = new HashSet<>();
    }

    public Formel(Formel f) {
        this.navn = f.navn;
        this.emne = f.emne;
        this.prefix = f.prefix;
        this.felt = f.felt;
        this.resultat = f.resultat;
        this.notasjon = f.notasjon;
        this.innhold = f.innhold;
        this.vekt = f.vekt;
        this.requiresValidation = f.requiresValidation;
        this.renameAllowed = f.renameAllowed;
        this.domain = f.domain;
        this.autoResolve = f.autoResolve;
        this.tokenSet = new HashSet<>(f.tokenSet);
        this.varMap = new HashMap<>(f.varMap);
        this.formelVarMap = new HashMap<>();
        if (!f.formelVarMap.isEmpty()) {
            for (Map.Entry<String, Formel> pair : f.formelVarMap.entrySet()) {
                formelVarMap.put(pair.getKey(), new Formel(pair.getValue()));
            }
        }
        this.subFormelList = new ArrayList<>();
        for (Formel subFormel : f.subFormelList) {
            this.subFormelList.add(new Formel(subFormel));
        }
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEmne() {
        return emne;
    }

    public void setEmne(String emne) {
        this.emne = emne;
    }

    public String getFelt() {
        return felt;
    }

    public void setFelt(String felt) {
        this.felt = felt;
    }

    public Number getResultat() {
        return resultat;
    }

    public void setResultat(Number resultat) {
        this.resultat = resultat;
    }

    public String getNotasjon() {
        return notasjon;
    }

    public void setNotasjon(String notasjon) {
        this.notasjon = notasjon;
    }

    public String getInnhold() {
        return innhold;
    }

    public void setInnhold(String innhold) {
        this.innhold = innhold;
    }

    public int getVekt() {
        return vekt;
    }

    public void setVekt(int vekt) {
        this.vekt = vekt;
    }

    public boolean isRequiresValidation() {
        return requiresValidation;
    }

    public void setRequiresValidation(boolean requiresValidation) {
        this.requiresValidation = requiresValidation;
    }

    public HashMap<String, Number> getVarMap() {
        return varMap;
    }

    public void setVarMap(HashMap<String, Number> varMap) {
        this.varMap = varMap;
    }

    public ArrayList<Formel> getSubFormelList() {
        return subFormelList;
    }

    public void setSubFormelList(ArrayList<Formel> subFormelList) {
        this.subFormelList = subFormelList;
    }

    public HashMap<String, Formel> getFormelVarMap() {
        return formelVarMap;
    }

    public void setFormelVarMap(HashMap<String, Formel> formelVarMap) {
        this.formelVarMap = formelVarMap;
    }

    public boolean isRenameAllowed() {
        return renameAllowed;
    }

    public void setRenameAllowed(boolean renameAllowed) {
        this.renameAllowed = renameAllowed;
    }

    public boolean isDomain() {
        return domain;
    }

    public void setDomain(boolean domain) {
        this.domain = domain;
    }

    public boolean isAutoResolve() {
        return autoResolve;
    }

    public void setAutoResolve(boolean autoResolve) {
        this.autoResolve = autoResolve;
    }

    public HashSet<String> getTokenSet() {
        return tokenSet;
    }

    public void setTokenSet(HashSet<String> tokenSet) {
        this.tokenSet = tokenSet;
    }

    @Override
    public String toString() {
        return toTreeString(0, Integer.MAX_VALUE);
    }

    public String toString(int maxLevel) {
        return toTreeString(0, maxLevel);
    }

    private String toTreeString(int level, int maxLevel) {
        StringBuilder s = new StringBuilder();

        s.append(StringUtils.repeat(' ', level * 2)).append("Formelnavn: '" + navn
                + "' felt: '" + (felt == null ? "---" : felt)
                + "' domain: " + domain
                + " level: " + level
                + " resultat: " + (resultat == null ? "---" : resultat)
                + " vekt: " + vekt
                + " ant.subFormler: " + subFormelList.size()
                + " hash: " + this.hashCode()
                + "\n");
        s.append(StringUtils.repeat(' ', level * 2)).append("    notasjon:\t'" + notasjon + "'\n");
        s.append(StringUtils.repeat(' ', level * 2)).append("    innhold: \t'" + innhold + "'" + (resultat == null ? "" : " = " + resultat) + "\n");
        s.append(StringUtils.repeat(' ', level * 2)).append("    varMap:  \t" + varMap.toString() + "\n");
        s.append(StringUtils.repeat(' ', level * 2)).append("    formelVarMap (keys):  \t" + formelVarMap.keySet() + "\n");

        if (level < maxLevel) {
            for (Formel f : subFormelList) {
                s.append(f.toTreeString(level + 1, maxLevel));
            }
        }
        return s.toString();
    }

    public String toHTML() {
        return toTreeHTML(0, Integer.MAX_VALUE);
    }

    public String toHTML(int maxLevel) {
        return toTreeHTML(0, maxLevel);
    }

    public String toTreeHTML(int level, int maxLevel) {
        StringBuilder s = new StringBuilder();

        s.append(StringUtils.repeat(' ', level * 2)).append("<formel title='" + navn
                + "' felt='" + (felt == null ? "---" : felt)
                + "' domain='" + domain
                + "' level='" + level
                + "' resultat='" + (resultat == null ? "---" : resultat)
                + "' vekt='" + vekt
                + "' antSubFormler='" + subFormelList.size()
                + "' >\n");
        s.append(StringUtils.repeat(' ', level * 2 + 2)).append("<fl>" + navn + " = " + notasjon + "</fl>\n");
        s.append(StringUtils.repeat(' ', level * 2 + 2)).append("<fl>" + navn + " = " + innhold + "</fl>\n");
        s.append(StringUtils.repeat(' ', level * 2 + 2)).append("<fl>" + navn + " = " + resultat + "</fl>\n");

        if (level < maxLevel) {
            for (Formel f : subFormelList) {
                s.append(f.toTreeHTML(level + 1, maxLevel));
            }
        }
        s.append(StringUtils.repeat(' ', level * 2)).append("</formel>\n");
        return s.toString();
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
