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
public class DataLoader implements CommandLineRunner, LinkImages {

    private final String[] linkImages = {};

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        List<Product> products = Arrays.asList(
                Product.builder().nameProduct("Audifonos muy gamer").distributorProduct("Gaymer").linkDistributor("www.example/gaymer.com").priceProduct(10000).descriptionProduct("Audifonos epicamente gaymer para todos los gays").categoryProduct("gaymer").urlImage(LinkImages.AUDIFONOS_GAMER).stockProduct(20).build(),
                Product.builder().nameProduct("Camara 8k 360fps").distributorProduct("Gaymer").linkDistributor("www.example/gaymer.com").priceProduct(10000).descriptionProduct("Camara para grabar tus plays de lol y subirlas al titok").categoryProduct("gaymer").urlImage(LinkImages.CAMARA_GAMER).stockProduct(20).build(),
                Product.builder().nameProduct("Kit para Osu!").distributorProduct("Gaymer").linkDistributor("www.example/gaymer.com").priceProduct(10000).descriptionProduct("Jugador de osu! promedio").categoryProduct("gaymer").urlImage(LinkImages.KIT_GAMER).stockProduct(20).build(),
                Product.builder().nameProduct("Lampara RGB").distributorProduct("Gaymer").linkDistributor("www.example/gaymer.com").priceProduct(10000).descriptionProduct("Lampara para hacer convulsionar a tu amigo epileptico").categoryProduct("gaymer").urlImage(LinkImages.LAMPARA_GAMER).stockProduct(20).build(),
                Product.builder().nameProduct("Microfono con supresion").distributorProduct("Gaymer").linkDistributor("www.example/gaymer.com").priceProduct(10000).descriptionProduct("Para que escuchen hasta tus respiraciones").categoryProduct("gaymer").urlImage(LinkImages.MICROFONO_GAMER).stockProduct(20).build(),
                Product.builder().nameProduct("Mousepad con extra mouse").distributorProduct("Gaymer").linkDistributor("www.example/gaymer.com").priceProduct(10000).descriptionProduct("Mouse al cuadrado").categoryProduct("gaymer").urlImage(LinkImages.MOUSEPAD).stockProduct(20).build(),
                Product.builder().nameProduct("Silla extra comoda").distributorProduct("Gaymer").linkDistributor("www.example/gaymer.com").priceProduct(10000).descriptionProduct("El seba se sienta y pasa a mejor vida").categoryProduct("gaymer").urlImage(LinkImages.SILLA_GAMER).stockProduct(20).build(),
                Product.builder().nameProduct("Teclado de membrana").distributorProduct("Gaymer").linkDistributor("www.example/gaymer.com").priceProduct(10000).descriptionProduct("Para escribir en silencio").categoryProduct("gaymer").urlImage(LinkImages.TECLADO_GAMER).stockProduct(20).build(),

                Product.builder().nameProduct("Catan").distributorProduct("Catan Inc.").linkDistributor("https://youtu.be/J8SBp4SyvLc?si=3Y4W4pOTVIH4Urgu").priceProduct(29990).descriptionProduct("Un clásico juego de estrategia donde los jugadores compiten por colonizar y expandirse en la isla de Catan. Ideal para 3-4 jugadores.").categoryProduct("tablegame").urlImage(LinkImages.CATAN_GAME).stockProduct(10).build(),
                Product.builder().nameProduct("Secretlab Titan").distributorProduct("Silla Inc.").linkDistributor("https://youtu.be/d5NEeeju30Y?si=AwapttS0CqdBNB-N").priceProduct(249990).descriptionProduct("Diseñada para el máximo confort, esta silla ofrece soporte ergonómico y personalización ajustable para sesiones de juego prolongadas.").categoryProduct("chair").urlImage(LinkImages.CHAIR_IMAGE).stockProduct(10).build(),
                Product.builder().nameProduct("Logitech G502 HERO").distributorProduct("Mause Inc.").linkDistributor("https://youtu.be/d5NEeeju30Y?si=AwapttS0CqdBNB-N").priceProduct(49990).descriptionProduct("Con sensor de alta precisión y botones personalizables, este mouse es ideal para gamers que buscan control y rendimiento.").categoryProduct("mouse").urlImage(LinkImages.MOUSE_IMAGE).stockProduct(10).build(),
                Product.builder().nameProduct("Razer Goliathus Extended Chroma").distributorProduct("Mousepad Inc.").linkDistributor("https://youtu.be/d5NEeeju30Y?si=AwapttS0CqdBNB-N").priceProduct(29990).descriptionProduct("Mousepad extendido con iluminación RGB Chroma. Textura ideal para todo tipo de sensores y estilos de juego.").categoryProduct("mouse").urlImage(LinkImages.MOUSEPAD_IMAGE).stockProduct(10).build(),
                Product.builder().nameProduct("Balatro Jimbo Plush").distributorProduct("LocalThunk").linkDistributor("https://youtu.be/d5NEeeju30Y?si=AwapttS0CqdBNB-N").priceProduct(19990).descriptionProduct("El Balatro Jimbo más adorable para tus estanterías gamer.").categoryProduct("plush").urlImage(LinkImages.BALATRO_PLUSH).stockProduct(10).build(),
                Product.builder().nameProduct("HyperX Cloud II").distributorProduct("HyperX").linkDistributor("https://example.com/hyperx").priceProduct(79990).descriptionProduct("Auriculares con sonido envolvente 7.1 y micrófono desmontable.").categoryProduct("accessory").urlImage(LinkImages.HEADPHONES_IMAGE).stockProduct(10).build(),
                Product.builder().nameProduct("MSI Katana 15").distributorProduct("MSI").linkDistributor("https://example.com/msi").priceProduct(1249990).descriptionProduct("Laptop gamer con procesador i7 y RTX 4060 para un rendimiento superior.").categoryProduct("pc").urlImage(LinkImages.LAPTOP_IMAGE).stockProduct(10).build(),
                Product.builder().nameProduct("Factorio").distributorProduct("Wube Software").linkDistributor("https://www.factorio.com/game/about").priceProduct(18000).descriptionProduct("Factorio es un juego que trata sobre construir y crear fábricas automatizadas").categoryProduct("digitalgame").urlImage(LinkImages.FACTORIO_GAME).stockProduct(10).build(),
                Product.builder().nameProduct("Factorio Space Age").distributorProduct("Wube Software").linkDistributor("https://www.factorio.com/game/about").priceProduct(18000).descriptionProduct("Factorio: Space Age continúa la aventura del jugador tras lanzar cohetes al espacio.").categoryProduct("digitalgame").urlImage(LinkImages.FACTORIO_SPACE_AGE).stockProduct(10).build(),
                Product.builder().nameProduct("Clair Obscur: Expedition 33").distributorProduct("Sandfall Interactive").linkDistributor("https://www.sandfall.co/").priceProduct(33000).descriptionProduct("Lidera a los miembros de la Expedición 33 en su misión para destruir a la Pintora para que nunca más pueda pintar la muerte.").categoryProduct("digitalgame").urlImage(LinkImages.EXPEDITION_33).stockProduct(10).build(),
                Product.builder().nameProduct("Puyo Puyo™ Tetris® 2").distributorProduct("SEGA").linkDistributor("https://example.com/SEGA").priceProduct(33000).descriptionProduct("La querida serie de juegos de rompecabezas de Japón Puyo Puyo y la franquicia de juegos Tetris® de renombre mundial se han unido nuevamente.").categoryProduct("digitalgame").urlImage(LinkImages.PUYO_PUYO_TETRIS_2_GAME).stockProduct(10).build(),
                Product.builder().nameProduct("OMORI").distributorProduct("OMOCAT").linkDistributor("https://example.com/OMOCAT").priceProduct(7700).descriptionProduct("Explora un mundo extraño lleno de amigos y enemigos peculiares.").categoryProduct("digitalgame").urlImage(LinkImages.OMORI_GAME).stockProduct(10).build(),
                Product.builder().nameProduct("Silksong Hornet plush").distributorProduct("Team Cherry").linkDistributor("https://example.com/teamcherry").priceProduct(20000).descriptionProduct("Es el hornet peluche con zapatos.").categoryProduct("plush").urlImage(LinkImages.SILSON_IMAGE).stockProduct(10).build(),
                Product.builder().nameProduct("Polera Mewing").distributorProduct("Mewing.INC").linkDistributor("https://example.com/mewing").priceProduct(9999).descriptionProduct("La polera del mewing.").categoryProduct("clothes").urlImage(LinkImages.MEWING_CAT_TSHIRT).stockProduct(10).build(),
                Product.builder().nameProduct("Polera Factorio").distributorProduct("Wube Software").linkDistributor("https://www.factorio.com").priceProduct(15000).descriptionProduct("La polera de factorio").categoryProduct("clothes").urlImage(LinkImages.FACTORIO_TSHIRT).stockProduct(10).build(),
                Product.builder().nameProduct("Peluche zeraora XL").distributorProduct("meow inc").linkDistributor("https://example.com/meowing").priceProduct(3000000).descriptionProduct("Es el zera peluche").categoryProduct("plush").urlImage(LinkImages.ZERAORA_PLUSH).stockProduct(10).build(),
                Product.builder().nameProduct("Xbox 720").distributorProduct("Microsoft 2").linkDistributor("https://example.com/microsoft_2").priceProduct(9999999).descriptionProduct("La legendaria consola sucesora de la Xbox 360").categoryProduct("console").urlImage(LinkImages.XBOX_720).stockProduct(10).build(),
                Product.builder().nameProduct("Zeebo").distributorProduct("brasil").linkDistributor("https://example.com/microsoft_2").priceProduct(100000).descriptionProduct("Esta consola nacio muerta").categoryProduct("console").urlImage(LinkImages.ZEEBO).stockProduct(10).build()


        );

        productRepository.saveAll(products);

        User user1 = User.builder().username("user_user")
                .password(passwordEncoder.encode("password"))
                .role("USER")
                .email("hola@gmail.com")
                .build();
        User user2 = User.builder().username("user_admin")
                .password(passwordEncoder.encode("password"))
                .role("ADMIN")
                .email("lkasdk@gmail.com")
                .build();

        userRepository.save(user1);
        userRepository.save(user2);
        System.out.println("Data loaded.");
    }
}
