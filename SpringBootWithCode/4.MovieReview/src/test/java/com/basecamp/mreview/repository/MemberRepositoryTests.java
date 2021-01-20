package com.basecamp.mreview.repository;

import com.basecamp.mreview.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMembers() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("r" + i + "@godo.org")
                    .pw("1111")
                    .nickname("reviewer" + i).build();
            memberRepository.save(member);
        });
    }
}
