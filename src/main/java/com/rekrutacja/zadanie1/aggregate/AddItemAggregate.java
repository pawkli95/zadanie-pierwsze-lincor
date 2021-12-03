package com.rekrutacja.zadanie1.aggregate;

import com.rekrutacja.zadanie1.event.ItemAddedEvent;
import com.rekrutacja.zadanie1.command.AddItemCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class AddItemAggregate {

    @AggregateIdentifier
    private UUID id;

    private String name;

    @CommandHandler
    public AddItemAggregate(AddItemCommand command) {
        AggregateLifecycle.apply(
                new ItemAddedEvent(
                        command.getId(),
                        command.getName()
                ));
    }

    @EventSourcingHandler
    public void on(ItemAddedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
    }
}
