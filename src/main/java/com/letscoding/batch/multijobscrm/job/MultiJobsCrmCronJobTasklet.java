package com.letscoding.batch.multijobscrm.job;

import com.letscoding.batch.multijobscrm.repository.postgress.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MultiJobsCrmCronJobTasklet implements Tasklet {
    private static Logger logger= LoggerFactory.getLogger(MultiJobsCrmCronJobTasklet.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

            logger.info("hello demo job");
            return RepeatStatus.FINISHED;
    }
}
