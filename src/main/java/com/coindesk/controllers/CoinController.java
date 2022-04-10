package com.coindesk.controllers;

import com.coindesk.models.Coin;
import com.coindesk.repositories.CoinRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coin")
public class CoinController {
    @Autowired
    private CoinRepository coinRepository;

    @GetMapping
    public List<Coin> getAll() {
        return coinRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Coin get(@PathVariable Long id) {
        return coinRepository.getById(id);
    }

    @PostMapping
    public Coin create(@RequestBody final Coin coin) {
        return coinRepository.saveAndFlush(coin);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        coinRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Coin update(@PathVariable Long id, @RequestBody Coin coin) {
        Coin existingCoin = coinRepository.getById(id);
        BeanUtils.copyProperties(coin, existingCoin);
        return coinRepository.saveAndFlush(existingCoin);
    }
}
