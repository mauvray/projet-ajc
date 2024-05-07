package grp1.malveillancemax.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

//import grp1.malveillancemax.dto.requests.AlcoolFortRequest;
import grp1.malveillancemax.dto.requests.CocktailRequest;
//import grp1.malveillancemax.dto.responses.AlcoolFortResponse;
import grp1.malveillancemax.dto.responses.CocktailResponse;
import grp1.malveillancemax.dto.responses.JsonViews;
//import grp1.malveillancemax.entities.AlcoolFort;
import grp1.malveillancemax.entities.Cocktail;
import grp1.malveillancemax.services.AlcoolFortService;
import grp1.malveillancemax.services.CocktailService;
import grp1.malveillancemax.services.SoftService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cocktail")
public class CocktailRestController {

    private Logger logger=LoggerFactory.getLogger(CocktailRestController.class);

    @Autowired
    public CocktailService cocktSvc;
    @Autowired
    public AlcoolFortService alcSvc;
    @Autowired
    public SoftService softSvc;

    @GetMapping("")
    @JsonView(JsonViews.Cocktail.class)
    public List<CocktailResponse> getAll(){
        return cocktSvc.getAll().stream()
        .map(cockt-> new CocktailResponse(cockt)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Cocktail.class)
    public CocktailResponse getById(@PathVariable Long id){
        return new CocktailResponse(cocktSvc.getById(id));
    }

    @PostMapping("")
    @JsonView(JsonViews.Cocktail.class)
    @ResponseStatus(code=HttpStatus.CREATED)
    public CocktailResponse create(@Valid @RequestBody CocktailRequest cocktReq, BindingResult br){
        if (br.hasErrors()){
            logger.info("erreur validation");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Cocktail cockt = new Cocktail();
        BeanUtils.copyProperties(cocktReq, cockt);
        if (cocktReq.getAlcoolId()==null && cocktReq.getSoftId()==null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (cocktReq.getAlcoolId()!=null) {
            cocktSvc.ajouterAlcool(alcSvc.getById(cocktReq.getAlcoolId()), cockt);
        }
        if (cocktReq.getSoftId() != null){
            cocktSvc.ajouterSoft(softSvc.getById(cocktReq.getSoftId()), cockt);
        }
       
        return new CocktailResponse(cocktSvc.creationCocktail(cockt));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        cocktSvc.deleteById(id);
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Cocktail.class)
    public CocktailResponse update(@PathVariable Long id, @RequestBody CocktailRequest cocktReq){
        Cocktail cockt = new Cocktail();
        BeanUtils.copyProperties(cocktReq, cockt);
        cockt.setId(id);
        return new CocktailResponse(cocktSvc.update(cockt));
    }

    @GetMapping("/{id}/alcools")
    @JsonView(JsonViews.CocktailAvecAlcool.class)
    public CocktailResponse getByIdWithAlcools(@PathVariable Long id){
        return new CocktailResponse(cocktSvc.getByIdWithAlcools(id), true, false);
    }

    @GetMapping("/{id}/softs")
    @JsonView(JsonViews.CocktailAvecSoft.class)
    public CocktailResponse getByIdWithSofts(@PathVariable Long id) {
        return new CocktailResponse(cocktSvc.getByIdWithSofts(id), false, true );
    }
        
}
