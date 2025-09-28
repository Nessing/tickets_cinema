package ru.nessing.booking_service.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {
        ErrorDetails errorDetails;
        try(InputStream stream = response.body().asInputStream()) {
            errorDetails = mapper.readValue(stream, ErrorDetails.class);
        } catch (IOException e) {
            return new IOException(e.getMessage());
        }
        return new StreamServiceException(errorDetails.getMessage());
    }
}
