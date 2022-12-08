package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.kode.GrunnlagKildeCti;
import no.nav.domain.pensjon.regler.kode.SivilstandTypeCti;

import java.io.Serializable;
import java.util.Date;

public class Sivilstand implements Serializable {



    /**
     * Kode som angir hvilken type sivilstand personen har.
     */
    private SivilstandTypeCti sivilstandType;

    /**
     * Sivilstandens gyldighet fra-og-med dato.
     */
    private Date fom;

    /**
     * Sivilstandens gyldighet til-og-med dato
     */
    private Date tom;

    /**
     * Person sivilstanden refererer seg til, for eksempel ektefellen hvis <em>sivilstandType</em>="Ektefelle"
     */
    private PenPerson relatertPerson;

    /**
     * Angir sivilstandens kilde.
     */
    private GrunnlagKildeCti kilde;

}
