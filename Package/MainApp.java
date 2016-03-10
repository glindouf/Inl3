import net.proteanit.sql.DbUtils;

    try
    {
    CreateConnection();
    PreparedStatement st =conn.prepareStatement("Select * from ABC;");
    ResultSet rs = st.executeQuery();
    tblToBeFilled.setModel(DbUtils.resultSetToTableModel(rs));
    conn.close();
    }
    catch(Exception ex)
    {
    JOptionPane.showMessageDialog(null, ex.toString());
    }