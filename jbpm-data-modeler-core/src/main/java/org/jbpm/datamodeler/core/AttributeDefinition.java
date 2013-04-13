package org.jbpm.datamodeler.core;

import java.util.Set;

public interface AttributeDefinition {

    /**
     * Attribute unique identifier e.g. @DataObject, @Equals, @Entity, @Column
     * 
     * @return
     */
    String getName();

    /**
     *
     * @return Attribute's short description.
     */
    String getShortDescription();

    /**
     * 
     * @return Attribute's long description.
     * 
     */
    String getDescription();


    /**
     * Set of supported parameters by this attribute.
     *
     * @return
     */
    Set<AttributeParamDefinition> getAttributeParams();
       
}
