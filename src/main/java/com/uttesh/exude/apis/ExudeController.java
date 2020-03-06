package com.uttesh.exude.apis;

import java.io.File;

import javax.ws.rs.Consumes;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uttesh.exude.bean.ExudeBean;
import com.uttesh.exude.bean.ExudeResponseBean;
import com.uttesh.exude.service.ExudeService;

/**
 * 
 * @author uttesh
 *
 *  Exude API end point class to filter the provided input data
 */
@RestController
public class ExudeController {

	private static final Logger logger = LoggerFactory.getLogger(ExudeController.class);
	
	@Autowired
	ExudeService exudeService;

	/**
	 * Filter the provided text or links data
	 * @param type
	 * @param exudeBean
	 * @return filter stopping/swear words
	 */
	@PostMapping("/exude/{type}/data")
	public ResponseEntity<?> exudeData(@PathVariable("type") String type, @RequestBody ExudeBean exudeBean) {
		ExudeResponseBean exudeResponseBean = new ExudeResponseBean();
		try {
			exudeResponseBean.setData(exudeService.getFilteredData(type, exudeBean));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(exudeResponseBean, HttpStatus.OK);
	}

	/**
	 * Filter the provided file data
	 * @param type
	 * @param exudeBean
	 * @return filter stopping/swear words
	 */
	@PostMapping("/exude/{type}/file")
	@Consumes({"multipart/form-data", "multipart/mixed"})
	public ResponseEntity<?> createModel(@PathVariable("type") String type, @RequestPart("file") MultipartFile uploadFile) {
		ExudeResponseBean exudeResponseBean = new ExudeResponseBean();
		try {
			logger.info("file name:: {}", uploadFile.getOriginalFilename());
			File targetFile = null;
			targetFile = File.createTempFile(uploadFile.getOriginalFilename(), "");
			logger.info("file name:: getPath: {}", targetFile.getPath());
			FileUtils.copyInputStreamToFile(uploadFile.getInputStream(), targetFile);
			exudeResponseBean.setData(exudeService.getFilteredFileData(type, targetFile.getPath()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(exudeResponseBean, HttpStatus.OK);
	}
}
