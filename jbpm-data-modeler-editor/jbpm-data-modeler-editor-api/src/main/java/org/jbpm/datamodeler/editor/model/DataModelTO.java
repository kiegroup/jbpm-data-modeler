package org.jbpm.datamodeler.editor.model;

import org.jboss.errai.common.client.api.annotations.Portable;

import java.io.Serializable;
import java.util.List;


@Portable
public class DataModelTO implements Serializable {
    
    private String name;

    private List<DataObjectTO> dataObjects;

    public DataModelTO() {
    }

    public DataModelTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataObjectTO> getDataObjects() {
        return dataObjects;
    }

    public void setDataObjects(List<DataObjectTO> dataObjects) {
        this.dataObjects = dataObjects;
    }
}

