package org.ajls.clientutils.container;

public class HealthRegenByFoodData {
    double byVigor;
    double byFoodLevel;
    public HealthRegenByFoodData(double byVigor, double byFoodLevel) {
        this.byVigor = byVigor;
        this.byFoodLevel = byFoodLevel;
    }

    public double getByVigor() {
        return byVigor;
    }

    public double getByFoodLevel() {
        return byFoodLevel;
    }
}
