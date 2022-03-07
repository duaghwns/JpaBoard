package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/sign")
    public String signView() {
        return "/member/sign";
    }


    @PostMapping("/sign")
    public String sign(MemberDto memberDto, Model model){
        MemberDto member = memberService.sign(memberDto);
        model.addAttribute(member);
        return "redirect:/";
    }


    @GetMapping("/login")
    public String loginView(){
        return "/member/login";
    }

    @PostMapping("/login")
    public String login(MemberDto member, HttpServletRequest request){
        MemberDto loginUser = memberService.login(member);
        System.out.println(loginUser);
        System.out.println(member);
        if(loginUser!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user", loginUser);
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/";
    }

}
