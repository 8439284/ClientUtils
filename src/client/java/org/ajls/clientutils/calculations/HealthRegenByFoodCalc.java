package org.ajls.clientutils.calculations;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.HungerManager;
import org.ajls.clientutils.container.HealthRegenByFoodData;
import org.ajls.clientutils.mixin.client.HungerManagerAccessor;

import java.lang.reflect.Field;

public class HealthRegenByFoodCalc {
    public static HealthRegenByFoodData getHealthRegenByFoodData() {
        MinecraftClient client = MinecraftClient.getInstance();
        HungerManager hungerManager = client.player.getHungerManager();
        HungerManagerAccessor hungerManagerAccessor = (HungerManagerAccessor) hungerManager;

        double saturationLevel = hungerManager.getSaturationLevel();
        int foodLevel = hungerManager.getFoodLevel();
        double exhaustion = hungerManagerAccessor.getExhaustion();

        double saturationLevelCeil = Math.ceil(saturationLevel);

        int foodLevelHealth = 0;
        double vigorHealth = 0;

        if (saturationLevel > 0) {
            double vigor = saturationLevelCeil*4 - exhaustion;
            vigorHealth = vigor / 6;

        }
//        else {
//
//
//        }
        foodLevel -= 17;
        while (foodLevel >= 3) {
            foodLevel -= 3;
            foodLevelHealth += 2;
        }
        if (foodLevel == 2) {
            if (exhaustion >= 2) {
                foodLevelHealth += 1;
            }
            else {
                foodLevelHealth += 2;
            }
        }
        else if (foodLevel == 1) {
            foodLevelHealth += 1;
        }


        return new HealthRegenByFoodData(vigorHealth, foodLevelHealth);

//        try {
//            Field exhaustionField = HungerManager.class.getDeclaredField("exhaustion");
//            exhaustionField.setAccessible(true);  // Allow access to the private field
//            return (float) exhaustionField.get(hungerManager);  // Cast the field value to float
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }

        //6 exhaustion = 1 health






//        return 0.0f;  // Default return if anything goes wrong
    }
}
