package com.wyc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.entity.SixModule;
import com.wyc.mapper.SixModuleMapper;
import com.wyc.service.SixmoduleService;
@Service
public class SixModuleServiceImpl implements SixmoduleService {
	
	@Autowired
	private SixModuleMapper sixMoudleMapper;

	@Override
	public int saveSixmodule(SixModule sixModule) {
		return sixMoudleMapper.addSixMoudle(sixModule);
	}

	@Override
	public SixModule querySixModules(String street, String version) {
		return sixMoudleMapper.querySixModules(street, version);
	}

	@Override
	public int updateSixModules(Integer id) {
		return sixMoudleMapper.updateSixModules(id);
	}

}
