package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age); //너무 길어져서 문제
    List<Member> findHelloBy();

    List<Member> findTop3HelloBy();

//    @Query(name = "Member.findByUsername") 없어도 실행 됨
    List<Member> findByUsername(@Param("username") String username);

    @Query("select m from Member m where m.username = :username and m.age = :age") //얘를 많이 사용
    List<Member> findUser(@Param("username") String username, @Param("age") int age);
}
