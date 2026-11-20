package br.com.elmaestro.service;
import br.com.elmaestro.model.Product;
import br.com.elmaestro.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CatalogSeeder implements CommandLineRunner {
 private final ProductRepository products;
 public CatalogSeeder(ProductRepository products){this.products=products;}
 @Override public void run(String... args){
  List<Product> initial=List.of(
   p("imperium-noir","Imperium Noir","Amadeirado","Eau de Parfum","Presença marcante com madeiras profundas e elegância noturna.","Bergamota, cedro, âmbar"),
   p("souverain","Souverain","Fougère","Eau de Parfum","Uma assinatura clássica, refinada e contemporânea.","Lavanda, gerânio, vetiver"),
   p("velvet-oud","Velvet Oud","Amadeirado Oriental","Extrait de Parfum","Oud envolvente com textura quente e sofisticada.","Açafrão, oud, baunilha"),
   p("atlas-blue","Atlas Blue","Aquático","Eau de Toilette","Frescor mineral inspirado em horizontes abertos.","Limão, notas marinhas, musk"),
   p("nocturne","Nocturne","Oriental","Eau de Parfum","Contraste elegante entre especiarias e âmbar.","Pimenta preta, cardamomo, âmbar"),
   p("royal-cedar","Royal Cedar","Amadeirado","Eau de Parfum","Cedro seco e limpo em uma composição distinta.","Mandarina, cedro, musgo"),
   p("ombre-dor","Ombre d'Or","Âmbar","Extrait de Parfum","Calor dourado com profundidade resinosa.","Canela, benjoim, tonka"),
   p("urban-legend","Urban Legend","Aromático","Eau de Toilette","Energia urbana com frescor verde e especiado.","Grapefruit, sálvia, vetiver"),
   p("black-tie","Black Tie","Amadeirado Aromático","Eau de Parfum","Elegância formal para ocasiões especiais.","Néroli, íris, patchouli"),
   p("santal-royal","Santal Royal","Amadeirado","Extrait de Parfum","Sândalo cremoso com acabamento luxuoso.","Cardamomo, sândalo, couro"),
   p("cobalt-essence","Cobalt Essence","Fresco","Eau de Toilette","Frescor vibrante com base almiscarada.","Bergamota, maçã, musk"),
   p("amber-crown","Amber Crown","Âmbar","Eau de Parfum","Âmbar luminoso e especiarias suaves.","Açafrão, âmbar, baunilha"),
   p("vetiver-absolute","Vetiver Absolute","Amadeirado","Eau de Parfum","Vetiver terroso em uma construção moderna.","Limão, vetiver, cedro"),
   p("midnight-iris","Midnight Iris","Aromático","Eau de Parfum","Íris elegante sobre madeiras escuras.","Íris, violeta, cashmeran"),
   p("ocean-crest","Ocean Crest","Aquático","Eau de Toilette","Brisa oceânica e notas cítricas luminosas.","Mandarina, sal marinho, musk"),
   p("leather-atelier","Leather Atelier","Couro","Extrait de Parfum","Acorde de couro refinado e especiarias secas.","Pimenta, couro, âmbar"),
   p("citrus-heritage","Citrus Heritage","Cítrico","Eau de Toilette","Cítricos clássicos com fundo amadeirado.","Limão siciliano, petitgrain, cedro"),
   p("smoked-vanilla","Smoked Vanilla","Oriental","Eau de Parfum","Baunilha adulta com nuances defumadas.","Pimenta rosa, baunilha, vetiver"),
   p("green-monarch","Green Monarch","Verde","Eau de Toilette","Verde aromático de personalidade fresca.","Manjericão, folhas verdes, musgo"),
   p("obsidian","Obsidian","Amadeirado Oriental","Extrait de Parfum","Composição intensa de resinas e madeiras.","Incenso, patchouli, âmbar"),
   p("silver-mountain","Silver Mountain","Fresco","Eau de Toilette","Sensação limpa e cristalina para o dia a dia.","Bergamota, chá branco, musk"),
   p("royal-spice","Royal Spice","Especiado","Eau de Parfum","Especiarias nobres sobre uma base quente.","Noz-moscada, canela, vetiver"),
   p("monaco-night","Monaco Night","Aromático","Eau de Parfum","Sofisticação descontraída para a noite.","Lavanda, grapefruit, tonka"),
   p("desert-crown","Desert Crown","Oriental","Extrait de Parfum","Acordes quentes inspirados em paisagens áridas.","Cardamomo, resinas, oud"),
   p("pure-instinct","Pure Instinct","Fougère","Eau de Toilette","Frescor limpo com assinatura confortável.","Limão, lavanda, musk"),
   p("eclipse","Eclipse","Amadeirado","Eau de Parfum","Luz e sombra em madeiras elegantes.","Pimenta preta, cipreste, âmbar"),
   p("golden-hour","Golden Hour","Cítrico Amadeirado","Eau de Toilette","Brilho cítrico com fundo macio e sofisticado.","Neroli, mandarina, sândalo"),
   p("royal-oud","Royal Oud","Amadeirado Oriental","Extrait de Parfum","Oud elegante equilibrado por notas aromáticas.","Açafrão, oud, cedro"),
   p("black-velour","Black Velour","Oriental","Eau de Parfum","Textura escura e envolvente para momentos especiais.","Pimenta, cacau, patchouli"),
   p("maestro-signature","Maestro Signature","Amadeirado Aromático","Eau de Parfum","A assinatura da casa: equilíbrio, presença e distinção.","Bergamota, lavanda, cedro")
  );
  for(Product p:initial) if(!products.existsBySlug(p.getSlug())) products.save(p);
 }
 private Product p(String slug,String name,String family,String concentration,String desc,String notes){return new Product(slug,name,family,concentration,desc,notes);}
}