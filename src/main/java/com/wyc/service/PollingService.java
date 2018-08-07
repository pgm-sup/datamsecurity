package com.wyc.service;


import java.util.List;

import com.wyc.entity.Polling;

public interface PollingService {
	int save(List<Polling> pollings);
	
	List<Polling> queryPolling(String street, String version);
	
	int updatePolling(List<Integer> ids);
}
