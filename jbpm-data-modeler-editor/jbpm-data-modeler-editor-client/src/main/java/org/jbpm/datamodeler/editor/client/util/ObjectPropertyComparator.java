package org.jbpm.datamodeler.editor.client.util;

import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;
import java.util.Comparator;

public class ObjectPropertyComparator implements Comparator<ObjectPropertyTO> {
    
    String field;

    public ObjectPropertyComparator(String field) {
        this.field = field;
    }


    @Override
    public int compare(ObjectPropertyTO o1, ObjectPropertyTO o2) {
        if (o1 == null && o2 == null) return 0;
        if (o1 == null && o2 != null) return -1;
        if (o1 != null && o2 == null) return 1;

        String key1 = null;
        String key2 = null;

        if ("className".equals(field)) {
            key1 = o1.getClassName();
            key2 = o2.getClassName();
        } else {
            //by default comparate by name
            key1 = o1.getName();
            key2 = o2.getName();
        }

        if (key1 != null) return key1.compareTo(key2);
        if (key2 != null) return key2.compareTo(key1);

        return 0;
    }
}