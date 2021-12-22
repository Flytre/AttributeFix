package net.flytre.attributefix.mixin;


import net.flytre.attributefix.Config;
import net.flytre.flytre_lib.api.config.ConfigRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Ljava/lang/Thread;currentThread()Ljava/lang/Thread;"))
    public void attribute_fix$registerConfig(RunArgs args, CallbackInfo ci) {
        ConfigRegistry.registerClientConfig(Config.HANDLER);
    }
}
