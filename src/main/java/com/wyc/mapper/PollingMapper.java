package com.wyc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wyc.entity.Polling;

public interface PollingMapper {

    int savePolling(List<Polling> pollings);

	List<Polling> query(@Param("street") String street, @Param("version") String version);

	int updatePollings(List<Integer> ids);
}
