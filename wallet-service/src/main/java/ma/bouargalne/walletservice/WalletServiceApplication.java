package ma.bouargalne.walletservice;

import ma.bouargalne.walletservice.entities.Client;
import ma.bouargalne.walletservice.entities.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
public class WalletServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ClientRepository clientRepository,
                            RepositoryRestConfiguration repositoryRestConfiguration
    ){
        repositoryRestConfiguration.exposeIdsFor(Client.class);
        return args->{

            Stream.of("hamid", "abdo", "karima", "ihssan", "khalid", "mouad", "samira").forEach(name -> {

                clientRepository.save(new Client(name,name+"@gmail.com"));

            });

            clientRepository.findAll().forEach(System.out::println);
        };
    }
}
