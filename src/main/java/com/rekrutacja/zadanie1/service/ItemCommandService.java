package com.rekrutacja.zadanie1.service;

import com.rekrutacja.zadanie1.model.Item;
import com.rekrutacja.zadanie1.command.AddItemCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ItemCommandService {

    private final CommandGateway commandGateway;

    public CompletableFuture<Item> addItem(UUID id, String name) {
       return commandGateway.send(new AddItemCommand(id, name));
    }
}
