package hellojpa;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressHistory> addressHistory = new ArrayList<>();

//    @ElementCollection
//    @CollectionTable(
//            name = "ADDRESS_HISTORY",
//            joinColumns = @JoinColumn(name = "MEMBER_ID")
//    )
//    private List<Address> addressHistory = new ArrayList<>();

//    @Embedded
//    private Address address;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column(name = "workCity")),
//            @AttributeOverride(name = "street", column = @Column(name = "workStreet")),
//            @AttributeOverride(name = "zipcode", column = @Column(name = "workZipcode"))
//    })
//    private Address workAddress;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;
//
////    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;
//
//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts;
}


