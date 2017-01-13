package scripts;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.Actor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Npc;

public class AttackChicken extends Task<ClientContext> {
    public AttackChicken(ClientContext ctx) {
        super(ctx);
    }

    //corners
    Tile ne = new Tile(3210, 3287, 0);
    Tile nw = new Tile(3204, 3287, 0);
    Tile se = new Tile(3210, 3285, 0);
    Tile sw = new Tile(3204, 3285, 0);

    final int chickenIds[]  = {1017, 41};
    private Npc chicken;

    @Override
    public boolean activate() {
        chicken = ctx.npcs.select().id(chickenIds).nearest().poll();
        return
                !ctx.npcs.within(new Area(nw, se)).id(chickenIds).select().isEmpty() &&
                !ctx.players.local().inMotion();
    }

    @Override
    public void execute() {
        System.out.println(chicken);
        chicken.interact("Attack");
    }
}
