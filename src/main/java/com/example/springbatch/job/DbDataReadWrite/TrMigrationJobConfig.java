package com.example.springbatch.job.DbDataReadWrite;

import com.example.springbatch.core.domain.accounts.Accounts;
import com.example.springbatch.core.domain.accounts.AccountsRepository;
import com.example.springbatch.core.domain.orders.Orders;
import com.example.springbatch.core.domain.orders.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@RequiredArgsConstructor
public class TrMigrationJobConfig {

    private final OrdersRepository ordersRepository;
    private final AccountsRepository accountsRepository;

    @Bean
    public Job trMigrationJob(JobRepository jobRepository, Step step){
        return new JobBuilder("trMigrationJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    @JobScope
    public Step trMigrationStep(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("trMigrationStep", jobRepository)
                .<Orders, Accounts>chunk(5, transactionManager)
                .reader(trOrdersReader())
//                .writer(chunk -> chunk.forEach(System.out::println))
                .processor(trOrderProcessor())
                .writer(trOrderWriter())
                .build();
    }

    @Bean
    @StepScope
    public RepositoryItemWriter<Accounts> trOrderWriter(){
        return new RepositoryItemWriterBuilder<Accounts>()
                .repository(accountsRepository)
                .methodName("save")
                .build();
    }

    //ItemWriter를 사용하면 repository를 직접 불러와 본인이 로직 작성
//    @Bean
//    @StepScope
//    public ItemWriter<Accounts> trOrderWriter(){
//        return new ItemWriter<Accounts>() {
//            @Override
//            public void write(Chunk<? extends Accounts> chunk) throws Exception {
//                chunk.forEach(accountsRepository::save);
//            }
//        };
//    }
    @Bean
    @StepScope
    public ItemProcessor<Orders, Accounts> trOrderProcessor(){
        return new ItemProcessor<Orders, Accounts>() {
            @Override
            public Accounts process(Orders item) throws Exception {
                return new Accounts(item);
            }
        };
    }

    @Bean
    @StepScope
    public RepositoryItemReader<Orders> trOrdersReader(){
        return new RepositoryItemReaderBuilder<Orders>()
                .name("trOrdersReader")
                .repository(ordersRepository)
                .methodName("findAll")
                .pageSize(5)
                .arguments(Arrays.asList())
                .sorts(Collections.singletonMap("id", Sort.Direction.ASC))
                .build();
    }
}
