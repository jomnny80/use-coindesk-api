package com.coindesk.controllers;

import com.coindesk.models.Coindesk;
import com.coindesk.repositories.CoindeskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coindesk")
public class CoindeskController {
    @Autowired
    private CoindeskRepository coindeskRepository;

    @GetMapping
    public List<Coindesk> getAll() {
        return coindeskRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Coindesk get(@PathVariable Long id) {
        return coindeskRepository.getById(id);
    }

    @PostMapping
    public Coindesk create(@RequestBody final Coindesk coindesk) {
        return coindeskRepository.saveAndFlush(coindesk);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        coindeskRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Coindesk update(@PathVariable Long id, @RequestBody Coindesk coindesk) {
        Coindesk existingCoindesk = coindeskRepository.getById(id);
        BeanUtils.copyProperties(coindesk, existingCoindesk, "coin_desk_id");
        return coindeskRepository.saveAndFlush(existingCoindesk);
    }
}
