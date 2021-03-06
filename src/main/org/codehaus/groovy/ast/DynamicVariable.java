/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.codehaus.groovy.ast;

import org.codehaus.groovy.ast.expr.Expression;

// An implicitly created variable, such as a variable in a script that's doesn't have an explicit
// declaration, or the "it" argument to a closure.
public class DynamicVariable implements Variable {

    private final String name;
    private boolean closureShare = false;
    private boolean staticContext = false;

    public DynamicVariable(String name, boolean context) {
        this.name = name;
        staticContext = context;
    }

    public ClassNode getType() {
        return ClassHelper.DYNAMIC_TYPE;
    }

    public String getName() {
        return name;
    }

    public Expression getInitialExpression() {
        return null;
    }

    public boolean hasInitialExpression() {
        return false;
    }

    public boolean isInStaticContext() {
        return staticContext;
    }

    public boolean isDynamicTyped() {
        return true;
    }

    public boolean isClosureSharedVariable() {
        return closureShare;
    }

    public void setClosureSharedVariable(boolean inClosure) {
        closureShare = inClosure;
    }

    public int getModifiers() {
        return 0;
    }

    public ClassNode getOriginType() {
        return getType();
    }

}
