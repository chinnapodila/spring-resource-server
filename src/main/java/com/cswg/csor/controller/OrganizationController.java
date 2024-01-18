package com.cswg.csor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cswg.csor.model.Organization;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/orgs")
@Slf4j
public class OrganizationController {
	@GetMapping(value = "/{id}")
    public Organization findOne(@PathVariable Long id) {
        return new Organization(id,id+"Org");
    }

    @GetMapping
    public List<Organization> findAll() {
        List<Organization> fooList = new ArrayList<>();
        fooList.add(new Organization(1l, "SWIFT"));
        fooList.add(new Organization(2l, "APPLE"));   return fooList;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody Organization newFoo) {
        log.info("Org created");
    }
}
