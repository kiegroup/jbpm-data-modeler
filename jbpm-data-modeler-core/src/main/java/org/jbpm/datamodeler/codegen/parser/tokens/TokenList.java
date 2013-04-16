package org.jbpm.datamodeler.codegen.parser.tokens;

import java.util.ArrayList;

public class TokenList<E> extends ArrayList<E> {

    public E getLast() {
        return size() > 0 ? get(size()-1) : null;        
    }

    public E getFirst() {
        return size() > 0 ? get(0) : null;
    }

}
