package com.liverpool.challenge.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liverpool.challenge.entity.FolioEntity;
import com.liverpool.challenge.repository.FolioRepository;
import com.liverpool.challenge.utils.LiverUtils;
import com.liverpool.challenge.vo.FolioRequestVO;
import com.liverpool.challenge.vo.FolioVO;

import jakarta.transaction.Transactional;

@Service
public class FolioServiceImpl implements FolioService {

	@Autowired
	private FolioRepository folioRepository;
	
	@Autowired
	private LiverUtils utils;
	
	@Override
	public List<FolioVO> getFolios(String folio) {
		List<FolioEntity> folios;
	    if (folio == null || folio.trim().isEmpty()) {
	        folios = folioRepository.findAll();
	    } else {
	    	folios = folioRepository.findByFolio(folio);
	    }
		return folios.stream().map(fol->
			new FolioVO(fol.getId(),fol.getFolio(),fol.getDigest())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void saveFolios(FolioRequestVO request) {
		LocalDateTime fechaHoraActual= LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyHHmmss");
		request.setFolio(request.getFolio().concat("_").concat(fechaHoraActual.format(formatter)));
		
		FolioEntity folio = new FolioEntity();
		folio.setFolio(request.getFolio());
		folio.setDigest(utils.encriptar(request.getFolio()));
		folioRepository.save(folio);
		folioRepository.flush();
	}

}
