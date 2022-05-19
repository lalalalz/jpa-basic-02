package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void 연관관계편의메서드사용(EntityManager entityManager) {
        Team team = new Team();
        team.setName("teamA");
        entityManager.persist(team);

        Member member = new Member();
        member.setUsername("memberA");
        member.setTeam(team);
        entityManager.persist(member);

        Team findTeam = entityManager.find(Team.class, team.getId());
        List<Member> members = findTeam.getMembers();

        System.out.println("========================");
        for (Member m : members) {
            System.out.println("m.getUsername() = " + m.getUsername());
        }
        System.out.println("========================");
    }

    private static void 양방향값지정하기(EntityManager entityManager) {
        Team team = new Team();
        team.setName("teamA");

        Member member = new Member();
        member.setUsername("memberA");

        team.getMembers().add(member);
        member.setTeam(team);

        entityManager.persist(member);
        entityManager.persist(team);

        Team findTeam = entityManager.find(Team.class, team.getId());
        List<Member> members = findTeam.getMembers();

        for (Member m : members) {
            System.out.println("m.getUsername() = " + m.getUsername());
        }
    }

    private static void 주인이아닌곳에값입력하기(EntityManager entityManager) {
        Member member = new Member();
        member.setUsername("memberA");
        entityManager.persist(member);
        
        Team team = new Team();
        team.setName("teamA");
        team.getMembers().add(member);
        entityManager.persist(team);

//        entityManager.flush();
//        entityManager.clear();
//
    }

    private static void 양방향매핑(EntityManager entityManager) {
        Team team = new Team();
        team.setName("teamA");
        entityManager.persist(team);

        Member member = new Member();
        member.setTeam(team);
        member.setUsername("memberA");
        entityManager.persist(member);

        entityManager.flush();
        entityManager.clear();

        Team findTeam = entityManager.find(Team.class, team.getId());
        List<Member> members = findTeam.getMembers();

        for (Member findMember : members) {
            System.out.println("findMember = " + findMember.getUsername());
        }
    }

    private static void 단방향매핑(EntityManager entityManager) {
        Team team = new Team();
        team.setName("teamA");
        entityManager.persist(team);

        Member member = new Member();
        member.setTeam(team);
        member.setUsername("memberA");
        entityManager.persist(member);

        entityManager.flush();
        entityManager.clear();

        Member findMember = entityManager.find(Member.class, member.getId());
        Team findTeam = findMember.getTeam();

        Team newTeam = new Team();
        newTeam.setName("teamB");
        entityManager.persist(newTeam);

        findMember.setTeam(newTeam);
    }
}
