package org.jonas.jontability.endpoint;

import org.jonas.jontability.business.impl.BillService;
import org.jonas.jontability.dto.BillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping(value="/bill")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<BillDto>> getAll() {
        return ResponseEntity.of(billService.getAll());
    }

    @PostMapping(value="/bill")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(code = HttpStatus.CREATED)
    public BillDto addBill(@RequestBody BillDto billDto) {
        System.out.println(billDto);
        return billService.persist(billDto);
    }

    @DeleteMapping(value="/bill/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable Integer id) {
        try {
            billService.delete(id);
        } catch (Exception as) {
            as.printStackTrace();
        }
    }

}
