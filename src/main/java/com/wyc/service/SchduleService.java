package com.wyc.service;

import java.util.List;

import com.wyc.entity.Schdule;

public interface SchduleService {
	
	int addSchdule(List<Schdule> schdules);
	
	List<Schdule> querySchdules(String street, String version);
	
	int updateSchdules(List<Integer> ids);	
}
