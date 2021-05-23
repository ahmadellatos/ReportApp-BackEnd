package com.reportapp.controller;

import java.io.IOException;

//import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.reportapp.entity.ReportData;
import com.reportapp.repository.ReportDataRepository;
import com.reportapp.utility.FileUtility;

@RestController
@RequestMapping("/")
public class ReportDataController {

	@Autowired
	ReportDataRepository reportDataRepo;
	
	@PostMapping("/addreport")
	public String addReport(@RequestParam(value="file") MultipartFile file,@RequestBody ReportData reportData) throws IOException {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		String uploadDir = "user-photos/";

		FileUtility.saveFile(uploadDir, fileName, file);

		reportData.setGambar("/" + uploadDir + fileName);
		 reportDataRepo.save(reportData);
		 
		return "Insert Berhasil";
	}
}
