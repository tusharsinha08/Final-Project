import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableExample {
    JFrame f;
    JTable j;

    JTableExample(ArrayList<CarRentalInfo> list) {
        f = new JFrame();

        f.setTitle("JTable Example");

        j = new JTable();
        j.setBounds(30, 40, 200, 300);

        j.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Name", "Mobile", "Car Name", "Licence", "Time", "Level", "Total"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        DefaultTableModel model = (DefaultTableModel) j.getModel();

        ArrayList<Object[]> newList = new ArrayList<>();

        for (CarRentalInfo c : list) {
            Object[] x = { c.getName(), c.getMobile(), c.getCars(), c.getLic(), c.getTime(), c.getLevel(),
                    c.getTotal() };
            newList.add(x);
        }

        for (Object[] x : newList) {
            model.addRow(x);
        }

        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        f.setSize(500, 200);
        f.setVisible(true);
    }

}
