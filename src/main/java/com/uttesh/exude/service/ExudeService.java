package com.uttesh.exude.service;

import org.springframework.stereotype.Service;

import com.uttesh.exude.bean.ExudeBean;
import com.uttesh.exude.exception.InvalidDataException;

/**
 * 
 * @author uttesh
 *
 */
@Service
public interface ExudeService {

	 public Object getFilteredData(String type, ExudeBean exudeBean) throws InvalidDataException;
	 public Object getFilteredFileData(String type, String file) throws InvalidDataException;
}
