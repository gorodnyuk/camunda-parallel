package com.example.camundaparallel.delegate;

import com.example.camundaparallel.processor.ListProcessorSync;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class ListProcessor1 implements JavaDelegate {

    private final ListProcessorSync listProcessorSync;

    @Override
    public void execute(DelegateExecution delegateExecution) throws InterruptedException {
        log.info("List Processor 1 is STARTED");

        TimeUnit.SECONDS.sleep(12); // simulates complex logic
        listProcessorSync.addData(delegateExecution);

        log.info("List Processor 1 is ENDED");
    }
}
