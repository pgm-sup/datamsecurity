package com.wyc.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.wyc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.entity.LogEntity;
import com.wyc.mapper.LogMapper;

@Service
public class LogServiceImpl implements LogService {
	
	@Autowired
	private LogMapper logMapper;

	@Override
	public void saveLog(LogEntity log) {
		logMapper.saveLog(log);	
	}
	@Override
	public List<LogEntity> getAllLogs(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return logMapper.getAllLogs();
	}

}
