package org.jbpm.datamodeler.core;

public interface AttributeParamDefinition extends HasClassName {

    /**
     * Attribute unique identifier e.g. name, size, quantity
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

}
