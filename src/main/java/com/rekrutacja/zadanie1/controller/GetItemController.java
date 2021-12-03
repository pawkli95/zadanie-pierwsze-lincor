package com.rekrutacja.zadanie1.controller;

import com.rekrutacja.zadanie1.model.Item;
import com.rekrutacja.zadanie1.service.ItemQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/api/items")
@RestController
@RequiredArgsConstructor
public class GetItemController {

    private final ItemQueryService itemQueryService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CompletableFuture<Item> getItem(@PathVariable("id") UUID id) {
        return itemQueryService.getItem(id);
    }
}
