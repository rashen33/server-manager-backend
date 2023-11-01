package edu.icet.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.Map;

import static org.hibernate.sql.InFragment.NOT_NULL;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpResponse status;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?,?> data;
}
