package galus.arkadio.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor

public enum NazwaEtapu {

    ENTRATA(1L),RICHIESTA(2L),PRIMI_VOTI(3L),RINNOVO(4L),VOTI_PERPETUI(5L);
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;



}
