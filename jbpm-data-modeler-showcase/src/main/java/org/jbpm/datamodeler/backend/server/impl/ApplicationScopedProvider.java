package  org.jbpm.datamodeler.backend.server.impl;

import org.kie.commons.io.IOService;
import org.kie.commons.io.impl.IOServiceDotFileImpl;
import org.uberfire.backend.repositories.Repository;
import org.uberfire.backend.server.repositories.DefaultSystemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class ApplicationScopedProvider {
    private final DefaultSystemRepository systemRepository = new DefaultSystemRepository();
    private final IOService ioService         = new IOServiceDotFileImpl();

    @Produces
    @Named("system")
    public Repository systemRepository() {
        return systemRepository;
    }

//    @Produces
//    @Named("ioStrategy")
//    public IOService ioService() {
//        return ioService;
//
//    }
}