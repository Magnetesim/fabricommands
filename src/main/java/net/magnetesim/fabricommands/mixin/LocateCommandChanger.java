package net.magnetesim.fabricommands.mixin;


import net.magnetesim.fabricommands.FabriCommands;
import net.magnetesim.fabricommands.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.command.LocateCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.magnetesim.fabricommands.FabriCommands.LOGGER;

@Mixin(Entity.class)
public abstract class LocateCommandChanger implements IEntityDataSaver {
    private NbtCompound persistentData;
    private static final double SPEED_IN_WATER = 3;
    public void main(String[] args) {
        FabriCommands.LOGGER.info("LOCATECOMMANDCHANGER/ENTITYBEINGRUN");
    }

    @Override
    public NbtCompound getPersistentData() {
        if(this.persistentData == null) {
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable info) {
        if (persistentData != null) {
            nbt.put("hiData", persistentData);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains("hiData", 10)) {
            persistentData = nbt.getCompound("KaupenData");
        }
    }
}
