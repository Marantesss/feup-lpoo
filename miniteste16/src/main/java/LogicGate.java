public abstract class LogicGate {

    protected LogicVariable output;

    public abstract LogicVariable getOutput();

    public abstract LogicVariable[] getInputs();

    public abstract String getSymbol();

    public abstract String getFormula();

    public abstract void setValue(LogicVariable logicVariable);

}
