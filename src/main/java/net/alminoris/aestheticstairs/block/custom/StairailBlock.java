package net.alminoris.aestheticstairs.block.custom;

import net.alminoris.aestheticstairs.util.helper.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.swing.text.html.BlockView;
import java.util.ArrayList;
import java.util.List;

import static net.minecraft.core.Direction.Plane.HORIZONTAL;

public class StairailBlock extends YAxisRotatedBlock
{
    private static final VoxelShape SHAPE = StairailBlock.box(7, 0, 0, 9, 15, 2);

    private static final VoxelShape SHAPESIDE = StairailBlock.box(0, 0, 0, 16, 15, 2);

    private static final VoxelShape SHAPERC = StairailBlock.box(14, 0, 0, 16, 15, 16);

    private static final VoxelShape SHAPELC = StairailBlock.box(0, 0, 0, 2, 15, 16);

    private static final VoxelShape SHAPE_HEAD = StairailBlock.box(6.5D, 15, -0.5D, 9.5D, 16, 2.5D);

    private static final VoxelShape SHAPESIDE_HEAD = StairailBlock.box(0, 15, -0.5D, 16, 16, 2.5D);

    private static final VoxelShape SHAPELC_HEAD = StairailBlock.box(-0.5D, 15, -0.5D, 2.5D, 16, 16);

    private static final VoxelShape SHAPERC_HEAD = StairailBlock.box(13.5D, 15, -0.5D, 16.5D, 16, 16);

    private static final VoxelShape SMALL_SHAPE = StairailBlock.box(7, 0, 0, 9, 12, 2);

    private static final VoxelShape SMALL_SHAPESIDE = StairailBlock.box(0, 0, 0, 16, 12, 2);

    private static final VoxelShape SMALL_SHAPERC = StairailBlock.box(14, 0, 0, 16, 12, 16);

    private static final VoxelShape SMALL_SHAPELC = StairailBlock.box(0, 0, 0, 2, 12, 16);

    private static final VoxelShape SMALL_SHAPE_HEAD = StairailBlock.box(6.5D, 12, -0.5D, 9.5D, 14.25D, 2.5D);

    private static final VoxelShape SMALL_SHAPESIDE_HEAD = StairailBlock.box(0, 12, -0.5D, 16, 14.25D, 2.5D);

    private static final VoxelShape SMALL_SHAPELC_HEAD = StairailBlock.box(-0.5D, 12, -0.5D, 2.5D, 14.25D, 16);

    private static final VoxelShape SMALL_SHAPERC_HEAD = StairailBlock.box(13.5D, 12, -0.5D, 16.5D, 14.25D, 16);

    public enum Variant implements StringRepresentable
    {
        NORMAL("normal"),
        SIDE("side"),
        LEFTCORNER("leftcorner"),
        RIGHTCORNER("rightcorner");

        private final String name;

        Variant(String name) { this.name = name; }

        @Override
        public String getSerializedName() { return this.name; }
    }

    public static final EnumProperty<Variant> VARIANT = EnumProperty.create("variant", Variant.class);

    private final String BLOCK_NAME;

    public StairailBlock(BlockBehaviour.Properties settings, String blockName)
    {
        super(settings.noOcclusion());
        BLOCK_NAME = blockName;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(VARIANT, Variant.NORMAL));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context)
    {
        return getRotatedShape(state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }

    private VoxelShape getRotatedShape(BlockState state)
    {
        Direction direction = state.getValue(FACING);

        List<AABB> boxes = new ArrayList<>();

        if (BLOCK_NAME.split("_")[0].equals("small"))
        {
            switch (state.getValue(VARIANT))
            {
                case NORMAL:
                    boxes.add(SMALL_SHAPE_HEAD.bounds());
                    boxes.add(SMALL_SHAPE.bounds());
                    break;
                case SIDE:
                    boxes.add(SMALL_SHAPESIDE_HEAD.bounds());
                    boxes.add(SMALL_SHAPESIDE.bounds());
                    break;
                case LEFTCORNER:
                    boxes.add(SMALL_SHAPESIDE_HEAD.bounds());
                    boxes.add(SMALL_SHAPESIDE.bounds());
                    boxes.add(SMALL_SHAPELC_HEAD.bounds());
                    boxes.add(SMALL_SHAPELC.bounds());
                    break;
                case RIGHTCORNER:
                    boxes.add(SMALL_SHAPESIDE_HEAD.bounds());
                    boxes.add(SMALL_SHAPESIDE.bounds());
                    boxes.add(SMALL_SHAPERC_HEAD.bounds());
                    boxes.add(SMALL_SHAPERC.bounds());
                    break;
            }
        }
        else
        {
            switch (state.getValue(VARIANT))
            {
                case NORMAL:
                    boxes.add(SHAPE_HEAD.bounds());
                    boxes.add(SHAPE.bounds());
                    break;
                case SIDE:
                    boxes.add(SHAPESIDE_HEAD.bounds());
                    boxes.add(SHAPESIDE.bounds());
                    break;
                case LEFTCORNER:
                    boxes.add(SHAPESIDE_HEAD.bounds());
                    boxes.add(SHAPESIDE.bounds());
                    boxes.add(SHAPELC_HEAD.bounds());
                    boxes.add(SHAPELC.bounds());
                    break;
                case RIGHTCORNER:
                    boxes.add(SHAPESIDE_HEAD.bounds());
                    boxes.add(SHAPESIDE.bounds());
                    boxes.add(SHAPERC_HEAD.bounds());
                    boxes.add(SHAPERC.bounds());
                    break;
            }
        }

        return VoxelShapeHelper.rotateShape(boxes, direction);
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos)
    {
        return updateStairailVariant(world, state, pos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, WATERLOGGED, VARIANT);
    }

    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify)
    {
        super.onPlace(state, world, pos, oldState, notify);

        BlockState updatedState = updateStairailVariant(world, state, pos);
        if (!updatedState.equals(state))
        {
            world.setBlock(pos, updatedState, 3);
        }

        updateSurroundingStairails(world, pos);
    }

    private void updateSurroundingStairails(Level world, BlockPos pos)
    {
        for (Direction direction : HORIZONTAL)
        {
            BlockPos neighborPos = pos.offset(direction.getNormal());
            BlockState neighborState = world.getBlockState(neighborPos);

            if (neighborState.getBlock() == this)
            {
                BlockState updatedState = updateStairailVariant(world, neighborState, neighborPos);
                if (!neighborState.equals(updatedState))
                {
                    world.setBlock(neighborPos, updatedState, 3);
                }
            }
        }
    }

    private BlockState updateStairailVariant(LevelAccessor world, BlockState state, BlockPos pos)
    {
        Direction facing = state.getValue(FACING);

        BlockPos leftPos = pos.offset(facing.getCounterClockWise(Direction.Axis.Y).getNormal());
        BlockPos rightPos = pos.offset(facing.getClockWise(Direction.Axis.Y).getNormal());

        if (isStairailL(world, rightPos.offset(facing.getCounterClockWise(Direction.Axis.Y).getNormal()).offset(facing.getClockWise(Direction.Axis.Y).getClockWise(Direction.Axis.Y).getNormal()), facing))
        {
            return state.setValue(VARIANT, Variant.RIGHTCORNER);
        } else if (isStairailR(world, leftPos.offset(facing.getClockWise(Direction.Axis.Y).getNormal()).offset(facing.getCounterClockWise(Direction.Axis.Y).getCounterClockWise(Direction.Axis.Y).getNormal()), facing))
        {
            return state.setValue(VARIANT, Variant.LEFTCORNER);
        }

        boolean leftConnected = isStairail(world, leftPos, facing, Variant.RIGHTCORNER);
        boolean rightConnected = isStairail(world, rightPos, facing, Variant.LEFTCORNER);

        if (leftConnected || rightConnected)
        {
            return state.setValue(VARIANT, Variant.SIDE);
        }

        return state.setValue(VARIANT, Variant.NORMAL);
    }

    private boolean isStairail(LevelAccessor world, BlockPos pos, Direction expectedFacing, Variant variant)
    {
        BlockState state = world.getBlockState(pos);

        return state.getBlock() == this && (state.getValue(FACING) == expectedFacing || state.getValue(VARIANT) == variant);
    }

    private boolean isStairailL(LevelAccessor world, BlockPos pos, Direction expectedFacing)
    {
        BlockState state = world.getBlockState(pos);

        return state.getBlock() == this && state.getValue(FACING) == expectedFacing.getClockWise(Direction.Axis.Y);
    }

    private boolean isStairailR(LevelAccessor world, BlockPos pos, Direction expectedFacing)
    {
        BlockState state = world.getBlockState(pos);

        return state.getBlock() == this && state.getValue(FACING) == expectedFacing.getCounterClockWise(Direction.Axis.Y);
    }
}