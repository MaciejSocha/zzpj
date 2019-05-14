package razdwatrzy.zzpj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import razdwatrzy.zzpj.model.Example;
import razdwatrzy.zzpj.repository.ExampleRepository;

import java.util.Arrays;

@RestController
public class ExampleController {
    @Autowired
    ExampleRepository repository;

    @GetMapping("/create")
    public String create() {
        repository.saveAll(Arrays.asList(new Example("Ukasz", "Kowalski"),
                                         new Example("Jan", "Paweł"),
                                         new Example("Kamil", "Nowak")));
        return "Created!";
    }
}
