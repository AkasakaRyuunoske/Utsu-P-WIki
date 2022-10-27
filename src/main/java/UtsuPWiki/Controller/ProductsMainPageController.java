package UtsuPWiki.Controller;

import UtsuPWiki.Entity.Products;
import UtsuPWiki.Repository.ProductsRepository;
import UtsuPWiki.utilities.Navigation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@Controller
public class ProductsMainPageController {
    @Autowired
    ProductsRepository productsRepository;

    @GetMapping("/buy")
    public String GETBuy(Model model, HttpServletRequest request){
        Navigation.addLocations(model, request);

        List<Products> productsList = productsRepository.findAll();
        String[] propertiesArray = productsRepository.getAllProperties();

        model.addAttribute("productsList", productsList);

        //todo get done this thing
        //model.addAttribute("propertiesArray", propertiesArray);

        return "buy";
    }
}
