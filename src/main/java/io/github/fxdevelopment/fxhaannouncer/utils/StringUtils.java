package io.github.fxdevelopment.fxhaannouncer.utils;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

public class StringUtils {
    public static Text format(String str) {
        return TextSerializers.FORMATTING_CODE.deserialize(str);
    }
}
