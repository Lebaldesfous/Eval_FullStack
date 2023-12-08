package fr.Eval_fullstack.config;

import fr.Eval_fullstack.dto.request.ErrorMessageDto;
import fr.Eval_fullstack.exception.AlreadyExistsException;
import fr.Eval_fullstack.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionConfig {

    @ExceptionHandler(value =Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessageDto InternalServerError(Exception e) {
        e.printStackTrace();
        return new ErrorMessageDto("INTERNAL_SERVER_ERROR", null);
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageDto NotFoundError(NotFoundException e) {
        e.printStackTrace();
        return ErrorMessageDto.builder().code("NOT_FOUND").message(e.getMessage()).build();
    }

    @ExceptionHandler(value = AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageDto AlreadyExistsError(AlreadyExistsException e) {
        e.printStackTrace();
        return ErrorMessageDto.builder().code("ALREADY_EXISTS").message(e.getMessage()).build();
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageDto IllegalArgumentError(IllegalArgumentException e) {
        e.printStackTrace();
        return ErrorMessageDto.builder().code("ILLEGAL_ARGUMENT").message(e.getMessage()).build();
    }
}