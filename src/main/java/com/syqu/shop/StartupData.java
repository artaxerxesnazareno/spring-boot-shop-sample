package com.syqu.shop;

import com.syqu.shop.domain.Category;
import com.syqu.shop.domain.Product;
import com.syqu.shop.domain.User;
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
        category1.setCategoryName("Acessórios para Eletrônicos");
        category2.setId(2);
        category2.setCategoryName("Calçados");
        category3.setId(3);
        category3.setCategoryName("Acessórios");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
    }

    private void exampleProducts() {
        final String NAME1 = "Cabo LDNIO Micro USB";
        final String IMAGE_URL1 = "4c19f86a-be58-4bad-a3fe-5a26a69af25a.jpg";
        final String DESCRIPTION1 = "Este cabo LDNIO Micro USB é a solução perfeita para carregar e sincronizar dados entre dispositivos compatíveis com Micro USB. Com um design durável e resistente, este cabo oferece uma conexão confiável e rápida para garantir que seu dispositivo esteja sempre carregado e pronto para uso.";
        final BigDecimal PRICE1 = BigDecimal.valueOf(1500);

        final String NAME2 = "Tênis Nike";
        final String IMAGE_URL2 = "category_img_02.jpg";
        final String DESCRIPTION2 = " Este tênis da Nike combina estilo e conforto para o seu dia a dia. Projetado com um cabedal de tecido respirável e leve, este calçado proporciona uma sensação extremamente macia e confortável aos pés. Sua entressola de espuma oferece amortecimento responsivo e excelente absorção de impacto, garantindo maior estabilidade durante a caminhada. O solado emborrachado antiderrapante e o colarinho acolchoado proporcionam suporte adicional e segurança em cada passo. Com um design moderno e elegante, este tênis Nike é a escolha perfeita para quem busca um calçado versátil e de alta qualidade";
        final BigDecimal PRICE2 = BigDecimal.valueOf(5000);

        final String NAME3 = "Relógio Digital";
        final String IMAGE_URL3 = "feature_prod_02.jpg";
        final String DESCRIPTION3 = "O relógio digital é um dispositivo elegante e funcional que permite que você acompanhe as horas com precisão e facilidade. Com um visor de LED claro e fácil de ler, este relógio é perfeito para uso diário ou para atividades esportivas. Além disso, ele possui recursos adicionais, como alarme, cronômetro e luz de fundo, tornando-o uma escolha versátil para todas as suas necessidades de cronometragem.";
        final BigDecimal PRICE3 = BigDecimal.valueOf(10000);

        final String NAME4 = "Óculos Escuros";
        final String IMAGE_URL4 = "category_img_03.jpg";
        final String DESCRIPTION4 = "Estes óculos escuros oferecem proteção contra os raios UV, garantindo estilo e conforto durante todo o dia. Com armação resistente e lentes polarizadas, eles são a escolha perfeita para quem busca um acessório de qualidade e sofisticação";
        final BigDecimal PRICE4 = BigDecimal.valueOf(12000);

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product1.setName(NAME1);
        product1.setImageUrl(IMAGE_URL1);
        product1.setDescription(DESCRIPTION1);
        product1.setCategory(categoryRepository.findByCategoryName("Acessórios para Eletrônicos"));
        product1.setPrice(PRICE1);

        product2.setName(NAME2);
        product2.setImageUrl(IMAGE_URL2);
        product2.setDescription(DESCRIPTION2);
        product2.setCategory(categoryRepository.findByCategoryName("Calçados"));
        product2.setPrice(PRICE2);

        product3.setName(NAME3);
        product3.setImageUrl(IMAGE_URL3);
        product3.setDescription(DESCRIPTION3);
        product3.setCategory(categoryRepository.findByCategoryName("Acessórios"));
        product3.setPrice(PRICE3);

        product4.setName(NAME4);
        product4.setImageUrl(IMAGE_URL4);
        product4.setDescription(DESCRIPTION4);
        product4.setCategory(categoryRepository.findByCategoryName("Acessórios"));
        product4.setPrice(PRICE4);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
    }
}
