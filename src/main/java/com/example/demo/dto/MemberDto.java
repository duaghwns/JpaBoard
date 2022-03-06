package com.example.demo.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private Long seq;
    private String id;
    private String name;
    private int age;
    private String password;
}
