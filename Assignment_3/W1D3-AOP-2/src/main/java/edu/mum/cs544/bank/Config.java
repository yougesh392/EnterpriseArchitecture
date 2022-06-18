package edu.mum.cs544.bank;

import edu.mum.cs544.bank.dao.AccountDAO;
import edu.mum.cs544.bank.jms.JMSSender;
import edu.mum.cs544.bank.logging.Logger;
import edu.mum.cs544.bank.service.AccountService;
import edu.mum.cs544.bank.service.CurrencyConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("edu.mum.cs544.bank")
@EnableAspectJAutoProxy
public class Config {
//    @Bean
//    public AccountService accountService(){
//        return new AccountService();
//        //new AccountDAO(), new CurrencyConverter(),  new JMSSender(),new Logger()
//    }
    @Bean
    public AccountDAO accountDAO(){
        return new AccountDAO();
    }
    @Bean
    public CurrencyConverter currencyConverter(){
        return new CurrencyConverter();
    }
    @Bean
    public JMSSender jmsSender(){
        return new JMSSender();
    }
    @Bean
    public Logger logger(){
        return new Logger();
    }
}
