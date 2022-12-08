package no.nav.service.pensjon.regler.to;

import java.io.Serializable;

/**
 * The base class for all service requests, which are serializable and may contain a <code>RequestContext</code>.
 * 
 * @see RequestContext
 * @version $Id$
 */
public abstract class ServiceRequest implements Serializable {

	/** The <code>RequestContext</code> instance to use. */
	private RequestContext requestContext;

}
