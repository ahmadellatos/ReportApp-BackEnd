package com.reportapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reportapp.entity.ReportData;

public interface ReportDataRepository extends JpaRepository<ReportData, Long>{

}
