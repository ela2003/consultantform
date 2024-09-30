package com.consultant.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultant.form.entity.consultantEntity;

public interface consultantRepository extends JpaRepository<consultantEntity,Long> {

}
