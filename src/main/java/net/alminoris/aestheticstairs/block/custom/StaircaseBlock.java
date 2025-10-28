package net.alminoris.aestheticstairs.block.custom;

import net.alminoris.aestheticstairs.block.ModBlocks;
import net.alminoris.aestheticstairs.util.helper.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


import javax.swing.text.html.BlockView;
import java.util.ArrayList;
import java.util.List;

import static net.minecraft.core.Direction.Plane.HORIZONTAL;

public class StaircaseBlock extends YAxisRotatedBlock
{
    private static final VoxelShape SHAPE = StaircaseBlock.box(0, 0, 8, 16, 3, 16);

    private static final VoxelShape SHAPE1 = StaircaseBlock.box(0, 7, 0, 16, 10, 8);

    private static final VoxelShape SHAPELC = StaircaseBlock.box(0, 7, 8, 8, 10, 16);

    private static final VoxelShape RSHAPEC = StaircaseBlock.box(0, 0, 8, 8, 3, 16);

    private static final VoxelShape LSHAPEC = StaircaseBlock.box(8, 0, 8, 16, 3, 16);

    private static final VoxelShape SHAPEC = StaircaseBlock.box(0, 7, 0, 16, 10, 8);

    private static final VoxelShape SHAPERC = StaircaseBlock.box(8, 7, 8, 16, 10, 16);

    private static final VoxelShape SMALL_SHAPE = StaircaseBlock.box(0, 2, 11, 16, 4, 15);

    private static final VoxelShape SMALL_SHAPE1 = StaircaseBlock.box(0, 7, 5.5D, 16, 9, 9.5D);

    private static final VoxelShape SMALL_SHAPE2 = StaircaseBlock.box(0, 12, 0, 16, 14, 4);

    private static final VoxelShape SMALL_SHAPERC = StaircaseBlock.box(12, 12, 0, 16, 14, 16);

    private static final VoxelShape SMALL_SHAPERC1 = StaircaseBlock.box(6.5D, 7, 9.5D, 10.5D, 9, 16);

    private static final VoxelShape SMALL_SHAPERC2 = StaircaseBlock.box(1, 2, 15, 5, 4, 16);

    private static final VoxelShape SMALL_RSHAPEC = StaircaseBlock.box(0, 2, 11, 5, 4, 15);

    private static final VoxelShape SMALL_RSHAPEC1 = StaircaseBlock.box(0, 7, 5.5D, 10.5D, 9, 9.5D);

    private static final VoxelShape SMALL_RSHAPEC2 = StaircaseBlock.box(0, 12, 0, 16, 14, 4);

    private static final VoxelShape SMALL_SHAPELC = StaircaseBlock.box(0, 2, 0, 4, 14, 16);

    private static final VoxelShape SMALL_SHAPELC1 = StaircaseBlock.box(5.5D, 7, 11, 9.5D, 9, 16);

    private static final VoxelShape SMALL_SHAPELC2 = StaircaseBlock.box(11, 2, 15, 15, 4, 16);

    private static final VoxelShape SMALL_LSHAPEC = StaircaseBlock.box(9, 2, 11, 15, 4, 15);

    private static final VoxelShape SMALL_LSHAPEC1 = StaircaseBlock.box(4, 7, 5.5D, 9, 9, 9.5D);

    private static final VoxelShape SMALL_LSHAPEC2 = StaircaseBlock.box(0, 12, 0, 4, 14, 4);

    public enum Variant implements StringRepresentable
    {
        NORMAL("normal"),
        LEFT("left"),
        RIGHT("right"),
        LEFTCORNER("leftcorner"),
        RIGHTCORNER("rightcorner"),
        CENTER("center"),
        UP("up"),
        UPLEFT("upleft"),
        UPRIGHT("upright"),
        UPCENTER("upcenter");

        private final String name;

        Variant(String name) { this.name = name; }

        @Override
        public String getSerializedName() { return this.name; }
    }

    public static final EnumProperty<Variant> VARIANT = EnumProperty.create("variant", Variant.class);

    public static final BooleanProperty RAILED = BooleanProperty.create("railed");

    private final String NAME;

    private final String BLOCK_NAME;

    public StaircaseBlock(BlockBehaviour.Properties settings, String name, String blockName)
    {
        super(settings.noOcclusion());
        NAME = name;
        BLOCK_NAME = blockName;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(VARIANT, Variant.NORMAL).setValue(RAILED, false));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit)
    {
        Variant currentVariant = state.getValue(VARIANT);
        boolean currentRailed = state.getValue(RAILED);
        Direction currentFacing = state.getValue(FACING);

        if (player.getMainHandItem().isEmpty()
                && (currentVariant.equals(Variant.CENTER) || currentVariant.equals(Variant.UPCENTER)
                || currentVariant.equals(Variant.LEFTCORNER) || currentVariant.equals(Variant.RIGHTCORNER)))
        {
            return InteractionResult.PASS;
        }

        if (!world.isClientSide)
        {
            ItemStack stack = player.getMainHandItem();

            boolean isStackFound = (!BLOCK_NAME.split("_")[0].equals("small") && stack.is(ModBlocks.STAIRAILS.get(NAME).get().asItem()))
                    || (BLOCK_NAME.split("_")[0].equals("small") && stack.is(ModBlocks.SMALL_STAIRAILS.get(NAME).get().asItem()));

            if (!currentRailed && isStackFound)
            {
                stack.shrink(1);
                currentRailed = true;

                world.setBlock(pos, state
                        .setValue(FACING, currentFacing)
                        .setValue(VARIANT, currentVariant)
                        .setValue(RAILED, currentRailed), 3);

                return InteractionResult.SUCCESS;
            }

            if (currentRailed && stack.is(ItemTags.AXES))
            {
                if (stack.getDamageValue() < stack.getMaxDamage() - 1)
                    stack.setDamageValue(stack.getDamageValue() + 1);
                else
                    stack.shrink(1);

                ItemStack stickStack = new ItemStack(Items.STICK);
                stickStack.setCount(3);
                if (!player.getInventory().add(stickStack))
                    player.drop(stickStack, false);

                currentRailed = false;

                world.setBlock(pos, state
                        .setValue(FACING, currentFacing)
                        .setValue(VARIANT, currentVariant)
                        .setValue(RAILED, currentRailed), 3);

                return InteractionResult.SUCCESS;
            }
        }
        return super.useWithoutItem(state, world, pos, player, hit);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) 
    {
        return getRotatedShape(state);
    }

    private VoxelShape getRotatedShape(BlockState state)
    {
        Direction direction = state.getValue(FACING);

        List<AABB> boxes = new ArrayList<>();

        if (BLOCK_NAME.split("_")[0].equals("small"))
        {
            if (state.getValue(VARIANT) == Variant.LEFTCORNER)
            {
                boxes.add(SMALL_LSHAPEC.bounds());
                boxes.add(SMALL_LSHAPEC1.bounds());
                boxes.add(SMALL_LSHAPEC2.bounds());
                boxes.add(SMALL_SHAPELC.bounds());
                boxes.add(SMALL_SHAPELC1.bounds());
                boxes.add(SMALL_SHAPELC2.bounds());
            }
            else if (state.getValue(VARIANT) == Variant.RIGHTCORNER)
            {
                boxes.add(SMALL_RSHAPEC.bounds());
                boxes.add(SMALL_RSHAPEC1.bounds());
                boxes.add(SMALL_RSHAPEC2.bounds());
                boxes.add(SMALL_SHAPERC.bounds());
                boxes.add(SMALL_SHAPERC1.bounds());
                boxes.add(SMALL_SHAPERC2.bounds());
            }
            else
            {
                boxes.add(SMALL_SHAPE.bounds());
                boxes.add(SMALL_SHAPE1.bounds());
                boxes.add(SMALL_SHAPE2.bounds());
            }
        }
        else
        {
            if (state.getValue(VARIANT) == Variant.LEFTCORNER)
            {
                boxes.add(LSHAPEC.bounds());
                boxes.add(SHAPELC.bounds());
                boxes.add(SHAPEC.bounds());
            }
            else if (state.getValue(VARIANT) == Variant.RIGHTCORNER)
            {
                boxes.add(RSHAPEC.bounds());
                boxes.add(SHAPERC.bounds());
                boxes.add(SHAPEC.bounds());
            }
            else
            {
                boxes.add(SHAPE.bounds());
                boxes.add(SHAPE1.bounds());
            }
        }

        return VoxelShapeHelper.rotateShape(boxes, direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, WATERLOGGED, VARIANT, RAILED);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor world, BlockPos pos, BlockPos neighborPos)
    {
        super.updateShape(state, direction, neighborState, world, pos, neighborPos);
        return updateStaircaseVariant(state, world, pos);
    }

    @Override
    protected void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify)
    {
        super.onPlace(state, world, pos, oldState, notify);

        BlockState updatedSelf = updateStaircaseVariant(state, world, pos);
        if (updatedSelf != state)
            world.setBlock(pos, updatedSelf, 3);

        updateSurroundingStaircases(world, pos);
    }

    @Override
    public void onBlockStateChange(LevelReader level, BlockPos pos, BlockState oldState, BlockState newState)
    {
        super.onBlockStateChange(level, pos, oldState, newState);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx)
    {
        return super.getStateForPlacement(ctx);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved)
    {
        super.onRemove(state, world, pos, newState, moved);

        if (state.getBlock() != newState.getBlock())
        {
            for (Direction direction : HORIZONTAL)
            {
                BlockPos diagonalAboveForward = pos.offset(direction.getNormal()).above();
                BlockState neighborState = world.getBlockState(diagonalAboveForward);

                if (neighborState.getBlock() == this)
                {
                    BlockState updated = updateStaircaseVariant(neighborState, world, diagonalAboveForward);
                    if (updated != neighborState)
                        world.setBlock(diagonalAboveForward, updated, 3);
                }
            }
        }
    }

    private void updateSurroundingStaircases(Level world, BlockPos pos)
    {
        for (Direction direction : HORIZONTAL)
        {
            BlockPos diagonalAboveForward = pos.offset(direction.getNormal()).above();
            BlockState neighborState = world.getBlockState(diagonalAboveForward);

            if (neighborState.getBlock() == this)
            {
                BlockState updated = updateStaircaseVariant(neighborState, world, diagonalAboveForward);
                if (updated != neighborState)
                    world.setBlock(diagonalAboveForward, updated, 3);
            }
        }
    }

    private BlockState updateStaircaseVariant(BlockState state, LevelAccessor world, BlockPos pos)
    {
        Direction facing = state.getValue(FACING);

        BlockPos diagonalBelowBehind = pos.offset(facing.getOpposite().getNormal()).below();
        BlockState belowState = world.getBlockState(diagonalBelowBehind);

        BlockPos leftPos = pos.offset(facing.getCounterClockWise(Direction.Axis.Y).getNormal());
        BlockPos rightPos = pos.offset(facing.getClockWise(Direction.Axis.Y).getNormal());

        boolean leftConnected = isStaircase(world, leftPos, facing, Variant.RIGHTCORNER);
        boolean rightConnected = isStaircase(world, rightPos, facing, Variant.LEFTCORNER);

        BlockPos diagonalAboveAhead = pos.offset(facing.getNormal()).above();
        BlockState aheadState = world.getBlockState(diagonalAboveAhead);

        if (state.getValue(VARIANT) == Variant.NORMAL && aheadState.getBlock() == this && aheadState.getValue(FACING) == facing)
        {
            Variant aheadVariant = aheadState.getValue(VARIANT);
            if (aheadVariant == Variant.RIGHT)
            {
                world.setBlock(diagonalAboveAhead, aheadState.setValue(VARIANT, Variant.UPRIGHT), 3);
                return state.setValue(VARIANT, Variant.RIGHT);
            }
            else if (aheadVariant == Variant.LEFT)
            {
                world.setBlock(diagonalAboveAhead, aheadState.setValue(VARIANT, Variant.UPLEFT), 3);
                return state.setValue(VARIANT, Variant.LEFT);
            }
            else if (aheadVariant == Variant.CENTER)
            {
                world.setBlock(diagonalAboveAhead, aheadState.setValue(VARIANT, Variant.UPCENTER), 3);
                return state.setValue(VARIANT, Variant.CENTER);
            }
        }

        if (belowState.getBlock() == this && belowState.getValue(FACING) == facing)
        {
            switch (belowState.getValue(VARIANT))
            {
                case CENTER, UPCENTER:
                    return state.setValue(VARIANT, Variant.UPCENTER);
                case RIGHT, UPRIGHT:
                    return state.setValue(VARIANT, Variant.UPRIGHT);
                case LEFT, UPLEFT:
                    return state.setValue(VARIANT, Variant.UPLEFT);
                case NORMAL, UP:
                    return state.setValue(VARIANT, Variant.UP);
            }
        }

        if (isStaircaseL(world, rightPos.offset(facing.getCounterClockWise(Direction.Axis.Y).getNormal())
                .offset(facing.getClockWise(Direction.Axis.Y).getClockWise(Direction.Axis.Y).getNormal()), facing))
        {
            return state.setValue(VARIANT, Variant.RIGHTCORNER);
        }
        else if (isStaircaseR(world, leftPos.offset(facing.getClockWise(Direction.Axis.Y).getNormal())
                .offset(facing.getCounterClockWise(Direction.Axis.Y).getCounterClockWise(Direction.Axis.Y).getNormal()), facing))
        {
            return state.setValue(VARIANT, Variant.LEFTCORNER);
        }
        else if (leftConnected && rightConnected)
        {
            return state.setValue(VARIANT, Variant.CENTER);
        }
        else if (leftConnected)
        {
            return state.setValue(VARIANT, Variant.RIGHT);
        }
        else if (rightConnected)
        {
            return state.setValue(VARIANT, Variant.LEFT);
        }
        else
        {
            return state.setValue(VARIANT, Variant.NORMAL);
        }
    }

    private boolean isStaircase(LevelAccessor world, BlockPos pos, Direction expectedFacing, Variant variant)
    {
        BlockState state = world.getBlockState(pos);
        return state.getBlock() == this && (state.getValue(FACING) == expectedFacing || state.getValue(VARIANT) == variant);
    }

    private boolean isStaircaseL(LevelAccessor world, BlockPos pos, Direction expectedFacing)
    {
        BlockState state = world.getBlockState(pos);

        return state.getBlock() == this && state.getValue(FACING) == expectedFacing.getClockWise(Direction.Axis.Y);
    }

    private boolean isStaircaseR(LevelAccessor world, BlockPos pos, Direction expectedFacing)
    {
        BlockState state = world.getBlockState(pos);

        return state.getBlock() == this && state.getValue(FACING) == expectedFacing.getCounterClockWise(Direction.Axis.Y);
    }
}