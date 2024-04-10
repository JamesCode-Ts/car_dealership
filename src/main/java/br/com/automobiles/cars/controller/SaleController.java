package br.com.automobiles.cars.controller;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.automobiles.cars.model.Sale;
import br.com.automobiles.cars.service.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {

	
    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Long id) {
       var sale = saleService.findById(id);
       return ResponseEntity.ok(sale);
    }

    @PostMapping
    public ResponseEntity<Sale> create(@RequestBody Sale saleToCreate) {
        var saleCreated = saleService.create(saleToCreate);
    	        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saleCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(saleCreated);
    }
	
	
	
}
