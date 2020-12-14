/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DanTocDAO;
import control.HocSinhDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.DiaChi;
import model.HoTen;
import model.KhoaHoc;
import model.Lop;
import model.TheGiaoVien;

import model.TheHocSinh;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author tuan2
 */


public class LoadFileExcel extends javax.swing.JFrame {

    /**
     * Creates new form LoadFileExcell
     */
    ArrayList<TheHocSinh> theHocSinh;
    ArrayList<String> status;
    Frame back;
    public LoadFileExcel(Frame e) {
        initComponents();
        this.back = e;
    }
    
    private ArrayList<TheHocSinh>  getALL(String path){
        ArrayList<TheHocSinh> ret = new ArrayList<>();
        File excelFile = null;
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;
        
        try{
            this.status = new ArrayList();
            excelFile = new File(path);
            fis = new FileInputStream(excelFile);
            // tao oop workbook
            workbook = new XSSFWorkbook(fis);
            // lay sheet dau tien
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            // tao hang doi ROW
            Iterator<Row> rowIt = sheet.iterator();
            rowIt.next();
            while(rowIt.hasNext()) {
                TheHocSinh e = new TheHocSinh();
                String x ;
                Row row = rowIt.next();
                Iterator<Cell> cellIterator = row.cellIterator();
               
                Cell cell = cellIterator.next();
                x = cell.toString();
                if(!x.equals("null"))
                    e.setMaHocSinh(x);
                cell = cellIterator.next();
                String ho = cell.toString();
                cell = cellIterator.next();
                String tenDem = cell.toString();
                cell = cellIterator.next();
                String ten = cell.toString();
                HoTen ht = new HoTen(ho, tenDem, ten);
                e.setHoTen(ht);
                DiaChi dc = new DiaChi();     
                cell = cellIterator.next();
                dc.setTinh_ThanhPho(cell.toString());
                cell = cellIterator.next();
                dc.setHuyen_Quan(cell.toString());
                cell = cellIterator.next();
                dc.setXa_Phuong(cell.toString());
                cell = cellIterator.next();
                dc.setThon(cell.toString());
                cell = cellIterator.next();
                x = cell.toString();
                if(!x.equals("null"))
                    dc.setDuong(x);
                cell = cellIterator.next();
                x = cell.toString();
                if(!x.equals("null"))
                    dc.setSoNha(x);
                e.setDiaChi(dc);
                cell = cellIterator.next();
                e.setGioiTinh(cell.toString());
                cell = cellIterator.next();
                e.setDanToc( new DanTocDAO().getDanToc(cell.toString() ));
                cell = cellIterator.next();
  
                try{
                    System.out.println(cell.toString());
                    e.setNgaySinh(cell.getDateCellValue());
                }
                catch(Exception ex){
                    e.setNgaySinh(cell.toString());
                        
                }
                cell = cellIterator.next();
                Lop lop = new Lop( cell.toString());
                
                
                e.setLop(lop);
                //System.out.println("ret da add");
                cell = cellIterator.next();
                e.setKhoahoc(new KhoaHoc(cell.toString()));
                cell = cellIterator.next();
                x = cell.toString();
                if(x.equals("null")) x = "";
                e.setEmail(x);
                cell = cellIterator.next();
                e.setSdtPhuHuynh(cell.toString());
               // KhachHang kh = new KhachHang(kiHanThang,maSanPham,soLanGuiTien,tenTaiKhoan,soTaiKhoan,tenKH,laiSuat,soTien,kiHanUaThich);
               // kh.setMaSoKH(maSoKH);
                //ret.add(kh);
                //System.out.println("a");
               // System.out.println("ret da add");
                this.status.add("Chưa Làm");
                ret.add(e);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return ret;
    }
    private void loadTable(ArrayList<TheHocSinh> arr){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        if(arr != null){
            int j = 1;
            for(TheHocSinh i : arr){
                String date = formatter.format(i.getNgaySinh());
                model.addRow(new Object[]{
                    j++,i.getMaHocSinh(), i.getHoTen().getHo()+" "+i.getHoTen().getTenDem()+" "+i.getHoTen().getTen(),
                    i.getGioiTinh(), i.getDanToc().getTenDanToc(), date,
                    i.getDiaChi().toString(), i.getLop().getTenLop(),
                    i.getKhoahoc().getBatDau().getYear() +"-"+ i.getKhoahoc().getKetThuc().getYear(),
                    i.getEmail(), i.getSdtPhuHuynh(),this.status.get(j-2)
                });
            }
            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable()
        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,11);
                componenet.setBackground(Color.WHITE);
                componenet.setForeground(Color.BLACK);

                if(value.equals("Chưa Thêm"))
                {

                    componenet.setBackground(Color.WHITE);
                    componenet.setForeground(Color.BLACK);

                }
                if(value.equals("Thêm Thành Công")){
                    // if date  equal current date
                    componenet.setBackground(Color.GREEN);
                    componenet.setForeground(Color.BLACK);
                }

                if(value.equals("Thêm Thất Bại")){
                    // if date  equal current date
                    componenet.setBackground(Color.RED);
                    componenet.setForeground(Color.BLACK);
                }
                if(value.equals("Đã Có Trong CSDL")){
                    // if date  equal current date
                    componenet.setBackground(Color.ORANGE);
                    componenet.setForeground(Color.BLACK);
                }
                if(value.equals("Landed")){
                    // if date  equal current date
                    componenet.setBackground(Color.cyan);
                    componenet.setForeground(Color.BLACK);
                }
                if(value.equals("Cancelled")){
                    // if date  equal current date
                    componenet.setBackground(Color.RED);
                    componenet.setForeground(Color.WHITE);
                }

                return componenet;

            }

        };
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Chọn File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Học Sinh", "Họ Và Tên", "Giới Tính", "Dân Tộc", "Ngày Sinh", "Địa Chỉ", "Lớp", "Khóa", "email", "sdt Phụ Huynh", "Trạng Thái"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(11).setResizable(false);
        }

        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Quay Lại");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(469, 469, 469)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(41, 41, 41))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setText("Thêm Học Sinh Load File Excel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
         JFileChooser file = new JFileChooser();
          file.setCurrentDirectory(new File(System.getProperty("user.home")));
          //filter the files
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.xlsx", "xlsx");
          file.addChoosableFileFilter(filter);
          int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
              this.theHocSinh = getALL(path);
              loadTable(theHocSinh);
              System.out.println(theHocSinh.size());
          }
           //if the user click on save in Jfilechooser
          else if(result == JFileChooser.CANCEL_OPTION){
              System.out.println("No File Select");
          }
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        HocSinhDAO dao = new HocSinhDAO();
        for(int i = 0 ; i < this.theHocSinh.size() ; i++){
            int res = dao.insertHocSinh(this.theHocSinh.get(i));
            
            if( res == -2){
                this.status.set(i, "Đã Có Trong CSDL");
            }
            else{
                if(res == -1){
                    this.status.set(i, "Thêm Thất Bại");
                }
                else{
                    this.status.set(i, "Thêm Thành Công");
                }
            }
        }
        loadTable(theHocSinh);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(this.back != null){
            this.back.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
