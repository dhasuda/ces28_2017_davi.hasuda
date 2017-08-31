package ref3;

public class School {
	
	public ApplicationResult recordNewApplication(Applicant applicant) {
		ApplicationResult retResult = new ApplicationResult();
		
		ApplicationValidation applicationValidation = this.getApplicationValidation();
		ApplicationDao admissionApplicationDao = this.getApplicationDao();
		
		boolean result = applicationValidation.validate(applicant);
		if (result) {
			result = admissionApplicationDao.persist(applicant);
			if (result){ // Note isSuccess()
				retResult.setSuccess(true);
				retResult.setMessage("Admission application successful");
				//this.register(applicant);
			} else {
				retResult.setMessage("Admission application failed");
			}
		} else {
			retResult.setMessage("Admission application failed");
		}
		return retResult;
	}

	public void register(Applicant applicant) {
		// TODO Auto-generated method stub
		
	}

	public ApplicationValidation getApplicationValidation() {
		// TODO Auto-generated method stub
		return null;
	}

	public ApplicationDao getApplicationDao() {
		// TODO Auto-generated method stub
		return null;
	}
}
