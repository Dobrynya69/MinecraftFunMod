package aspirin.volitionmod.entity;

import aspirin.volitionmod.VolitionMod;
import aspirin.volitionmod.entity.custom.GhostCarpEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<GhostCarpEntity> GHOST_CARP = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(VolitionMod.MOD_ID, "ghost_carp"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GhostCarpEntity::new)
                    .dimensions(EntityDimensions.fixed(0.3f, 1f)).build());
}
