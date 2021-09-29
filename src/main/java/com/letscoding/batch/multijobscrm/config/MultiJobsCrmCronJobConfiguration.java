package com.letscoding.batch.multijobscrm.config;

import com.letscoding.batch.multijobscrm.job.MultiJobsCrmCronJobTasklet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Configuration
public class MultiJobsCrmCronJobConfiguration {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    Environment environment;

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;


    public MultiJobsCrmCronJobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory){
        this.jobBuilderFactory=jobBuilderFactory;
        this.stepBuilderFactory=stepBuilderFactory;
    }

    @Bean
    public Job demoCronJob(MultiJobsCrmCronJobTasklet multiJobsCrmCronJobTasklet) {

        return jobBuilderFactory.get("demoCronJob")
                .start(demoCronJobStep(multiJobsCrmCronJobTasklet))
                .build();
    }

    @Bean
    public Step demoCronJobStep(MultiJobsCrmCronJobTasklet multiJobsCrmCronJobTasklet) {
        DefaultTransactionAttribute attribute = new DefaultTransactionAttribute();
        attribute.setTimeout(2000);

        return stepBuilderFactory.get("demoCronJobStep")
                .tasklet(multiJobsCrmCronJobTasklet)
                .transactionAttribute(attribute)
                .build();
    }
}
