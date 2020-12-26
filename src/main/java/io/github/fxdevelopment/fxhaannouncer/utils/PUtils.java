package io.github.fxdevelopment.fxhaannouncer.utils;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

public class PUtils {
    public static boolean hasHA(Pokemon pokemon) {
        return pokemon.getAbilitySlot() == 2;
    }
}
