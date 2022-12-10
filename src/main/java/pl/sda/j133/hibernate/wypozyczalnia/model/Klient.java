package pl.sda.j133.hibernate.wypozyczalnia.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imie;
    private String nazwisko;
    private String nip;

    // Część relacji Klient-Wypozyczenie
    @OneToMany(mappedBy = "klientY")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Wypozyczenie> wypozyczenia;
}
