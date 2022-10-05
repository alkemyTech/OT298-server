package com.alkemy.ong.controller;

import com.alkemy.ong.dto.MemberDTO;
import com.alkemy.ong.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.alkemy.ong.util.Constants.Endpoints;

import javax.validation.Valid;

@RestController
@RequestMapping(Endpoints.MEMBER)
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @PostMapping
    public ResponseEntity<MemberDTO> save(@Valid @RequestBody MemberDTO dto){
        MemberDTO savedMember = memberService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(memberService.getAll(), HttpStatus.OK);
    }
}
