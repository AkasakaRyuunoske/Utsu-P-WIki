package UtsuPWiki.Controller;

import UtsuPWiki.Entity.Products;
import UtsuPWiki.Repository.ProductsRepository;
import UtsuPWiki.utilities.Navigation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Log4j2
@Controller
public class VocaloidAlbumsController {
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/authors/{author}/albums")
    public String albumsGETController(Model model, @PathVariable String author, HttpServletRequest request){
        Navigation.addLocations(model, request);

        String resultPage = "Authors/" + author + "/" + author + "Albums"; // here is defined page to be returned
        model.addAttribute("currentPage","/authors/{" + author + "}/albums");

        return resultPage;
    }

    @GetMapping("/authors/{author}/albums/{album}")
    public String albumGETController(Model model, @PathVariable String author, @PathVariable String album, HttpServletRequest request){
        //Todo Change order to go by one full column to another full column
        //Todo Add numbers
        //Todo Add "THE GREATEST INDIE VOCALOID" etc...
        //TODO Add ChatGPT-3 Interpretations for EACH song
        //Todo help yo self
        Navigation.addLocations(model, request);

        String albumAndAuthor = author + " - " + album;

        Products product = productsRepository.selectProductByProductName(albumAndAuthor);

        // Adding every thing to the model:
        model.addAttribute("product_name"      , product.getProductName());
        model.addAttribute("product_image"     , product.getProductImage());
        model.addAttribute("product_cost"      , product.getCost());
        model.addAttribute("product_date_out"  , product.getDateOut());
        model.addAttribute("product_product_id", product.getId());
        model.addAttribute("track_list", productsRepository.selectTrackListByAlbumId(product.getId()));

        log.info("Info on selected product: " + product.getProductName() + " " + product.getId());
        log.info("Track list of selected album: " + Arrays.toString(productsRepository.selectTrackListByAlbumId(product.getId())));
        model.addAttribute("album_and_author", albumAndAuthor);

        String resultPage = "Authors" + "/" + author + "/" + "Albums" + "/album.html"; // here is defined page to be returned
        model.addAttribute("currentPage","/authors/{" + author + "}/albums/{" + album + "}");

        return resultPage;
    }
}
