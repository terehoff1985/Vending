package ООП;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

public class Market implements QueueBehaviour, MarketBehaviour {

    private List<Action> queue;
    private List<Action> market;

    public Market() {
        this.queue = new ArrayList<>();
        this.market = new ArrayList<>();
    }

    @Override
    public void takeInQueue(Actor actor) {
        queue.add(actor);
    }

    @Override
    public void releaseFromQueue() {
        if (!queue.isEmpty()) {
            market.add(queue.remove(0));
        }
    }

    @Override
    public void acceptToMarket(Actor actor) {
        market.add(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        market.removeAll(actors);
    }

    @Override
    public void takeOrders() {
        for (Actor actor : market) {
            actor.makeOrder();
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : market) {
            actor.receiveOrder();
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }
}
