package ore.forge.Strategies.UpgradeStrategies;

public abstract class AbstractUpgrade implements UpgradeStrategy {
   public enum ValueToModify {ORE_VALUE, TEMPERATURE, MULTIORE}
   private final double modifier;
   private final ValueToModify value;

   public AbstractUpgrade(double mod, ValueToModify val) {
      modifier = mod;
      value = val;
   }

   public double getModifier() {
       return modifier;
   }

   public ValueToModify getValueToMod() {
       return value;
   }

   public String toString() {
      return "Type: " + getClass().getSimpleName() + "\tVTM: " + value + "\tModifier: " + modifier;
   }

}
