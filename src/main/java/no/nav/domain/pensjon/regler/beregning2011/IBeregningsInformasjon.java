package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.kode.BeregningMetodeTypeCti;
import no.nav.domain.pensjon.regler.kode.JustertPeriodeCti;
import no.nav.domain.pensjon.regler.kode.LandCti;
import no.nav.domain.pensjon.regler.kode.ResultatTypeCti;

import java.util.List;

public interface IBeregningsInformasjon {

    public abstract PenPerson getPenPerson();

    public abstract void setPenPerson(PenPerson penPerson);

    public abstract BeregningMetodeTypeCti getBeregningsMetode();

    public abstract void setBeregningsMetode(BeregningMetodeTypeCti beregningsMetode);

    public abstract boolean isEnsligPensjonInstOpph();

    public abstract void setEnsligPensjonInstOpph(boolean ensligPensjonInstOpph);

    public abstract JustertPeriodeCti getInstOppholdType();

    public abstract void setInstOppholdType(JustertPeriodeCti instOppholdType);

    public abstract boolean isInstOpphAnvendt();

    public abstract void setInstOpphAnvendt(boolean instOpphAnvendt);

    public abstract ResultatTypeCti getResultatType();

    public abstract void setResultatType(ResultatTypeCti resultatType);

    public abstract List<TapendeBeregningsmetode> getTapendeBeregningsmetodeListe();

    public abstract void setTapendeBeregningsmetodeListe(List<TapendeBeregningsmetode> tapendeBeregningsmetodeListe);

    public abstract Integer getTrygdetid();

    public abstract void setTrygdetid(Integer trygdetid);

    public abstract int getTt_anv();

    public abstract void setTt_anv(int tt_anv);

    public abstract LandCti getVurdertBosattland();

    public abstract void setVurdertBosattland(LandCti vurdertBosattland);

    public abstract boolean isEksport();

    public abstract void setEksport(boolean eksport);
}
