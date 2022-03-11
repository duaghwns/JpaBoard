package com.example.demo.dto;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private MemberDto author;
    private LocalDateTime regDate;
    private LocalDateTime modDate;


    public Board dtoToEntity(){
        Member member = Member.builder()
                .seq(author.getSeq())
                .id(author.getId())
                .name(author.getName())
                .age(author.getAge())
                .password(author.getPassword())
                .build();

        return Board.builder()
                .title(title)
                .content(content)
                .author(member)
                .regDate(regDate)
                .modDate(modDate)
                .build();
    }
}
