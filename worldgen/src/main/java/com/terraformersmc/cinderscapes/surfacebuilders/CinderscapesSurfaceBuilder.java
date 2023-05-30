package com.terraformersmc.cinderscapes.surfacebuilders;

import net.minecraft.tag.TagKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.BlockColumn;

/**
 * CinderscapesSurfaceBuilder provides an interface used by the surface builder mixin to inject surface builders.
 * Because surface builders are no longer a first class citizen in Minecraft, this interface is simpler than
 * the pre-1.18.2 surface builder interfaces.
 *
 * All you have to do is provide a generator method which modifies each existing BlockColumn as required for
 * the surface you wish to generate and override the setBiomeKey or setBiomeTag method to specify valid biomes
 * to modify.
 */
public abstract class CinderscapesSurfaceBuilder {
	RegistryKey<Biome> biomeKey;
	TagKey<Biome> biomeTag;

	/**
	 * CinderscapesSurfaceBuilder.generate()
	 *
	 * The generate() method will be called after noise is used to set the surface height and the noise-based
	 * default material block column has been computed (when badlands pillars are created).  This is before the
	 * application of biome-specific material rules.
	 *
	 * @param column The block column to modify as generated by the surface noise
	 * @param rand The random provider specified by the chunk generator
	 * @param chunk The chunk being generated
	 * @param biome The biome assigned to the block column at the world surface
	 * @param x The X coordinate of the column being generated
	 * @param z The Y coordinate of the column being generated
	 * @param vHeight The height of the world surface as generated by the surface noise
	 * @param seaLevel The sea level used by the chunk generator
	 */
	public void generate(BiomeAccess biomeAccess, BlockColumn column, Random rand, Chunk chunk, Biome biome, int x, int z, int vHeight, int seaLevel) {}

	/**
	 * CinderscapesSurfaceBuilder.generateLate()
	 *
	 * The generateLate() method will be called at the end of column generation (when icebergs are created).
	 * This is after the application of biome-specific material rules.
	 *
	 * @param column The block column to modify as generated by the surface noise
	 * @param rand The random provider specified by the chunk generator
	 * @param chunk The chunk being generated
	 * @param biome biome The biome assigned to the block column at the world surface
	 * @param x x The X coordinate of the column being generated
	 * @param z z The Y coordinate of the column being generated
	 * @param vHeight vHeight The height of the world surface as generated by the surface noise
	 * @param seaLevel seaLevel The sea level used by the chunk generator
	 * @param surfaceMinY The value returned by MaterialRules.MaterialRuleContext.method_39551()
	 */
	public void generateLate(BiomeAccess biomeAccess, BlockColumn column, Random rand, Chunk chunk, Biome biome, int x, int z, int vHeight, int seaLevel, int surfaceMinY) {}

	/**
	 * CinderscapesSurfaceBuilder.filterBiome()
	 *
	 * This method will be called for every block column generated by Minecraft to determine whether to apply each
	 * injected surface builder, so keep the logic here as simple as possible.  The default implementation which
	 * evaluates biomes set in setBiomeKey() and setBiomeTag() is sufficient for most requirements:
	 *
	 * <pre>{@code
	 * public boolean filterBiome(RegistryEntry<Biome> biome) {
	 *     if (biomeKey != null) {
	 *         return biome.matchesKey(biomeKey);
	 *     } else if (biomeTag != null) {
	 *         return biome.isIn(biomeTag);
	 *     } else {
	 *         return false;
	 *     }
	 * }
	 * }</pre>
	 *
	 * @param biome RegistryEntry<Biome> - Registry entry of the currently processing biome
	 * @return boolean - True if the surface rule is applicable to the given biome
	 */
	public boolean filterBiome(RegistryEntry<Biome> biome) {
		if (biomeKey != null) {
			return biome.matchesKey(biomeKey);
		} else if (biomeTag != null) {
			return biome.isIn(biomeTag);
		} else {
			return false;
		}
	}

	/**
	 * CinderscapesSurfaceBuilder.setBiomeKey()
	 *
	 * Sets the biome registry key of the biome to which this surface builder applies.
	 *
	 * @param biomeKey RegistryKey<Biome> - Registry key of the biome to which this surface builder applies.
	 * @return CinderscapesSurfaceBuilder - This method returns the surface builder being configured.
	 */
	public CinderscapesSurfaceBuilder setBiomeKey(RegistryKey<Biome> biomeKey) {
		this.biomeKey = biomeKey;

		return this;
	}

	/**
	 * CinderscapesSurfaceBuilder.setBiomeTag()
	 *
	 * Sets the biome tag key of the biomes to which this surface builder applies.
	 *
	 * @param biomeTag TagKey<Biome> - Tag containing biomes to which this surface builder applies.
	 * @return CinderscapesSurfaceBuilder - This method returns the surface builder being configured.
	 */
	public CinderscapesSurfaceBuilder setBiomeTag(TagKey<Biome> biomeTag) {
		this.biomeTag = biomeTag;

		return this;
	}
}
