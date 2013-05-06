package org.jbpm.datamodeler.editor.client.editors;

import org.jbpm.datamodeler.editor.model.DataObjectTO;

import java.util.Comparator;

public class DataObjectComparator implements Comparator <DataObjectTO> {

    @Override
    public int compare(DataObjectTO o1, DataObjectTO o2) {

        if (o1 == null && o2 == null) return 0;
        if (o1 == null && o2 != null) return -1;
        if (o1 != null && o2 == null) return 1;

        String key1 = o1.getName();
        String key2 = o2.getName();

        if (key1 != null) return key1.compareTo(key2);
        if (key2 != null) return key2.compareTo(key1);
        return 0;
    }
}
