package com.example.springbatch.job.MultiStepJob;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class MultiStepJobConfig {

//    private final JobRepository jobRepository;
//    private final PlatformTransactionManager transactionManager;
//
//    @Bean
//    public Job multipleStepJob(){
//        return new JobBuilder("multipleStepJob", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .start(multipleStep1())
//                .next(multipleStep2())
//                .next(multipleStep3())
//                .build();
//    }
//
//    @Bean
//    @JobScope
//    public Step multipleStep1(){
//        return new StepBuilder("multipleStep1", jobRepository)
//                .tasklet((contribution, chunkContext) -> {
//                    System.out.println("step1");
//                    return RepeatStatus.FINISHED;
//                }, transactionManager)
//                .build();
//    }
//
//    @Bean
//    @JobScope
//    public Step multipleStep2(){
//        return new StepBuilder("multipleStep2", jobRepository)
//                .tasklet((contribution, chunkContext) -> {
//                    System.out.println("step2");
//
//                    ExecutionContext executionContext = chunkContext
//                            .getStepContext()
//                            .getStepExecution()
//                            .getJobExecution()
//                            .getExecutionContext();
//
//                    executionContext.put("someKey", "hello!!");
//
//                    return RepeatStatus.FINISHED;
//                }, transactionManager)
//                .build();
//    }
//
//    @Bean
//    @JobScope
//    public Step multipleStep3(){
//        return new StepBuilder("multipleStep3", jobRepository)
//                .tasklet((contribution, chunkContext) -> {
//                    System.out.println("step3");
//
//                    ExecutionContext executionContext = chunkContext
//                            .getStepContext()
//                            .getStepExecution()
//                            .getJobExecution()
//                            .getExecutionContext();
//
//                    System.out.println(executionContext.get("someKey"));
//
//                    return RepeatStatus.FINISHED;
//                }, transactionManager)
//                .build();
//    }
}
