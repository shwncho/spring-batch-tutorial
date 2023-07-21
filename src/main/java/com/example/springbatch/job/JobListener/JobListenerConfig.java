package com.example.springbatch.job.JobListener;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JobListenerConfig {

//    @Bean
//    public Job jobListenerJob(JobRepository jobRepository, Step step){
//        return new JobBuilder("jobListenerJob",jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .listener(new JobLoggerListener())
//                .start(step)
//                .build();
//    }
//
//    @Bean
//    @JobScope
//    public Step jobListenerStep(JobRepository jobRepository, Tasklet tasklet, PlatformTransactionManager transactionManager){
//        return new StepBuilder("jobListenerStep", jobRepository)
//                .tasklet(tasklet, transactionManager)
//                .build();
//    }
//
//    @StepScope
//    @Bean
//    public Tasklet joinListenerTasklet(){
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
////                System.out.println("join Listener Tasklet");
////                return RepeatStatus.FINISHED;
//                throw new Exception("Failed");
//            }
//        };
//    }
}
