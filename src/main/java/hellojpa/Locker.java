package hellojpa;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Locker {

    @Id @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;
    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;
}
