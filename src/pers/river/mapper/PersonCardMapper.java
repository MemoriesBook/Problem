package pers.river.mapper;

import java.util.List;

public interface PersonCardMapper {
	public List<pers.river.pojo.PersonCard> findPersonCard() throws Exception;

	public List<pers.river.pojo.PersonCardPojo> findPersonCardMapper() throws Exception;
}