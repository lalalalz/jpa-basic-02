package hellojpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AddressHistory {

    @Id @GeneratedValue
    @Column(name = "ADDRESS_HISTORY_ID")
    private Long id;

    @Embedded
    private Address address;

    public AddressHistory() {}

    public AddressHistory(Address address) {
        this.address = address;
    }
}
