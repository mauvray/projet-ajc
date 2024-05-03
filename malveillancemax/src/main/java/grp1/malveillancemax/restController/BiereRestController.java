package grp1.malveillancemax.restController;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.stream.Collectors;

import grp1.malveillancemax.services.BiereService;
import grp1.malveillancemax.entities.Biere;
import grp1.malveillancemax.dto.responses.BiereResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
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




    
}