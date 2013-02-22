/**
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.datamodeler.codegen;

import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.core.DataObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps all the information for generating a set of files
 */
public class GenerationContext {
    private List<String> templateSet = new ArrayList<String>();
    private String packageName;
    private String outputPath;
    private List<String> generatedFiles = new ArrayList<String>();
    private DataModel dataModel;
    private DataObject currentDataObject;
    private String currentTemplate;

    //private boolean zipFile;

    public GenerationContext(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public void addTemplateSet(String templateId) {
        templateSet.add(templateId);
    }

    public void addGeneratedFile(String file) {

    }

    public List<String> getTemplateSet() {
        return templateSet;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public DataObject getCurrentDataObject() {
        return currentDataObject;
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    public void setCurrentDataObject(DataObject currentDataObject) {
        this.currentDataObject = currentDataObject;
    }


    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public String getFilePath(DataObject dataObject, String extension) {
         String packageName = dataObject.getPackageName();
        String objectName = dataObject.getName();

        if( packageName != null) {
            packageName = "/" + packageName.replace(".", "/");
        } else {
            packageName = "";
        }

        return packageName + "/" + toFileName(objectName) + "." + extension;

    }

    public String getCurrentTemplate() {
        return currentTemplate;
    }

    public void setCurrentTemplate(String currentTemplate) {
        this.currentTemplate = currentTemplate;
    }

    public String toFileName(String name) {
        // TODO:
        return name.replaceAll("\\s", "");
    }
}
