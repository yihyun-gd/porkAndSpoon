package kr.co.porkandspoon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.porkandspoon.dao.TestDAO;

@Service
public class TestService {
	
	@Autowired TestDAO testDao;

}
