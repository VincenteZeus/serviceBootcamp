/*
 * Bignon
 */
package com.bootcamp.rest.exception;

import javax.ws.rs.core.Response;

/**
 *
 * @author edwigegédéon
 */
public class ReturnMsgResponse {
    public static Response message(String msg) {
            return Response.status(200).entity("\n"+msg).build();
	}
}
