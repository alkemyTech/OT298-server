package com.alkemy.ong.controller;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("organization")
public class OrganizationController {

    @Autowired
    private IOrganizationService organizationService;

    @GetMapping("/public")
    public ResponseEntity<OrganizationBasicDTO> getOrganizationBasic() {
        return ResponseEntity.ok(organizationService.getOrganizationBasic());
    }
}
