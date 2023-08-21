package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.kode.EksportUnntakCti;

import java.io.Serializable;

public class Eksportforbud implements Serializable {

    private static final long serialVersionUID = 5793974025276989318L;

    /**
     * Angir om personen har eksportforbud eller ikke.
     */
    @GuiPrompt(prompt = "Eksportforbud")
    boolean forbud;

    /**
     * Angir type eksportunntak.
     */
    @GuiPrompt(prompt = "Eksport unntak")
    EksportUnntakCti unntakType;

    /**
     * Copy Constructor
     * 
     * @param eksportforbud a <code>Eksportforbud</code> object
     */
    public Eksportforbud(Eksportforbud eksportforbud) {
        forbud = eksportforbud.forbud;
        if (eksportforbud.unntakType != null) {
            unntakType = new EksportUnntakCti(eksportforbud.unntakType);
        }
    }

    public Eksportforbud() {
        super();
    }

    public Eksportforbud(boolean forbud, EksportUnntakCti unntakType) {
        super();
        this.forbud = forbud;
        this.unntakType = unntakType;
    }

    public boolean isForbud() {
        return forbud;
    }

    public void setForbud(boolean forbud) {
        this.forbud = forbud;
    }

    public EksportUnntakCti getUnntakType() {
        return unntakType;
    }

    public void setUnntakType(EksportUnntakCti unntakType) {
        this.unntakType = unntakType;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     * 
     * @return a <code>String</code> representation
     *         of this object.
     */
    @Override
    public String toString() {
        final String TAB = "    ";

        StringBuilder retValue = new StringBuilder();

        retValue.append("Eksportforbud ( ").append(super.toString()).append(TAB).append("forbud = ").append(forbud).append(TAB).append("unntakType = ").append(unntakType)
                .append(TAB).append(" )");

        return retValue.toString();
    }

}
