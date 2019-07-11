package com.looboo.rabbitmqexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private NewTask newTask;

    @RequestMapping("/send/{message}")
    public String send(@PathVariable("message") String message) throws Exception {
        newTask.send(message);
        return "success";
    }
}
