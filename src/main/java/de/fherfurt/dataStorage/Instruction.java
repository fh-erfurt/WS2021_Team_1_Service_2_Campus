package de.fherfurt.dataStorage;

import java.util.ArrayList;
import java.util.List;

import de.fherfurt.enums.Action;

public class Instruction extends BaseStorage
{
    Action action;
    public List<String> instData = new ArrayList<>();

    public Action getAction()
    {
        return action;
    }

    public void setAction(Action action)
    {
        this.action = action;
    }

    public Instruction(Action action)
    {
        setAction(action);
    }
}