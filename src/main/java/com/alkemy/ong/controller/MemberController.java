package com.alkemy.ong.controller;

import com.alkemy.ong.dto.MemberDTO;
import com.alkemy.ong.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("members")
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @PostMapping
    public ResponseEntity<MemberDTO> save(@Valid @RequestBody MemberDTO dto){
        MemberDTO savedMember = memberService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> update(@Valid @PathVariable("id") Long id, @RequestBody MemberDTO dto) {

        MemberDTO memberdtoupdated = memberService.update(id,dto);

        return ResponseEntity.ok().body(memberdtoupdated);


    }
}
