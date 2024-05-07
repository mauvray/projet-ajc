package grp1.malveillancemax.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import grp1.malveillancemax.services.CidreService;
import grp1.malveillancemax.dto.responses.CidreResponse;
import grp1.malveillancemax.dto.requests.CidreRequest;
import grp1.malveillancemax.entities.Cidre;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;



// CidreRestController

@RestController
@RequestMapping("/cidre")
public class CidreRestController {

    private Logger logger = LoggerFactory.getLogger(CidreRestController.class);
    @Autowired
    public CidreService cidreSrv;

    @GetMapping("")
    public List<CidreResponse> getAll(){
        return cidreSrv.getAllCidre().stream().map(b -> new CidreResponse(b)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CidreResponse getById(@PathVariable Long id){
        return new CidreResponse(cidreSrv.getByID(id));
    }

    @GetMapping("/provenance/{provenance}")
    public List<CidreResponse> getAllByProvenance(@PathVariable String provenance){
      return cidreSrv.getByProvenance(provenance).stream().map(c -> new CidreResponse(c)).collect(Collectors.toList());
    }

    @PostMapping("")
    @ResponseStatus(code=HttpStatus.CREATED)
    public CidreResponse create(@Valid @RequestBody CidreRequest cidreRequest, BindingResult br){
        if (br.hasErrors()){
          logger.info("erreur validation");
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Cidre c = new Cidre();
        BeanUtils.copyProperties(cidreRequest, c);
        return new CidreResponse(cidreSrv.createCidre(c));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        cidreSrv.deleteCidre(id);
    }

    @PutMapping("/{id}")
    public CidreResponse update(@PathVariable Long id, @RequestBody CidreRequest cidreRequest){
      Cidre cidre = new Cidre();
      BeanUtils.copyProperties(cidreRequest, cidre);
      cidre.setId(id);
      return new CidreResponse(cidreSrv.updateCidre(cidre));
    }


  
}
    
