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
package org.apache.tiles.request;

import java.io.Serial;

/**
 * Thrown when something related to a request fails.
 *
 * @version $Rev$ $Date$
 */
public class RequestException extends RuntimeException {

	@Serial
    private static final long serialVersionUID = -1240335604658715444L;

	/**
     * Constructor.
     */
    public RequestException() {
    	super();
    }

    /**
     * Constructor.
     *
     * @param message The message of the exception.
     */
    public RequestException(String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param cause The cause.
     */
    public RequestException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor.
     *
     * @param message The message of the exception.
     * @param cause The cause.
     */
    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }

}
