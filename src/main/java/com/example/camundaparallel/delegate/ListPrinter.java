package com.example.camundaparallel.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ListPrinter implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        List<String> data = (List<String>) delegateExecution.getVariable("data");
        log.info("Data in List: {}", data);
    }
}
