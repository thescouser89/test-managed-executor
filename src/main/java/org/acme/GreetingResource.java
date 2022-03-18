package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.context.ManagedExecutor;

@Path("/hello")
public class GreetingResource {

    @Inject
    ManagedExecutor executorFirst;

    @Inject
    ManagedExecutor executorSecond;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "" + executorFirst.equals(executorSecond);
    }
}