package lod_antes;

public class Applicant {
	int id;
	String nome;
	double averageGrade = 0.0;

	public ApplicationResult recordNewApplication(School school) {
		ApplicationResult retResult = new ApplicationResult();
		
		ApplicationValidation applicationValidation = school.getApplicationValidation();
		ApplicationDao admissionApplicationDao = school.getApplicationValidation().getApplicationDao();
		
		ApplicationResult result = applicationValidation.validate(this);
		if (result.isSuccess()) {
			result = admissionApplicationDao.persist(this);
			if (result.isSuccess()) { // Note isSuccess()
				retResult.setSuccess(true);
				retResult.setMessage("Admission application successful");
				school.register(this);
			} else {
				retResult.setMessage(result.getMessage());
			}
		} else {
			retResult.setMessage(result.getMessage());
		}
		return retResult;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

}
