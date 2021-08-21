package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import controlador.ControladorRequerimientos;
import modelo.dao.Requerimiento_1Dao;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;

public class VentanaRequerimiento extends JFrame implements ActionListener {

    private ControladorRequerimientos control;
    private JTable tabla1, tabla2;
    public VentanaRequerimiento() {
        control = new ControladorRequerimientos();
        initUI();
        setLocationRelativeTo(null);
    }



    private void initUI()
    {
        setTitle("Interfaz Reto 5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);

        var tdb = new JTabbedPane();
        getContentPane().add(tdb,BorderLayout.CENTER);

        var panel1 = new JPanel();
        var panel2 = new JPanel();

        panel1.setLayout(new BorderLayout());
        tdb.addTab("Consulta", panel1);

        var panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("Requerimientos"));

        var botonConsulta = new JButton("Buscar");

        botonConsulta.addActionListener(e -> CargarDatos());

        panelEntrada.add(botonConsulta);
        panel1.add(panelEntrada,BorderLayout.PAGE_START);

        tabla1 = new JTable();
        tabla2 = new JTable();
        panel1.add(new JScrollPane(tabla1),BorderLayout.CENTER);
        panel1.add(new JScrollPane(tabla2),BorderLayout.PAGE_END);
    }



    private void CargarDatos() {
        try {
            var lista1 = control.consultarRequerimiento1();
            var lista2 = control.consultarRequerimiento2();
            var modeloTabla1 = new requerimiento1TablaModelo();
            var modeloTabla2 = new requerimiento2TablaModelo();
            modeloTabla1.setData(lista1);
            modeloTabla2.setData(lista2);
        
            tabla1.setModel(modeloTabla1);
            tabla2.setModel(modeloTabla2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar","Advertencia", 
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private class requerimiento1TablaModelo extends AbstractTableModel
    {
        private ArrayList<Requerimiento_1Vo> data;

        public void setData(ArrayList<Requerimiento_1Vo> data) {
            this.data = data;
        }
        @Override
        public String getColumnName(int column) {
            switch (column)
            {
                case 0:
                    return "ID_lider";
                case 1:
                    return "Salario";
                case 2: 
                    return "Ciudad de residencia";
            }
            return super.getColumnName(column);
        }
        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registros = data.get(rowIndex);

            switch (columnIndex)
            {
                case 0:
                    return registros.getID_Lider();
                case 1:
                    return registros.getSalario();
                case 2: 
                    return registros.getCiudad();
            }
            return null;
        }
        
    }

    private class requerimiento2TablaModelo extends AbstractTableModel
    {

        private ArrayList<Requerimiento_2Vo> data;

        public void setData(ArrayList<Requerimiento_2Vo> data) {
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            switch (column)
            {
                case 0:
                    return "id_Proyecto";
                case 1:
                    return "Nombre_Material";
                case 2: 
                    return "Importado";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
           return data.size();
        }

        @Override
        public int getColumnCount() {
            // TODO Auto-generated method stub
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registros = data.get(rowIndex);

            switch (columnIndex)
            {
                case 0:
                    return registros.getID_Proyecto();
                case 1:
                    return registros.getNombre_Material();
                case 2: 
                    return registros.getImportado();
            }
            return null;
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
