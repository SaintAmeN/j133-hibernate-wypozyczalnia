package pl.sda.j133.hibernate.wypozyczalnia.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Paweł Recław, AmeN
 * @project j133-hibernate-fakturownia
 * @created 04.12.2022
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Zwrot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String notatka;
    private LocalDateTime dataZwrotu;

    // Część relacji Zwrot-Wypozyczenie
    @OneToOne()
    @EqualsAndHashCode.Exclude
    private Wypozyczenie wypozyczenieZ;
}
