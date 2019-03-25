import java.util.ArrayList;
import java.util.List;

public class CombinatorialCircuit {

    List<LogicVariable> logicVariableList;

    CombinatorialCircuit(){
        this.logicVariableList = new ArrayList<>();
    }

    public boolean addVariable(LogicVariable logicVariable){
        for(LogicVariable lv : logicVariableList){
            if(lv.equals(logicVariable))
                return false;
        }
        this.logicVariableList.add(logicVariable);
        return true;
    }

    public LogicVariable getVariableByName(String name){
        for(LogicVariable logicVariable : logicVariableList){
            if(logicVariable.getName().equals(name))
                return logicVariable;
        }
        return null;
    }
}
