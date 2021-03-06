package com.dell.bbt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dell.bbt.model.Subject;
import com.dell.bbt.service.SubjectService;

@Controller
@RequestMapping("/subject/api")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<Subject> getAllSubjects() {
		return subjectService.getSubject();
	}

}
