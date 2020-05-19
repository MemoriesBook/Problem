package pers.river.pojo;

public class PersonCard extends Person {
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "PersonCard [code=" + code + ", getId()=" + getId() + ", getName()=" + getName() + ", getAge()="
				+ getAge() + ", getSex()=" + getSex() + ", getCard_id()=" + getCard_id() + "]";
	}
}
