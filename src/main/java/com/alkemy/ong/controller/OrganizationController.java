package com.alkemy.ong.controller;

import com.alkemy.ong.dto.ActivityDTO;
import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.dto.OrganizationFullDTO;
import com.alkemy.ong.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("organization")
public class OrganizationController {

    @Autowired
    private IOrganizationService organizationService;

    @GetMapping("/public")
    public ResponseEntity<OrganizationBasicDTO> getOrganizationBasic() {
        return ResponseEntity.ok(organizationService.getOrganizationBasic());
    }

    @PutMapping ("/public/{id}")
    public ResponseEntity<OrganizationFullDTO> putOrganization(@PathVariable Long id, @Valid @RequestBody OrganizationFullDTO dto) {
        OrganizationFullDTO updatedOrganization = organizationService.update(id, dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedOrganization);
    }
}
