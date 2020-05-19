package pers.river.pojo;

public class PersonCardPojo {
	private Person person;
	private Idcard idCard;

	@Override
	public String toString() {
		return "PersonCardPojo [person=" + person + ", idCard=" + idCard + "]";
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Idcard getIdCard() {
		return idCard;
	}

	public void setIdCard(Idcard idCard) {
		this.idCard = idCard;
	}
}
