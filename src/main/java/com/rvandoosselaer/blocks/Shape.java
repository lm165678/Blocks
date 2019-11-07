package com.rvandoosselaer.blocks;

import com.jme3.math.Vector3f;
import com.simsilica.mathd.Vec3i;

/**
 * The interface describing the shape of a {@link Block} element. The {@link #add(Vec3i, Chunk, ChunkMesh)} method is
 * called for each block in the chunk when the mesh is constructed using the {@link ChunkMeshGenerator}.
 *
 * @author rvandoosselaer
 */
public interface Shape {

    String CUBE = "cube";
    String PYRAMID = "pyramid";
    String WEDGE_FRONT = "wedge-front";
    String WEDGE_RIGHT = "wedge-right";
    String WEDGE_BACK = "wedge-back";
    String WEDGE_LEFT = "wedge-left";
    String SLAB = "slab";
    String DOUBLE_SLAB = "double-slab";
    String STAIR_FRONT = "stair-front";
    String STAIR_RIGHT = "stair-right";
    String STAIR_BACK = "stair-back";
    String STAIR_LEFT = "stair-left";

    /**
     * Adds the shape at the location in the chunk to the chunk mesh.
     *
     * @param location  of the shape in the chunk
     * @param chunk     of the shape
     * @param chunkMesh to add the shape to
     */
    void add(Vec3i location, Chunk chunk, ChunkMesh chunkMesh);

    /**
     * A helper method that offsets a vertex based on the location of the block in the chunk and the block scale.
     *
     * @param vertex
     * @param blockLocation
     * @param blockScale
     * @return the same vertex with an offset
     */
    static Vector3f createVertex(Vector3f vertex, Vec3i blockLocation, float blockScale) {
        return vertex.addLocal(blockLocation.x, blockLocation.y, blockLocation.z).multLocal(blockScale);
    }

}
