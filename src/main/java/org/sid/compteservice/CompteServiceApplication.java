package org.sid.compteservice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sid.compteservice.enums.TypeCompte;
import java.util.Date;
import org.sid.compteservice.entities.Compte;
import org.sid.compteservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class CompteServiceApplication {
    private static final Logger log = LogManager.getLogger(CompteServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            compteRepository.save(new Compte(null, 98000, new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null, 12000, new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, 2100, new Date(), TypeCompte.COURANT));
            compteRepository.findAll().forEach(cp -> {
                log.info(String.valueOf(cp.getCode()));
                log.info(String.valueOf(cp.getType()));
                log.info(String.valueOf(cp.getSolde()));
            });
        };
    }
}