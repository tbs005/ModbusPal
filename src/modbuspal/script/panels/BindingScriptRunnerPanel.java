/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modbuspal.script.panels;

import modbuspal.binding.BindingFactory;
import modbuspal.main.ModbusPal;
import modbuspal.script.ScriptRunner;
import modbuspal.script.ScriptRunnerPanel;

/**
 *
 * @author avincon
 */

public class BindingScriptRunnerPanel
extends ScriptRunnerPanel
{
    public BindingScriptRunnerPanel(ScriptRunner def, boolean canExecute)
    {
        super(def, canExecute);
    }

    @Override
    protected void deleteScript()
    {
        ScriptRunner runner = getScriptRunner();
        System.out.println("Deleting " + runner.getClassName() + " binding..." );
        ModbusPal.removeBindingScript( runner );
    }
}