package com.example.springbatch.job.ConditionalStep;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobScope;
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
@RequiredArgsConstructor
public class ConditionalStepConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public Job conditionalStepJob(){
        return new JobBuilder("conditionalStepJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(conditionalStartStep())
                .on("FAILED").to(conditionalFailStep())
                .from(conditionalStartStep())
                .on("COMPLETED").to(conditionalCompletedStep())
                .from(conditionalStartStep())
                .on("*").to(conditionalAllStep())
                .end()
                .build();

    }

    @Bean
    @JobScope
    public Step conditionalStartStep(){
        return new StepBuilder("conditionalStartStep", jobRepository)
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("conditional Start Step");
                        return RepeatStatus.FINISHED;
                        //throw new Exception("Exception!!");
                    }
                },transactionManager)
                .build();
    }

    @Bean
    @JobScope
    public Step conditionalAllStep(){
        return new StepBuilder("conditionalAllStep", jobRepository)
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("conditional All Step");
                        return RepeatStatus.FINISHED;
                    }
                },transactionManager)
                .build();
    }

    @Bean
    @JobScope
    public Step conditionalFailStep() {
        return new StepBuilder("conditionalFailStep", jobRepository)
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("conditional Fail Step");
                        return RepeatStatus.FINISHED;
                    }
                },transactionManager)
                .build();
    }

    @Bean
    @JobScope
    public Step conditionalCompletedStep() {
        return new StepBuilder("conditionalCompletedStep", jobRepository)
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("conditional Completed Step");
                        return RepeatStatus.FINISHED;
                    }
                },transactionManager)
                .build();
    }
}
