package com.wyc.service;

import com.wyc.entity.SixModule;

public interface SixmoduleService {
	
	int saveSixmodule(SixModule sixModule);
	
	SixModule querySixModules(String street, String version);
	
	int updateSixModules(Integer id);
}
