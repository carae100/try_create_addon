package com.seuaddon.mixin;

import net.narutomod.entity.EntityGedoStatue.EntityCustom;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = EntityCustom.class, remap = false)
public abstract class EntityGedoStatueMixin {

    @ModifyArg(
            method = "func_70071_h_()V", // Método obfuscado para onUpdate
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/narutomod/entity/EntityTailedBeast$Base;fuuinIntoVessel(Lnet/minecraft/entity/Entity;I)V"
            ),
            index = 1, // Modifica o segundo argumento (int)
            require = 0 // Evita crash caso o alvo não seja encontrado
    )
    private int modifyFuuinTime(int originalTime) {
        System.out.println("[FastSeal Addon] Modifying sealing time! Original: " + originalTime);
        return 3600; // Define o novo tempo de selamento
    }
}