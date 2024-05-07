package grp1.malveillancemax.restcontroller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.stream.Collectors;
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

import grp1.malveillancemax.entities.Vin;
import grp1.malveillancemax.dto.requests.VinRequest;
import grp1.malveillancemax.dto.responses.JsonViews;
import grp1.malveillancemax.dto.responses.VinResponse;
import grp1.malveillancemax.services.VinService;


/**
 * VinRestController
 */
@RestController
@RequestMapping("/vin")
public class VinRestController {

    private Logger logger=LoggerFactory.getLogger(VinRestController.class);
    @Autowired
    public VinService vinSrv;

    @GetMapping("")
    public List<VinResponse> getAll(){
        return vinSrv.getAllVin().stream().map(v -> new VinResponse(v)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VinResponse getById(@PathVariable Long id){
        return new VinResponse(vinSrv.getById(id));
    }

    @GetMapping("/couleur/{couleur}")
    public List<VinResponse> getAllByCouleur(@PathVariable String couleur){
        return vinSrv.getByCouleur(couleur).stream().map(v -> new VinResponse(v)).collect(Collectors.toList());
    }

    @GetMapping("provenance/{provenance}")
     public List<VinResponse> getAllByProvenance(@PathVariable String provenance){
        return vinSrv.getByCouleur(provenance).stream().map(v -> new VinResponse(v)).collect(Collectors.toList());
    }

    @PostMapping("")
    @ResponseStatus(code=HttpStatus.CREATED)
    @JsonView(JsonViews.Generic.class)
    public VinResponse create(@Valid @RequestBody VinRequest vinRequest, BindingResult br){
        if (br.hasErrors()){
            logger.info("erreur validation");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Vin v = new Vin();
        BeanUtils.copyProperties(vinRequest, v);
        return new VinResponse(vinSrv.createVin(v));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        vinSrv.deleteVin(id);
    }

    @PutMapping("/{id}")
    public VinResponse update(@PathVariable Long id, @RequestBody VinRequest vinRequest){
        Vin vin = new Vin();
        BeanUtils.copyProperties(vinRequest, vin);
        vin.setId(id);
        return new VinResponse(vinSrv.updateVin(vin));
    }



    
}