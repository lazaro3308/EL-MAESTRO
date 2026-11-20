package br.com.elmaestro.controller;
import br.com.elmaestro.model.Product;
import br.com.elmaestro.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.math.BigDecimal;
@Controller @RequestMapping("/admin")
public class AdminController {
 private final ProductRepository products;
 public AdminController(ProductRepository p){products=p;}
 @GetMapping public String dashboard(Model model){model.addAttribute("products",products.findAll());return "admin";}
 @PostMapping("/produto") public String save(@RequestParam(required=false) Long id,@RequestParam String name,@RequestParam String slug,@RequestParam String family,@RequestParam String concentration,@RequestParam String description,@RequestParam String notes,@RequestParam BigDecimal price,@RequestParam int stock,RedirectAttributes flash){
  if(price.signum()<0||stock<0){flash.addFlashAttribute("error","Preço e estoque não podem ser negativos.");return "redirect:/admin";}
  Product p=id==null?new Product():products.findById(id).orElseThrow();p.setName(name.trim());p.setSlug(slug.trim().toLowerCase().replaceAll("[^a-z0-9-]","-"));p.setFamily(family);p.setConcentration(concentration);p.setDescription(description);p.setNotes(notes);p.setPrice(price);p.setStock(stock);p.setCategory("MASCULINO");p.setActive(true);products.save(p);return "redirect:/admin";
 }
 @PostMapping("/produto/{id}/excluir") public String delete(@PathVariable Long id){products.deleteById(id);return "redirect:/admin";}
}