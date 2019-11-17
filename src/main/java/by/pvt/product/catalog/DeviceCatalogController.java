package by.pvt.product.catalog;

import by.pvt.pojo.Device;
import by.pvt.service.DeviceCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



import java.util.logging.Logger;

@Controller
@RequestMapping("/product-catalog")
public class DeviceCatalogController {
    private static Logger log = Logger.getLogger(DeviceCatalogController.class.getName());

    @Autowired
    private
    DeviceCatalogService deviceCatalogService;

    @GetMapping()
    public String showCatalog(Model model) {
        log.info("Calling showCatalog");
        model.addAttribute("catalog", deviceCatalogService.getFirstTopTenProducts());
        return "productCatalog";
    }

    @GetMapping("/item/{deviceId}")
    public String showCatalogItem(@PathVariable Long id, Model model) {
        log.info("Call showCatalogItem");
        Device item = deviceCatalogService.findItem(id);
        model.addAttribute("item", item);
        return "productCatalogItem";
    }
}
