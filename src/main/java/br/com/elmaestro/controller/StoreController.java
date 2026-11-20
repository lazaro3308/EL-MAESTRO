package br.com.elmaestro.controller;
import br.com.elmaestro.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class StoreController {
 private final ProductRepository products;
 public StoreController(ProductRepository products){this.products=products;}
 @GetMapping("/") public String home(Model model){
  model.addAttribute("products",products.findByActiveTrueAndCategoryOrderByNameAsc("MASCULINO"));
  return "index";
 }
 @GetMapping("/perfumes/{slug}") public String product(@PathVariable String slug,Model model){
  var product=products.findBySlugAndActiveTrue(slug).orElseThrow(()->new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND));
  model.addAttribute("product",product);return "product";
 }
 @GetMapping("/entrar") public String login(){return "login";}
 @GetMapping("/cadastro") public String register(){return "register";}
 @GetMapping("/carrinho") public String cart(){return "cart";}
 @GetMapping("/checkout") public String checkout(){return "checkout";}
}