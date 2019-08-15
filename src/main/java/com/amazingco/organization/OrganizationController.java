package com.amazingco.organization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/v1/organization")
public class OrganizationController {


    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(final OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("{nodeName}/children")
    ResponseEntity<List<OrganizationNodes>> findChildNodes(@PathVariable final String nodeName) {

        final List<OrganizationNodes> nodes = organizationService.findAllChildrenNodes(nodeName);

        return ResponseEntity.ok().body(nodes);
    }

    @PutMapping("{nodeName}/updateParent")
    ResponseEntity setParent(@PathVariable final String nodeName, @RequestParam final String parentNode) {

        if (StringUtils.isEmpty(parentNode)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ParentNode cannot be blank");
        }

        organizationService.moveNode(nodeName, parentNode);
        return ResponseEntity.ok("Node moved Successfully");
    }

}
