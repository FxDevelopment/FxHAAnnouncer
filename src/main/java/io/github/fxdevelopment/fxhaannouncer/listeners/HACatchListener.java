package io.github.fxdevelopment.fxhaannouncer.listeners;

import com.pixelmonmod.pixelmon.api.events.CaptureEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import io.github.fxdevelopment.fxhaannouncer.FxHAAnnouncer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;

public class HACatchListener {

    private final FxHAAnnouncer plugin;

    public HACatchListener(FxHAAnnouncer plugin) {
        this.plugin = plugin;
    }

    //    @SubscribeEvent
//    public void onPixelmonReceived(PixelmonReceivedEvent event) {
//        Player player = (Player) event.player;
//        if (plugin.getPokemonUtils().hasHA(event.pokemon)) {
//            Sponge.getServer().getBroadcastChannel().send(plugin.getFormattingUtils().format(
//                    "&d" + player.getName() + "&a caught a hidden ability &d" + event.pokemon.getSpecies() +
//                            " &awith the hidden ability &d" + event.pokemon.getAbilityName() + "&a."));
//        }
//    }
    @SubscribeEvent
    public void onPixelmonReceived(CaptureEvent.SuccessfulCapture event) {
        if (event.player == null) return;
        Player player = (Player) event.player;
        if (event.getPokemon() == null) return;
        Pokemon pokemon = event.getPokemon().getPokemonData();
        if (plugin.getPokemonUtils().hasHA(pokemon)) {
            Sponge.getServer().getBroadcastChannel().send(plugin.getFormattingUtils().format(
                    "&d" + player.getName() + "&a caught a hidden ability &d" + pokemon.getSpecies() +
                            " &awith the hidden ability &d" + pokemon.getAbilityName() + "&a."));
        }
    }
}
