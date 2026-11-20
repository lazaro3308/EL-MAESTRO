package br.com.elmaestro.controller;
import br.com.elmaestro.model.Customer;
import br.com.elmaestro.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class RegistrationController {
 private final CustomerRepository customers; private final PasswordEncoder encoder;
 public RegistrationController(CustomerRepository c,PasswordEncoder e){customers=c;encoder=e;}
 @PostMapping("/cadastro") public String register(@RequestParam String name,@RequestParam String email,@RequestParam String password,RedirectAttributes flash){
  String cleanEmail=email.trim().toLowerCase();
  if(name.isBlank()||!cleanEmail.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")||password.length()<12||password.getBytes(java.nio.charset.StandardCharsets.UTF_8).length>72||customers.existsByEmailIgnoreCase(cleanEmail)){
   flash.addFlashAttribute("error","Confira os dados. A senha precisa ter ao menos 12 caracteres e o e-mail não pode estar cadastrado.");return "redirect:/cadastro";
  }
  Customer c=new Customer();c.setName(name.trim());c.setEmail(cleanEmail);c.setPassword(encoder.encode(password));customers.save(c);
  flash.addFlashAttribute("success","Cadastro criado. Entre com seu e-mail e senha.");return "redirect:/entrar";
 }
}