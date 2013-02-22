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

package org.jbpm.datamodeler.impexp.impl;

import org.jbpm.datamodeler.impexp.ExportManager;
import org.jbpm.datamodeler.impexp.ImportExportFactory;
import org.jbpm.datamodeler.impexp.ImportManager;

public class ImportExportFactoryImpl implements ImportExportFactory {

    public static ImportExportFactory getInstance() {
        return new ImportExportFactoryImpl();
    }

    @Override
    public ImportManager newImportManager() {
        return new ImportManagerImpl();
    }

    @Override
    public ExportManager newExportManager() {
        return new ExportManagerImpl();
    }
}
