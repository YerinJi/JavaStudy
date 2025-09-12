package com.multi.springboot;
import com.multi.springboot.DTO.Mapper.Member;
import com.multi.springboot.DTO.Mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberMapper memberMapper;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> list = memberMapper.findAll();
        model.addAttribute("members", list);
        return "members";
    }
}