package com.syqu.shop.controller;

import com.syqu.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ImageController {

    private static final String UPLOAD_DIR = "src/main/resources/static/images/upload/";

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/uploadForm")
    public String showUploadForm(Model model) {
        model.addAttribute("productForm", new Product());
        return "product-test";
    }
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("imageFile") MultipartFile file, RedirectAttributes redirectAttributes, Model model) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Por favor, selecione um arquivo para fazer o upload.");
            return "redirect:/";
        }

        try {
            // Salva o arquivo na pasta de upload
            byte[] bytes = file.getBytes();
            Path path = Paths.get(servletContext.getRealPath(UPLOAD_DIR) + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message", "Upload realizado com sucesso: " + file.getOriginalFilename());
            model.addAttribute("filename", file.getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
            return String.valueOf(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }

        return "upload_success";
    }
}

