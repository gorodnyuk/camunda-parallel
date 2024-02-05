package com.example.camundaparallel.controller;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/camunda/start")
public class StartController {

    private final RuntimeService runtimeService;

    @GetMapping // must be post, but with get you can run in from browser ;)
    @ResponseStatus(HttpStatus.OK)
    public void startProcess() {
        runtimeService.startProcessInstanceByKey("process");
    }
}
