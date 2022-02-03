package zw.co.digitalnomad.learningspring.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student theophilus = new Student(
                    "Theophilus Okoye",
                    "theophilusokoye6@gmail.com",
                    LocalDate.of(1998, 8, 16)
            );

            Student blessed = new Student(
                    "Blessed Mahuni",
                    "blessedmahuni@gmail.com",
                    LocalDate.of(1997, 8, 18)
            );

            repository.saveAll(List.of(theophilus, blessed));
        };
    }
}
