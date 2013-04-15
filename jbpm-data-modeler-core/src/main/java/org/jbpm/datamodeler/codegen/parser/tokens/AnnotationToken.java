package org.jbpm.datamodeler.codegen.parser.tokens;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: wmedvede
 * Date: 4/13/13
 * Time: 3:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnnotationToken {
    
    private String name;

    private List<AnnotationValuePairToken> valuePairs = new ArrayList<AnnotationValuePairToken>();

    public AnnotationToken(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AnnotationValuePairToken> getValuePairs() {
        return valuePairs;
    }

    public void setValuePairs(List<AnnotationValuePairToken> valuePairs) {
        this.valuePairs = valuePairs;
    }
}
