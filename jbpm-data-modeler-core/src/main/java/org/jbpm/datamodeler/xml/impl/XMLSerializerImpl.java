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

package org.jbpm.datamodeler.xml.impl;

import org.jbpm.datamodeler.core.DataModel;
import org.jbpm.datamodeler.xml.SerializerException;
import org.jbpm.datamodeler.xml.XMLSerializer;

import java.io.Reader;
import java.io.Writer;

public class XMLSerializerImpl implements XMLSerializer {

    @Override
    public String serialize(DataModel dataModel) {
        return null;
    }

    @Override
    public void serialize(DataModel dataModel, Writer writer) {

    }

    @Override
    public DataModel unserialize(String xml) throws SerializerException {
        return null;
    }

    @Override
    public DataModel unserialize(Reader reader) throws SerializerException {
        return null;
    }
}
