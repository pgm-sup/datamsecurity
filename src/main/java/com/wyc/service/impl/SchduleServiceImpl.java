package com.wyc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.entity.Schdule;
import com.wyc.mapper.SchduleMapper;
import com.wyc.service.SchduleService;

@Service
public class SchduleServiceImpl implements SchduleService {
	
	@Autowired
	private SchduleMapper schduleMapper;

	@Override
	public int addSchdule(List<Schdule> schdules) {
		return schduleMapper.addSchdule(schdules); 
	}

	@Override
	public List<Schdule> querySchdules(String street, String version) {
		return schduleMapper.querySchdules(street, version);
	}

	@Override
	public int updateSchdules(List<Integer> ids) {
		return schduleMapper.updateSchdules(ids);
	}

}
