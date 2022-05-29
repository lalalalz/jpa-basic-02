package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
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

    private static void 불변객체테스트(EntityManager entityManager) {
//        Address address = new Address("Seoul", "Kang-Nam", "1111");
//
//        Member member1 = new Member();
//        member1.setUsername("member1");
//        member1.setAddress(address);
//        entityManager.persist(member1);
//
//        Address newAddress = new Address("InCheon", "Jung-Gu", "2323");
//        member1.setAddress(newAddress);
    }

    private void 값타입복사(EntityManager entityManager) {
//        Address address = new Address();
//        address.setCity("Seoul");
//        address.setStreet("Kang-Nam");
//        address.setZipcode("1234");
//
//        Member member1 = new Member();
//        member1.setUsername("member1");
//        member1.setAddress(address);
//        entityManager.persist(member1);
//
//        Address newAddress = new Address();
//        newAddress.setCity(address.getCity());
//        newAddress.setStreet(address.getStreet());
//        newAddress.setZipcode(address.getZipcode());
//
//        Member member2 = new Member();
//        member2.setUsername("member2");
//        member2.setAddress(newAddress);
//        entityManager.persist(member2);
//
//        member1.getAddress().setCity("InCheon");
    }

    private static void 값타입공유참조문제테스트(EntityManager entityManager) {
//        Address address = new Address();
//        address.setCity("Seoul");
//        address.setStreet("Kang-Nam");
//        address.setZipcode("1234");
//
//        Member member1 = new Member();
//        member1.setUsername("member1");
//        member1.setAddress(address);
//        entityManager.persist(member1);
//
//
//        Member member2 = new Member();
//        member2.setUsername("member2");
//        member2.setAddress(address);
//        entityManager.persist(member2);
//
//        member1.getAddress().setCity("InCheon");
    }

    private static void 고아객체테스트(EntityManager entityManager) {
//        Child child = new Child();
//        child.setName("childA");
//
//        Parent parent = new Parent();
//        parent.setName("parentA");
//        parent.addChild(child);
//        entityManager.persist(parent);
//        entityManager.persist(child);
//
////        entityManager.flush();
////        entityManager.clear();
//
//        Parent findParent = entityManager.find(Parent.class, parent.getId());
//
//        System.out.println("=============연관관계 제거=============");
//        System.out.println("findParent.getClass() = " + System.identityHashCode(findParent));
//        System.out.println("parent = " + System.identityHashCode(parent));
//        entityManager.remove(findParent);
    }

    private static void 영속성전이테스트(EntityManager entityManager) {
//        Child child1 = new Child();
//        Child child2 = new Child();
//
//        Parent parent = new Parent();
//        parent.addChild(child1);
//        parent.addChild(child2);
//        entityManager.persist(parent);
    }

    private static void nplus1문제테스트(EntityManager entityManager) {
//        Team teamA = new Team();
//        teamA.setName("teamA");
//        entityManager.persist(teamA);
//
//        Team teamB = new Team();
//        teamB.setName("teamA");
//        entityManager.persist(teamB);
//
//
//        Member memberA = new Member();
//        memberA.setUsername("memberA");
//        memberA.setTeam(teamA);
//        entityManager.persist(memberA);
//
//        Member memberB = new Member();
//        memberB.setUsername("memberB");
//        memberB.setTeam(teamB);
//        entityManager.persist(memberB);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        List<Member> members;
//        members = entityManager.createQuery("select m from Member m", Member.class).getResultList();
    }

    private static void 즉시로딩테스트(EntityManager entityManager) {
//        Team team = new Team();
//        team.setName("teamA");
//        entityManager.persist(team);
//
//        Member member = new Member();
//        member.setUsername("userA");
//        member.setTeam(team);
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Member findMember = entityManager.find(Member.class, member.getId());
//        System.out.println("findMember.getTeam().getClass() = " + findMember.getTeam().getClass());
    }

    private static void 지연로딩테스트(EntityManager entityManager) {
//        Team team = new Team();
//        team.setName("teamA");
//        entityManager.persist(team);
//
//        Member member = new Member();
//        member.setUsername("userA");
//        member.setTeam(team);
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Member findMember = entityManager.find(Member.class, member.getId());
//        System.out.println("findMember.getTeam().getClass() = " + findMember.getTeam().getClass());
//
//        System.out.println("========================= 프록시 초기화 ===============================");
//        String teamName = findMember.getTeam().getName();
//        System.out.println("========================= 프록시 초기화 ===============================");
    }

    private static void 프록시강제초기화편의메서드테스트(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
//        Member member = new Member();
//        member.setUsername("memberA");
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        PersistenceUnitUtil persistenceUnitUtil = entityManagerFactory.getPersistenceUnitUtil();
//
//        System.out.println("================== 초기화 이전 ====================");
//        Member findMember = entityManager.getReference(Member.class, member.getId());
//        System.out.println("persistenceUnitUtil.isLoaded(findMember) = " + persistenceUnitUtil.isLoaded(findMember));
//
//        System.out.println("================== 초기화 이후 ====================");
//        Hibernate.initialize(findMember);
//        System.out.println("persistenceUnitUtil.isLoaded(findMember) = " + persistenceUnitUtil.isLoaded(findMember));
    }

    private static void 프록시초기화여부편의메서드테스트(EntityManagerFactory entityManagerFactory, EntityManager entityManager, Member member) {

//        Member member = new Member();
//        member.setUsername("memberA");
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        PersistenceUnitUtil persistenceUnitUtil = entityManagerFactory.getPersistenceUnitUtil();
//
//        System.out.println("================== 초기화 이전 ====================");
//
//        Member findMember = entityManager.getReference(Member.class, member.getId());
//        System.out.println("persistenceUnitUtil.isLoaded(findMember) = " + persistenceUnitUtil.isLoaded(findMember));
//
//        System.out.println("================== 초기화 이후 ====================");
//        String username = findMember.getUsername();
//        System.out.println("persistenceUnitUtil.isLoaded(findMember) = " + persistenceUnitUtil.isLoaded(findMember));
    }

    private static void 준영속상태일때초기화안됨테스트(EntityManager entityManager) {
//        Member member = new Member();
//        member.setUsername("memberA");
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Member findMember = entityManager.getReference(Member.class, member.getId());
//
//        entityManager.detach(findMember);
//
//        System.out.println("findMember.getUsername() = " + findMember.getUsername());
    }

    private static void 영속컨텍스트에있을때실제엔티티반환(EntityManager entityManager) {
//        Member member = new Member();
//        member.setUsername("memberA");
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Member realMember = entityManager.find(Member.class, member.getId());
//        System.out.println("realMember.getClass() = " + realMember.getClass());
//
//        Member refMember = entityManager.getReference(Member.class, member.getId());
//        System.out.println("findMember.getClass() = " + refMember.getClass());
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Member refMember2 = entityManager.getReference(Member.class, member.getId());
//        String username = refMember2.getUsername();
//        System.out.println("findMember.getClass() = " + refMember2.getClass());
//
//        Member realMember2 = entityManager.find(Member.class, member.getId());
//        System.out.println("realMember.getClass() = " + realMember2.getClass());
    }

    private static void 타입비교테스트(EntityManager entityManager) {
//        Member member = new Member();
//        member.setUsername("memberA");
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Member findMember = entityManager.getReference(Member.class, member.getId());
//        System.out.println("findMember.getClass() == member.getClass() = " + (findMember.getClass() == member.getClass()));
//        System.out.println("findMember instance of Member = " + (findMember instanceof Member));
    }

    private static void 프록시초기화이후에도교체되지않음테스트(EntityManager entityManager) {
//        Member member = new Member();
//        member.setUsername("memberA");
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Member findMember = entityManager.getReference(Member.class, member.getId());
//        System.out.println("findMember.getClass() = " + findMember.getClass());
//        System.out.println("findMember.getUsername() = " + findMember.getUsername());
//        System.out.println("=============================================");
//        System.out.println("findMember.getClass() = " + findMember.getClass());
    }

    private static void 프록시초기화는최초한번만테스트(EntityManager entityManager) {
//        Team team = new Team();
//        team.setName("teamA");
//        entityManager.persist(team);
//
//        Member member = new Member();
//        member.setUsername("memberA");
//        member.setTeam(team);
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Member findMember = entityManager.getReference(Member.class, member.getId());
//
//        System.out.println("첫번째 실제 엔티티 접근");
//        String username = findMember.getUsername();
//
//        System.out.println("두번째 실제 엔티티 접근");
//        Team findTeam = findMember.getTeam();
    }

    private static void 프록시동작원리확인(EntityManager entityManager) {
//        Member member = new Member();
//        member.setUsername("memberA");
//        entityManager.persist(member);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Member findMember = entityManager.getReference(Member.class, member.getId());
//        System.out.println("findMember.getClass() = " + findMember.getClass());
//
//        System.out.println("===============================");
//        String username = findMember.getUsername();
//        System.out.println("===============================");
    }

    private static void 프록시필요성(EntityManager entityManager) {
//        Team team = new Team();
//        team.setName("teamA");
//        entityManager.persist(team);
//
//        Member member = new Member();
//        member.setUsername("userA");
//        member.setTeam(team);
//        entityManager.persist(member);
//
//        Member findMember = findTeam(entityManager, member.getId());
//        System.out.println("findMember = " + findMember.getUsername() + " : " +  findMember.getTeam().getName());
    }

    private Member findTeam(EntityManager entityManager, Long memberId) {
//        Member findMember = entityManager.find(Member.class, memberId);
//        return findMember;
        return null;
    }

    private static void 상속관계매핑(EntityManager entityManager) {
//        Movie movie = new Movie();
//        movie.setDirector("ChoiJinSoo");
//        movie.setActor("ChoiMinKyung");
//        movie.setName("바람과 함께 사라지다");
//
//        entityManager.persist(movie);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Movie findMovie = entityManager.find(Movie.class, movie.getId());
    }

    private static void 일대일양방향(EntityManager entityManager) {
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
