package org.jbpm.datamodeler.codegen;

import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Properties;


/**
 * Simple code generation engine
 */
public class GenerationEngine {
    public static final String INITIAL_TEMPLATE = "initial.vm";
    public static final String TEMPLATE_PATH = "templates";

    private static final GenerationEngine singleton = new GenerationEngine();
    private VelocityEngine velocityEngine = new VelocityEngine();
    private static final Logger logger = LoggerFactory.getLogger(GenerationEngine.class);

    /**
     * Returns an instance of the GenerationEngine
     *
     * @return
     */
    public static GenerationEngine getInstance() {
        return singleton;
    }

    /**
     * Initializes the code generation engine
     */
    public void init() {

        // Init velocity engine
        Properties properties = new Properties();

        //properties.setProperty("file.resource.loader.path", templatesPath);
        //properties.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
        //        "org.apache.velocity.runtime.log.SimpleLog4JLogSystem");
        //properties.setProperty("runtime.log.logsystem.log4j.category", "velocity");

        properties.setProperty("resource.loader", "class");
        properties.setProperty("class.resource.loader.description", "Velocity Classpath Resource Loader");
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        // init velocity engine
        velocityEngine.init(properties);

    }

    /**
     * Shutdowns the code generation engine
     */

    public void stop() {
        // Shutdowns the code generation engine
    }

    /**
     * Runs generation
     *
     * @param generationContext
     * @throws Exception
     */
    public void generateAllTemplates(GenerationContext generationContext) throws Exception {
        VelocityContext context = buildContext(generationContext);

        StringWriter writer = new StringWriter();

        // Add generation tools
        List<String> templatesIds = generationContext.getTemplateSet();
        for (String templatesId : templatesIds) {
            generationContext.setCurrentTemplate(templatesId);

            context.put("templateId", templatesId);

            logger.info("Generating template '" + templatesId + "'....");

            // Always start by the initial template
            String templatePath = getFullVelocityPath(templatesId, null);

            logger.debug(" ... Initial template: " + templatePath);

            Template t = velocityEngine.getTemplate(templatePath);

            t.merge(context, writer);

            //System.out.println(" ... Initial output: " + writer.toString() + "\n\n");
        }
    }

    /**
     * Fills the context with common variables
     *
     * @param generationContext
     * @return
     */
    protected VelocityContext buildContext(GenerationContext generationContext) {
        VelocityContext context = new VelocityContext();

        // Add main objects to template conects
        context.put("engine", this);
        context.put("context", generationContext);
        context.put("model", generationContext.getDataModel());
        context.put("nameTool", new GenerationTools());

        return context;
    }

    /**
     * Invoked from templates, generates a file by invoking a template and writing it to the relative output path
     *
     * @param generationContext
     * @param template
     * @param outputPath
     * @throws IOException
     */
    public void generateAsset(GenerationContext generationContext, String template, String outputPath) throws IOException {
        StringWriter writer = new StringWriter();

        String templatePath = getFullVelocityPath(generationContext.getCurrentTemplate(), template);
        VelocityContext context = buildContext(generationContext);
        Template t = velocityEngine.getTemplate(templatePath);

        t.merge(context, writer);

        File fout = new File(generationContext.getOutputPath(), outputPath);

        fout.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(fout, false);

        System.out.println("Writing " + fout.getAbsolutePath());

        IOUtils.write(writer.toString(), fos);
    }

    /**
     * Returns the path that a given template has, from the templateSet ID and the templateID
     *
     * @param templateSetId
     * @param template
     * @return
     */
    protected String getFullVelocityPath(String templateSetId, String template) {

        String templateName = template == null ? INITIAL_TEMPLATE : (template + ".vm");
        // Always start by the initial.vm template
        String templatePath = "/" + TEMPLATE_PATH + "/" + templateSetId + "/" + templateName;
        return templatePath;

    }
}
