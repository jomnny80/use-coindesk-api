package com.coindesk.controllers;

import com.coindesk.models.Time;
import com.coindesk.repositories.TimeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time")
public class TimeController {
    @Autowired
    private TimeRepository timeRepository;

    @GetMapping
    public List<Time> getAll() {
        return timeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Time get(@PathVariable Long id) {
        return timeRepository.getById(id);
    }

    @PostMapping
    public Time create(@RequestBody final Time time) {
        return timeRepository.saveAndFlush(time);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        timeRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Time update(@PathVariable Long id, @RequestBody Time time) {
        Time existingTime = timeRepository.getById(id);
        BeanUtils.copyProperties(time, existingTime);
        return timeRepository.saveAndFlush(existingTime);
    }
}
