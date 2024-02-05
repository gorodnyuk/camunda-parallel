package com.example.camundaparallel.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListInitializer implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        List<String> data = new ArrayList<>();

        delegateExecution.setVariable("data", data);
    }
}
