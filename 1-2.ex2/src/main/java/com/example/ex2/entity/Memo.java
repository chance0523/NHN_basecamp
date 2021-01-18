package com.example.ex2.entity;

import lombok.*;

import javax.persistence.*;

@Entity // 반드시 추가
@Table(name = "tbl_memo") // db상에서 엔티티 클래스를 어떠한 테이블로 생성할 것인
@ToString
@Getter // getter 메소드 생성
@Builder // 객체를 생성
@AllArgsConstructor // Builer를 위해
@NoArgsConstructor // 필요하다.
public class Memo {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK를 자동으로 생성
    // IDENTITY : 사용하는 데이터베이스가 키 생성을 결
    private Long mno;

    @Column(length = 200, nullable = false)
    private String memoText;
}
