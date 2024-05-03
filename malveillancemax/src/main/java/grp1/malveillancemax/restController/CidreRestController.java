package grp1.malveillancemax.restController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import grp1.malveillancemax.services.CidreService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


// CidreRestController

@RestController
@RequestMapping("/cidre")
public class CidreRestController {
  //  private Logger logger = LoggerFactory.getLogger(CidreRestController.class);
    @Autowired
    public CidreService cidreSrv;

  
}
    
