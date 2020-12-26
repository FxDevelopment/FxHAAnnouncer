package io.github.fxdevelopment.fxhaannouncer;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.client.models.obj.utils.Logger;
import io.github.fxdevelopment.fxhaannouncer.listeners.HACatchListener;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;

import javax.inject.Inject;

@Plugin(
        id="fxhaannouncer",
        name="FxHAAnnouncer",
        description="Announces when a player catches a hidden ability pokemon!",
        authors = {
                "OzzyMar"
        },
        dependencies = {
                @Dependency(id = "pixelmon", version = "8.1.2"),
                @Dependency(id = "spongeapi", version = "7.2.0")
        }
)

public class Main {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        Pixelmon.EVENT_BUS.register(new HACatchListener());
    }
}
