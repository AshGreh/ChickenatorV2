package scripts;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;

public class Bank extends Task<ClientContext> {
    public Bank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.bank.opened() &&  ctx.bank.inViewport() && ctx.backpack.select().count() > 0;
    }

    @Override
    public void execute() {
        ctx.bank.open();
        if (ctx.backpack.select().count() != 0) {
            ctx.bank.depositInventory();
        }
    }
}
    /*public void execute() {
        ctx.bank.open();
        for (Item i : ctx.backpack.select().id(526)) {
            i.interact("Deposit-All");
        }
    }
    */


