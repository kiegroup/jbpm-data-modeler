package org.jbpm.datamodeler.editor.model;

import org.jboss.errai.common.client.api.annotations.Portable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Portable
public class DataObjectTO implements Serializable {
    
    private String name;

    private List<ObjectPropertyTO> properties = new ArrayList<ObjectPropertyTO>();

    public DataObjectTO() {
    }

    public DataObjectTO(int i) {
        this.name = "DataObject"+i;
        for (int prop = 0; prop < i; prop++) {
            properties.add(new ObjectPropertyTO(name + ".property." + prop, "type->"+prop));
        }
    }

    public DataObjectTO(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ObjectPropertyTO> getProperties() {
        return properties;
    }

    public void setProperties(List<ObjectPropertyTO> properties) {
        this.properties = properties;
    }
}
