package com.dell.bbt.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dell.bbt.mapper.SubjectMapper;
import com.dell.bbt.model.Subject;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SubjectService {

	@Autowired
	private SqlSession sqlSession;

	public List<Subject> getSubject() {
		SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
		return subjectMapper.getAllsubject();
	}

	public Subject saveSubject(Subject subject) {
		SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
		subjectMapper.saveSubject(subject);
		return subject;
	}

	public int updateSubject(Subject subject) {
		SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
		return subjectMapper.updateSubject(subject);
	}

	public int deleteSubject(int id) {
		SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
		return subjectMapper.deleteSubject(id);
	}

}
