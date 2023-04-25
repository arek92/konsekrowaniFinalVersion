package galus.arkadio.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
public class EtapWspolnotowy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nazwa_etapu_id")
    @Cascade(CascadeType.ALL)
    @Enumerated(EnumType.ORDINAL)
    private NazwaEtapu nazwaEtapu;
    LocalDate dataEtapu;


    public EtapWspolnotowy(NazwaEtapu nazwaEtapu, LocalDate dataEtapu) {
        this.nazwaEtapu = nazwaEtapu;
        this.dataEtapu = dataEtapu;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EtapWspolnotowy that = (EtapWspolnotowy) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
