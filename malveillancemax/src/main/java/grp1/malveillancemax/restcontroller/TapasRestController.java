package grp1.malveillancemax.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import grp1.malveillancemax.entities.Tapas;
import grp1.malveillancemax.dto.responses.JsonViews;
import grp1.malveillancemax.services.TapasService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tapas")
//@CrossOrigin(origins = "http://localhost:4200")
public class TapasRestController {

    @Autowired
	private TapasService tapasSrv;

    @GetMapping("")
	@JsonView(JsonViews.Tapas.class)
	public List<Tapas> getAll() {
		return tapasSrv.getAll();
	}

    @GetMapping("/{id}")
	@JsonView(JsonViews.Tapas.class)
	public Tapas getById(@PathVariable("id") Long id) {
		return tapasSrv.getById(id);
	}

    @GetMapping("/nom/{nom}")
	@JsonView(JsonViews.Tapas.class)
	public List<Tapas> getByNom(@PathVariable String nom) {
		return tapasSrv.getByNom(nom);
	}

    @PostMapping({ "", "/inscription" })
	@JsonView(JsonViews.Tapas.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tapas create(@Valid @RequestBody Tapas tapas, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return tapasSrv.create(tapas);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Tapas.class)
	public Tapas update(@Valid @RequestBody Tapas tapas, BindingResult br, @PathVariable Long id) {
		tapas.setId(id);
		return tapasSrv.update(tapas);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		tapasSrv.delete(id);
	}
}
