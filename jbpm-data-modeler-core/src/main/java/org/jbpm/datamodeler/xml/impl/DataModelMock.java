package org.jbpm.datamodeler.xml.impl;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class DataModelMock {



    String name;

    String packageName;

    List<String> dataObjects = new ArrayList<String>();

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    @XmlAttribute
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<String> getDataObjects() {
        return dataObjects;
    }

    @XmlElement
    public void setDataObjects(List<String> dataObjects) {
        this.dataObjects = dataObjects;
    }

}
