package de.fherfurt;

import de.fherfurt.resources.BaseResource;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URI;

public class WebApplication {

    public static final String BASE_URI = "http://localhost:8080";

    public static Server startServer()
    {
        final ResourceConfig config = new ResourceConfig(BaseResource.class);
        final Server server = JettyHttpContainerFactory.createServer(URI.create(BASE_URI), config);

        return server;
    }

    public static void main(String[] args){
        Logger LOG = LoggerFactory.getLogger(WebApplication.class);

        try{
            final Server server = startServer();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try{
                    LOG.info("Shutting down");
                    server.stop();
                    LOG.info("Done");
                }catch(Exception e){
                    LOG.error(null, e);
                }
            }));
            LOG.info("Application started");
            Thread.currentThread().join();
        }catch (InterruptedException ex){
            LOG.error(null, ex);
        }
    }
}
