package me.thecuddlybear.hyadditions.command;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.util.EventTitleUtil;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;

public class TestTitleCommand extends CommandBase {


    public TestTitleCommand(@NonNullDecl String name, @NonNullDecl String description, boolean requiresConfirmation) {
        super("titleCommand", "A test Title command", false);
    }

    @Override
    protected void executeSync(@Nonnull CommandContext commandContext) {
        commandContext.senderAs(Player.class).getWorld().execute(() -> {
            EventTitleUtil.showEventTitleToPlayer(commandContext.senderAs(Player.class).getPlayerRef(),
                    Message.raw("Its a title!"),
                    Message.raw("Love"),
                    true);
        });
    }
}
