package com.forum.reactor;


public interface ReactiveActivityRepository extends ReactiveMongoRepository<UCFUserActivity, String> {
    Flux<UCFUserActivity> findByName(String name);
    Flux<UCFUserActivity> findByName(Mono<String> name);
    
}
