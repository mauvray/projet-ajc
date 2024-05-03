package grp1.malveillancemax.restController;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.stream.Collectors;

import grp1.malveillancemax.services.BiereService;
import grp1.malveillancemax.entities.Biere;
import grp1.malveillancemax.dto.responses.BiereResponse;
import grp1.malveillancemax.dto.requests.BiereRequest;
import org.springframework.beans.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
/**
 * BiereRestController
 */
@RestController
@RequestMapping("/biere")
public class BiereRestController {

    private Logger logger=LoggerFactory.getLogger(BiereRestController.class);
    @Autowired
    public BiereService biereSrv;

    @GetMapping("")
    public List<BiereResponse> getAll(){
        return biereSrv.getAllBiere().stream().map(b -> new BiereResponse(b)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BiereResponse getById(@PathVariable Long id){
        return new BiereResponse(biereSrv.getById(id));
    }

    @GetMapping("/style/{style}")
    public List<BiereResponse> getAllByStyle(@PathVariable String style){
       return biereSrv.getByStyle(style).stream().map(b -> new BiereResponse(b)).collect(Collectors.toList());

    }
    

    @PostMapping("")
    @ResponseStatus(code=HttpStatus.CREATED)
    public BiereResponse create(@Valid @RequestBody BiereRequest biereRequest, BindingResult br){
        if (br.hasErrors()){
            logger.info("erreur validation");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Biere b = new Biere();
        BeanUtils.copyProperties(biereRequest,b);
        return new BiereResponse(biereSrv.createBiere(b));
    }

    @PutMapping("/{id}")
    public BiereResponse update(@PathVariable Long id, @RequestBody BiereRequest biereRequest){
        Biere biere = new Biere();
        BeanUtils.copyProperties(biereRequest, biere);
        biere.setId(id);
        return new BiereResponse(biereSrv.updateBiere(biere));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        biereSrv.deleteBiere(id);
    }

 
        



    
}