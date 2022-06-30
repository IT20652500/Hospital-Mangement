package hospitalM.Service;

import java.util.List;

import hospitalM.Model.MedicineModel;




public interface MedicineService {
	public boolean addMedicine(MedicineModel medi);
	public List<MedicineModel>allMedi();
	public MedicineModel getSingleMedie(int id);
	public boolean updateMedi(MedicineModel medi);
	public boolean deleteMedi(int id);
}
