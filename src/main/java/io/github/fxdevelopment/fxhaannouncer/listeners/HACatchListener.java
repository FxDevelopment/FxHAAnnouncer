package io.github.fxdevelopment.fxhaannouncer.listeners;

import com.pixelmonmod.pixelmon.api.enums.ReceiveType;
import com.pixelmonmod.pixelmon.api.events.PixelmonReceivedEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import io.github.fxdevelopment.fxhaannouncer.FxHAAnnouncer;
import io.github.fxdevelopment.fxhaannouncer.utils.PokemonUtils;
import io.github.fxdevelopment.fxhaannouncer.utils.FormattingUtils;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;

public class HACatchListener {

    private final FxHAAnnouncer plugin;
    public HACatchListener(FxHAAnnouncer plugin) {
        this.plugin = plugin;
    }

    @SubscribeEvent
    public void onPixelmonReceived(PixelmonReceivedEvent event) {

        if (!(event.player instanceof Player)) return;
        Player player = (Player) event.player;

        Pokemon pokemon = event.pokemon;
        if (pokemon == null) return;

        if (event.receiveType == ReceiveType.PokeBall) {
            if (plugin.getPokemonUtils().hasHA(pokemon)) {
                Sponge.getServer().getBroadcastChannel().send(plugin.getFormattingUtils().format(
                        "&d" + player.getName() + "&a caught a hidden ability &d" + pokemon.getSpecies() +
                                " &awith the ability &d" + pokemon.getAbilityName() + "&a."));
            }
        }
    }
}
