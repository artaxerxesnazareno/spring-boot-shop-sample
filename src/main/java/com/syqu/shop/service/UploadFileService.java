package com.syqu.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class UploadFileService {
	private String folder="images//";
	
	public String saveImagem(MultipartFile file) throws IOException {
		
		if (!file.isEmpty()) {
			byte [] bytes= file.getBytes(); //precisa converter a imagem em byte para passar do servidor
			Path path = Path.of(folder+file.getOriginalFilename());
			Files.write(path, bytes);
			return file.getOriginalFilename();
			
		}
		return file.getOriginalFilename();
	}
	
	public void deleteImagem(String nome) {
		String rota="images//";
		File file = new File(rota+nome);
		file.delete();
	}

}
