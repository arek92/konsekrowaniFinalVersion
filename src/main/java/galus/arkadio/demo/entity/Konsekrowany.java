package galus.arkadio.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Konsekrowany {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    String name;
    String lastname;
    String oasis;
    LocalDate birthDay;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "nazwa_etapu_id")
    @ToString.Exclude
    @Cascade(CascadeType.ALL)
    List<EtapWspolnotowy> etapWspolnotowyList;



    public Konsekrowany(String name, String lastname, String oasis, LocalDate birthDay, List<EtapWspolnotowy> etapWspolnotowyList) {
        this.name = name;
        this.lastname = lastname;
        this.oasis = oasis;
        this.birthDay = birthDay;
        this.etapWspolnotowyList = etapWspolnotowyList;
    }


    public List<EtapWspolnotowy> getListaEtapowWspolnotowych() {
        return etapWspolnotowyList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Konsekrowany that = (Konsekrowany) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
