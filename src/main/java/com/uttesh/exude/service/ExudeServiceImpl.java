package com.uttesh.exude.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.uttesh.exude.ExudeData;
import com.uttesh.exude.bean.ExudeBean;
import com.uttesh.exude.common.Constants;
import com.uttesh.exude.exception.InvalidDataException;

/**
 * 
 * @author uttesh
 *
 */
@Service
public class ExudeServiceImpl implements ExudeService {
	
	private static final Logger logger = LoggerFactory.getLogger(ExudeServiceImpl.class);

	@Override
	public Object getFilteredData(String type, ExudeBean exudeBean) throws InvalidDataException {
		switch (Constants.PATHS.valueOf(type.toUpperCase())) {
		case STOPPING:
			return this.getData(true, exudeBean);
		case SWEAR:
			return this.getData(false, exudeBean);
		default:
			break;
		}
		return null;
	}

	private Object getData(boolean isStopping, ExudeBean exudeBean) throws InvalidDataException {
		boolean isLinks = exudeBean.getLinks().size() > 0 ? true : false;
		Map<String, String> multiData = new HashMap<>();
		if (isLinks) {
			for (String link : exudeBean.getLinks()) {
				String data = isStopping ? this.getExudeInstance().filterStoppings(link)
						: this.getExudeInstance().getSwearWords(link);
				multiData.put(link, getCommaSeparatedData(data));
			}
			return multiData;
		} else {
			String data = isStopping ? this.getExudeInstance().filterStoppings(exudeBean.getData())
					: this.getExudeInstance().getSwearWords(exudeBean.getData());
			return getCommaSeparatedData(data);
		}
	}

	private String getCommaSeparatedData(String data) {
		// return data.replaceAll("\\s+", ",").substring(0, data.length()-1);
		return data;
	}

	public ExudeData getExudeInstance() {
		return ExudeData.getInstance();
	}

	@Override
	public Object getFilteredFileData(String type, String file) throws InvalidDataException {
		String result =  "";
		if(Constants.PATHS.STOPPING.name().toLowerCase().equalsIgnoreCase(type)) {
			logger.info("getFilteredFileData :: STOPPING :: ");
			result = this.getExudeInstance().filterStoppings(file);
		}else {
			logger.info("getFilteredFileData :: SwearWords :: ");
			result = this.getExudeInstance().getSwearWords(file);
		}
		return result;
	}

}
