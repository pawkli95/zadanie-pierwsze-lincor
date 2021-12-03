package com.rekrutacja.zadanie1.controller;

import com.rekrutacja.zadanie1.dto.AddItemDto;
import com.rekrutacja.zadanie1.model.Item;
import com.rekrutacja.zadanie1.service.ItemCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RequestMapping("/api/items")
@RequiredArgsConstructor
@RestController
public class AddItemController {
    
   private final ItemCommandService itemCommandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<Item> addItem(@RequestBody AddItemDto addItemDto) {
       return itemCommandService.addItem(addItemDto.getId(), addItemDto.getName());
    }
}
