package me.thecuddlybear.hyadditions.command;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.protocol.packets.interface_.CustomPageLifetime;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import me.thecuddlybear.hyadditions.pages.TestPage;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class TestUiCommand extends AbstractPlayerCommand {

    public TestUiCommand() {
        super("testui", "Opens test ui!", false);
    }

    @Override
    protected void execute(@NonNullDecl CommandContext commandContext, @NonNullDecl Store<EntityStore> store, @NonNullDecl Ref<EntityStore> ref, @NonNullDecl PlayerRef playerRef, @NonNullDecl World world) {
        Player player = store.getComponent(ref, Player.getComponentType());
        TestPage page = new TestPage(playerRef, CustomPageLifetime.CanDismiss);
        assert player != null;
        player.getPageManager().openCustomPage(ref, store, page);
    }
}
