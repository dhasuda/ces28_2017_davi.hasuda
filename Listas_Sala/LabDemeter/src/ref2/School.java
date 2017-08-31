package ref2;

public class School {
	
	public ApplicationResult recordNewApplication(Applicant applicant) {
		ApplicationResult retResult = new ApplicationResult();
		
		ApplicationValidation applicationValidation = this.getApplicationValidation();
		ApplicationDao admissionApplicationDao = this.getApplicationDao();
		
		ApplicationResult result = applicationValidation.validate(applicant);
		if (result.isSuccess()) {
			result = admissionApplicationDao.persist(applicant);
			if (result.isSuccess()) { // Note isSuccess()
				retResult.setSuccess(true);
				retResult.setMessage("Admission application successful");
				//this.register(applicant);
			} else {
				retResult.setMessage(result.getMessage());
			}
		} else {
			retResult.setMessage(result.getMessage());
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
