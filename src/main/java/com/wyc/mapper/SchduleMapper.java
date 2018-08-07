package com.wyc.mapper;

import java.util.List;

import com.wyc.entity.Schdule;

public interface SchduleMapper {

	int addSchdule(List<Schdule> schdules);

	List<Schdule> querySchdules(String street, String version);

	int updateSchdules(List<Integer> ids);

}
