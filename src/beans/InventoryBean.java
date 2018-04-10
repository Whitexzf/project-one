package beans;

import java.sql.Timestamp;

public class InventoryBean {
    private String location;
    private String plate_name;
    private String plate_id;
    private String color;
    private String color_num;
    private int col;
    private int row;
    private int Frame_num;
    private int State;
    private float amout;
    private String nature;
    public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	private Timestamp frist_store_time;
    private String comment;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPlate_name() {
		return plate_name;
	}
	public void setPlate_name(String plate_name) {
		this.plate_name = plate_name;
	}
	public String getPlate_id() {
		return plate_id;
	}
	public void setPlate_id(String plate_id) {
		this.plate_id = plate_id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor_num() {
		return color_num;
	}
	public void setColor_num(String color_num) {
		this.color_num = color_num;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getFrame_num() {
		return Frame_num;
	}
	public void setFrame_num(int frame_num) {
		Frame_num = frame_num;
	}
	public int getState() {
		return State;
	}
	public void setState(int state) {
		State = state;
	}
	public float getAmout() {
		return amout;
	}
	public void setAmout(float amout) {
		this.amout = amout;
	}
	public Timestamp getFrist_store_time() {
		return frist_store_time;
	}
	public void setFrist_store_time(Timestamp frist_store_time) {
		this.frist_store_time = frist_store_time;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
