package no.nav.pensjon.regler.to;

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

	/**
	 * Returns the <code>RequestContext</code> instance to use.
	 * 
	 * Used reflectively by the Stelvio framework. Application code should not work directly with this
	 * <code>RequestContext</code>, instead use {@link no.stelvio.common.context.RequestContextHolder} to get hold of the
	 * current instance.
	 * 
	 * @return the <code>RequestContext</code> instance to use.
	 * @see no.stelvio.common.context.RequestContext
	 * @deprecated Application code should not work directly with this <code>RequestContext</code>, instead use
	 *             {@link no.stelvio.common.context.RequestContextHolder} to get hold of the current instance. Must stop using
	 *             interceptors between RequestContextHolder and ServiceRequest before deleting the method.
	 */
	@Deprecated
	public RequestContext getRequestContext() {
		// private RequestContext getRequestContext() {
		return requestContext;
	}

	/**
	 * Should only be set by reflection through interceptors used when the transfer object goes through layers.
	 * 
	 * @param requestContext
	 *            The <code>RequestContext</code> instance to use.
	 * @see no.stelvio.common.context.RequestContext
	 * @deprecated Application code should not work directly with this <code>RequestContext</code>, instead use
	 *             {@link no.stelvio.common.context.RequestContextHolder} to get hold of the current instance. Must stop using
	 *             interceptors between RequestContextHolder and ServiceRequest before deleting the method.
	 */
	@Deprecated
	protected void setRequestContext(RequestContext requestContext) {
		// private void setRequestContext(RequestContext requestContext) {
		this.requestContext = requestContext;
	}
}
