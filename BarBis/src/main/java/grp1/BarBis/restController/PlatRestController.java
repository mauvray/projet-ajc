package grp1.BarBis.restController;

import java.util.List;
import java.util.stream.Collectors;

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

import jakarta.validation.Valid;
import grp1.BarBis.dto.request.PlatRequest;
import grp1.BarBis.dto.response.PlatResponse;
import grp1.BarBis.entities.Plat;
import grp1.BarBis.services.PlatService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/plat")
public class PlatRestController {

    @Autowired
	private PlatService platSrv;

	@Operation(summary="liste des plats",description="recup de tous les plats")
    @GetMapping("")
	public List<PlatResponse> getAll() {
		return platSrv.getAll().stream().map(p -> new PlatResponse(p)).collect(Collectors.toList());
	}

	@Operation(summary="plat par son id",description="recup un plat par son id")
    @GetMapping("/{id}")
	public PlatResponse getById(@PathVariable("id") Long id) {
		return new PlatResponse(platSrv.getById(id));
	}

	@Operation(summary="liste de plats selon leur nom",description="recup les plats avec meme chaine de caracteres dans le nom")
    @GetMapping("/nom/{nom}")
	public List<PlatResponse> getByNom(@PathVariable String nom) {
		return platSrv.getByNom(nom).stream().map(p -> new PlatResponse(p)).collect(Collectors.toList());
	}

	@Operation(summary="liste des plats par categorie",description="recup de tous les plats de meme categorie")
    @GetMapping("/categorie/{categorie}")
	public List<PlatResponse> getByCategorie(@PathVariable String categorie) {
		return platSrv.getByCategorie(categorie).stream().map(p -> new PlatResponse(p)).collect(Collectors.toList());
	}

	@Operation(summary="creation de plat",description="creation un plat necessite nom prix et categorie")
    @PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PlatResponse create(@Valid @RequestBody PlatRequest plat, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
        Plat p = new Plat();
        BeanUtils.copyProperties(plat, p);
		return new PlatResponse(platSrv.create(p));
	}

	@Operation(summary="update plat",description="update un plat par son id")
    @PutMapping("/{id}")
	public PlatResponse update(@Valid @RequestBody PlatRequest plat, BindingResult br, @PathVariable Long id) {
		Plat p = new Plat();
        BeanUtils.copyProperties(plat, p);
        p.setId(id);
		return new PlatResponse(platSrv.update(p));
	}

	@Operation(summary="supression plat",description="suppression d'un plat par son id")
    @DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		platSrv.delete(id);
	}
}
