package beans;

import java.sql.Timestamp;

public class AccessBean {
     private int id;//���
     private String Location;//λ�ñ��
     private String Plate_name;//�������
     private String Plate_id;
     private String Admin_name;
     private Timestamp DateTime;//����ʱ��
     private int Print_num;//ӡ��
     private String Status;//�����״̬
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getAdmin_name() {
		return Admin_name;
	}
	public void setAdmin_name(String admin_name) {
		Admin_name = admin_name;
	}
	public Timestamp getDateTime() {
		return DateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		DateTime = dateTime;
	}
	public int getPrint_num() {
		return Print_num;
	}
	public void setPrint_num(int print_num) {
		Print_num = print_num;
	}

	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getPlate_name() {
		return Plate_name;
	}
	public void setPlate_name(String plate_name) {
		Plate_name = plate_name;
	}
	public String getPlate_id() {
		return Plate_id;
	}
	public void setPlate_id(String plate_id) {
		Plate_id = plate_id;
	}

     
}
