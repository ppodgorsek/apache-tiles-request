/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tiles.request.render;

import java.io.Serial;

/**
 * Indicates that something went wrong during the rendering process.
 *
 * @version $Rev$ $Date$
 */
public class CannotRenderException extends RenderException {

	@Serial
    private static final long serialVersionUID = -3488529565581703493L;

	/**
     * Constructor.
     */
    public CannotRenderException() {
    	super();
    }

    /**
     * Constructor.
     *
     * @param message The detail message.
     */
    public CannotRenderException(String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param e The exception to be wrapped.
     */
    public CannotRenderException(Throwable e) {
        super(e);
    }

    /**
     * Constructor.
     *
     * @param message The detail message.
     * @param e The exception to be wrapped.
     */
    public CannotRenderException(String message, Throwable e) {
        super(message, e);
    }

}
