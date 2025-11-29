package levelUp.main.LevelUp.dataLoader;

import levelUp.main.LevelUp.model.Product;
import levelUp.main.LevelUp.model.User;
import levelUp.main.LevelUp.repository.ProductRepository;
import levelUp.main.LevelUp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        List<Product> products = Arrays.asList(
                Product.builder().nameProduct("Catan").distributorProduct("Catan Inc.").linkDistributor("https://youtu.be/J8SBp4SyvLc?si=3Y4W4pOTVIH4Urgu").priceProduct(29990).descriptionProduct("Un clásico juego de estrategia donde los jugadores compiten por colonizar y expandirse en la isla de Catan. Ideal para 3-4 jugadores.").categoryProduct("tablegame").urlImage("https://devirinvestments.s3.eu-west-1.amazonaws.com/img/catalog/product/8436017220100-1200-frontflat.jpg").stockProduct(10).build(),
                Product.builder().nameProduct("Secretlab Titan").distributorProduct("Silla Inc.").linkDistributor("https://youtu.be/d5NEeeju30Y?si=AwapttS0CqdBNB-N").priceProduct(249990).descriptionProduct("Diseñada para el máximo confort, esta silla ofrece soporte ergonómico y personalización ajustable para sesiones de juego prolongadas.").categoryProduct("chair").urlImage("https://m.media-amazon.com/images/I/61i4ShTt0lL._AC_SL1500_.jpg").stockProduct(10).build(),
                Product.builder().nameProduct("Logitech G502 HERO").distributorProduct("Mause Inc.").linkDistributor("https://youtu.be/d5NEeeju30Y?si=AwapttS0CqdBNB-N").priceProduct(49990).descriptionProduct("Con sensor de alta precisión y botones personalizables, este mouse es ideal para gamers que buscan control y rendimiento.").categoryProduct("mouse").urlImage("https://media.spdigital.cl/thumbnails/products/mqe4fakp_585eaaaa_thumbnail_512.jpg").stockProduct(10).build(),
                Product.builder().nameProduct("Razer Goliathus Extended Chroma").distributorProduct("Mousepad Inc.").linkDistributor("https://youtu.be/d5NEeeju30Y?si=AwapttS0CqdBNB-N").priceProduct(29990).descriptionProduct("Mousepad extendido con iluminación RGB Chroma. Textura ideal para todo tipo de sensores y estilos de juego.").categoryProduct("mouse").urlImage("https://vision-techno.com/assets/images/columnsblocks/product128/93796.jpg").stockProduct(10).build(),
                Product.builder().nameProduct("Balatro Jimbo Plush").distributorProduct("LocalThunk").linkDistributor("https://youtu.be/d5NEeeju30Y?si=AwapttS0CqdBNB-N").priceProduct(19990).descriptionProduct("El Balatro Jimbo más adorable para tus estanterías gamer.").categoryProduct("plush").urlImage("https://balatroplushies.com/wp-content/uploads/2025/06/Balatro-Plush-Merch.png").stockProduct(10).build(),
                Product.builder().nameProduct("HyperX Cloud II").distributorProduct("HyperX").linkDistributor("https://example.com/hyperx").priceProduct(79990).descriptionProduct("Auriculares con sonido envolvente 7.1 y micrófono desmontable.").categoryProduct("accessory").urlImage("https://media.spdigital.cl/thumbnails/products/1745962602770-t5_88a79dff_thumbnail_512.png").stockProduct(10).build(),
                Product.builder().nameProduct("MSI Katana 15").distributorProduct("MSI").linkDistributor("https://example.com/msi").priceProduct(1249990).descriptionProduct("Laptop gamer con procesador i7 y RTX 4060 para un rendimiento superior.").categoryProduct("pc").urlImage("https://media.solotodo.com/media/products/1741642_picture_1679639223.png").stockProduct(10).build(),
                Product.builder().nameProduct("Factorio").distributorProduct("Wube Software").linkDistributor("https://www.factorio.com/game/about").priceProduct(18000).descriptionProduct("Factorio es un juego que trata sobre construir y crear fábricas automatizadas").categoryProduct("digitalgame").urlImage("https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/427520/header.jpg?t=1763986204").stockProduct(10).build(),
                Product.builder().nameProduct("Factorio Space Age").distributorProduct("Wube Software").linkDistributor("https://www.factorio.com/game/about").priceProduct(18000).descriptionProduct("Factorio: Space Age continúa la aventura del jugador tras lanzar cohetes al espacio.").categoryProduct("digitalgame").urlImage("https://cdn.factorio.com/assets/img/blog/fff-418-space-age-cover.png").stockProduct(10).build(),
                Product.builder().nameProduct("Clair Obscur: Expedition 33").distributorProduct("Sandfall Interactive").linkDistributor("https://www.sandfall.co/").priceProduct(33000).descriptionProduct("Lidera a los miembros de la Expedición 33 en su misión para destruir a la Pintora para que nunca más pueda pintar la muerte.").categoryProduct("digitalgame").urlImage("https://image.api.playstation.com/vulcan/ap/rnd/202501/2217/15dd9f9368aa87c9b2dcaf58e1856e8cca01b6e595331858.jpg").stockProduct(10).build(),
                Product.builder().nameProduct("Puyo Puyo™ Tetris® 2").distributorProduct("SEGA").linkDistributor("https://example.com/SEGA").priceProduct(33000).descriptionProduct("La querida serie de juegos de rompecabezas de Japón Puyo Puyo y la franquicia de juegos Tetris® de renombre mundial se han unido nuevamente.").categoryProduct("digitalgame").urlImage("https://assets.nintendo.com/image/upload/c_fill,w_1200/q_auto:best/f_auto/dpr_2.0/store/software/switch/70010000029372/958722fbfe647204319c90eefed47f2d482f845814703b8d031deec0ced3efcb").stockProduct(10).build(),
                Product.builder().nameProduct("OMORI").distributorProduct("OMOCAT").linkDistributor("https://example.com/OMOCAT").priceProduct(7700).descriptionProduct("Explora un mundo extraño lleno de amigos y enemigos peculiares.").categoryProduct("digitalgame").urlImage("https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1150690/capsule_616x353.jpg?t=1671584768").stockProduct(10).build(),
                Product.builder().nameProduct("Silksong Hornet plush").distributorProduct("Team Cherry").linkDistributor("https://example.com/teamcherry").priceProduct(20000).descriptionProduct("Es el hornet peluche con zapatos.").categoryProduct("plush").urlImage("https://www.reddit.com/media?url=https%3A%2F%2Fpreview.redd.it%2Fi-really-love-these-images-of-plushies-in-big-shoes-i-was-v0-gc1e0aizwytc1.jpg%3Fwidth%3D640%26crop%3Dsmart%26auto%3Dwebp%26s%3D6f9e546806edc700b1579b96e81b9271e023f4b2").stockProduct(10).build(),
                Product.builder().nameProduct("Polera Mewing").distributorProduct("Mewing.INC").linkDistributor("https://example.com/mewing").priceProduct(9999).descriptionProduct("La polera del mewing.").categoryProduct("clothes").urlImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThv4NLatpRauFR9wjutLUaf3-_6Sb5Dtmuow&s").stockProduct(10).build(),
                Product.builder().nameProduct("Polera Factorio").distributorProduct("Wube Software").linkDistributor("https://www.factorio.com").priceProduct(15000).descriptionProduct("La polera de factorio").categoryProduct("clothes").urlImage("https://images.teepublic.com/derived/production/designs/65589265_0/1725595993/i_m:bi_production_blanks_mtl53ofohwq5goqjo9ke_1462829015,c_0_0_470x,s_313,q_90.jpg").stockProduct(10).build(),
                Product.builder().nameProduct("Peluche zeraora XL").distributorProduct("meow inc").linkDistributor("https://example.com/meowing").priceProduct(3000000).descriptionProduct("Es el zera peluche").categoryProduct("plush").urlImage("https://pbs.twimg.com/media/FHyWkwOX0AswpCR.jpg:large").stockProduct(10).build(),
                Product.builder().nameProduct("Xbox 720").distributorProduct("Microsoft 2").linkDistributor("https://example.com/microsoft_2").priceProduct(9999999).descriptionProduct("La legendaria consola sucesora de la Xbox 360").categoryProduct("console").urlImage("https://www.reddit.com/media?url=https%3A%2F%2Fi.redd.it%2Fbar2zg0yw34c1.jpg").stockProduct(10).build(),
                Product.builder().nameProduct("Zeebo").distributorProduct("brasil").linkDistributor("https://example.com/microsoft_2").priceProduct(100000).descriptionProduct("Esta consola nacio muerta").categoryProduct("console").urlImage("https://i.blogs.es/9170c0/zeebo-2/1366_2000.jpeg").stockProduct(10).build()
        );

        productRepository.saveAll(products);

        User user1 = User.builder().username("username").password(passwordEncoder.encode("password")).role("USER").build();

        userRepository.save(user1);
        System.out.println("Data loaded.");
    }
}
