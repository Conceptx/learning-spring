package zw.co.digitalnomad.learningspring.student;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private LocalDate dob;

    @Transient
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
