package com.packt.learnjava.reactive;

import io.vertx.core.Promise;
import io.vertx.rxjava.core.AbstractVerticle;

public class MessageRcvVert extends AbstractVerticle {
    private String id, address;

    public MessageRcvVert(String id, String address) {
        this.id = id;
        this.address = address;
    }

    @Override
    public void start(Promise<Void> startFuture) {
        String name = this.getClass().getSimpleName() + "(" + Thread.currentThread().getName() + ", " + id + ", " + address + ")";

        vertx.eventBus()
              .consumer(address)
              .toObservable()
              .subscribe(msgObj -> {
                    String body = msgObj.body().toString();
                    String msg = name + " got message '" + body + "'.";
                    System.out.println(msg);
                    String reply = msg + " Thank you.";
                    msgObj.reply(reply);
              }, Throwable::printStackTrace );

        System.out.println(name + " is waiting...");
    }
}
