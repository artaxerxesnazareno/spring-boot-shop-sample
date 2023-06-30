package com.syqu.shop.controller;

<<<<<<< HEAD

import com.syqu.shop.domain.Product;
import com.syqu.shop.service.CategoryService;
import com.syqu.shop.service.ProductService;
import com.syqu.shop.service.UploadFileService;
=======
import com.syqu.shop.model.Product;
import com.syqu.shop.service.CategoryService;
import com.syqu.shop.service.ProductService;
import com.syqu.shop.service.UploadFileService;
import com.syqu.shop.service.impl.FileUploadUtil;
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30
import com.syqu.shop.validator.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
=======
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
<<<<<<< HEAD
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
=======
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30

@Controller
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private final ProductValidator productValidator;
    private final CategoryService categoryService;

    private static final String UPLOAD_DIR = "static/images/upload/";

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private UploadFileService uplaod;
    @Autowired
    public ProductController(ProductService productService, ProductValidator productValidator, CategoryService categoryService) {
        this.productService = productService;
        this.productValidator = productValidator;
        this.categoryService = categoryService;
    }
<<<<<<< HEAD
    @PostMapping("/uploadd")
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
=======
    @GetMapping("/images/{filename}")
    @ResponseBody
    public Resource getImage(@PathVariable String filename) {
        Path file = Paths.get("src/main/resources/static/images", filename);
        Resource resource;
        try {
            resource = new UrlResource(file.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        return resource;
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30
    }
    @GetMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("productForm", new Product());
        model.addAttribute("method", "new");
        model.addAttribute("categories", categoryService.findAll());
        return "dashboard/novo_sapato";
    }

    @PostMapping("/product/new")
    public String newProduct(@ModelAttribute("productForm") Product productForm, BindingResult bindingResult, Model model, HttpServletRequest request) throws IOException {
        productValidator.validate(productForm, bindingResult);

        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "new");
            return "dashboard/novo_sapato";
        }

        // Processa o upload da image
        MultipartFile file = productForm.getImageFile();
        String nomeImagem = uplaod.saveImagem(file);

<<<<<<< HEAD
=======
       /* String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        String randomFileName = UUID.randomUUID().toString() + "." + fileExtension;
        String uploadDir = "src/main/resources/static/images/upload/";
        String filePath = uploadDir + randomFileName;

        FileUploadUtil.saveFile(uploadDir, randomFileName, file);*/
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30

// Define o caminho da imagem no objeto Product
        productForm.setImageUrl(nomeImagem);


        productService.save(productForm);
        logger.debug(String.format("Product with id: %s successfully created.", productForm.getId()));

        return "redirect:/home";
    }


    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") long productId, Model model) {
        Product product = productService.findById(productId);
        if (product != null) {
            model.addAttribute("productForm", product);
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("method", "edit");
            return "dashboard/novo_sapato";
        } else {
            return "error/404";
        }
    }

    @PostMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") long productId, @ModelAttribute("productForm") Product productForm, BindingResult bindingResult, Model model, HttpServletRequest request) throws IOException {
        productValidator.validate(productForm, bindingResult);

        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "edit");
            return "dashboard/novo_sapato" ;
        }
        // Processa o upload da imagem
        MultipartFile file = productForm.getImageFile();
        String nomeImagem = uplaod.saveImagem(file);
// Define o caminho da imagem no objeto Product
        productForm.setImageUrl(nomeImagem);

        productService.edit(productId, productForm);
        logger.debug(String.format("Product with id: %s has been successfully edited.", productId));

        return "redirect:/home";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") long productId) {
        Product product = productService.findById(productId);
        if (product != null) {
            productService.delete(productId);
            logger.debug(String.format("Product with id: %s successfully deleted.", product.getId()));
            return "redirect:/home";
        } else {
            return "error/404";
        }
    }

    @GetMapping("/product/details/{id}")
    public String showProductDetails(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product-details";
    }

}
