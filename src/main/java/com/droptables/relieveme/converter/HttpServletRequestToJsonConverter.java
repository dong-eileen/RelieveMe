package com.droptables.relieveme.converter;

import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.json.JsonParser;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpServletRequestToJsonConverter {

    private static JsonParser jsonParser = new BasicJsonParser();

    /**
     * Returns the contents of a POST request.
     * @param request non-null request
     * @return null if the request can't be converted to a POST request
     * @throws IOException if the request can't be read
     */
    public static Map<String, Object> convertPostRequestToJson(HttpServletRequest request) throws IOException {
        try {
            return jsonParser.parseMap(extractPostRequestBody(request));
        } catch (JsonParseException jsonParseException) {
            return null;
        }
    }

    /**
     * Extracts the contents of an HttpServlet POST request.
     *
     * @param request POST request to parse
     * @return the body of a POST request if it exists; empty string if there is no
     *         body
     */
    private static String extractPostRequestBody(HttpServletRequest request) throws IOException {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            return request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        }
        return "";
    }
}
