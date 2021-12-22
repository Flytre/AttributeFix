package net.flytre.attributefix.mixin;


import net.minecraft.entity.attribute.ClampedEntityAttribute;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClampedEntityAttribute.class)
public class ClampedEntityAttributeMixin {

    private static boolean patchRan = false;

    @Mutable
    @Shadow
    @Final
    private double minValue;

    @Mutable
    @Shadow
    @Final
    private double maxValue;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void patch(String translationKey, double fallback, double min, double max, CallbackInfo ci) {
        if (!patchRan) {
            System.out.println("[Flytre] Patching Attributes");
            patchRan = true;
        }
        switch (translationKey) {
            case "attribute.name.generic.max_health", "attribute.name.generic.movement_speed", "attribute.name.generic.flying_speed", "attribute.name.generic.attack_damage", "attribute.name.generic.attack_knockback", "attribute.name.generic.attack_speed", "attribute.name.generic.armor", "attribute.name.generic.armor_toughness", "attribute.name.horse.jump_strength" -> this.maxValue = Double.MAX_VALUE;
            case "attribute.name.generic.luck" -> {
                this.maxValue = Double.MAX_VALUE;
                this.minValue = Double.MIN_VALUE;
            }
        }
    }

}
