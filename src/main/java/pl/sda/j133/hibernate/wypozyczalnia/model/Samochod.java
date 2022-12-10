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
public class Samochod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // IDENTITY - gdy wstawiamy rekord to:
    //              - wysyłamy INSERT ... (NULL <- pozycja id)
    //              - baza generuje ID
    // AUTO     - różnie
    // SEQUENCE - gdy wstawiamy rekord to
    //              (współdzielone przez tabele)
    //              (baza danych będzie posiadać tabelę: `hibernate_sequence` z kolumną `next_id`)
    //              - wysyłamy select next_id z tabeli `hiberante_sequence`
    //              - wysyłamy insert rekord
    //              - wysyłamy update next_id na next_id+1
    // TABLE    - gdy wstawiamy rekord to
    //              (nie jest współdzielone, każda tabela ma oddzielny licznik)
    //              (baza danych będzie posiadać tabelę: `hibernate_sequence` z kolumną `next_id`)
    //              - wysyłamy select next_id z tabeli `hiberante_sequence`
    //              - wysyłamy insert rekord
    //              - wysyłamy update next_id na next_id+1

    private String nrRej;
    private String model;
    private String marka;
    private int iloscMiejsc;

    // Część relacji Samochod-Wypozyczenie
    @OneToMany(mappedBy = "samochodX")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Wypozyczenie> wypozyczenia;
}
