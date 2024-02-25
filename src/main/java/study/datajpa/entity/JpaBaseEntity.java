package study.datajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass //속성들이 테이블에 저장됨
@Getter
public class JpaBaseEntity {

    @Column(updatable = false) //값 변경 못함
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist //persist 하기 전 이벤트 발생
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        updatedDate = now;
    }

    @PreUpdate //update 하기 전 이벤트 발생
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
