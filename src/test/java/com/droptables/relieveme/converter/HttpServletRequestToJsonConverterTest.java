package com.droptables.relieveme.converter;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class HttpServletRequestToJsonConverterTest {

    private MockHttpServletRequest mockHttpServletRequest;

    @Before
    public void setUp() {
        mockHttpServletRequest = new MockHttpServletRequest();
    }

    @Test
    public void givenPostRequestWhenConvertPostRequestIsCalledReturnsFields() throws IOException {
        givenPostRequest("{\n\"field1\": \"hello!\",\n" +
                "\"field2\": \"world!\"\n}\n");
        Map<String, Object> fields = HttpServletRequestToJsonConverter.convertPostRequestToJson(mockHttpServletRequest);
        assertThat(fields.get("field1"), is("hello!"));
        assertThat(fields.get("field2"), is("world!"));
    }

    @Test
    public void givenGetRequestWhenConvertPostRequestIsCalledReturnsNull() throws IOException {
        Map<String, Object> fields = HttpServletRequestToJsonConverter.convertPostRequestToJson(mockHttpServletRequest);
        assertNull(fields);
    }

    private void givenPostRequest(String content) {
        mockHttpServletRequest.setMethod("POST");
        mockHttpServletRequest.setContent(content.getBytes());
    }
}