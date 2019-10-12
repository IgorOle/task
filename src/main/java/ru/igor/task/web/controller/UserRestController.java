package ru.igor.task.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.igor.task.SecurityUtil;
import ru.igor.task.exception.NotAllowException;
import ru.igor.task.model.User;
import ru.igor.task.repository.UserRepository;
import ru.igor.task.to.UserTo;

import javax.validation.constraints.Positive;
import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserRestController {
    private static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserTo> get(@PathVariable @Positive int id) {
        LOGGER.debug("Get param userID=" + id + ". Request from user:" + SecurityUtil.getUser().getName());
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found user with ID=" + id));
        return ResponseEntity.ok().body(new UserTo(user.getFio(), user.getEmail()));
    }

    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    @GetMapping(value = "")
    public List<UserTo> getAll() {
        throw new NotAllowException();
    }
}
