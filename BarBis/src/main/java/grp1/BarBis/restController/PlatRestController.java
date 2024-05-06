package grp1.BarBis.restController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
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

import jakarta.validation.Valid;
import grp1.BarBis.dto.request.PlatRequest;
import grp1.BarBis.dto.response.PlatResponse;
import grp1.BarBis.entities.Plat;
import grp1.BarBis.services.PlatService;

@RestController
@RequestMapping("/plat")
public class PlatRestController {

    @Autowired
	private PlatService platSrv;

    @GetMapping("")
	public List<PlatResponse> getAll() {
		return platSrv.getAll().stream().map(p -> new PlatResponse(p)).collect(Collectors.toList());
	}

    @GetMapping("/{id}")
	public PlatResponse getById(@PathVariable("id") Long id) {
		return new PlatResponse(platSrv.getById(id));
	}

    @GetMapping("/nom/{nom}")
	public List<PlatResponse> getByNom(@PathVariable String nom) {
		return platSrv.getByNom(nom).stream().map(p -> new PlatResponse(p)).collect(Collectors.toList());
	}

    @GetMapping("/categorie/{categorie}")
	public List<PlatResponse> getByCategorie(@PathVariable String categorie) {
		return platSrv.getByCategorie(categorie).stream().map(p -> new PlatResponse(p)).collect(Collectors.toList());
	}

    @PostMapping({ "", "/inscription" })
	@ResponseStatus(code = HttpStatus.CREATED)
	public PlatResponse create(@Valid @RequestBody PlatRequest plat, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
        Plat p = new Plat();
        BeanUtils.copyProperties(plat, p);
		return new PlatResponse(platSrv.create(p));
	}

    @PutMapping("/{id}")
	public PlatResponse update(@Valid @RequestBody PlatRequest plat, BindingResult br, @PathVariable Long id) {
		Plat p = new Plat();
        BeanUtils.copyProperties(plat, p);
        p.setId(id);
		return new PlatResponse(platSrv.update(p));
	}

    @DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		platSrv.delete(id);
	}
}
