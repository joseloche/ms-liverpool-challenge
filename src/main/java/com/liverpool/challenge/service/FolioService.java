package com.liverpool.challenge.service;

import java.util.List;

import com.liverpool.challenge.vo.FolioRequestVO;
import com.liverpool.challenge.vo.FolioVO;

public interface FolioService {

	public List<FolioVO> getFolios(String folio);
	
	public void saveFolios(FolioRequestVO request);
}
