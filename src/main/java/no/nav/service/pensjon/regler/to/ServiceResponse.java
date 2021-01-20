package no.nav.service.pensjon.regler.to;

import java.io.Serializable;


/**
 * The base class for all service responses, which are serializable.
 * 
 * @version $Id$
 */
public abstract class ServiceResponse implements Serializable {
	/** Used to ensure backwards compatability when serializing instances. */
	private static final long serialVersionUID = 8537404654247801408L;
}
