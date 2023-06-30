package com.syqu.shop;

import com.syqu.shop.model.Category;
import com.syqu.shop.model.Product;
import com.syqu.shop.model.User;
import com.syqu.shop.repository.CategoryRepository;
import com.syqu.shop.service.ProductService;
import com.syqu.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("dev")
public class StartupData implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;

    @Autowired
    public StartupData(UserService userService, ProductService productService, CategoryRepository categoryRepository) {
        this.userService = userService;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        adminAccount();
        userAccount();
        category();
        exampleProducts();
    }

    private void userAccount() {
        User user = new User();

        user.setUsername("user");
        user.setPassword("user");
        user.setPasswordConfirm("user");
        user.setGender("Female");
        user.setEmail("user@example.com");

        userService.save(user);
    }

    private void adminAccount() {
        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPasswordConfirm("admin");
        admin.setGender("Male");
        admin.setEmail("admin@example.com");

        userService.save(admin);
    }

    private void category() {
        Category category1 = new Category();
        Category category2 = new Category();
        Category category3 = new Category();
        category1.setId(1);
        category1.setCategoryName("Eletrônicos");
        category2.setId(2);
        category2.setCategoryName("Roupa");
        category3.setId(3);
        category3.setCategoryName("Acessórios");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
    }

    private void exampleProducts() {
        final String NAME1 = "Tênis Nike Marom";
        final String IMAGE_URL1 = "maksim-larin-NOpsC3nWTzY-unsplash.jpg";
        final String DESCRIPTION1 = "O tênis Nike Marom é uma calça de campo masculina de alta qualidade, perfeita para atividades esportivas e informais.\n" +
                "Feita com tecido leve e transpirabilidade, a calça de campo é confortável de usar em qualquer clima.\n" +
                "O design moderno e atlético da calça de campo garante um estilo dinâmico e confortável, valorizando a silhueta masculina.\n" +
                "Disponível em diversas cores e tamanhos, a calça de campo é uma escolha versátil para qualquer guarda-roupa masculino";
        final BigDecimal PRICE1 = BigDecimal.valueOf(12000);

        final String COR1 = "Amarelo";
        final String TAMANHO1 = "42";
        final String MARCA1 = "Nike";


        final String NAME2 = "Tênis Nike";
        final String IMAGE_URL2 = "category_img_02.jpg";
        final String DESCRIPTION2 = " Este tênis da Nike combina estilo e conforto para o seu dia a dia. Projetado com um cabedal de tecido respirável e leve, este calçado proporciona uma sensação extremamente macia e confortável aos pés. Sua entressola de espuma oferece amortecimento responsivo e excelente absorção de impacto, garantindo maior estabilidade durante a caminhada. O solado emborrachado antiderrapante e o colarinho acolchoado proporcionam suporte adicional e segurança em cada passo. Com um design moderno e elegante, este tênis Nike é a escolha perfeita para quem busca um calçado versátil e de alta qualidade";
        final BigDecimal PRICE2 = BigDecimal.valueOf(5000);

        final String NAME3 = "Vermelho Air Jordan 2";
        final String IMAGE_URL3 = "wengang-zhai-_fOL6ebfECQ-unsplash.jpg";
        final String DESCRIPTION3 = "O tênis Vermelho Air Jordan 2 é uma calça de campo masculina de alta qualidade, perfeita para atividades esportivas e informais.\n" +
                "Feita com tecido leve e transpirabilidade, a calça de campo é confortável de usar em qualquer clima.\n" +
                "O design moderno e atlético da calça de campo garante um estilo dinâmico e confortável, valorizando a silhueta masculina.\n" +
                "Disponível em diversas cores e tamanhos, a calça de campo é uma escolha versátil para qualquer guarda-roupa masculino";
        final BigDecimal PRICE3 = BigDecimal.valueOf(14000);

        final String COR3 = "Vermelho";
        final String TAMANHO3 = "42";
        final String MARCA3 = "Nike";


        final String NAME4 = "Converses Verde";
        final String IMAGE_URL4 = "sneakers-g85398866c_1280.png";
        final String DESCRIPTION4 = "Os converses Verde são uma calça de campo masculina de alta qualidade, perfeita para atividades esportivas e informais.\n" +
                "Feita com tecido leve e transpirabilidade, a calça de campo é confortável de usar em qualquer clima.\n" +
                "O design moderno e atlético da calça de campo garante um estilo dinâmico e confortável, valorizando a silhueta masculina.\n" +
                "Disponível em diversas cores e tamanhos, a calça de campo é uma escolha versátil para qualquer guarda-roupa masculino";
        final BigDecimal PRICE4 = BigDecimal.valueOf(15000);

        final String COR4 = "Amarelo";
        final String TAMANHO4 = "42";
        final String MARCA4 = "Nike";


        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product1.setName(NAME1);
        product1.setImageUrl(IMAGE_URL1);
        product1.setDescription(DESCRIPTION1);
//        product1.setCategory(categoryRepository.findByCategoryName("Eletrônicos"));
        product1.setPrice(PRICE1);
        product1.setCor(COR1);
        product1.setTamanho(TAMANHO1);
        product1.setMarca(MARCA1);

        product2.setName(NAME2);
        product2.setImageUrl(IMAGE_URL2);
        product2.setDescription(DESCRIPTION2);
//        product2.setCategory(categoryRepository.findByCategoryName("Calçados"));
        product2.setPrice(PRICE2);

        product3.setName(NAME3);
        product3.setImageUrl(IMAGE_URL3);
        product3.setDescription(DESCRIPTION3);
//        product3.setCategory(categoryRepository.findByCategoryName("Acessórios"));
        product3.setPrice(PRICE3);
        product3.setCor(COR3);
        product3.setTamanho(TAMANHO3);
        product3.setMarca(MARCA3);


        product4.setName(NAME4);
        product4.setImageUrl(IMAGE_URL4);
        product4.setDescription(DESCRIPTION4);
//        product4.setCategory(categoryRepository.findByCategoryName("Acessórios"));
        product4.setPrice(PRICE4);
        product4.setCor(COR4);
        product4.setTamanho(TAMANHO4);
        product4.setMarca(MARCA4);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
    }
}
