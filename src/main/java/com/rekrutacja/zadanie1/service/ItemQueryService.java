package com.rekrutacja.zadanie1.service;

import com.rekrutacja.zadanie1.model.Item;
import com.rekrutacja.zadanie1.query.GetItemQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ItemQueryService {

    private final QueryGateway queryGateway;

    public CompletableFuture<Item> getItem(UUID id) {
        return this.queryGateway.query(
                new GetItemQuery(id),
                ResponseTypes.instanceOf(Item.class)
        );
    }
}
