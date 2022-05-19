package hellojpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    private String username;

    public void setTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
