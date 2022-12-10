package pl.sda.j133.hibernate.wypozyczalnia.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

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
public class Wypozyczenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate dataWypozyczenia;

    private String numerUmowy;
    private LocalDate dataPlanowanegoZwrotu;
    private Double cenaWynajmu;

    // Część relacji Samochod-Wypozyczenie
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Samochod samochodX;

    // Część relacji Klient-Wypozyczenie
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Klient klientY;

    // Część relacji Zwrot-Wypozyczenie
    @OneToOne(mappedBy = "wypozyczenieZ")
    @EqualsAndHashCode.Exclude
    private Zwrot zwrot;
}
