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

import org.apache.tiles.request.RequestException;

/**
 * Thrown when rendering fails.
 *
 * @version $Rev$ $Date$
 */
public class RenderException extends RequestException {

	@Serial
    private static final long serialVersionUID = -4573346867875292947L;

	/**
     * Constructor.
     */
    public RenderException() {
    	super();
    }

    /**
     * Constructor.
     *
     * @param message The message of the exception.
     */
    public RenderException(String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param cause The cause.
     */
    public RenderException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor.
     *
     * @param message The message of the exception.
     * @param cause The cause.
     */
    public RenderException(String message, Throwable cause) {
        super(message, cause);
    }
}
