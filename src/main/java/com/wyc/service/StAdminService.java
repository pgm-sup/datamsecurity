package com.wyc.service;

import java.util.List;
import java.util.Map;

import com.wyc.entity.Polling;
import com.wyc.entity.Schdule;
import com.wyc.entity.SixModule;

public interface StAdminService {
	
	void addData(List<Polling> pollings, SixModule sixModule, List<Schdule> schdules) throws Exception;
	
	Map<String, Object> queryData(String street, String version);
	
	void updateData(List<Integer> pollids, Integer sixId, List<Integer> scids);

}
