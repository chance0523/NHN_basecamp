package com.example.guestbook.entity;

import lombok.Getter;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
// 해당 어노테이션이 적용된 클래스는 테이블로 생성되지 않는다.
// 실제 테이블은 BaseEntity 클래스를 상속한 엔티티의 클래스로 데이터베이스 테이블이 생성된다.
@EntityListeners(value = {AuditingEntityListener.class})
// 엔티티 객체의 변화가 일어나는 것을 감지하는 리스너
@Getter
abstract class BaseEntity {

    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;

}
