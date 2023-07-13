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

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

import org.apache.tiles.request.attribute.Addable;
import org.easymock.EasyMock;
import org.junit.Test;

/**
 * Tests {@link DefaultRequestWrapper}.
 *
 * @version $Rev: 1215009 $ $Date: 2011-12-16 01:32:31 +0100 (Fri, 16 Dec 2011) $
 */
public class DefaultRequestWrapperTest {

    /**
     * Creates the RequestWrapper to be tested.
     *
     * @param wrappedRequest the request to be wrapped.
     * @return the RequestWrapper.
     */
    protected RequestWrapper createRequestWrapper(Request wrappedRequest) {
        DefaultRequestWrapper request = new DefaultRequestWrapper(wrappedRequest);
        return request;
    }

    /**
     * Creates a mock Request adequate to the test.
     *
     * @return the Request object.
     */
    protected Request createMockRequest() {
        Request wrappedRequest = EasyMock.createMock(Request.class);
        return wrappedRequest;
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getWrappedRequest()}.
     */
    @Test
    public void testGetWrappedRequest() {
        Request wrappedRequest = createMockRequest();

        EasyMock.replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(wrappedRequest, request.getWrappedRequest());
        EasyMock.verify(wrappedRequest);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getHeader()}.
     */
    @Test
    public void testGetHeader() {
        Request wrappedRequest = createMockRequest();
        Map<String, String> header = EasyMock.createMock(Map.class);

        expect(wrappedRequest.getHeader()).andReturn(header);

        EasyMock.replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(header, request.getHeader());
        EasyMock.verify(wrappedRequest);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getResponseHeaders()}.
     */
    @Test
    public void testGetResponseHeaders() {
        Request wrappedRequest = createMockRequest();
        Addable<String> header = EasyMock.createMock(Addable.class);

        expect(wrappedRequest.getResponseHeaders()).andReturn(header);

        EasyMock.replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(header, request.getResponseHeaders());
        EasyMock.verify(wrappedRequest);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getHeaderValues()}.
     */
    @Test
    public void testGetHeaderValues() {
        Request wrappedRequest = createMockRequest();
        Map<String, String[]> header = EasyMock.createMock(Map.class);

        expect(wrappedRequest.getHeaderValues()).andReturn(header);

        EasyMock.replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(header, request.getHeaderValues());
        EasyMock.verify(wrappedRequest);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getContext(java.lang.String)}.
     */
    @Test
    public void testGetContext() {
        Request wrappedRequest = createMockRequest();
        Map<String, Object> context = EasyMock.createMock(Map.class);

        RequestWrapper request = createRequestWrapper(wrappedRequest);

        expect(wrappedRequest.getContext("one")).andReturn(context);

        EasyMock.replay(wrappedRequest, context);
        assertEquals(context, request.getContext("one"));
        EasyMock.verify(wrappedRequest, context);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getAvailableScopes()}.
     */
    @Test
    public void testGetAvailableScopes() {
        Request wrappedRequest = createMockRequest();
        Map<String, Object> context = EasyMock.createMock(Map.class);

        RequestWrapper request = createRequestWrapper(wrappedRequest);

        String[] scopes = new String[] {"one", "two", "three"};
        expect(wrappedRequest.getAvailableScopes()).andReturn(Arrays.asList(scopes));

        EasyMock.replay(wrappedRequest, context);
        assertArrayEquals(scopes, request.getAvailableScopes().toArray());
        EasyMock.verify(wrappedRequest, context);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getApplicationContext()}.
     */
    @Test
    public void testGetApplicationContext() {
        Request wrappedRequest = createMockRequest();
        ApplicationContext applicationContext = EasyMock.createMock(ApplicationContext.class);

        expect(wrappedRequest.getApplicationContext()).andReturn(applicationContext);

        EasyMock.replay(wrappedRequest, applicationContext);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(applicationContext, request.getApplicationContext());
        EasyMock.verify(wrappedRequest, applicationContext);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getOutputStream()}.
     * @throws IOException If something goes wrong.
     */
    @Test
    public void testGetOutputStream() throws IOException {
        Request wrappedRequest = createMockRequest();
        OutputStream stream = EasyMock.createMock(OutputStream.class);

        expect(wrappedRequest.getOutputStream()).andReturn(stream);

        EasyMock.replay(wrappedRequest, stream);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(stream, request.getOutputStream());
        EasyMock.verify(wrappedRequest, stream);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getWriter()}.
     * @throws IOException If something goes wrong.
     */
    @Test
    public void testGetWriter() throws IOException {
        Request wrappedRequest = createMockRequest();
        Writer writer = EasyMock.createMock(Writer.class);

        expect(wrappedRequest.getWriter()).andReturn(writer);

        EasyMock.replay(wrappedRequest, writer);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(writer, request.getWriter());
        EasyMock.verify(wrappedRequest, writer);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getPrintWriter()}.
     * @throws IOException If something goes wrong.
     */
    @Test
    public void testGetPrintWriter() throws IOException {
        Request wrappedRequest = createMockRequest();
        PrintWriter writer = EasyMock.createMock(PrintWriter.class);

        expect(wrappedRequest.getPrintWriter()).andReturn(writer);

        EasyMock.replay(wrappedRequest, writer);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(writer, request.getPrintWriter());
        EasyMock.verify(wrappedRequest, writer);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#isResponseCommitted()}.
     */
    @Test
    public void testIsResponseCommitted() {
        Request wrappedRequest = createMockRequest();

        expect(wrappedRequest.isResponseCommitted()).andReturn(Boolean.TRUE);

        EasyMock.replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertTrue(request.isResponseCommitted());
        EasyMock.verify(wrappedRequest);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getParam()}.
     */
    @Test
    public void testGetParam() {
        Request wrappedRequest = createMockRequest();
        Map<String, String> param = EasyMock.createMock(Map.class);

        expect(wrappedRequest.getParam()).andReturn(param);

        EasyMock.replay(wrappedRequest, param);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(param, request.getParam());
        EasyMock.verify(wrappedRequest, param);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getParamValues()}.
     */
    @Test
    public void testGetParamValues() {
        Request wrappedRequest = createMockRequest();
        Map<String, String[]> param = EasyMock.createMock(Map.class);

        expect(wrappedRequest.getParamValues()).andReturn(param);

        EasyMock.replay(wrappedRequest, param);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(param, request.getParamValues());
        EasyMock.verify(wrappedRequest, param);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getRequestLocale()}.
     */
    @Test
    public void testGetRequestLocale() {
        Request wrappedRequest = createMockRequest();
        Locale param = Locale.ITALY;

        expect(wrappedRequest.getRequestLocale()).andReturn(param);

        EasyMock.replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(param, request.getRequestLocale());
        EasyMock.verify(wrappedRequest);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#isUserInRole(java.lang.String)}.
     */
    @Test
    public void testIsUserInRole() {
        Request wrappedRequest = createMockRequest();

        expect(wrappedRequest.isUserInRole("myrole")).andReturn(Boolean.TRUE);

        EasyMock.replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertTrue(request.isUserInRole("myrole"));
        EasyMock.verify(wrappedRequest);
    }

}
