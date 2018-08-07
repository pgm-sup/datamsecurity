package com.wyc.mapper;

import com.wyc.entity.SixModule;

public interface SixModuleMapper {

	int addSixMoudle(SixModule sixModule);

	SixModule querySixModules(String street, String version);

	int updateSixModules(Integer id);

}
