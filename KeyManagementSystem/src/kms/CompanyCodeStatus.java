package kms;

public class CompanyCodeStatus {

	private String code;
	private boolean isValid;
	private String errorMessage;
	
	public CompanyCodeStatus(String code, boolean isValid, String errorMessage) {
		this.code = code;
		this.isValid = isValid;
		this.errorMessage = errorMessage;
	}
	
	public CompanyCodeStatus(String code, boolean isValid) {
		this(code, isValid, null);
	}

	public String getCode() {
		return code;
	}

	public boolean isValid() {
		return isValid;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
