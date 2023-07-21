package com.example.springbatch.job.HelloWorld;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
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

@Configuration()
public class HelloWorldJobConfig {

//    @Bean
//    public Job helloWorldJob(JobRepository jobRepository, Step step){
//        System.out.println("job");
//        return new JobBuilder("helloWorldJob", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .start(step)
//                .build();
//    }
//
//    @Bean
//    public Step helloWorldStep(JobRepository jobRepository, Tasklet tasklet, PlatformTransactionManager transactionManager) {
//        System.out.println("step");
//        return new StepBuilder("helloWorldStep", jobRepository)
//                .tasklet(tasklet, transactionManager)
//                .build();
//    }
//
//    @Bean
//    public Tasklet helloWorldTasklet(){
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                System.out.println("Hello World Spring Batch");
//                return RepeatStatus.FINISHED;
//            }
//        };
//    }

}
