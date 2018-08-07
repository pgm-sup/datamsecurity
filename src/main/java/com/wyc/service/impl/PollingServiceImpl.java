package com.wyc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.entity.Polling;
import com.wyc.mapper.PollingMapper;
import com.wyc.service.PollingService;

@Service
public class PollingServiceImpl implements PollingService {
	
	@Autowired
	private PollingMapper pollingMapper;

	@Override
	public int save(List<Polling> pollings) {
		return pollingMapper.savePolling(pollings);
	}

	@Override
	public List<Polling> queryPolling(String street, String version) {
		return pollingMapper.query(street, version);
	}

	@Override
	public int updatePolling(List<Integer> ids) {
		
		return pollingMapper.updatePollings(ids);
	}
	

}
