package grp1.BarBis.restController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import grp1.BarBis.dto.request.AnimationRequest;
import grp1.BarBis.dto.response.AnimationResponse;
import grp1.BarBis.entities.Animation;
import grp1.BarBis.services.AnimationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/animation")
public class AnimationRestController {

    @Autowired
    private AnimationService animSrv;

    @GetMapping("")
    public List<AnimationResponse> getAll(){
        return animSrv.getAll().stream().map(a -> new AnimationResponse(a)).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(code=HttpStatus.CREATED)
    public AnimationResponse create(@Valid @RequestBody AnimationRequest anim, BindingResult br){
        if (br.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Animation a = new Animation();
        BeanUtils.copyProperties(anim, a);
        return new AnimationResponse(animSrv.create(a));
    }
}
