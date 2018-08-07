package com.wyc.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wyc.entity.Polling;
import com.wyc.entity.Schdule;
import com.wyc.entity.SixModule;
import com.wyc.mapper.PollingMapper;
import com.wyc.mapper.SchduleMapper;
import com.wyc.mapper.SixModuleMapper;
import com.wyc.service.StAdminService;

@Service
public class StAdminServiceImpl implements StAdminService {
	
	@Autowired
	private PollingMapper pollingMapper;
	
	@Autowired
	private SixModuleMapper sixModuleMapper;
	
	@Autowired
	private SchduleMapper schduleMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void addData(List<Polling> pollings, SixModule sixModule, List<Schdule> schdules) throws Exception{

		Subject subject = SecurityUtils.getSubject();
		if(subject.hasRole(sixModule.getStreet()) || subject.hasRole("admin")){
			pollingMapper.savePolling(pollings);
			sixModuleMapper.addSixMoudle(sixModule);
			schduleMapper.addSchdule(schdules);
		}else {
			throw new Exception("没有修改权限");
		}
	}

	@Override
	public Map<String, Object> queryData(String street, String version) {
		Map<String, Object> map = new HashedMap();
		List<Polling> pollings = pollingMapper.query(street, version);
		SixModule sixModule = sixModuleMapper.querySixModules(street, version);
		List<Schdule> schdules = schduleMapper.querySchdules(street, version);
		map.put("pollings", pollings);
		map.put("sixModule", sixModule);
		map.put("schdules", schdules);
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void updateData(List<Integer> pollids, Integer sixId, List<Integer> scids) {
		pollingMapper.updatePollings(pollids);
		sixModuleMapper.updateSixModules(sixId);
		schduleMapper.updateSchdules(scids);	
	}
}
