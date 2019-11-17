package by.pvt.product.add;

import by.pvt.pojo.Device;
import by.pvt.service.DeviceCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping("/add-product")
public class AddDeviceController {
    private static Logger log = Logger.getLogger("AddProductController");

    @Autowired
    DeviceCatalogService deviceCatalogService;

    @Autowired
    DeviceValidator validator;

    @GetMapping
    public ModelAndView showAddProductView() {
        ModelAndView view = new ModelAndView();
        view.setViewName("addProduct");
        return view;
    }

    @PostMapping
    public String submitAddProductForm(
            @ModelAttribute Device item,
            @RequestParam("file") MultipartFile file,
            BindingResult result, Model model
    ) throws IOException {
        validator.validate(item, result);
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            result.getAllErrors().forEach(objectError -> log.info(objectError.getDefaultMessage()));
            return "addProduct";
        }

        log.info("Call submitAddProductForm: " + item);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("Username=" + user.getUsername());

        log.info("File: " + file);
        item.setProductImage(file.getBytes());

        if (!deviceCatalogService.addItem(item)) {
            return "addProductError";
        }
        return "addProductOk";
    }

}


