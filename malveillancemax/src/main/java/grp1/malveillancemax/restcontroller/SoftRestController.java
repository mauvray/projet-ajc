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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import grp1.malveillancemax.dto.responses.JsonViews;
import grp1.malveillancemax.dto.requests.SoftRequest;
import grp1.malveillancemax.dto.responses.SoftResponse;
import grp1.malveillancemax.entities.Soft;
import grp1.malveillancemax.services.SoftService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/softs")
public class SoftRestController {
	
	private Logger logger=LoggerFactory.getLogger(SoftRestController.class);
	@Autowired
	private SoftService softService;
	
	@GetMapping
	@JsonView(JsonViews.Soft.class)
	public List<SoftResponse> getAll() {
		
		return softService.getAll()
				.stream()
				.map(soft -> new SoftResponse(soft)).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
    @JsonView(JsonViews.Soft.class)
	public SoftResponse getById(@PathVariable Long id) {
		
		Soft soft = softService.getById(id);
		
		//return new SoftResponse(soft.getId(), soft.getNom(), soft.getPrix(), soft.getCategorie());
		return new SoftResponse(softService.creaSoft(soft));
	}
	
	@PostMapping
    @JsonView(JsonViews.Soft.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public SoftResponse createSoft(@Valid @RequestBody SoftRequest request, BindingResult br) {
		
        if (br.hasErrors()) {
            logger.info("erreur validation");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

		Soft soft = new Soft();
		BeanUtils.copyProperties(request, soft);
		// return new SoftResponse(soft.getId(), soft.getNom(), soft.getPrix(), soft.getCategorie());
		return new SoftResponse(softService.creaSoft(soft));
	}
	
	@PutMapping("/{id}")
    @JsonView(JsonViews.Soft.class)
	public SoftResponse updateSoft(@PathVariable Long id, @Valid @RequestBody SoftRequest request) {
		
		Soft soft = softService.update(id, request);
		
		// return new SoftResponse(soft.getId(), soft.getNom(), soft.getPrix());
		return new SoftResponse(softService.creaSoft(soft));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteSoft(@PathVariable Long id) {
		
		softService.deleteById(id);
	}

    @GetMapping("/{id}/cocktails")
    @JsonView(JsonViews.SoftAvecCocktail.class)
    public SoftResponse getByIdWithCocktails(@PathVariable long id) {
        return new SoftResponse(softService.getByIdWithCocktails(id), true);
    }
}


