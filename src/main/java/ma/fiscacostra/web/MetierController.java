package ma.fiscacostra.web;


import lombok.AllArgsConstructor;
import ma.fiscacostra.dtos.MetierResponse;
import ma.fiscacostra.services.MetierService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/employee/metiers")
@CrossOrigin("*")
public class MetierController {


    private final MetierService metierService;

    private final int PAGE_SIZE = 16;


    @GetMapping
    List<MetierResponse> getAll(@RequestParam(name = "page") int page){

        System.out.println("ffffffffffffff");
        Pageable pageable = PageRequest.of(page, this.PAGE_SIZE);
        return  this.metierService.getAll(pageable);
    }

}
