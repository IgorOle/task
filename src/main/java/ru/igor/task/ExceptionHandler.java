package ru.igor.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.igor.task.exception.NotAllowException;

import javax.servlet.http.HttpServletRequest;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE + 5)
public class ExceptionHandler {
    private static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private ResponseEntity<Object> getResponseEntity(String message, String error, String path, HttpStatus status){
        Map<String, String> map = new HashMap<>();
        map.put("message", message);
        map.put("error", error);
        map.put("path", path);
        return new ResponseEntity(map, status);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotAllowException.class)
    public ResponseEntity<Object> notAllow(HttpServletRequest req, Exception e) {
        LOGGER.debug("Not allow. Path:" + req.getContextPath() + ". Request from user:" + SecurityUtil.getUser().getName());
        return getResponseEntity("Not allow",
                "not allow",
                        req.getContextPath(),
                HttpStatus.METHOD_NOT_ALLOWED
                );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(java.lang.NumberFormatException.class)
    public ResponseEntity<Object> converting(HttpServletRequest req, Exception e) {
        LOGGER.debug("Error input data. Path:" + req.getContextPath() + ". Request from user:" + SecurityUtil.getUser().getName());
        return getResponseEntity("Incorrect inserted data",
                "Digital format error",
                req.getContextPath(),
                HttpStatus.BAD_REQUEST
        );
    }
}
