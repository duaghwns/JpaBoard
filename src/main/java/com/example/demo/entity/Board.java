package com.example.demo.entity;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.MemberDto;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "author")
    private Member author;
    private LocalDateTime regDate;



    public BoardDto entityToDto(){
        MemberDto memberDto = MemberDto.builder()
                .seq(author.getSeq())
                .id(author.getId())
                .name(author.getName())
                .age(author.getAge())
                .password(author.getPassword())
                .build();

        return BoardDto.builder()
                .title(title)
                .content(content)
                .author(memberDto)
                .regDate(regDate)
                .build();
    }
}
