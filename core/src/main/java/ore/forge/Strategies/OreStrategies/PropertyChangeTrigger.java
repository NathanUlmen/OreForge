package ore.forge.Strategies.OreStrategies;

import ore.forge.Ore;

//@author Nathan Ulmen
public class PropertyChangeTrigger implements OreStrategy {
    //what to do if true.
    //what to do if false
    //what to evaluate
    //Comparison
    //


    public PropertyChangeTrigger() {

    }

    public PropertyChangeTrigger(PropertyChangeTrigger clone) {

    }


    @Override
    public void activate(float deltaT, Ore ore) {

    }

    @Override
    public OreStrategy clone() {
        return new PropertyChangeTrigger(this);
    }

    @Override
    public boolean isEndStepEffect() {
        return false;
    }
}