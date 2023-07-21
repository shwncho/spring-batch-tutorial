package com.example.springbatch.job.FileDataReadWrite;

import com.example.springbatch.job.FileDataReadWrite.dto.Player;
import com.example.springbatch.job.FileDataReadWrite.dto.PlayerYears;
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
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class FileDataReadWriteConfig {

//    @Bean
//    public Job fileReadWriteJob(JobRepository jobRepository, Step step){
//        return new JobBuilder("fileReadWriteJob", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .start(step)
//                .build();
//    }
//
//    @Bean
//    @JobScope
//    public Step fileReadWriteStep(JobRepository jobRepository, PlatformTransactionManager transactionManager){
//        return new StepBuilder("fileReadWriteStep", jobRepository)
//                .<Player, PlayerYears>chunk(5, transactionManager)
//                .reader(playerItemReader())
////                .writer(new ItemWriter<Player>() {
////                    @Override
////                    public void write(Chunk<? extends Player> chunk) throws Exception {
////                        chunk.forEach(System.out::println);
////                    }
////                })
//                .processor(playerItemProcessor())
//                .writer(playerItemWriter())
//                .build();
//
//
//    }
//
//    @Bean
//    @StepScope
//    public ItemProcessor<Player, PlayerYears> playerItemProcessor(){
//        return new ItemProcessor<Player, PlayerYears>() {
//            @Override
//            public PlayerYears process(Player item) throws Exception {
//                return new PlayerYears(item);
//            }
//        };
//    }
//
//    @Bean
//    @StepScope
//    public FlatFileItemReader<Player> playerItemReader() {
//        return new FlatFileItemReaderBuilder<Player>()
//                .name("playerItemReader")
//                .resource(new FileSystemResource("Players.csv"))
//                .lineTokenizer(new DelimitedLineTokenizer())
//                .fieldSetMapper(new PlayerFieldSetMapper())
//                .linesToSkip(1)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public FlatFileItemWriter<PlayerYears> playerItemWriter(){
//        BeanWrapperFieldExtractor<PlayerYears> fieldExtractor = new BeanWrapperFieldExtractor<>();
//        fieldExtractor.setNames(new String[]{"ID", "lastName", "position", "yearsExperience"});
//        fieldExtractor.afterPropertiesSet();
//
//        DelimitedLineAggregator<PlayerYears> lineAggregator = new DelimitedLineAggregator<>();
//        lineAggregator.setDelimiter(",");
//        lineAggregator.setFieldExtractor(fieldExtractor);
//
//        FileSystemResource outputResource = new FileSystemResource("players_output.txt");
//
//        return new FlatFileItemWriterBuilder<PlayerYears>()
//                .name("playerItemWriter")
//                .resource(outputResource)
//                .lineAggregator(lineAggregator)
//                .build();
//    }
}
