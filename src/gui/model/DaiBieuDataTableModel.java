/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import dto.Daibieu;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class DaiBieuDataTableModel extends AbstractTableModel {

    private static final String[] FIELD_NAMES = {"ID", "SBD", "Họ", "Tên", "Giới tính", "Phân loại", "Ngày sinh", "Dân tộc", "Tôn giáo", "Chức vụ", "Khoa", "Tuổi"};
    private ArrayList<Daibieu> listDaiBieu;

    public DaiBieuDataTableModel() {
        listDaiBieu = new ArrayList<>();
    }

    public ArrayList<Daibieu> getListDaiBieu() {
        return listDaiBieu;
    }

    public void setListDaiBieu(ArrayList<Daibieu> listDaiBieu) {
        this.listDaiBieu = listDaiBieu;
    }

    @Override
    public int getRowCount() {
        return listDaiBieu.size();
    }

    @Override
    public int getColumnCount() {
        return FIELD_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= getRowCount()) {
            return "";
        }
        Daibieu db = listDaiBieu.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return db.getDbId();
            case 1:
                return db.getDbSbd();
            case 2:
                return db.getDbFirstname();
            case 3:
                return db.getDbLastname();
            case 4:
                return db.isDbMale();
            case 5:
                return db.getDbClassify();
            case 6:
                return db.getDbBirthday();
            case 7:
                return db.getDbHome();
            case 8:
                return db.getDbEthnic();
            case 9:
                return db.getDbReligion();
            case 10:
                return db.getDbPosition();
            case 11:
                return db.getDbFaculty();
            case 12:
                return db.getDbAge();
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return String.class;
    }

    @Override
    public String getColumnName(int col) {
        if (col < getColumnCount()) {
            return FIELD_NAMES[col];
        }
        return "";
    }
    
    public void addDaiBieu(Daibieu db){
        listDaiBieu.add(db);
        fireTableDataChanged();
    }
    
    public void removeDaiBieu(int index){
        listDaiBieu.remove(index);
        fireTableDataChanged();
        
    }
    
    public Daibieu getDaiBieu(int index){
        return listDaiBieu.get(index);
    }
    
    public void updateDaiBieu(int index, Daibieu daibieu){
        Daibieu db = getDaiBieu(index);
        db.setDbId(daibieu.getDbId());
        db.setDbSbd(daibieu.getDbSbd());
        db.setDbFirstname(daibieu.getDbFirstname());
        db.setDbLastname(daibieu.getDbLastname());
        db.setDbMale(daibieu.isDbMale());
        db.setDbClassify(daibieu.getDbClassify());
        db.setDbBirthday(daibieu.getDbBirthday());
        db.setDbHome(daibieu.getDbHome());
        db.setDbEthnic(daibieu.getDbEthnic());
        db.setDbReligion(daibieu.getDbReligion());
        db.setDbPosition(daibieu.getDbPosition());
        db.setDbFaculty(daibieu.getDbFaculty());
        db.setDbAge(daibieu.getDbAge());
        fireTableDataChanged();
    }

}
