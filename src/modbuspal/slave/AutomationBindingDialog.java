/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AutomationBindingDialog.java
 *
 * Created on 30 déc. 2008, 19:59:57
 */

package modbuspal.slave;

import java.awt.Frame;
import modbuspal.automation.*;
import javax.swing.ComboBoxModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import modbuspal.binding.Binding;
import modbuspal.main.ModbusPal;

/**
 *
 * @author nnovic
 */
class AutomationBindingDialog
extends javax.swing.JDialog
{
    class AutomationList
    implements ListModel
    {
        private Automation[] automations;

        AutomationList( Automation[] list ) {
            automations = list;
        }

        public Automation getAutomation(int index) {
            return automations[index];
        }

        public int getSize() {
            return automations.length;
        }

        public Object getElementAt(int index) {
            return automations[index].getName();
        }

        public void addListDataListener(ListDataListener l) {
            return;
        }

        public void removeListDataListener(ListDataListener l) {
            return;
        }
    }

    class BindingList
    implements ComboBoxModel
    {
        private Class[] bindings;
        private String selected;

        public BindingList(Class[] list) {
            bindings = list;
        }

        public void setSelectedItem(Object anItem) {
            selected = (String)anItem;
        }

        public Object getSelectedItem() {
            return selected;
        }

        public int getSize() {
            return bindings.length;
        }

        public Object getElementAt(int index) {
            return bindings[index].getSimpleName();
        }

        public void addListDataListener(ListDataListener l) {
            return;
        }

        public void removeListDataListener(ListDataListener l) {
            return;
        }

        public Class getClass(int index) {
            return bindings[index];
        }
    }

    private AutomationList automations;
    private BindingList bindings;
    
    /** Creates new form AutomationBindingDialog */
    public AutomationBindingDialog(Frame frame, boolean allowOrderSelection)
    {
        super(frame, true);
        automations = new AutomationList( ModbusPal.getAutomations() );
        bindings = new BindingList( Binding.getClassList() );
        initComponents();
        orderComboBox.setEnabled(allowOrderSelection);
        bindingsComboBox.setSelectedIndex(0);
    }

    public Class getSelectedClass()
    {
        int index = bindingsComboBox.getSelectedIndex();
        return bindings.getClass(index);
    }

    public Automation getSelectedAutomation()
    {
        int index = automationsList.getSelectedIndex();
        if( index < 0 )
        {
            return null;
        }
        
        Automation selected = automations.getAutomation(index);
        return selected;
    }

    public int getSelectedOrder()
    {
        return orderComboBox.getSelectedIndex();
    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        automationsList = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        bindingsComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        orderComboBox = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Automation binding");

        automationsList.setModel(automations);
        automationsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(automationsList);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        bindingsComboBox.setModel(bindings);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel1.add(bindingsComboBox, gridBagConstraints);

        jLabel1.setText("Mapping:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Order:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jLabel2, gridBagConstraints);

        orderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        jPanel1.add(orderComboBox, gridBagConstraints);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel1.add(okButton, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        setVisible(false);
}//GEN-LAST:event_okButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList automationsList;
    private javax.swing.JComboBox bindingsComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox orderComboBox;
    // End of variables declaration//GEN-END:variables

}
