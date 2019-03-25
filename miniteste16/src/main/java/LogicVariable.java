import java.util.ArrayList;
import java.util.List;

public class LogicVariable {

    private String name;
    private boolean value;

    private LogicGate logicGate;

    private List<LogicGate> inputLogicGates;

    LogicVariable(String name, boolean value) {
        this.name = name;
        this.value = value;
        this.logicGate = null;
        inputLogicGates = new ArrayList<>();
    }

    LogicVariable(String name) {
        this.name = name;
        this.value = false;
        this.logicGate = null;
        inputLogicGates = new ArrayList<>();
    }


    LogicVariable(LogicVariable l) {
        this.name = l.getName();
        this.value = l.getValue();
        this.logicGate = l.getCalculatedBy();
        inputLogicGates =  l.getInputLogicGates();
    }

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of LogicVariable or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof LogicVariable)) {
            return false;
        }

        // typecast o to LogicVariable so that we can compare data members
        LogicVariable l = (LogicVariable) o;

        // Compare the data members and return accordingly
        return this.name.equals(l.getName());
    }

    // ---- getters
    public String getName() {
        return name;
    }

    public boolean getValue() {
        return value;
    }

    public LogicGate getCalculatedBy(){
        return logicGate;
    }

    public String getFormula() {
        if (this.logicGate == null)
            return this.name;

        return this.logicGate.getFormula();
    }

    public List<LogicGate> getInputLogicGates() {
        return inputLogicGates;
    }

    // ---- setters
    public void setName(String name) {
        this.name = name;
    }

    public void setValue(boolean value) {
        this.value = value;
        for (LogicGate lg : inputLogicGates) {
            lg.setValue(this);
        }
    }

    public void setLogicGate(LogicGate logicGate) {
        this.logicGate = logicGate;
    }

    public void addLogicGate(LogicGate logicGate){
        this.inputLogicGates.add(logicGate);
    }
}
