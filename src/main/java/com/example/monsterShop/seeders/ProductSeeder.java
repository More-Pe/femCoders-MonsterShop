package com.example.monsterShop.seeders;

import com.example.monsterShop.models.Product;
import com.example.monsterShop.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;

    public ProductSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        if (productRepository.count() == 0) {
            List<Product> products = List.of(
                    new Product("Fluffy Shock", "A fuzzy red creature always in shock. Loves surprises.", 19.99, "https://media.istockphoto.com/id/1449422859/es/foto/criatura-esponjosa-conmocionada-mascota-roja-peluda-con-cuernos-renderizado-3d.jpg?s=2048x2048&w=is&k=20&c=vtk1hkcZt3mPZI8d58qmyniyy7YDUf0TOu9-XWGE6gE=", true),
                    new Product("Classic Screamer", "A classic Halloween monster with an iconic scream.", 24.50, "https://media.istockphoto.com/id/178640157/es/foto/halloween-monster.jpg?s=1024x1024&w=is&k=20&c=hwU7xR0t0kvKPvF4nEz-MCLDkBPeDB1XDpj2JNerL9U=", false),
                    new Product("Angry Pompom", "A red fluffy devil that takes everything personally.", 22.00, "https://media.istockphoto.com/id/1448577806/es/foto/monstruo-enojado-rojo-esponjoso-juguete-diablo-con-cuernos-mascota-peluda-de-aspecto-divertido.jpg?s=2048x2048&w=is&k=20&c=_mJTrVO1Oc3-ucyvIA5Iwmh-YheDgqvA15jA_zX6RrQ=", false),
                    new Product("Suspicious Fluff", "He’s always watching you, silently judging.", 18.75, "https://media.istockphoto.com/id/2193982779/es/foto/textura-de-cara-de-piel-de-personaje-de-c%C3%B3mic-esponjoso-en-3d-con-renderizado-de-expresi%C3%B3n-de.jpg?s=2048x2048&w=is&k=20&c=90vot9IAMnmrKLYQmfLnjbRkmrqEHncKkqfMKTHgQow=", false),
                    new Product("Bored Beast", "Nothing impresses him. Not even other monsters.", 16.40, "https://media.istockphoto.com/id/1365373390/es/foto/monstruo-de-piel-mirando-a-la-c%C3%A1mara-con-expresi%C3%B3n-aburrida-o-rancia.jpg?s=1024x1024&w=is&k=20&c=Stmr8wEdDf0LcTHt98pGwoBtV4o1zjcuBj7vMl6GChA=", false),
                    new Product("Geo Puff", "Round and geometrically perfect. Also fuzzy and cute.", 20.99, "https://media.istockphoto.com/id/2195618364/es/foto/monstruo-esponjoso-lindo-en-3d-personaje-de-dibujos-animados-geom%C3%A9trico-circular-con.jpg?s=2048x2048&w=is&k=20&c=Mdx__pIFyDuhvEHEIPu_ERIzSRebE9fBlaLL0HoeL8U=", true),
                    new Product("Blue Napper", "A sleepy blue monster who loves pink backgrounds.", 21.10, "https://media.istockphoto.com/id/1448797638/es/foto/mascota-cansada-y-esponjosa-juguete-peludo-azul-sobre-fondo-rosa-renderizado-3d.jpg?s=2048x2048&w=is&k=20&c=fEC3u601Bm9TccmQZlWiVXsQnfhx17hwhm2fvAR4L24=", false),
                    new Product("Happy Puff", "Just a cute fluffy thing. No danger, only love.", 19.30, "https://media.istockphoto.com/id/1149273958/es/foto/lindo-monstruo-peludo.jpg?s=2048x2048&w=is&k=20&c=Qo1uxS1e_u1MSdC-pHemEthKElTTq-EB6yR_KN9Hpbw=", true),
                    new Product("3D Mystery", "A strange entity from the 3D void. Nobody knows its name.", 25.00, "https://media.istockphoto.com/id/1363264779/es/foto/ilustraci%C3%B3n-3d.jpg?s=2048x2048&w=is&k=20&c=6CwiXJQRIYj193mJsrBeNz7O--kkcR64iH_Ko0fY9RA=", false)
            );
            productRepository.saveAll(products);
        }
    }
}