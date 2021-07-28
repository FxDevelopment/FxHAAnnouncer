package io.github.fxdevelopment.fxhaannouncer;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.client.models.obj.utils.Logger;
import io.github.fxdevelopment.fxhaannouncer.listeners.HACatchListener;
import io.github.fxdevelopment.fxhaannouncer.utils.FormattingUtils;
import io.github.fxdevelopment.fxhaannouncer.utils.PokemonUtils;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;

import javax.inject.Inject;

@Plugin(
        id = "fxhaannouncer",
        name = "FxHAAnnouncer",
        description = "Announces when a player catches a hidden ability pokemon!",
        authors = {
                "OzzyMar"
        },
        dependencies = {
                @Dependency(id = "pixelmon", version = "8.2.0"),
                @Dependency(id = "spongeapi", version = "7.3.0")
        }
)
public class FxHAAnnouncer {

    private final FormattingUtils formattingUtils = new FormattingUtils();
    private final PokemonUtils pokemonUtils = new PokemonUtils();

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        Pixelmon.EVENT_BUS.register(new HACatchListener(this));
    }

    public FormattingUtils getFormattingUtils() {
        return formattingUtils;
    }

    public PokemonUtils getPokemonUtils() {
        return pokemonUtils;
    }
}
