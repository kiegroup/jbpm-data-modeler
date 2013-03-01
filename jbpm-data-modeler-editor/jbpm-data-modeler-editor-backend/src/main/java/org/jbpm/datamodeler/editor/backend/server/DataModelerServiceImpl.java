package org.jbpm.datamodeler.editor.backend.server;

import org.jboss.errai.bus.server.annotations.Service;
import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.editor.backend.server.DataModelHelper;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.service.DataModelerService;
import org.jbpm.datamodeler.impexp.codegen.GenerationContext;
import org.jbpm.datamodeler.impexp.codegen.GenerationEngine;
import org.kie.commons.java.nio.file.OpenOption;
import org.kie.commons.java.nio.file.StandardOpenOption;
import org.uberfire.backend.vfs.Path;
import org.uberfire.backend.server.util.Paths;

import org.kie.commons.io.IOService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@ApplicationScoped
public class DataModelerServiceImpl implements DataModelerService {

    @Inject
    @Named("ioStrategy")
    IOService ioService;

    @Inject
    private Paths paths;

    public DataModelerServiceImpl() {
    }

    @Override
    public DataModelTO loadModel(Path path) {
        System.out.println("read this path: " + path);

        try {

            final String content = ioService.readAllString( paths.convert( path ) );

            System.out.println("the file content is: " + content);


        } catch (Exception e) {
            e.printStackTrace();
        }


        //TODO: implement the correct model loading
        DataModelTO dataModel = new DataModelTO("TestModel");
        List<DataObjectTO> dataObjects = new ArrayList<DataObjectTO>();
        for (int i=0; i< 10 ; i++) {
            dataObjects.add(new DataObjectTO(i));
        }
        dataModel.setDataObjects(dataObjects);

        return dataModel;
    }

    @Override
    public void saveModel(DataModelTO dataModel, Path path) {

        try {

            String content = ioService.readAllString( paths.convert( path ) );

            content = content + " - file was saved at: " + new Date();
            ioService.write(paths.convert(path), content);

            //convert to the domain model
            DataModel dataModelDomain = DataModelHelper.to2Domain(dataModel);

            GenerationContext generationContext = new GenerationContext(dataModelDomain);
            generationContext.addTemplateSet("POJOS");
            generationContext.setOutputPath("/tmp");
            generationContext.setPackageName("org.jboss.test");


            GenerationEngine generationEngine = GenerationEngine.getInstance();
            generationEngine.init();
            generationEngine.generateAllTemplates(generationContext);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Path createModel(Path context, String fileName) {

        org.kie.commons.java.nio.file.Path kiePath = paths.convert( context ).resolve( fileName );

        //create the file to support the model
        //TODO implement the "DataModelBuilder" that creates the empty model xml file
        ioService.createFile(kiePath);
        
        ioService.write(kiePath, "The file was created at: " + new Date());

        final Path path = paths.convert(kiePath, false);

        return path;
    }
}