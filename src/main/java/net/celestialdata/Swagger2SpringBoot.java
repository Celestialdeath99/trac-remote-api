package net.celestialdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "net.celestialdata", "net.celestialdata.api" , "net.celestialdata.configuration"})
public class Swagger2SpringBoot implements CommandLineRunner {

    @Override
    public void run(String... arg0) {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) {
        //RelayControl.initRelayControl();
        new SpringApplication(Swagger2SpringBoot.class).run(args);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("logs/api-launches.log", true))) {
            writer.write(DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm:ss a").format(LocalDateTime.now()) + " --> System Started\n");
        } catch (Exception ignored) { }
    }

    static class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
