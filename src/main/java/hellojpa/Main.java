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

//        Locker locker = new Locker();
//        locker.setName("lockerA");
//        entityManager.persist(locker);
//
//        Member member = new Member();
//        member.setUsername("memberA");
//        member.setLocker(locker);
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Member findMember = entityManager.find(Member.class, member.getId());
//        Locker findLocker = findMember.getLocker();
//
//        System.out.println("findLocker.getName() = " + findLocker.getName());
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Locker findLocker = entityManager.find(Locker.class, locker.getId());
//        Member findMember = findLocker.getMember();
//
//        System.out.println("findMember2.getUsername() = " + findMember.getUsername());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void 일대일단방향주테이블에외래키(EntityManager entityManager) {
//        Locker locker = new Locker();
//        locker.setName("lockerA");
//        entityManager.persist(locker);
//
//        Member member = new Member();
//        member.setUsername("memberA");
//        member.setLocker(locker);
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Member findMember = entityManager.find(Member.class, member.getId());
//        Locker findLocker = findMember.getLocker();
//
//        System.out.println("findLocker.getName() = " + findLocker.getName());
    }

    private static void 일대다양방향테스트(EntityManagerFactory entityManagerFactory, EntityManager entityManager, EntityTransaction transaction) {
//        Member member = new Member();
//        entityManager.persist(member);
//
//        Team team = new Team();
//        team.getMembers().add(member);
//        entityManager.persist(team);


    }

    private static void 일대다단방향테스트(EntityManager entityManager) {
//        Team team = new Team();
////        team.getMembers().add(member);
//        entityManager.persist(team);
//
//        Member member = new Member();
//        member.setTeam(team);
//        entityManager.persist(member);
    }

    private static void 연관관계편의메서드사용(EntityManager entityManager) {
//        Team team = new Team();
//        team.setName("teamA");
//        entityManager.persist(team);
//
//        Member member = new Member();
//        member.setUsername("memberA");
//        member.setTeam(team);
//        entityManager.persist(member);
//
//        Team findTeam = entityManager.find(Team.class, team.getId());
//        List<Member> members = findTeam.getMembers();
//
//        System.out.println("========================");
//        for (Member m : members) {
//            System.out.println("m.getUsername() = " + m.getUsername());
//        }
//        System.out.println("========================");
    }

    private static void 양방향값지정하기(EntityManager entityManager) {
    }

    private static void 주인이아닌곳에값입력하기(EntityManager entityManager) {
//        Member member = new Member();
//        member.setUsername("memberA");
//        entityManager.persist(member);
//
//        Team team = new Team();
//        team.setName("teamA");
//        team.getMembers().add(member);
//        entityManager.persist(team);
//
////        entityManager.flush();
//        entityManager.clear();
//
    }

    private static void 양방향매핑(EntityManager entityManager) {
//        Team team = new Team();
//        team.setName("teamA");
//        entityManager.persist(team);
//
//        Member member = new Member();
//        member.setTeam(team);
//        member.setUsername("memberA");
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Team findTeam = entityManager.find(Team.class, team.getId());
//        List<Member> members = findTeam.getMembers();
//
//        for (Member findMember : members) {
//            System.out.println("findMember = " + findMember.getUsername());
//        }
    }

    private static void 단방향매핑(EntityManager entityManager) {
//        Team team = new Team();
//        team.setName("teamA");
//        entityManager.persist(team);
//
//        Member member = new Member();
//        member.setTeam(team);
//        member.setUsername("memberA");
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Member findMember = entityManager.find(Member.class, member.getId());
//        Team findTeam = findMember.getTeam();
//
//        Team newTeam = new Team();
//        newTeam.setName("teamB");
//        entityManager.persist(newTeam);
//
//        findMember.setTeam(newTeam);
    }
}
