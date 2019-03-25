public class GateNot extends LogicGate {

    private LogicVariable input;
    private String symbol = "NOT";

    GateNot(LogicVariable output, LogicVariable input) throws ColisionException, CycleException {
        // ---- checking for collisions
        if(output.getCalculatedBy() != null)
            throw new ColisionException();

        // ---- handling inputs
        this.input = input;
        this.input.addLogicGate(this);
        // ---- handling outputs
        this.output = output;
        this.output.setLogicGate(this);
        // ---- checking for loops
        LogicVariable lv[] = this.input.getCalculatedBy().getInputs();
        for(LogicVariable l : lv) {
            if(this.output.equals(l))
                throw new CycleException();
        }
        // We need to check for Gate loops before setting a value for output
        this.output.setValue(!input.getValue());
    }

    // ---- getters
    @Override
    public LogicVariable getOutput() {
        return output;
    }

    @Override
    public LogicVariable[] getInputs() {
        LogicVariable lv[] = {input};
        return lv;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String getFormula() {
        return "NOT(" + this.input.getFormula() + ")";
    }

    @Override
    public void setValue(LogicVariable logicVariable) {
        if(this.input.equals(logicVariable))
            this.output.setValue(!this.input.getValue());
    }
}
