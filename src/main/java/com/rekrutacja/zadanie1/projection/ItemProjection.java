package com.rekrutacja.zadanie1.projection;

import com.rekrutacja.zadanie1.event.ItemAddedEvent;
import com.rekrutacja.zadanie1.exception.ItemAlreadyExistsException;
import com.rekrutacja.zadanie1.model.Item;
import com.rekrutacja.zadanie1.query.GetItemQuery;
import com.rekrutacja.zadanie1.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class ItemProjection {

    private final ItemRepository itemRepository;

    @EventHandler
    public void on(ItemAddedEvent event) {
        Item item = new Item(
                event.getId(),
                event.getName()
        );
        if(itemRepository.existsById(item.getId())) {
            throw new ItemAlreadyExistsException("Id is already in use");
        }
        this.itemRepository.save(item);
    }

    @QueryHandler
    public Item handle(GetItemQuery query) {
        return itemRepository
                .findById(query.getId())
                .orElseThrow(() -> new NoSuchElementException("Item is not in database"));
    }


}
