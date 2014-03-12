/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.commons.core.edm;

import java.util.List;

import org.apache.olingo.commons.api.edm.EdmAction;
import org.apache.olingo.commons.api.edm.EdmComplexType;
import org.apache.olingo.commons.api.edm.EdmEntityContainer;
import org.apache.olingo.commons.api.edm.EdmEntityType;
import org.apache.olingo.commons.api.edm.EdmEnumType;
import org.apache.olingo.commons.api.edm.EdmFunction;
import org.apache.olingo.commons.api.edm.EdmSchema;
import org.apache.olingo.commons.api.edm.EdmTypeDefinition;

public abstract class AbstractEdmSchemaImpl implements EdmSchema {

  protected final String namespace;
  private final String alias;
  private List<EdmTypeDefinition> typeDefinitions;
  private List<EdmEnumType> enumTypes;
  private List<EdmEntityType> entityTypes;
  private List<EdmComplexType> complexTypes;
  private List<EdmAction> actions;
  private List<EdmFunction> functions;
  private EdmEntityContainer entityContainer;

  public AbstractEdmSchemaImpl(String namespace, String alias) {
    this.namespace = namespace;
    this.alias = alias;
  }

  protected abstract EdmEntityContainer createEntityContainer();

  protected abstract List<EdmTypeDefinition> createTypeDefinitions();

  protected abstract List<EdmEnumType> createEnumTypes();

  protected abstract List<EdmEntityType> createEntityTypes();

  protected abstract List<EdmComplexType> createComplexTypes();

  protected abstract List<EdmAction> createActions();

  protected abstract List<EdmFunction> createFunctions();

  @Override
  public List<EdmTypeDefinition> getTypeDefinitions() {
    if (typeDefinitions == null) {
      typeDefinitions = createTypeDefinitions();
    }
    return typeDefinitions;
  }

  @Override
  public List<EdmEnumType> getEnumTypes() {
    if (enumTypes == null) {
      enumTypes = createEnumTypes();
    }
    return enumTypes;
  }

  @Override
  public List<EdmEntityType> getEntityTypes() {
    if (entityTypes == null) {
      entityTypes = createEntityTypes();
    }
    return entityTypes;
  }

  @Override
  public List<EdmComplexType> getComplexTypes() {
    if (complexTypes == null) {
      complexTypes = createComplexTypes();
    }
    return complexTypes;
  }

  @Override
  public List<EdmAction> getActions() {
    if (actions == null) {
      actions = createActions();
    }
    return actions;
  }

  @Override
  public List<EdmFunction> getFunctions() {
    if (functions == null) {
      functions = createFunctions();
    }
    return functions;
  }

  @Override
  public EdmEntityContainer getEntityContainer() {
    if (entityContainer == null) {
      entityContainer = createEntityContainer();
    }
    return entityContainer;
  }

  @Override
  public String getNamespace() {
    return namespace;
  }

  @Override
  public String getAlias() {
    return alias;
  }
}
