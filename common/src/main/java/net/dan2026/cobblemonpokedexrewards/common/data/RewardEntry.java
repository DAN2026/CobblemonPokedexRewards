/*
 *
 * CobblemonPokedexRewards - A NeoForge Minecraft Mod.
 *
 * Copyright (c) 2026 DAN2026. All rights reserved.
 *
 * This software is licensed under the CobblemonPokedexRewards License v1.0.
 *  A copy of this license should have been included with this software.
 *  If not, you can obtain a copy at [https://github.com/DAN2026/CobblemonPokedexRewards/blob/master/LICENSE].
 *
 */

package net.dan2026.cobblemonpokedexrewards.common.data;

public class RewardEntry {

    private final String name;
    private final int requiredDexCount;
    private final RewardType rewardType;
    private final String rewardValue;
    private boolean claimed;

    public RewardEntry(String name, int requiredDexCount, RewardType rewardType, String rewardValue) {
        this.name = name;
        this.requiredDexCount = requiredDexCount;
        this.rewardType = rewardType;
        this.rewardValue = rewardValue;
        this.claimed = false;
    }

    public enum RewardType {
        ITEM,
        COMMAND,
        POKEMON
    }

    public String getName() { return name; }
    public int getRequiredDexCount() { return requiredDexCount; }
    public RewardType getRewardType() { return rewardType; }
    public String getRewardValue() { return rewardValue; }
    public boolean isClaimed() { return claimed; }
    public void setClaimed(boolean claimed) { this.claimed = claimed; }
}
