package se.andolf.nordic.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import se.andolf.nordic.models.Command;
import se.andolf.nordic.models.CommandType;
import se.andolf.nordic.resources.workouts.DagensResource;
import se.andolf.nordic.resources.workouts.FitnessResource;

@Component
public class CacheHandler {

    private final DagensResource dagensResource;
    private final FitnessResource fitnessResource;

    @Autowired
    public CacheHandler(DagensResource dagensResource, FitnessResource fitnessResource) {
        this.dagensResource = dagensResource;
        this.fitnessResource = fitnessResource;
    }

    public Mono<Void> execute(Mono<Command> commandMono) {
        return commandMono.flatMap(command ->
                resolve(command.getCommand()));
    }

    private Mono<? extends Void> resolve(CommandType command) {
        switch (command) {
            case CLEAR_FETCH_AND_PUSH:
                return dagensResource.get()
                        .flatMap(dagensResource::push)
                        .then(fitnessResource.get()
                            .flatMap(fitnessResource::push));
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
