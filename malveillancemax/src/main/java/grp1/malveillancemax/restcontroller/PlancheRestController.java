package grp1.malveillancemax.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.CrossOrigin;
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

// import com.fasterxml.jackson.annotation.JsonView;

import grp1.malveillancemax.entities.Planche;
// import grp1.malveillancemax.dto.responses.JsonViews;
import grp1.malveillancemax.services.PlancheService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/planche")

public class PlancheRestController {

    @Autowired
	private PlancheService plancheSrv;

    @GetMapping("")
	public List<Planche> getAll() {
		return plancheSrv.getAll();
	}

    @GetMapping("/{id}")
	public Planche getById(@PathVariable("id") Long id) {
		return plancheSrv.getById(id);
	}

    @GetMapping("/nom/{nom}")
	public List<Planche> getByNom(@PathVariable String nom) {
		return plancheSrv.getByNom(nom);
	}

    @PostMapping({ ""})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Planche create(@Valid @RequestBody Planche planche, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return plancheSrv.create(planche);
	}

	@PutMapping("/{id}")
	public Planche update(@Valid @RequestBody Planche planche, BindingResult br, @PathVariable Long id) {
		planche.setId(id);
		return plancheSrv.update(planche);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		plancheSrv.delete(id);
	}
}
