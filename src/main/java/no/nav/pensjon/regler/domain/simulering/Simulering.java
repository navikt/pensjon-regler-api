/*
 * Created on Jan 10, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package no.nav.pensjon.regler.domain.simulering;

import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag;
import no.nav.pensjon.regler.domain.kode.AfpOrdningTypeCti;
import no.nav.pensjon.regler.domain.kode.SimuleringTypeCti;
import no.nav.pensjon.regler.domain.util.ToStringUtil;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Simulering
 */
public class Simulering implements Serializable {

    private static final long serialVersionUID = 5255513491684380283L;

    /**
     * Type simulering
     */
    private SimuleringTypeCti simuleringType;

    /**
     * Type AFP ordning
     */
    private AfpOrdningTypeCti afpOrdning;

    /**
     * Dato for når bruker ønsker å simulere uttak av pensjon fra.
     */
    private Date uttaksdato;

    /**
     * Liste av tilknyttede personer.
     */
    private List<Persongrunnlag> persongrunnlagListe;

    private List<VilkarsVedtak> vilkarsvedtakliste;

    public Simulering(SimuleringTypeCti ytelseType, AfpOrdningTypeCti afpOrdning, Date uttaksdato, List<Persongrunnlag> persongrunnlagListe, List<VilkarsVedtak> vilkarsvedtakliste) {
        super();
        simuleringType = ytelseType;
        this.afpOrdning = afpOrdning;
        this.uttaksdato = uttaksdato;
        this.persongrunnlagListe = persongrunnlagListe;
        this.vilkarsvedtakliste = vilkarsvedtakliste;
    }

    public Simulering() {
        persongrunnlagListe = new ArrayList<Persongrunnlag>();
        vilkarsvedtakliste = new ArrayList<VilkarsVedtak>();
    }

    /**
     * @return Returns the afpOrdning.
     */
    public AfpOrdningTypeCti getAfpOrdning() {
        return afpOrdning;
    }

    /**
     * @param afpOrdning
     *            The afpOrdning to set.
     */
    public void setAfpOrdning(AfpOrdningTypeCti afpOrdning) {
        this.afpOrdning = afpOrdning;
    }

    public List<Persongrunnlag> getPersongrunnlagListe() {
        return persongrunnlagListe;
    }

    public void setPersongrunnlagListe(List<Persongrunnlag> persongrunnlagListe) {
        this.persongrunnlagListe = persongrunnlagListe;
    }

    /**
     * @deprecated
     * @return Returns the persongrunnlagListe as array.
     */
    @Deprecated
    public Persongrunnlag[] retrievePersongrunnlagListeAsArray() {
        return persongrunnlagListe.toArray(new Persongrunnlag[0]);
    }

    /**
     * Read only property for persongrunnlagListe as array.
     * 
     * @return array of Persongrunnlag
     */
    public Persongrunnlag[] getPersongrunnlagListeAsArray() {
        return persongrunnlagListe != null ? persongrunnlagListe.toArray(new Persongrunnlag[persongrunnlagListe.size()]) : new Persongrunnlag[0];
    }

    public SimuleringTypeCti getYtelseType() {
        return simuleringType;
    }

    public void setYtelseType(SimuleringTypeCti ytelseType) {
        simuleringType = ytelseType;
    }

    public List<VilkarsVedtak> getVilkarsvedtakliste() {
        return vilkarsvedtakliste;
    }

    public void setVilkarsvedtakliste(List<VilkarsVedtak> vilkarsvedtakliste) {
        this.vilkarsvedtakliste = vilkarsvedtakliste;
    }

    /**
     * @deprecated
     * @return
     */
    @Deprecated
    public VilkarsVedtak[] retrieveVilkarsvedtakListeAsArray() {
        return vilkarsvedtakliste.toArray(new VilkarsVedtak[0]);
    }

    /**
     * Read only property for vilkarsvedtakListe as array.
     * 
     * @return array of VilkarsVedtak
     */
    public VilkarsVedtak[] getVilkarsvedtakListeAsArray() {
        return vilkarsvedtakliste != null ? vilkarsvedtakliste.toArray(new VilkarsVedtak[vilkarsvedtakliste.size()]) : new VilkarsVedtak[0];
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

    public SimuleringTypeCti getSimuleringType() {
        return simuleringType;
    }

    public void setSimuleringType(SimuleringTypeCti simuleringType) {
        this.simuleringType = simuleringType;
    }

    public Date getUttaksdato() {
        return uttaksdato;
    }

    public void setUttaksdato(Date uttaksdato) {
        this.uttaksdato = uttaksdato;
    }
}
