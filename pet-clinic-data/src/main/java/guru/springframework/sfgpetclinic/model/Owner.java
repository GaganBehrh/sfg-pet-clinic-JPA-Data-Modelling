package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 7/13/18.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owners")
@Builder
public class Owner extends Person {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(Long id,final String firstName, final String lastName, final String address, final String city, final String telephone, final Set<Pet> pets) {
        this.setId(id);
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

}
