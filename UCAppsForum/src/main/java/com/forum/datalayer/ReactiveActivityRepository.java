package com.forum.datalayer;

public interface ReactiveActivityRepository extends ReactiveCrudRepository<UCFUserActivity, String> {
    Flux<UCFUserActivity> findByName(String name);
    Flux<UCFUserActivity> findByName(Mono<String> name);
    
}
