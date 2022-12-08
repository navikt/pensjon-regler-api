package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.Merknad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Magnus Bakken (Accenture), PK-10597
 * @author Lars Hartviksen (Decisive), PK-6180
 */
public abstract class AbstraktBeregningsvilkar implements Serializable {

    protected List<Merknad> merknadListe;


}
