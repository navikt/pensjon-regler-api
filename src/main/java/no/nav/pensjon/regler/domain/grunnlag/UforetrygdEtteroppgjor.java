package no.nav.pensjon.regler.domain.grunnlag;


import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static no.nav.pensjon.regler.domain.util.DateCopyUtil.copyDate;
import static no.nav.pensjon.regler.domain.util.ListUtil.deepCopyList;

/**
 * @author Tatyana Lochehina PK-13673
 * @author Swiddy de Louw (Capgemini) PK-13673
 */
public class UforetrygdEtteroppgjor implements Serializable {

    private static final long serialVersionUID = -8016458021980741278L;

    /**
     * Angir om det har vært arbeidsforsøk i etteroppgjørsåret.
     */

    private boolean arbeidsforsok;

    /**
     * Angir start av arbeidsforsøk.
     */

    private Date arbeidsforsokFom;

    /**
     * Angir slutt av arbeidsforsøk.
     */

    private Date arbeidsforsokTom;


    private List<UforetrygdEtteroppgjorDetalj> detaljer = new ArrayList<UforetrygdEtteroppgjorDetalj>();

    /**
     * Angir start av uføretrygd i etteroppgjørsåret.
     */

    private Date periodeFom;

    /**
     * Angir slutt av uføretrygd i etteroppgjørsåret.
     */

    private Date periodeTom;

    public UforetrygdEtteroppgjor() {
        super();
    }

    public UforetrygdEtteroppgjor(UforetrygdEtteroppgjor uforetrygdEtteroppgjor) {
        this();
        arbeidsforsok = uforetrygdEtteroppgjor.arbeidsforsok;
        detaljer = deepCopyList(uforetrygdEtteroppgjor.detaljer);

        periodeFom = copyDate(uforetrygdEtteroppgjor.periodeFom);
        periodeTom = copyDate(uforetrygdEtteroppgjor.periodeTom);
        arbeidsforsokFom = copyDate(uforetrygdEtteroppgjor.arbeidsforsokFom);
        arbeidsforsokTom = copyDate(uforetrygdEtteroppgjor.arbeidsforsokTom);
    }

    public Date getArbeidsforsokFom() {
        return arbeidsforsokFom;
    }

    public Date getArbeidsforsokTom() {
        return arbeidsforsokTom;
    }

    public List<UforetrygdEtteroppgjorDetalj> getDetaljer() {
        return detaljer;
    }

    public UforetrygdEtteroppgjorDetalj[] getDetaljerAsArray() {
        return detaljer != null ? detaljer.toArray(new UforetrygdEtteroppgjorDetalj[detaljer.size()]) : new UforetrygdEtteroppgjorDetalj[0];
    }

    public Date getPeriodeFom() {
        return periodeFom;
    }

    public Date getPeriodeTom() {
        return periodeTom;
    }

    public boolean isArbeidsforsok() {
        return arbeidsforsok;
    }

    public void setArbeidsforsok(boolean arbeidsforsok) {
        this.arbeidsforsok = arbeidsforsok;
    }

    public void setArbeidsforsokFom(Date arbeidsforsokFom) {
        this.arbeidsforsokFom = arbeidsforsokFom;
    }

    public void setArbeidsforsokTom(Date arbeidsforsokTom) {
        this.arbeidsforsokTom = arbeidsforsokTom;
    }

    public void setDetaljer(List<UforetrygdEtteroppgjorDetalj> detaljer) {
        this.detaljer = detaljer;
    }

    public void setPeriodeFom(Date periodeFom) {
        this.periodeFom = periodeFom;
    }

    public void setPeriodeTom(Date periodeTom) {
        this.periodeTom = periodeTom;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

    public UforetrygdEtteroppgjorDetalj getUforetrygdEtteroppgjorDetalj(String grunnlagsrolle) {
        for (UforetrygdEtteroppgjorDetalj ued : detaljer) {
            if (ued.getGrunnlagsrolle().getKode().equals(grunnlagsrolle)) {
                return ued;
            }
        }
        return null;
    }
}
