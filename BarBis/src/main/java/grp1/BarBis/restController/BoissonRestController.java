package grp1.BarBis.restController;

import java.util.List;
import java.util.stream.Collectors;

//import org.hibernate.validator.internal.util.logging.LoggerFactory;
//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
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

import grp1.BarBis.dto.request.BoissonRequest;
import grp1.BarBis.dto.response.BoissonResponse;
import grp1.BarBis.dto.response.JsonViews;
import grp1.BarBis.entities.Boisson;
import grp1.BarBis.services.BoissonService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/boisson")
public class BoissonRestController {

   // private Logger logger=LoggerFactory.getLogger(BoissonRestController.class);

    @Autowired
    private BoissonService boissonSrv;

    @GetMapping("")
    @JsonView(JsonViews.Basic.class)
    public List<BoissonResponse> getAll(){
        return boissonSrv.getAll().stream().map(b -> new BoissonResponse(b)).collect(Collectors.toList());
    }


    @GetMapping("/categorie/{categorie}")
    @JsonView(JsonViews.Basic.class)
    public List<BoissonResponse> getCategorie(@PathVariable String categorie){
        return boissonSrv.getByCategorie(categorie).stream().map(b -> new BoissonResponse(b)).collect(Collectors.toList());
    }


    @GetMapping("/cocktail/alcool/{id}")
    @JsonView(JsonViews.Basic.class)
    public List<BoissonResponse> getCocktailByAlcool(@PathVariable Long id){
        Boisson alcool = boissonSrv.getById(id);
        return boissonSrv.getByAlcool(alcool).stream().map(b -> new BoissonResponse(b)).collect(Collectors.toList());
    }

    @GetMapping("/cocktail/soft/{id}")
    @JsonView(JsonViews.Basic.class)
    public List<BoissonResponse> getCocktailBySoft(@PathVariable Long id){
        Boisson soft = boissonSrv.getById(id);
        return boissonSrv.getBySoft(soft).stream().map(b -> new BoissonResponse(b)).collect(Collectors.toList());
    }

   

    @GetMapping("/nom/{nom}")
    @JsonView(JsonViews.Basic.class)
    public List<BoissonResponse> getByNom(@PathVariable String nom){
        return boissonSrv.getByNom(nom).stream().map(b -> new BoissonResponse(b)).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    @JsonView(JsonViews.Basic.class)
    public BoissonResponse getByIdBoisson(@PathVariable Long id){
        return new BoissonResponse(boissonSrv.getById(id));
    }

    @PostMapping("")
    @JsonView(JsonViews.Basic.class)
    public BoissonResponse create(@Valid @RequestBody BoissonRequest boissonRequest, BindingResult br){
        if(br.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Boisson b = new Boisson();
        BeanUtils.copyProperties(boissonRequest, b);
        if(boissonRequest.getAlcoolId()!=null){
            b.setAlcool(boissonSrv.getById(boissonRequest.getAlcoolId()));
        }
        if(boissonRequest.getSoftId()!=null){
         b.setSoft(boissonSrv.getById(boissonRequest.getSoftId()));
        }
        return new BoissonResponse(boissonSrv.creationBoisson(b));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        boissonSrv.deleteBoisson(id);
    }

    @PutMapping("/{id}")
    public BoissonResponse update(@PathVariable Long id, @RequestBody BoissonRequest boissonRequest){
        Boisson b = new Boisson();
        BeanUtils.copyProperties(boissonRequest, b);
        b.setId(id);
        return new BoissonResponse(boissonSrv.update(b));
    }

}
