package com.liverpool.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liverpool.challenge.service.FolioService;
import com.liverpool.challenge.vo.FolioRequestVO;
import com.liverpool.challenge.vo.FolioVO;

@RestController
@RequestMapping("/api/liverpool/")
public class FolioController {
	
	@Autowired
	private FolioService folioService;
	
	@GetMapping("folio")
	public ResponseEntity<Object> getFolio(@RequestParam String folio){
		return ResponseEntity.ok(folioService.getFolios(folio));
	}
	
	@PostMapping("folio")
	public ResponseEntity<Object> postMethodName(@RequestBody FolioRequestVO request) {
		folioService.saveFolios(request);
		return ResponseEntity.ok(null);
	}
	

}
