package com.compassuol.sp.challenge.msaddress.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

public class ApiExceptionHandlerTest {

    private ApiExceptionHandler apiExceptionHandler = new ApiExceptionHandler();

    @Test
    public void runtimeExceptionHandler_WhenRuntimeException_ThenInternalServerError() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/test");
        RuntimeException ex = new RuntimeException("Test exception");

        ResponseEntity<ErrorMessage> response = apiExceptionHandler.runtimeExceptionHandler(ex, request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        assertEquals("/test", response.getBody().getPath());
        assertEquals("Test exception", response.getBody().getMessage());
    }
}
