package net.flytre.attributefix;

import com.google.gson.annotations.SerializedName;
import net.flytre.flytre_lib.api.config.ConfigHandler;
import net.flytre.flytre_lib.api.config.annotation.DisplayName;

@DisplayName("config.attribute_fix")
public class Config {


    public static final ConfigHandler<Config> HANDLER = new ConfigHandler<>(new Config(),"attribute_fix","config.attribute_fix");


    @SerializedName("render_toughness_bar")
    public boolean renderToughnessBar = true;
}
