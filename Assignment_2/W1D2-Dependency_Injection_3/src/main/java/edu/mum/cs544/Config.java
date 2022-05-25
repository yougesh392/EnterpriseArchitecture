package edu.mum.cs544;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.mum.cs544")
public class Config {
    @Bean
    public BookService bookService(){
        return new BookService();
    }

    @Bean
    public Amazon amazon(){
        return new Amazon();
    }

    @Bean
    public EBooks eBooks(){
        return new EBooks();
    }

    @Bean
    public BarnesAndNoble barnesAndNoble(){
        return new BarnesAndNoble();
    }
    @Bean
    public Borders borders(){
        return new Borders();
    }

}
