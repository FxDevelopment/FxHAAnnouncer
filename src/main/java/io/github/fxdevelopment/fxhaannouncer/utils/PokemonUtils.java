package io.github.fxdevelopment.fxhaannouncer.utils;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;

public class PokemonUtils {
    public boolean hasHA(Pokemon pokemon) {
        return pokemon.getAbilitySlot() == 2;
    }
}
