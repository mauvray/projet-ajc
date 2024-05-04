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

import grp1.malveillancemax.dto.requests.AlcoolFortRequest;
import grp1.malveillancemax.dto.responses.AlcoolFortResponse;
import grp1.malveillancemax.dto.responses.JsonViews;
import grp1.malveillancemax.entities.AlcoolFort;
import grp1.malveillancemax.services.AlcoolFortService;
import grp1.malveillancemax.services.CocktailService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alcool")
public class AlcoolFortRestController {

    private Logger logger=LoggerFactory.getLogger(AlcoolFortRestController.class);

    @Autowired
    public AlcoolFortService alcScv;
    @Autowired
    public CocktailService cockSv;

    @GetMapping("")
    @JsonView(JsonViews.Alcool.class)
    public List<AlcoolFortResponse> getAll(){
        return alcScv.getAllAlcool().stream()
        .map(al -> new AlcoolFortResponse(al)).collect(Collectors.toList());
    }

    @GetMapping("/id")
    @JsonView(JsonViews.Alcool.class)
    public AlcoolFortResponse getById(@PathVariable Long id){
        return new AlcoolFortResponse(alcScv.getById(id));
    }

    @PostMapping("")
    @JsonView(JsonViews.Alcool.class)
    @ResponseStatus(code=HttpStatus.CREATED)
    public AlcoolFortResponse create(@Valid @RequestBody AlcoolFortRequest alcReq, BindingResult br){
        if (br.hasErrors()){
            logger.info("erreur validation");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        AlcoolFort alc = new AlcoolFort();
        BeanUtils.copyProperties(alcReq, alc);
        return new AlcoolFortResponse(alcScv.creationAlcoolFort(alc));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        alcScv.deleteById(id);
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Alcool.class)
    public AlcoolFortResponse update(@PathVariable Long id, @RequestBody AlcoolFortRequest alcReq){
        AlcoolFort alc = new AlcoolFort();
        BeanUtils.copyProperties(alcReq, alc);
        alc.setId(id);
        return new AlcoolFortResponse(alcScv.update(alc));
    }

    @GetMapping("/{id}/cocktails")
    @JsonView(JsonViews.AlcoolAvecCocktail.class)
    public AlcoolFortResponse getByIdWithCocktails(@PathVariable Long id){
        return new AlcoolFortResponse(alcScv.getByIdWithCocktails(id), true);
    }

}
