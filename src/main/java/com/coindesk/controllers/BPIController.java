package com.coindesk.controllers;

import com.coindesk.models.BPI;
import com.coindesk.repositories.BPIRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bpi")
public class BPIController {
    @Autowired
    private BPIRepository bpiRepository;

    @GetMapping
    public List<BPI> getAll() {
        return bpiRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public BPI get(@PathVariable Long id) {
        return bpiRepository.getById(id);
    }

    @PostMapping
    public BPI create(@RequestBody final BPI bpi) {
        return bpiRepository.saveAndFlush(bpi);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        bpiRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public BPI update(@PathVariable Long id, @RequestBody BPI bpi) {
        BPI existingBpi = bpiRepository.getById(id);
        BeanUtils.copyProperties(bpi, existingBpi, "bpi_id");
        return bpiRepository.saveAndFlush(existingBpi);
    }
}
