package com.Neptune.IssueService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Neptune.IssueService.entity.IssuerEntity;

public interface IssuerEntityRepo extends JpaRepository<IssuerEntity,Integer>{

}
