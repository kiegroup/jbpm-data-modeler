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

import org.jbpm.datamodeler.impexp.ImportExportMessage;

import java.util.ArrayList;
import java.util.List;

public abstract class ImportExportResult {

    private List<ImportExportMessage> errors = new ArrayList<ImportExportMessage>();

    private List<ImportExportMessage> warnings = new ArrayList<ImportExportMessage>();

    private Exception exception;

    public ImportExportResult() {
    }

    public List<ImportExportMessage> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<ImportExportMessage> warnings) {
        this.warnings = warnings;
    }

    public List<ImportExportMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<ImportExportMessage> errors) {
        this.errors = errors;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public void addError(ImportExportMessage error) {
        getErrors().add(error);
    }

    public boolean hasErrors() {
        return exception != null || !errors.isEmpty();
    }
}
