package com.example.camundaparallel.processor;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Component
public class ListProcessorSync {

    private final ReentrantLock reentrantLock;

    public ListProcessorSync() {
        this.reentrantLock = new ReentrantLock();
    }

    public void addData(DelegateExecution delegateExecution) {
        reentrantLock.lock();
        try {
            List<String> data = (List<String>) delegateExecution.getVariable("data");
            data.add("some-data");
            delegateExecution.setVariable("data", data);
        } finally {
            reentrantLock.unlock();
        }
    }
}
