package spring_pegawai.pegawaiDbNew.util;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring_pegawai.pegawaiDbNew.exceptions.CustomException;

import java.util.ArrayList;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ArrayList<ApiResponse> customException(HttpServletRequest req, CustomException ex) {
        printStackTrace(ex);
        ArrayList<ApiResponse> apiResponses = new ArrayList<>();

        Message message = new Message();
        message.setCode(ex.getFlag());
        message.setDesc(ex.getMessage());
        ArrayList<Message> messages = new ArrayList<Message>();
        messages.add(message);

        apiResponses.add(ApiResponse.errors(messages));
        return apiResponses;
    }

    private void printStackTrace(Exception e) {
        logger.debug("trace: ", e);
    }


}
